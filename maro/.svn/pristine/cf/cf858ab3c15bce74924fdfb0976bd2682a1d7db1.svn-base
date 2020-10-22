<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="催菜">
        <div slot="left" @click="$router.goBack()">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div class="my-container">
        <div class="my-box urge">
          <yd-checklist v-model="checkList" color="#ED3368">
            <yd-checklist-item v-for="item, index in urgeList" :key="index" :val="index">
              <yd-flexbox class="urge-pick">
                <yd-flexbox-item>
                  <div class="urge-pick-name">{{item.foodName}}</div>
                  <div class="urge-pick-format fc-theme">{{item.specificationsName}}</div>
                </yd-flexbox-item>
                <div>
                  <span class="my-price fc-theme"><em>¥</em>{{item.price}}</span>
                </div>
              </yd-flexbox>
            </yd-checklist-item>
          </yd-checklist>
        </div>
      </div>
      <div slot="bottom" class="my-btn-box">
        <yd-button size="large" type="primary" shape="circle" class="my-btn my-btn-shade bg-theme" @click.native="urgeSubmitHandle">确定</yd-button>
      </div>
    </yd-layout>
  </div>
</template>
<script>
  import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      serverOrderId: '54598430-3eb7-43f8-9c89-507664c92edb',
      urgeList: [],
      checkList: [],
      submitList: []
    }
  },
  computed: {
  ...mapGetters([ 'getOrderId'])
  },
  created() {
    this.$dialog.loading.open('努力获取菜品信息中');
    // 获取订单详情
    let param = new URLSearchParams()
    param.append('serverOrderId', this.getOrderId)
    this.$http.post('maroClientServerorderController.do?getServerOrderById', param)
      .then((res) => {
        if (res.data.success) {
          this.$dialog.loading.close()
          this.handleDishData(res.data.obj)
        } else {
          this.getDishError(res)
        }
      })
      .catch((err) => {
        this.getDishError(err)
      })
  },
  methods: {
    getDishError(obj) {
      this.$dialog.loading.close()
      this.$router.goBack()

      // 获取数据出错的回调函数
      this.$dialog.notify({
        mes: '暂时无法获取菜品信息，请稍后重试。',
        timeout: 5000
      })
    },
    handleDishData(obj) {
      this.urgeList = obj.maroClientFoodOrderVOs.filter((m) => {
        return m.states !== 6
      })
    },
    urgeSubmitHandle() {
      // 处理催菜数据
      this.submitList.splice(0, this.submitList.length)

      if (this.checkList.length === 0) {
        this.$dialog.notify({
          mes: '请先选择需要催的菜品。',
          timeout: 3000
        })
        return
      }

      for (let i = 0; i < this.checkList.length; i++) {
        let n = this.urgeList[this.checkList[i]]
        let urgeObj = {
          'id': n.id,
          'foodName': n.foodName,
          'quantity': n.quantity
        }
        this.submitList.push(urgeObj)
      }

      this.urgeSubmit()
    },
    urgeSubmit() {
      this.$dialog.loading.open('正在为你催菜中');
      // 提交催菜数据
      let thisObj = {
        'maroClientFoodorderDOList': this.submitList,
        'maroClientServerorderDO': {
          'id': this.serverOrderId
        }
      }

      let param = new URLSearchParams()
      param.append('foodOrderParamsDTOJson', JSON.stringify(thisObj))
      this.$http.post('maroClientServerorderController.do?UrgeFood', param)
        .then((res) => {
          if (res.data.success) {
            this.$dialog.loading.close()
            this.urgeSubmitSuccess()
          } else {
            this.urgeSubmitError(res)
          }
        })
        .catch((err) => {
          this.urgeSubmitError(err)
        })
    },
    urgeSubmitError(obj) {
      // 提交催菜数据出错的回调函数
      this.$dialog.loading.close()
      this.$dialog.notify({
        mes: '暂时未能为您催菜，请稍后重试。',
        timeout: 5000
      })
    },
    urgeSubmitSuccess() {
      // 提交催菜数据成功后的操作
      this.$router.goBack()
      this.$dialog.toast({
          mes: '已为您催菜，菜品将尽快上桌',
          timeout: 2000,
          icon: 'success'
      })
    }
  }
}

</script>
<style scoped>
.urge .yd-checklist-item {
  margin-left: .3rem;
}

.urge .yd-checklist-content {
  padding-right: .3rem;
}

.urge .yd-checklist-item-icon {
  padding: .3rem;
  margin-left: -.3rem;
}

.urge .yd-checklist-icon {
  width: .4rem;
  height: .4rem;
}

.urge-pick {
  min-height: 1.12rem;
}

.urge-pick-name {
  font-size: .28rem;
}

.urge-pick-format {
  font-size: .24rem;
  margin-top: .06rem;
}

</style>
