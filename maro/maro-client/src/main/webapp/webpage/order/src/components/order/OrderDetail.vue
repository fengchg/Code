<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="订单详情">
        <div slot="left" @click="backTo">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div class="my-container">
        <div class="my-box ord-box">
          <div class="ord-item ord-cell">
            <yd-flexbox>
              <div class="ord-cell-label">下单时间</div>
              <yd-flexbox-item>
                <div class="ord-cell-value">{{beginTime}}</div>
              </yd-flexbox-item>
            </yd-flexbox>
          </div>
          <div class="ord-item ord-cell">
            <yd-flexbox>
              <div class="ord-cell-label">下单流水号</div>
              <yd-flexbox-item>
                <div class="ord-cell-value">{{disNo}}</div>
              </yd-flexbox-item>
            </yd-flexbox>
          </div>
        </div>
        <div class="my-box ord-box">
          <!-- <div class="ord-item ord-list-head fc-theme">
            <yd-flexbox>
              <yd-flexbox-item>
                <div class="ord-list-name">菜品名称</div>
              </yd-flexbox-item>
              <div class="ord-list-amount">数量</div>
              <div class="ord-list-price">价格</div>
              <div class="ord-list-status">状态</div>
            </yd-flexbox>
          </div> -->
          <div class="ord-item ord-list" v-for="item, index in orderList">
            <yd-flexbox>
              <yd-flexbox-item>
                <div class="ord-list-name">{{item.foodName}}</div>
                <div class="ord-list-format fc-theme">{{item.specificationsName}}</div>
              </yd-flexbox-item>
              <div class="ord-list-amount">×{{item.quantity}}</div>
              <div class="ord-list-price">
                <span class="my-price fc-theme"><em>¥</em>{{item.price}}</span>
              </div>
              <div class="ord-list-status">{{item.statusText}}</div>
            </yd-flexbox>
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
      orderList: [],
      disNo: '',
      beginTime: ''
    }
  },
  computed: {
  ...mapGetters([ 'getOrderId','getPick'])
  },
  components: {},
  created() {
    this.$dialog.loading.open('努力获取订单信息中');
    // 获取订单详情
    let param = new URLSearchParams()
    param.append('serverOrderId', this.getOrderId)
    console.log(this.getOrderId)
    this.$http.post('maroClientServerorderController.do?getServerOrderById', param)
      .then((res) => {
        console.log(res);
        if (res.data.success) {
          this.$dialog.loading.close()
          this.handleOrderData(res.data.obj)
        } else {
          this.getOrderError(res)
        }
      })
      .catch((err) => {
        console.log(res);
        this.getOrderError(err)
      })
  },
  methods: {
    getOrderError(obj) {
      this.$dialog.loading.close()
      this.$router.goBack()

      // 获取数据出错的回调函数
      this.$dialog.notify({
        mes: '暂时无法获取订单详情，请稍后重试。',
        timeout: 5000
      })
    },
    handleOrderData(obj) {
      this.disNo = obj.maroClientServerorderVO.code
      this.beginTime = this.stampToTime(obj.maroClientServerorderVO.beginTime)
      this.orderList = [].concat(obj.maroClientFoodOrderVOs)

      for (let i = 0; i < this.orderList.length; i++) {
        this.$set(this.orderList[i], 'statusText', this.arrStatus[this.orderList[i].status])
      }
    },
    stampToTime(timestamp) {
      let t = this
      let date = new Date(timestamp.length == 10 ? timestamp * 1000 : timestamp)
      let y = date.getFullYear()
      let m = t.supplyZero(date.getMonth() + 1)
      let d = t.supplyZero(date.getDate())
      let h = t.supplyZero(date.getHours())
      let n = t.supplyZero(date.getMinutes())
      let s = t.supplyZero(date.getSeconds())
      return y + '-' + m + '-' + d + ' ' + h + ':' + n + ':' + s
    },
    supplyZero(num) {
      return Number(num) < 10 ? '0' + num : num;
    },
    backTo(){
      this.$router.goBack();
      if(this.getPick.length==0){
        this.$router.beforeEach((to, from, next) => {
          console.log(to);
          if (to.name === 'OrderBase') {
            to.meta.keepAlive = false
          }
          next()
        })
      }

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
}

.ord-list-status {
  width: 2em;
}

</style>
