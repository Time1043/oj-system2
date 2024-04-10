<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
}
</style>

<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { onMounted } from "vue";
import AccessEnum from "@/access/accessEnum";

/**
 * 全局初始化函数，全局单次调用的代码
 */
const doInit = () => {
  // todo 初始化函数
  console.log("hello shiOJ welcome");
};

onMounted(() => {
  doInit();
});

const router = useRouter();
const store = useStore();

router.beforeEach((to, from, next) => {
  // 能够监听到路由信息 且有权限信息
  if (to.meta?.access === AccessEnum.ADMIN) {
    // 该页面需要管理员权限
    if (store.state.user.loginUser?.userRole !== AccessEnum.ADMIN) {
      // 当前用户不是管理员
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
