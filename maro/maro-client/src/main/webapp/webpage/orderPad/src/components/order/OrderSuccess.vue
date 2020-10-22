<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="支付成功">
        <div slot="left" @click="back">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div>
        <div class="my-box suc-box">
          <yd-flexbox class="suc-title">
            <div class="suc-icon">
              <img :src="icon" />
            </div>
            <div class="suc-icon-text">您点的菜已下单</div>
          </yd-flexbox>
          <div class="suc-info">
            <div class="suc-text-table">第{{seatName}}</div>
            <yd-flexbox>
              <yd-flexbox-item>
                <div class="suc-text-black">您已点了{{amount}}道菜，共支付{{sum}}元</div>
              </yd-flexbox-item>
              <div class="suc-text-grey" style="display:none">点餐详情＞</div>
            </yd-flexbox>
          </div>
          <div class="suc-btn-box">
            <yd-button size="large" class="my-btn bg-theme" @click.native="back">加菜</yd-button>
          </div>
        </div>
      </div>
    </yd-layout>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      icon: require('../../assets/icon/pay_success.png'),
      pickList: [],
      sum: 0,
      amount: 0,
      seatName:''
    }
  },
  computed: {
    ...mapGetters([ 'getPick', 'getSum', 'getAmount','getSeatName' ])
  },
  created() {
    this.pickList = this.getPick
    this.sum = this.getSum
    this.amount = this.getAmount
    this.seatName=this.getSeatName
  },
  methods: {
    back() {
      this.$router.goBack()

      // 清空 vuex 对应值
      this.$store.dispatch('setPick', [])
      this.$store.dispatch('setSum', 0)
      this.$store.dispatch('setAmount', 0)

      // keepAlive 为 false 时将不缓存该路由, 重新请求数据
      this.$router.beforeEach((to, from, next) => {
        if (to.name === 'OrderBase' && from.name === 'OrderSuccess') {
          to.meta.keepAlive = true
        }
        next()
      })
    }
  }
}

</script>
<style>
.suc-box {
  padding: .2rem .3rem;
}

.suc-title {
  justify-content: center;
}

.suc-icon-box {
  margin: 0 auto;
}

.suc-icon {
  width: 1.8rem;
  height: 1.8rem;
}

.suc-icon>img {
  width: 100%;
}

.suc-icon-text {
  font-size: .48rem;
  margin-left: .75em;
  color: #666;
}

.suc-info {
  margin-top: .4rem;
  padding-top: .2rem;
  position: relative;
}

.suc-info:before {
  content: "";
  position: absolute;
  z-index: 0;
  top: 0;
  left: 0;
  right: 0;
  border-bottom: 1px solid #d9d9d9;
  transform: scaleY(.5);
  transform-origin: 0 0;
}

.suc-text-table {
  font-size: .4rem;
  color: #333;
  margin-bottom: .12rem;
}

.suc-text-black,
.suc-text-grey {
  font-size: .24rem;
}

.suc-text-black {
  color: #333;
}

.suc-text-grey {
  color: #999;
}

.suc-btn-box {
  margin-top: .21rem;
}

</style>
