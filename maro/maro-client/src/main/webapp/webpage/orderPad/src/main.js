// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
import YDUI from 'vue-ydui'
import 'vue-ydui/dist/ydui.rem.css'
import '@/assets/css/reset.css'
import store from './store'
import 'vue-ydui/dist/ydui.flexible.js'
import qs from 'qs'
import common from './assets/js/common.js'
import router from './router'
Vue.config.productionTip = false

Vue.use(YDUI)
Vue.prototype.$http = axios
Vue.prototype.$qs = qs
Vue.prototype.arrStatus = ['即起', '打厨', '出锅', '加急', '催菜', '', '已上'];

//axios.defaults.baseURL = 'http://10.10.11.116:8080/jeecg/'
// axios.defaults.baseURL = 'http://10.10.11.121:8080/maro/'
//axios.defaults.baseURL = 'http://10.135.16.105:8080/jeecg';
Vue.prototype.BasePhonto = 'http://10.135.16.105:8080/jeecg';
// axios.defaults.baseURL = 'http://app.tuxingtianxia.com.cn/client/'
axios.defaults.withCredentials = true

Vue.prototype.common = common
//Vue.use(common);

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
