<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="确认订单">
        <div slot="left" @click="$router.goBack()">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div class="my-container">
        <div class="my-box ord-box">
          <div class="ord-item ord-list" v-for="item, index in confirmList">
            <yd-flexbox>
              <yd-flexbox-item>
                <div class="ord-list-name">{{item.dishesName}}</div>
                <div class="ord-list-format fc-theme">
                  <template v-if="item.specificationsList.length > 1">{{item.spec.pageName}}</template>
                  <template v-for="value, key in item.spec.remarkArr">{{value}}&nbsp;</template>
                  <template v-if="item.spec.remark!==''">{{item.spec.remark}}</template>
                </div>
              </yd-flexbox-item>
              <div class="ord-list-amount">×{{item.quantity}}</div>
              <div class="ord-list-price">
                <span class="my-price fc-theme"><em>¥</em>{{item.spec.unitPrice * item.quantity}}</span>
              </div>
            </yd-flexbox>
          </div>
        </div>
      </div>
      <div slot="bottom" class="my-buy">
        <yd-flexbox class="my-buy-box">
          <yd-flexbox-item>
            <div class="my-buy-left yd-flexbox">
              <div class="my-price fc-theme"><em>¥</em>{{sum}}</div>
            </div>
          </yd-flexbox-item>
          <div class="my-buy-right">
            <button type="button" class="my-buy-pay bg-theme" @click="goPay">
              <span class="my-buy-pay-text">结账</span>
            </button>
          </div>
        </yd-flexbox>
      </div>
    </yd-layout>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      confirmList: [],
      sum: 0
    }
  },
  computed: {
    ...mapGetters([ 'getPick', 'getSum'])
  },
  created() {
    this.confirmList = this.getPick
    this.sum = this.getSum
  },
  methods: {
    goPay() {
      this.$router.replace({
        name: 'OrderPay'
      })
    }
  }
}

</script>
<style scoped>
.ord-box {
  padding: .1rem 0;
}

.ord-item {
  font-size: .28rem;
  line-height: 1.5;
  padding: .07rem .4rem;
}

.ord-cell {
  padding: .07rem .4rem;
}

.ord-cell-label {
  text-align: left;
  padding-right: 1em;
}

.ord-cell-value {
  text-align: right;
}

.ord-list-head {
  padding: .15rem .4rem .2rem;
  margin-bottom: .1rem;
  position: relative;
}

.ord-list-head:after {
  content: "";
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
  border-bottom: 1px solid #e1e1e1;
  transform: scaleY(.5);
  transform-origin: 0 0;
}

.ord-list-amount {
  width: 15%;
}

.ord-list-price {
  width: 4.5em;
  text-align: right;
}

.ord-list-status {
  width: 2em;
}

</style>
