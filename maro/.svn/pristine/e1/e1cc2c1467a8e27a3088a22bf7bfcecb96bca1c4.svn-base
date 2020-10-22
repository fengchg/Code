<template>
  <div class="login-bg">
    <div class="login-box">
      <div class="login-logo">
        <img :src="logo"/>
        <div class="login-appname">子煊餐饮</div>
      </div>
      <div class="login-form">
        <yd-cell-group>
          <yd-cell-item>
            <yd-input slot="right" required v-model="baseUrl" max="100" placeholder="请输入服务器地址"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <yd-input slot="right" required v-model="user" max="20" placeholder="请输入用户名"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <yd-input slot="right" type="password" v-model="pass" placeholder="请输入密码"></yd-input>
          </yd-cell-item>
        </yd-cell-group>
      </div>
      <div class="login-div login-remember">
        <yd-checkbox v-model="remember" color="rgb(237, 51, 104)">
          <span class="login-remember-text">记住密码</span>
        </yd-checkbox>
      </div>
      <div class="login-div">
        <yd-button size="large" type="primary" shape="circle" class="my-btn bg-theme" @click.native="paySubmit">登录</yd-button>
      </div>
    </div>
  </div>
</template>

<script type="text/babel">
import Vue from 'vue'
import axios from 'axios'
export default {
  data () {
    return {
      user: '',
      pass: '',
      baseUrl: '',
      baseUrlShow: false,
      remember: false,
      logo: require('../../assets/icon/logo.png')
    }
  },
  created (){
   let baseShow= window.localStorage.getItem('baseUrlShow');
   if(baseShow==null){
     this.baseUrlShow=true;
     if(window.localStorage.getItem('baseUrl')!= null){
       this.baseUrl=window.localStorage.getItem('baseUrl')
     }

   }else{
     this.baseUrlShow=false;
   }

  },
  methods: {
    paySubmit () {
      let that = this;

        if (this.baseUrl=='') {
          this.$dialog.notify({
            mes: '请填写服务器地址',
            timeout: 2000
          })
          return false
        } else {
          window.localStorage.setItem('baseUrl', this.baseUrl);
        }


      //校验参数是否正确
      if (!this.verifyParam()) {
        return false;
      }

      //定义请求参数
      let data = new URLSearchParams()
      data.append('user', this.user)
      data.append('pass', this.pass)
      data.append("isLogin", true)
      //定义需要调用公共方法的ajax请求的参数
      let param={
        loadingText:'登录中...',
        isLoading:true,
        data:data,
        myVue:this
      }
      this.common.$ajax('/clientUserController.do?login', param, function (obj) {
        console.log(obj);
        window.localStorage.setItem('isLogin',true);
        window.localStorage.setItem('user',that.user);
        window.localStorage.setItem('pass',that.pass);
        window.localStorage.setItem('waiterId',obj.obj.id);
        window.localStorage.setItem('waiterName',obj.obj.realName);
        window.localStorage.setItem('baseUrlShow',false);
        window.localStorage.setItem('shopName',obj.obj.maroShopEntity.name);
        if (that.baseUrlShow) {
          window.localStorage.setItem('baseUrl', that.baseUrl);
        }
        that.$router.push({
          name: 'Table'
        })
      }, function (obj) {
        that.$dialog.notify({
          mes: obj.data.msg,
          timeout: 2000
        })
        console.log(obj);
      })
    },
    verifyParam () {
      if (this.user=='') {
        this.$dialog.notify({
            mes: '用户名不能为空',
            timeout: 2000
        });
        return false;
      } else if (this.pass == '') {
        this.$dialog.notify({
          mes: '密码不能为空',
          timeout: 2000
        })
        return false;
      }
      return true;
    }
  }
}
</script>

<style scoped>
.login-bg {
  width: 100%;
  height: 100%;
  /*display: flex;
  align-items: center;
  justify-content: center;*/
  background: linear-gradient(to right, rgba(239,92,72,.7) 0%, rgba(204,64,109,.7) 100%);
}

.login-box {
  width: 100%;
}

.login-logo {
  padding: 1.06rem .2rem .8rem;
}

.login-logo > img {
  display: block;
  width: 1.92rem;
  height: 1.92rem;
  margin: 0 auto;
}

.login-appname {
  font-size: .56rem;
  text-align: center;
  color: #fff;
  margin-top: .2rem;
}

.login-form {
  background-color: #fff;
}

.login-div {
  padding: .1rem .2rem;
}

.login-remember {
  text-align: right;
}

.login-remember-text {
  color: #fff;
  padding-left: .1rem;
}
</style>
