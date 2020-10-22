// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import YDUI from 'vue-ydui'
import 'vue-ydui/dist/ydui.rem.css'
import '@/assets/css/reset.css'
import store from './store'
import 'vue-ydui/dist/ydui.flexible.js'
import qs from 'qs';

Vue.config.productionTip = false

Vue.use(YDUI)
Vue.prototype.$http = axios
Vue.prototype.$qs = qs
Vue.prototype.arrStatus = ['即起', '打厨', '出锅', '加急', '催菜', '', '已上']
//axios.defaults.baseURL = 'http://10.10.11.116:8080/jeecg/'
// axios.defaults.baseURL = 'http://10.10.11.121:8080/maro/'
 axios.defaults.baseURL = 'http://10.10.60.31:8081/'
axios.defaults.withCredentials = true

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
