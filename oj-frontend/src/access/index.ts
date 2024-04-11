import router from "@/router";
import store from "@/store";
import ACCESS_ENUM from "@/access/accessEnum";
import checkAccess from "@/access/checkAccess";

router.beforeEach(async (to, from, next) => {
  console.log("登录用户信息：", store.state.user.loginUser);

  const loginUser = store.state.user.loginUser;
  // loginUser不存在 或 userRole不存在(还未触发登录) 则自动登录
  if (!loginUser || !loginUser.userRole) {
    // await 等用户登录成功后再执行路由跳转
    await store.dispatch("user/getLoginUser");
  }

  // 要去页面的权限
  const needAccess = (to.meta.access as string) ?? ACCESS_ENUM.NOT_LOGIN;
  // 如果用户访问的页面需要登录 强制跳转登录页面
  if (needAccess !== ACCESS_ENUM.NOT_LOGIN) {
    // 如果没登陆 强制跳转登录页面
    if (!loginUser || !loginUser.userRole) {
      next(`/user/login?redirect=${to.fullPath}`);
      return;
    }
    // 如果登陆了 则判断用户权限
    if (!checkAccess(loginUser, needAccess)) {
      next("/noAuth");
      return;
    }
  }

  next();
});
