// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import Element from 'element-ui'
import 'element-ui/lib/element-#CC406D/index.css'
import './lib/setHtmlRem.js'
import common from './assets/js/common.js'
Vue.use(Element, { size: 'medium' })
Vue.prototype.$http = axios
axios.defaults.withCredentials = true

if (window.client != 'undefined' && window.client != undefined) {
  Vue.prototype.BaseUrl = client.addr()
}else{
  Vue.prototype.BaseUrl = 'http://10.10.11.54:8082/'
}

//Vue.prototype.BaseUrl = 'http://10.10.11.122:8080/jeecg/'

Vue.config.productionTip = false
Vue.prototype.common = common

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  //components: { App },
  render: h => h(App),
  template: '<App/>'
})
