import Vue from 'vue'
import axios from 'axios'
import router from './../../router'
export default{
    $ajax:function(api,param,fucSuss,fucErr) {
        //是否显示加载中
        if (param.hasOwnProperty("isLoading")) {
          if (param.isLoading) {
            if (param.hasOwnProperty('loadingText')) {
              param.myVue.$dialog.loading.open(param.loadingText);
            } else {
              param.myVue.$dialog.loading.open('加载中.....');
            }
          }
        } else {
          param.myVue.$dialog.loading.open('加载中.....');
        }
      let baseUrl= window.localStorage.getItem('baseUrl');

      axios.post("http://"+baseUrl+'/client'+api, param.data)
          .then((res) => {
            if (param.hasOwnProperty("isLoading")) {
              if (param.isLoading) {
                param.myVue.$dialog.loading.close();
              }
            } else {
              param.myVue.$dialog.loading.close();
            }
            if(res.data.success){
              fucSuss(res.data);
            }else{
              if(res.data.obj==100){
                this.login(api,param,fucSuss,fucErr);
              }else{
                fucErr(res);
              }

            }
          })
          .catch((err) => {
            if (param.hasOwnProperty("isLoading")) {
              if (param.isLoading) {
                param.myVue.$dialog.loading.close();
              }
            } else {
              param.myVue.$dialog.loading.close();
            }

            // param.myVue.$dialog.toast({
            //   mes: '网络请求错误',
            //   timeout: 2000,
            //   icon: 'error'})
            router.push({
              path: '/login'
            })
          })
      },
      login:function(api,param,fucSuss,fucErr){
        let data = new URLSearchParams()
        data.append('user', window.localStorage.getItem('user'))
        data.append('pass',window.localStorage.getItem('pass'))
        data.append("isLogin", true)
        let baseUrl= window.localStorage.getItem('baseUrl');
        axios.post("http://"+baseUrl+'/client/clientUserController.do?login', data)
          .then((res) => {
            console.log(res);
            if(res.data.success){
              this.$ajax(api,param,fucSuss,fucErr)
            }else{
              router.push({
                path: '/login'
              })
            }
          })
          .catch((err) => {
            router.push({
              path: '/login'
            })
            //param.myVue.$dialog.showWarn('网络错误，请检查网络环境');
          })
      }

}
