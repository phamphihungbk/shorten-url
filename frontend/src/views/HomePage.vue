<template>
  <div id="home">
    <el-container>
      <el-header></el-header>
      <el-main>
        <el-row :gutter="20">
          <el-col :span="4" :offset="10">
            <el-image src="./logo.png" lazy />
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12" :offset="6">
            <div v-show="data.length !== 0">
              Your shorten URL is
              <b>http://localhost:8080/api/v1/url/{{ data.id }}</b>
            </div>
            <el-input
              v-model="input.originalUrl"
              placeholder="Enter the full original URL includes https"
            >
            </el-input>
            <el-button
              type="primary"
              size="large"
              @click="createItem"
              class="mrt-1"
              >Get Shorten URL</el-button
            >
          </el-col>
        </el-row>
      </el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>

<script>
import { createURL } from '@/api/url.js';

export default {
  name: 'HomePage',
  data() {
    return {
      input: {
        originalUrl: '',
      },
      data: [],
    };
  },
  methods: {
    async createItem() {
      this.data = await createURL(this.input);
    },
  },
};
</script>

<style scoped lang="scss">
.mrt-1 {
  margin-top: 1rem;
}
#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
