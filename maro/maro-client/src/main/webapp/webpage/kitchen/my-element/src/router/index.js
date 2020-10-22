import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main/Main'
import Login from '@/components/Main/Login'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/main',
    name: 'Main',
    component: Main
  }]
})
