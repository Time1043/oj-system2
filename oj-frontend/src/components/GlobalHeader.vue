<template>
  <a-row id="globalHeader" align="center" :wrap="false">
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
        <a-menu-item v-for="item in visibleRoutes" :key="item.path">
          {{ item.name }}
        </a-menu-item>
      </a-menu>
    </a-col>

    <a-col flex="100px">
      <div>{{ loginUse?.userName ?? "userName not found" }}</div>
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
import { routes } from "@/router/routes";
import { useRoute, useRouter } from "vue-router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/access/checkAccess";
import AccessEnum from "@/access/accessEnum";

const router = useRouter();
const route = useRoute();
const store = useStore(); // 状态信息管理
const loginUse = store.state.user.loginUser; // 当前用户
const selectedKeys = ref([route.path]); // 默认选中首页

// 路由跳转后 更新选中的菜单项
router.afterEach((to, from, failure) => {
  selectedKeys.value = [to.path];
});

const doMenuClick = (key: string) => {
  router.push({ path: key });
};

// todo 修改状态信息
// setTimeout(() => {
//   alert("2" + loginUse.userName);
//   store.dispatch("user/getLoginUser", {
//     userName: "yingzhu",
//     userRole: AccessEnum.ADMIN,
//   });
// }, 3000);

// 控制路由的显隐 展示在菜单的路由数组
const visibleRoutes = computed(() => {
  alert("1" + loginUse.userName);
  return routes.filter((item, index) => {
    if (item.meta?.hideInMenu) {
      return false;
    }
    // todo 根据权限过滤菜单
    if (!checkAccess(loginUse, item?.meta?.access as string)) {
      return false;
    }
    return true;
  });
});
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
