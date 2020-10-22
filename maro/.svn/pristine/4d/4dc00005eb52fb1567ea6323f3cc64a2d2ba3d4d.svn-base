<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="支付">
        <div slot="left" @click="$router.goBack()">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div class="my-container">
        <div class="my-box pay-cell">
          <yd-cell-group>
            <yd-cell-item arrow type="label">
              <span slot="left">会员</span>
            </yd-cell-item>
            <yd-cell-item arrow type="label">
              <span slot="left">优惠</span>
            </yd-cell-item>
          </yd-cell-group>
        </div>
        <div class="pay-methods">
          <div class="pay-methods-title">选择支付方式</div>
          <div class="pay-methods-box">
            <div class="pay-methods-item" v-for="item, index in payMethods" :key="index">
              <div class="pay-methods-item-con" @click="pickPay(item, index)" :class="{'active': payPickId === item.id}">
                <div class="pay-methods-icon" :style="{backgroundImage: 'url(' + item.icon + ')'}"></div>
                <div class="pay-methods-name" v-text="item.name"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div slot="bottom" class="my-btn-box">
        <yd-button size="large" type="primary" shape="circle" class="my-btn my-btn-shade bg-theme" @click.native="paySubmit">确定</yd-button>
      </div>
    </yd-layout>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      payMethods: [{
        icon: require('../../assets/icon/pay_wechat.png'),
        id: '0',
        name: '微信支付'
      }, {
        icon: require('../../assets/icon/pay_zfb.png'),
        id: '1',
        name: '支付宝'
      }, {
        icon: require('../../assets/icon/pay_credit.png'),
        id: '2',
        name: '信用卡'
      }, {
        icon: require('../../assets/icon/pay_yuan.png'),
        id: '3',
        name: '现金'
      }],
      payPickId: '',
      pickList: []
    }
  },
  computed: {
    ...mapGetters([ 'getPick','getOrderId','getSeatId','getSum'])
  },
  created() {
    this.pickList = this.getPick
  },
  methods: {
    pickPay(n, i) {
      // 选择支付方式
      this.payPickId = this.payPickId !== '' && this.payPickId === n.id ? '' : n.id
    },
    paySubmit() {
      // 点击确定
      if (this.payPickId === '') {
        this.$dialog.notify({
          mes: '请选择支付方式。',
          timeout: 3000
        })
        return
      }
      let foodorderDOList=new Array()
        for(let i=0;i<this.pickList.length;i++){
          let food=this.pickList[i]
          let remarkArr=''
          for(let j=0;j<food.spec.remarkArr.length;j++){
            remarkArr=remarkArr+food.spec.remarkArr[j]
          }
          let foodList={
             'foodId': food.id,
             'quantity': food.quantity,
             'specificationsId': food.spec.id,
             'specificationsName': food.spec.pageName,
             'unitCode':food.unit,
             'unitName':food.unitName,
             'price':food.spec.unitPrice,
             'remark':remarkArr
           }
          foodorderDOList.push(foodList)
       }
      let foodOrderParamsDTOListJson={
        "maroClientServerorderDO":{
          "id":this.getOrderId,
          "kitchenNotify":1,
          "openId":"chidalu"
        },
        "maroShopSeatEntity":{
          "id":this.getSeatId
        },
        "maroClientFoodorderDOList":foodorderDOList
      };
      let payParamsDTOJson={
        "maroClientServerorderDO":{
          "id":this.getOrderId,
          "smallChange":0,
          "billMoney":0,
          "makeBillType":0,
          "memberPhone":"",
          "memberId":"",
          "memberName":""
        },
        "maroClientPayedDO":{
          "payType":0,
          "payTerminal":1,
          "cardNumber":'',
          "amount":this.getSum,
          "serverOrderId":this.getOrderId,
        },
        "maroClientPayedDetailDOList":[{'payType':0,
          'payTerminal':1,
          'amount':this.getSum}]
      }
   /*   let postData = this.$qs.stringify({
        'foodOrderParamsDTOString':foodOrderParamsDTOListJson,
        'payParamsDTOJson':payParamsDTOJson,
        'user': 'y1',
        'pass':'888888'
      });*/
      //console.log(postData)
      let param = new URLSearchParams()
      //console.log(JSON.stringify(payParamsDTOJson))
      param.append('foodOrderParamsDTOString', JSON.stringify(foodOrderParamsDTOListJson))
      param.append('payParamsDTOJson', JSON.stringify(payParamsDTOJson))
      param.append('user', 'y1')
      param.append('pass', '888888')
      this.$http.post('maroClientServerorderController.do?orderFoodForApp', param)
        .then((res) => {
          if (res.data.success) {
            this.$dialog.loading.close()
            this.$router.replace({
              name: 'OrderSuccess'
            })

          } else {
            //this.getMenuError(res)
          }
        })
        .catch((err) => {
          //this.getMenuError(err)
        })
      //console.log(JSON.stringify(this.pickList))
      // 选择了支付方式后
      /*this.$router.replace({
        name: 'OrderSuccess'
      })*/
    }
  }
}

</script>
<style>
.pay-cell {
  margin-top: .24rem;
}

.pay-cell .yd-cell-left {
  font-size: .28rem;
}

.pay-cell .yd-cell-right {
  min-height: .92rem;
}

.pay-methods-title {
  margin-bottom: .12rem;
  padding: 0 .24rem;
  font-size: .24rem;
}

.pay-methods-box {
  overflow: hidden;
  padding: 0 .12rem;
}

.pay-methods-item {
  width: 25%;
  float: left;
}

.pay-methods-item-con {
  margin: .02rem .02rem .12rem;
  padding: .06rem;
  border: .06rem dashed transparent;
}

.pay-methods-item-con.active {
  border-color: rgb(240, 93, 64);
}

.pay-methods-icon {
  width: 1rem;
  height: 1rem;
  background: no-repeat center / 100%;
}

.pay-methods-name {
  margin-top: .16rem;
  font-size: .24rem;
  text-align: center;
}

.pay-methods-icon,
.pay-methods-name {
  margin-left: auto;
  margin-right: auto;
}

</style>
