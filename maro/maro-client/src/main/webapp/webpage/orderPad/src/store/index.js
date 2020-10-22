import Vue from 'vue'
import vuex from 'vuex'
Vue.use(vuex)

import cart from './modules/cart.js'

export default new vuex.Store({
  modules: {
    cart: cart
  }
})
