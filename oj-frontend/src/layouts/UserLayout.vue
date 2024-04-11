<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header"> 用户布局</a-layout-header>

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
#userLayout .header {
  margin-bottom: 16px;
  box-shadow: #eee 1px 1px 5px;
}

#userLayout .content {
  background: linear-gradient(to right, #bbb, #fff);
  margin-bottom: 16px;
  padding: 20px;
}

#userLayout .footer {
  background: #efefef;
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>

<script></script>
