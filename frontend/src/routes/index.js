const routes = [
	{ path: '/', component: () => import('../views/Home') },
];

const router = VueRouter.createRouter({
	history: VueRouter.createWebHashHistory(),
	routes,
});

export default router;
