<template>
	<div id="home">
		<el-container>
			<el-header></el-header>
			<el-main>
				<el-row :gutter="20">
					<el-col :span="12" :offset="6">
						<div v-if="data.length > 0">{{ data }}</div>
						<el-input v-model="originURL" placeholder="Enter the original URL">
							<template #prepend>Http://</template>
						</el-input>
						<el-button type="primary" size="large" @click="createItem" class="mrt-1">Get Shorten URL</el-button>
					</el-col>
				</el-row>
			</el-main>
			<el-footer></el-footer>
		</el-container>
	</div>
</template>

<script>
import {createURL} from "../api/url.js";

export default {
	name: 'HomePage',
	data() {
		return {
			data: '',
			originURL: '',
		}
	},
	methods: {
		async createItem() {
			this.data = await createURL(this.originURL);
		},
	},
}
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
