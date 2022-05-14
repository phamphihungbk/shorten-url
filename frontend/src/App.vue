<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
</script>

<template>
  <el-container>
    <el-header>
      <p>
        <!-- <el-page-header title="Vue URL Shortener" /> -->
        Vue URL Shortener
      </p>
    </el-header>
    <div id="app">
        <router-view></router-view>
      </div>
    <el-footer></el-footer>
  </el-container>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  height: 100vh;
}
p {
  text-align: center;
}
</style>
