import ACCESS_ENUM from "@/access/accessEnum";

/**
 * 检查权限
 * @param loginUser 当前登录用户
 * @param needAccess 需要有的权限 (默认值是未登录)
 * @returns boolean 是否有权限
 */
const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  // 获取当前用户的权限 如果没有则未登录
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;

  // 未登录用户可以访问的页面 放行
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    return true;
  }

  // 需要用户登录才能访问的页面
  if (needAccess === ACCESS_ENUM.USER) {
    // 如果用户未登录 则无权限
    if (loginUserAccess === ACCESS_ENUM.NOT_LOGIN) {
      return false;
    }
  }

  // 需要管理员权限才能访问的页面
  if (needAccess === ACCESS_ENUM.ADMIN) {
    // 如果用户不是管理员 则无权限
    if (loginUserAccess !== ACCESS_ENUM.ADMIN) {
      return false;
    }
  }
  return true; // 有权限 放行
};

export default checkAccess;
