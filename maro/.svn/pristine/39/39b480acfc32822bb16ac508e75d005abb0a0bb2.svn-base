const cart = {
  state: {
    // 共享状态, state相当于对外的只读属性
    pick: [],
    sum: 0,
    amount: 0,
    //订单号
    orderId:'',
    //桌id
    seatId:'',
    seatName:'',
    openId:'',
    shopId:'',

    sales:[],//套餐规则
    FoodOrder:[]//已下单的菜
  },
  mutations: {
    setFoodOrder(state, payload){
      state.FoodOrder = payload
    },
    setSales(state, payload){
      state.sales = payload
    },
    // 改变内部状态的方法(同步)
    setPick(state, payload) {
      state.pick = payload
    },
    setSum(state, payload) {
      state.sum = payload
    },
    setAmount(state, payload) {
      state.amount = payload
    },
    setOrderId(state, payload) {
      state.orderId = payload
    },
    setSeatId(state, payload) {
      state.seatId = payload
    },
    setSeatName(state, payload) {
      state.seatName = payload
    },
    setOpenId(state, payload) {
      state.openId = payload
    },
    setShopId(state, payload) {
      state.shopId = payload
    }
  },
  actions: {
    setFoodOrder ({ commit, state }, value) {
      commit('setFoodOrder', value)
    },
    setSales ({ commit, state }, value) {
      commit('setSales', value)
    },
    // 由外部执行多个mutations(可执行异步操作)
    setPick ({ commit, state }, value) {
      commit('setPick', value)
    },
    setSum ({ commit, state }, value) {
      commit('setSum', value)
    },
    setAmount ({ commit, state }, value) {
      commit('setAmount', value)
    },
    setOrderId ({ commit, state }, value) {
      commit('setOrderId', value)
    },
    setSeatId ({ commit, state }, value) {
      commit('setSeatId', value)
    },
    setSeatName ({ commit, state }, value) {
      commit('setSeatName', value)
    },
    setOpenId ({ commit, state }, value) {
      commit('setOpenId', value)
    },
    setShopId ({ commit, state }, value) {
      commit('setShopId', value)
    }
  },
  getters: {
    setFoodOrder: (state, getters) => {
      return state.FoodOrder
    },
    setSales: (state, getters) => {
      return state.sales
    },
    // 相当于计算属性, 由外部调用取值
    getPick: (state, getters) => {
      return state.pick
    },
    getSum: (state, getters) => {
      return state.sum
    },
    getAmount: (state, getters) => {
      return state.amount
    },
    getOrderId: (state, getters) => {
      return state.orderId
    },
    getSeatId: (state, getters) => {
      return state.seatId
    },
    getSeatName: (state, getters) => {
      return state.seatName
    },
    getOpenId: (state, getters) => {
      return state.openId
    },
    getShopId: (state, getters) => {
      return state.shopId
    }
  }
}

export default cart
