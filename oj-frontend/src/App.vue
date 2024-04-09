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

const router = useRouter();
const store = useStore();

router.beforeEach((to, from, next) => {
  // 能够监听到路由信息 且有权限信息
  if (to.meta?.access === "canAdmin") {
    // 该页面需要管理员权限
    if (store.state.user.loginUser?.role !== "admin") {
      // 当前用户不是管理员
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
