import { createWebHistory, createRouter } from 'vue-router'

const home = import('../views/HomePage.vue')

const routes = [
	{ path: '/', component: home },
];

const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;
