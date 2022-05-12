import * as VueRouter from 'vue-router'
import { createApp } from 'vue'

const Home = import('../views/HomePage.vue')

const routes = [
	{ path: '/', component: Home },
];

const router = VueRouter.createRouter({
	history: VueRouter.createWebHashHistory(),
	routes,
});

const app = createApp({})

app.use(router)
app.mount('#app')

export default router;
