<template>
  <div id="userLoginView">
    <h2 style="margin-bottom: 16px">welcome to user login</h2>

    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="账号">
        <a-input v-model="form.userAccount" placeholder="请输入账号..." />
      </a-form-item>
      <a-form-item field="userPassword" tooltip="密码不少于8位" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码..."
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" style="width: 120px" html-type="submit"
          >登录
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

/**
 * 表单数据
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
});

const router = useRouter();
const store = useStore();

/**
 * 提交表单事件
 * @param data
 */
const handleSubmit = async (data: any) => {
  const res = await UserControllerService.userLoginUsingPost(form);
  if (res.code === 0) {
    // 登录成功跳转到首页 (有重定向的url)
    await store.dispatch("user/getLoginUser");
    router.push({ path: "/", replace: true });
  } else {
    message.error("登录失败：" + res.message);
  }
};
</script>
