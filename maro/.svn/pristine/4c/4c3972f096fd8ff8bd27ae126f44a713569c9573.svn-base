<template>
  <div class="login-bg">
    <div class="login-box">
      <el-form ref="ruleForm" :model="form" status-icon :rules="rules" size="large" v-cloak>
        <el-form-item prop="name">
          <el-input v-model="form.name" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="pass">
          <el-input type="password" v-model="form.pass" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item prop="mark">
          <!-- <el-switch v-model="form.mark" width="80"></el-switch>
          <span>记住密码</span> -->
          <el-checkbox v-model="form.mark">记住密码</el-checkbox>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit('ruleForm')">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    var valiName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('账号不能为空'));
      } else {
        setTimeout(() => {
          callback();
        }, 300);
      }
    };
    var valiPass = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('密码不能为空'));
      } else {
        setTimeout(() => {
          callback();
        }, 300);
      }
    };

    return {
      form: {
        name: '',
        pass: '',
        mark: false
      },
      rules: {
        name: [
          { validator: valiName, trigger: 'blur' }
        ],
        pass: [
          { validator: valiPass, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    if (localStorage.getItem('name') != null) {
      this.form.name = localStorage.getItem('name');
      this.form.pass = localStorage.getItem('pass');
      this.form.mark = true;
    } else {
      this.form.mark = false;
    }
  },
  methods: {
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let that = this;
          let data = new URLSearchParams();
          data.append("user", this.form.name)
          data.append("pass", this.form.pass)
          data.append("isLogin", true)

          const loading = this.$loading({
            lock: true,
            text: '正在登录……',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)',
            customClass: 'login-loading'
          });
          let param={
            data:data,
            myVue:this
          }
          this.common.$ajax(this.BaseUrl +'clientUserController.do?login', param, function (obj) {
            loading.close();
              that.$message.success({
                message: '登录成功!'
              });
              that.$router.push({
                path: '/main'
              })
              localStorage.setItem('user', that.form.name);
              localStorage.setItem('password', that.form.pass);
              if (that.form.mark) {
                localStorage.setItem('name', that.form.name);
                localStorage.setItem('pass', that.form.pass);
              } else {
                localStorage.removeItem('name');
                localStorage.removeItem('pass');
              }
          }, function (obj) {
            loading.close();
            that.$message.error('登录失败!');
          })

          // this.$http.post(this.BaseUrl + 'clientUserController.do?login', param, {
          //     withCredentials: true
          //   })
          //   .then(function(response) {
          //     console.log(response);
          //     loading.close();
          //     if (response.data.success) {
          //       that.$message.success({
          //         message: '登录成功!'
          //       });
          //       that.$router.push({
          //         path: '/main'
          //       })
          //       localStorage.setItem('user', that.form.name);
          //       localStorage.setItem('password', that.form.pass);
          //       if (that.form.mark) {
          //         localStorage.setItem('name', that.form.name);
          //         localStorage.setItem('pass', that.form.pass);
          //       } else {
          //         localStorage.removeItem('name');
          //         localStorage.removeItem('pass');
          //       }
          //     } else {
          //       that.$message.error('登录失败!');
          //     }
          //   })
          //   .catch(function(error) {
          //     console.log(error);
          //     loading.close();
          //     that.$message.error('登录失败!');
          //   })

          /**/
        } else {
          return false;
        }
      })
    }
  }
}

</script>
<style>
.el-button {
  font-size: .26rem;
  padding: .2rem .4rem;
  border-radius: .08rem;
}

.el-form-item {
  margin-bottom: .44rem;
}

.el-form-item__label {
  font-size: .28rem;
  line-height: .72rem;
}

.login-loading .el-loading-spinner i,
.login-loading .el-loading-spinner .el-loading-text {
  color: #fff;
}

.login-loading .el-loading-spinner .el-loading-text {
  font-size: .32rem;
}

.el-form-item__content {
  line-height: .72rem !important;
}

.el-input {
  font-size: .28rem;
}

.el-input__inner {
  height: .8rem;
  line-height: .8rem;
  border-radius: .08rem;
  padding: 0 .3rem;
}

.el-input__suffix {
  right: .1rem;
}

.el-input__icon {
  width: .5rem;
}

.el-form-item__error {
  font-size: .24rem;
  padding-top: .08rem;
}

.el-checkbox__inner {
  width: .28rem;
  height: .28rem;
  vertical-align: middle;
}

.el-checkbox__inner::after {
  height: .14rem;
  left: .08rem;
  top: .02rem;
  width: .06rem;
  border-width: .02rem;
}

.el-checkbox__label {
  font-size: .28rem;
  line-height: .38rem;
  padding-left: .2rem;
  vertical-align: middle;
}

.el-message {
  min-width: 7.6rem;
  top: .4rem;
  padding: .3rem .3rem .3rem .4rem;
}

.el-message .el-message__icon {
  font-size: .5rem;
}

.el-message .el-message__content {
  font-size: .28rem;
}

</style>
<style scoped>
.login-bg {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(to right, #ef5c48 0%, #cc406d 100%);
}

.login-box {
  width: 25%;
  padding: .44rem .44rem 0;
  border-radius: .16rem;
  background-color: rgba(255, 255, 255, 0.8);
}

</style>
