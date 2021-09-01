/**
 * 页面已经开发完毕之后，
 * 来控制一下哪些页面是需要登录之后才能跳转的，
 * 如果未登录访问就直接重定向到登录页面
 */
import router from "./router";
// 路由判断登录 根据路由配置文件的参数
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requireAuth)) { // 判断该路由是否需要登录权限
        const token = localStorage.getItem("token")
        console.log("------------" + token)
        if (token) { // 判断当前的token是否存在 ； 登录存入的token
            if (to.path === '/login') {
            } else {
                next()
            }
        } else {
            next({
                path: '/login'
            })
        }
    } else {
        next()
    }
})