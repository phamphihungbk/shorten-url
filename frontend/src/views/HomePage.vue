<script setup>
import { ref } from 'vue';
import url from '../api/url';

const input = ref('');
const fill = ref(true);

const shortenedUrl = ref('');

const baseHost = 'http://localhost.com/';

const handleShortenUrl = async () => {
  const res = await url.getURLs(input.value).catch((e) => {
    console.log(e);
    shortenedUrl.value = `${baseHost}${input.value}`;
  });

  if (res) {
    shortenedUrl.value = `${baseHost}${res}`;
  }

  shortenedUrl.value = `${baseHost}${input.value}`;
};
</script>

<template>
  <div id="home">
    <!-- <el-container>
            <el-header></el-header>
            <el-main>
                <el-space :fill="fill" :size="200" wrap>
                    <el-card shadow="always" class="box-card">
                        <el-input v-model="input" size="large" placeholder="Enter the URL for shorten" target="_blank" clearable />
                        <p><el-link type="primary" :href="shortenedUrl">{{ shortenedUrl }}</el-link></p>
                        <el-button type="primary" size="large" @click="handleShortenUrl">Shorten</el-button>
                    </el-card>
                </el-space>
            </el-main>
            <el-footer></el-footer>
        </el-container> -->
    <el-space :fill="fill" :size="200" wrap>
      <el-card shadow="always" class="box-card">
        <el-input
          v-model="input"
          size="large"
          placeholder="Enter the URL for shorten"
          target="_blank"
          input-style="{ border-radius: 10px }"
          clearable
        />
        <p>
          <el-link type="primary" :href="shortenedUrl">{{
            shortenedUrl
          }}</el-link>
        </p>
        <el-button type="primary" size="large" @click="handleShortenUrl"
          >Shorten</el-button
        >
      </el-card>
    </el-space>
  </div>
</template>

<style>
#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  background-color: linear-gradient(
    to bottom right,
    rgba(255, 255, 255, 0.2),
    rgba(255, 255, 255, 0)
  );
}
.box-card {
  background-color: rgba(255, 255, 255, 0.4);
  border-radius: 15px;
  border: 0;
}

.el-input__wrapper {
  border-radius: 10px !important;
}
</style>
