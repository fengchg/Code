import Vue from 'vue'
import axios from 'axios'
import router from './../../router'
export default{
    $ajax:function(api,param,fucSuss,fucErr) {
      console.log(api,param);
      axios.post(api, param.data)
          .then((res) => {
            console.log(res);
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
            fucErr(err);
          })
      },
      login:function(api,param,fucSuss,fucErr){
      let that=this
        let data = new URLSearchParams();
      console.log(window.localStorage.getItem('user'),window.localStorage.getItem('password'))
        data.append('user', window.localStorage.getItem('user'))
        data.append('pass',window.localStorage.getItem('password'))
        data.append("isLogin", true)
        console.log(param.baseUrl);
        axios.post(param.baseUrl+'clientUserController.do?login', data)
          .then((res) => {
            if(res.data.success){
              that.$ajax(api,param,fucSuss,fucErr)
            }else{
              router.push({
                path: '/'
              })
            }
          })
          .catch((err) => {
            router.push({
              path: '/'
            })
            //param.myVue.$dialog.showWarn('网络错误，请检查网络环境');
          })
      }

}
