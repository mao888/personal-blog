//Vue项目的入口
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import Element from 'element-ui' //引进element-ui
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios' //引进axios   和ajax类似  不过axios是基于promise

import "./axios"
import "./permission"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

// use
Vue.use(Element) //全局使用
Vue.use(mavonEditor)

Vue.config.productionTip = false
Vue.prototype.$axios = axios //全局使用
Vue.prototype.$store = store //全局使用
new Vue({
  router,
  store,
  beforeCreate(){
    Vue.prototype.$bus = this;
  },
  render: h => h(App)
}).$mount('#app')