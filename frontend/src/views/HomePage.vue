<script setup>
    import { ref } from 'vue';
    import url from '../api/url';
    
    const input = ref('');
    const fill = ref(true);

    let shortenedUrl = '';

    const baseHost = 'http://localhost.com/';

    const handleShortenUrl = (inputURL) => {
        url.getURLs(inputURL).then(
            (res) => {
                console.log(res);
                shortenedUrl = `${baseHost}${res || '1234'}`;
            }
        );
    };

    
</script>

<template>
    <div id="home">
        <el-space :fill="fill" :size="200" wrap>
            <el-card shadow="always" class="box-card">
                <el-input v-model="input" size="large" placeholder="Enter the URL for shorten" clearable />
                <p><el-link type="primary" v-model="shortenedUrl"></el-link></p>
                <el-button type="primary" size="large" @click="handleShortenUrl">Shorten</el-button>
            </el-card>
        </el-space>
    </div>
</template>

<style scoped>
    #home {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
