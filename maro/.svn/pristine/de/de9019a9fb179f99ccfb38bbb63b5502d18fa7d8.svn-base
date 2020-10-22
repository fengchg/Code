import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login/Login'
import Table from '@/components/table/Table'
import OrderBase from '@/components/order/OrderBase'
import OrderDetail from '@/components/order/OrderDetail'
import OrderUrge from '@/components/order/OrderUrge'
import OrderConfirm from '@/components/order/OrderConfirm'
import OrderPay from '@/components/order/OrderPay'
import OrderSuccess from '@/components/order/OrderSuccess'

Vue.use(Router)
Router.prototype.isBack = false
Router.prototype.goBack = function() {
  this.isBack = true
  window.history.go(-1)
}

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        title: '登录',
        keepAlive: false
      }
    },{
      path: '/',
      name: 'Table',
      component: Table,
      meta: {
        title: '餐桌',
        keepAlive: false
      },beforeEnter: (to, from, next) => {
        let isLogin=window.localStorage.getItem('isLogin');
        if(!isLogin){
          next({path: '/login'});
        }else{
          next();
        }
      }
    },
    {
    path: '/orderBase',
    name: 'OrderBase',
    component: OrderBase,
    meta: {
      title: '点餐',
      keepAlive: false
    }
  }, {
    path: '/detail',
    name: 'OrderDetail',
    component: OrderDetail,
    meta: {
      title: '订单详情',
      keepAlive: false
    }
  }, {
    path: '/urge',
    name: 'OrderUrge',
    component: OrderUrge,
    meta: {
      title: '催菜',
      keepAlive: false
    }
  }, {
    path: '/confirm',
    name: 'OrderConfirm',
    component: OrderConfirm,
    meta: {
      title: '确认订单',
      keepAlive: false
    }
  }, {
    path: '/pay',
    name: 'OrderPay',
    component: OrderPay,
    meta: {
      title: '支付',
      keepAlive: false
    }
  }, {
    path: '/ordersuccess',
    name: 'OrderSuccess',
    component: OrderSuccess,
    meta: {
      title: '支付成功',
      keepAlive: false
    }
  }]

})
