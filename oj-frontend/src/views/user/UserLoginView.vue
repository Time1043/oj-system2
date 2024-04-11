<template>
  <div id="userLoginView">
    <h1>用户登录页面</h1>

    <a-form :model="form" :style="{ width: '600px' }" @submit="handleSubmit">
      <a-form-item field="userAccount" label="账号">
        <a-input v-model="form.userAccount" placeholder="请输入账号..." />
      </a-form-item>
      <a-form-item field="userPassword" tooltip="请输入密码" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码..."
        />
      </a-form-item>
      <a-form-item>
        <a-button html-type="submit">提交</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";

/**
 * 表单数据
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
});

/**
 * 提交表单事件
 * @param data
 */
const handleSubmit = (data: any) => {
  console.log(data);
  alert(JSON.stringify(data));
};
</script>
