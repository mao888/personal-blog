import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
// import Blogs from '../views/Blogs.vue'
import BlogEdit from '../views/BlogEdit.vue'
import BlogDetail from '../views/BlogDetail.vue'

Vue.use(VueRouter)

const routes = [
  //  主页面
  {
    path: '/',
    name: 'Index',
    redirect: { name: 'Blogs' }   //首页重定向到Blogs页面
  },
  //  博客主页
  {
    path: '/blogs',
    name: 'Blogs',
    // 懒加载
    component: () => import('../views/Blogs.vue')
  },
  //登录页面
  {
    path: '/login',
    name: 'Login',
    component: Login // 调到Login页面 正常写法
  },
  //  增：发表博客
  {
    path: '/blog/add', // 注意放在 path: '/blog/:blogId'之前
    name: 'BlogAdd',
    meta: {
      requireAuth: true   //添加路由权限
    },
    component: BlogEdit //每次路由之前（router.beforeEach）判断token的状态，觉得是否需要跳转到登录页面
  },
  //点击 进入对应文章界面
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: BlogDetail
  },
  //改：进入对应文章界面 并对文章进行编辑
  {
    path: '/blog/:blogId/edit',
    name: 'BlogEdit',
    meta: {
      requireAuth: true   //添加路由权限
    },
    component: BlogEdit
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
