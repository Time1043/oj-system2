# 【项目】OJ在线判题系统

- 介绍

  OJ = Online Judge 在线判题评测系统

  用于在线评测编程题目代码的系统，能够根据用户提交的代码、出题人预先设置的题目输入输出用例，进行编译代码、运行代码、判断代码运行结果是否正确

  判题系统作为一个开放的API提供，便于开发者开放自己的OJ系统

  

- 参考

  [鱼皮笔记](https://bcdh.yuque.com/staff-wpxfif/resource/rls4he4gffa1g1ob)



## 理论知识

### 需求分析

- 描述

  用户：选择题目在线做题、编写代码提交代码

  系统：根据出题人设置答案判断用户提交是否正确

  ACM、蓝桥杯

- 科普概念

  题目给出：描述、输入输出、样例

  考察算法：时间限制、空间限制 

  - 规定模板、不能让用户随便引包、暴力遍历、内存限制时间限制 -> 安全性
  - 判题过程是异步的 -> 异步化
  - 提交后生成提交记录 (运行结果 运行信息)

  题目结果：

  - AC(Accepted 通过)、WA(Wrong Answer 答案错误)、
  - TLE(Time Limit Exceed 超时)、OLE(Output Limit Exceed 超过输出限制)、MLE(Memory Limit Exceed 超内存)、
  - RE(Runtime Error 运行时错误)、PE(Presentation Error 格式错误)、
  - CE(Compile Error 无法编译)、UKE(Unknown Error 未知错误)

  测频功能：普通测评(比对用例文件)、特殊测评(SPJ 精度误差 特判程序)、交互测评

- OJ系统的开发

  前后端：增删改查CRUD (略)

  判题系统：代码沙箱 (难点)



- 为什么做这个项目？

  网上教程比较少

  比较新颖 简历有区分度

  能学到东西：CRUD、编程思想、计算机基础、架构设计 (限制子进程内存时间)

  复杂度有点高 全程攻克

  可扩展性非常强

- 现有产品

  [leetcode](https://leetcode.cn/)、[newcoder](https://www.nowcoder.com/)、[北大poj](http://poj.org/)、[杭电oj](https://acm.hdu.edu.cn/)、[上交大oj](https://acm.sjtu.edu.cn/OnlineJudge/)、

  [hoj (java 推荐学习)](https://github.com/HimitZH/HOJ)、[青岛大学oj (python 很成熟但不好学)](https://github.com/QingdaoU/OnlineJudge)、[zoj (文档水)](https://github.com/licheng/zoj)、[voj (不完备但好学)](https://github.com/hzxie/voj)、

  [uoj (php 文档水)](https://github.com/vfleaking/uoj)、[hustoj (php 成熟但不好学)](https://github.com/hustoj/hustoj-neo)

- 核心实现

  题目浏览：CRUD

  权限校验：谁能提代码谁不能

  代码沙箱：用户提交代码藏毒、系统的资源分配 -> 沙箱 (隔离的安全的环境)、限制资源

  判题规则：题目用例的比对、结果的验证

  任务调度：服务器资源优先用户排队(有顺序的等待 而不是直接拒绝)

- 项目扩展

  > 支持多种语言
  >
  > Remote Judge
  >
  > 完善的评测功能：普通测评、特殊测评、交互测评、在线自测、子任务分组评测、文件IO
  >
  > 统计分析用户判题记录

  



### 业务流程

- 核心业务流程 (线性)

  题目模块：创建题目(管理员)、删除题目(管理员)、修改题目(管理员)、搜索题目、在线做题、提交题目代码

  用户模块：注册、登录

  判题模块：

  - 提交判题(结果是正确还是错误)、错误处理(内存溢出、安全性、超时)

  - 自主实现代码沙箱、开放接口(提供一个独立的服务)

  ![Snipaste_2024-04-02_15-38-24](res/Snipaste_2024-04-02_15-38-24.png)

- 详细业务流程 (时序图)

  判题服务：获取题目信息、预计的输入输出结果，返回给主业务后端，说明用户的答案是否正确

  代码沙箱：只负责运行代码给出结果，不管什么结果是正确的 (解耦)

  ![Snipaste_2024-04-02_15-40-25](res/Snipaste_2024-04-02_15-40-25.png)





- 技术选型

  前端：vue3、Arco Design组件库、手搓项目模板、在线代码编辑器、在线文档浏览

  后端：

  - java进程控制、java安全管理器、部分JVM知识点
  - 虚拟机(云服务器)、Docker(代码沙箱实现)
  - Spring Cloud微服务、消息队列、多种设计模式

- 架构设计 

  ![Snipaste_2024-04-02_16-04-23](res/Snipaste_2024-04-02_16-04-23.png)





### 计划和方案

- 计划

  介绍：OJ系统概念、OJ原理；项目流程、需求分析、技术选型、架构设计、主流实现方案

  前后端初始化：前端通用项目模板的搭建

  主业务流程的前后端：除代码沙箱

  自主实现代码沙箱：逐步多方案实现、安全优化

  系统优化：微服务改造、系统扩展思路



- 主流的OJ系统实现方案

  开放原则：能用别人现成的就不要自己写

  1. 现成的OJ系统：[judge0 成熟的商业产品](https://github.com/judge0/judge0) 可以用源码部署 或者公有云私有云

  2. 现成的判题API、现成的代码沙箱：[API Documentation](https://ce.judge0.com/)、[RapidAPI](https://rapidapi.com/judge0-official/api/judge0-ce) (API接口)
  3. 自主开发
  4. AI充当沙箱
  5. 移花接木：无头浏览器模拟爬虫





## 前端初始化模板

- 确认环境 (切换和管理node版本工具 nvm)

  ```
  node -v  # 18 or 16
  npm -v  # 9.5.1
  
  ```

- 初始化：[vue-cli](https://cli.vuejs.org/zh/guide/) (稳定)

  ```
  cd /d/code2/java-code/
  mkdir oj-system && cd oj-system/
  
  npm install -g @vue/cli  # 脚手架工具
  vue -V  # 5.0.8
  vue create oj-frontend  # 创建项目
  
  
  # 创建项目的选项
  Vue CLI v5.0.8
  ? Please pick a preset: Manually select features
  ? Check the features needed for your project: Babel, TS, Router, Vuex, Linter
  ? Choose a version of Vue.js that you want to start the project with 3.x
  ? Use class-style component syntax? No
  ? Use Babel alongside TypeScript (required for modern mode, auto-detected polyfills, transpiling JSX)? Yes
  ? Use history mode for router? (Requires proper server setup for index fallback in production) Yes
  ? Pick a linter / formatter config: Prettier
  ? Pick additional lint features: Lint on save
  ? Where do you prefer placing config for Babel, ESLint, etc.? In dedicated config files
  ? Save this as a preset for future projects? (y/N) n
  
  
  cd oj-frontend && npm run server  # 先运行
  
  ```

  脚手架自动整合vue-router





### 前端工程化配置

- 前端工程化配置

  脚手架已配置：代码美化、自动校验、格式化插件 (无需自己配置)

  但是WebStorm的格式化和`.eslintrc.js`不适配：

  settings -> prettier -> prettier package选上、run for files`{**/*,*}.{js,ts,jsx,tsx,vue}`、on reformat code 打勾

  settings -> eslint -> automatic eslint configuration 

- 自己整合的一些参考

  [代码规范](https://eslint.org/docs/latest/use/getting-started)、[代码美化](https://prettierio/docs/en/install.html)、[直接整合](https://github.com/prettier/eslint-plugin-prettier#recommended-configuration)、[直接整合](https://github.com/prettier/eslint-config-prettier#installation)





- 引入组件

  [arco design vue组件库](https://arco.design/vue/docs/start)

  ```
  npm install --save-dev @arco-design/web-vue
  
  ```

  main.ts (完整引入)

  ```typescript
  import { createApp } from "vue";
  import App from "./App.vue";
  import ArcoVue from "@arco-design/web-vue";
  import "@arco-design/web-vue/dist/arco.css";
  import router from "./router";
  import store from "./store";
  
  createApp(App).use(ArcoVue).use(store).use(router).mount("#app");
  
  ```

  App.vue (验证是否成功)

  ```vue
      <a-calendar v-model="value" />
  ```

  



### 项目通用布局

- 项目通用布局

  [acro design 布局](https://arco.design/vue/component/layout)

  ```
  mkdir src/layouts
  cp src/App.vue src/layouts/BasicLayout.vue
  cp src/components/HelloWorld.vue src/components/GlobalHeader.vue
  
  ```

  App.vue

  ```vue
  <template>
    <div id="app">
      <BasicLayout />
    </div>
  </template>
  
  <style>
  #app {
  }
  </style>
  
  <script>
  import BasicLayout from "@/layouts/BasicLayout.vue";
  
  export default {
    components: { BasicLayout },
  };
  </script>
  
  ```

  BasicLayout.vue (上中下布局)

  ```vue
  <template>
    <div id="basicLayout">
      <a-layout style="height: 400px">
        <a-layout-header class="header">
          <GlobalHeader />
        </a-layout-header>
  
        <a-layout-content class="content">
          <router-view />
        </a-layout-content>
  
        <a-layout-footer class="footer">
          <a href="http://github.com/Time1043" target="_blank">Time1043 周坚深</a>
        </a-layout-footer>
      </a-layout>
    </div>
  </template>
  
  <style scoped>
  #basicLayout .header {
    margin-bottom: 16px;
    box-shadow: #eee 1px 1px 5px;
  }
  
  #basicLayout .content {
    background: linear-gradient(to right, #bbb, #fff);
    margin-bottom: 16px;
  }
  
  #basicLayout .footer {
    background: #efefef;
    padding: 16px;
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    text-align: center;
  }
  </style>
  
  <script setup lang="ts">
  import GlobalHeader from "@/components/GlobalHeader.vue";
  </script>
  
  ```
  
  GlobalHeader.vue (封装组件) 
  
  - 点击菜单项 -> 跳转更新路由 -> 更新路由后同步更新菜单栏的高亮状态
  
    点击菜单项后跳转：点击路由跳转对应页面 (菜单组件读取路由 动态渲染菜单项 绑定跳转事件)
  
    刷新后要选中之前：根据当前页面激活状态 (同步路由到菜单项)
  
  - 登录信息
  
    [栅格布局](https://arco.design/vue/component/grid#grid)
  
    获取状态变量 `store.state.user.loginUser?.userName`
  
    修改状态变量：调用actions -> mutations -> state `store.dispatch("user/getLoginUser", { userName: "yz" });`
  
  ```vue
  <template>
    <a-row id="gloablHeader" style="margin-bottom: 16px" align="center">
      <a-col flex="auto">
        <a-menu
          mode="horizontal"
          :selected-keys="selectedKeys"
          @menu-item-click="doMenuClick"
        >
          <a-menu-item
            key="0"
            :style="{ padding: 0, marginRight: '38px' }"
            disabled
          >
            <div class="title-bar">
              <img class="logo" src="../assets/egg-log.png" />
              <div class="title">时oj</div>
            </div>
          </a-menu-item>
          <a-menu-item v-for="item in routes" :key="item.path">
            {{ item.name }}
          </a-menu-item>
        </a-menu>
      </a-col>
  
      <a-col flex="100px">
        <div>{{ store.state.user.loginUser?.userName ?? "未登录" }}</div>
      </a-col>
    </a-row>
  </template>
  
  <script setup lang="ts">
  import { routes } from "@/router/routes";
  import { useRoute, useRouter } from "vue-router";
  import { ref } from "vue";
  import { useStore } from "vuex";
  
  const router = useRouter();
  const route = useRoute();
  
  const selectedKeys = ref([route.path]); // 默认选中首页
  
  // 路由跳转后 更新选中的菜单项
  router.afterEach((to, from, failure) => {
    selectedKeys.value = [to.path];
  });
  
  const doMenuClick = (key: string) => {
    router.push({ path: key });
  };
  
  // 状态信息管理
  const store = useStore();
  // todo 修改状态信息
  setTimeout(() => {
    store.dispatch("user/getLoginUser", { userName: "admin" });
  }, 3000);
  </script>
  
  <style scoped>
  .title-bar {
    display: flex;
    align-items: center;
  }
  
  .title {
    color: #444;
    margin-left: 16px;
  }
  
  .logo {
    height: 48px;
  }
  </style>
  
  ```
  
  router\index.ts (参数抽出来 喂给菜单)
  
  ```typescript
  import { createRouter, createWebHistory } from "vue-router";
  import { routes } from "@/router/routes";
  
  const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
  });
  
  export default router;
  ```
  
  router\routes.ts
  
  ```typescript
  import { RouteRecordRaw } from "vue-router";
  import HomeView from "@/views/HomeView.vue";
  
  export const routes: Array<RouteRecordRaw> = [
    {
      path: "/",
      name: "浏览题目",
      component: HomeView,
    },
    {
      path: "/about",
      name: "关于我的",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
    },
  ];
  
  ```
  
  

### 全局状态管理

- 全局状态管理 [vuex](https://vuex.vuejs.org/) 

  所有页面全局共享的变量 而不是局限在一个页面 (本质上是增删改查全局变量API 再多点功能)

  用户登录态存放、权限检验

  ![](res/Snipaste_2024-04-03_21-17-38.png)

- [modules](https://vuex.vuejs.org/zh/guide/modules.html)、[购物车示例](https://github.com/vuejs/vuex/tree/4.0/examples/classic/shopping-cart)

  ```
  touch src/store/user.ts
  
  ```

- 知识总结

  state：存储的状态信息 (如用户信息)

  mutation (尽量同步)：定义了变量进行增删改的方法

  actions (支持异步)：执行异步操作，并且触发mutation的更改 (actions调用mutation)

- 代码实现

  store\index.ts

  ```typescript
  import { createStore } from "vuex";
  import user from "./user";
  
  export default createStore({
    mutations: {},
    actions: {},
    modules: {
      user,
    },
  });
  ```

  store\user.ts (先定义user模块)

  ```typescript
  // initial state
  import { StoreOptions } from "vuex";
  
  export default {
    namespaced: true,
    state: () => ({
      loginUser: {
        userName: "未登录",
      },
    }),
    actions: {
      getLoginUser({ commit, state }, payload) {
        // todo 从远程请求获取登录信息
        commit("updateUser", { userName: "yingzhu" });
      },
    },
    mutations: {
      updateUser(state, payload) {
        state.loginUser = payload;
      },
    },
  } as StoreOptions<any>;
  
  ```
  
  
  



### 权限管理

- 权限管理

  以一套通用的机制，去定义哪个页面需要哪些权限 (路由中定义权限)



















## 从单点登录改造成微服务













## 简历写法

