// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import YDUI from 'vue-ydui'
import axios from 'axios'
import 'vue-ydui/dist/ydui.rem.css'
import 'vue-ydui/dist/ydui.flexible.js'
Vue.prototype.$http = axios
Vue.config.productionTip = false
axios.defaults.baseURL = 'http://app.tuxingtianxia.com.cn/maro/'
/*function getRootPath(){
  //获取当前网址，如： https://localhost:8083/uimcardprj/share/meun.jsp
  var curWwwPath=window.document.location.href;
  //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
  var pathName=window.document.location.pathname;
  var pos=curWwwPath.indexOf(pathName);
  //获取主机地址，如： https://localhost:8083
  var localhostPaht=curWwwPath.substring(0,pos);
  //获取带"/"的项目名，如：/uimcardprj
  var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
  var commonPath=localhostPaht+projectName+"/";
  //alert(commonPath);
  axios.defaults.baseURL =commonPath;

}
getRootPath();*/
axios.defaults.withCredentials = true
Vue.use(YDUI)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
