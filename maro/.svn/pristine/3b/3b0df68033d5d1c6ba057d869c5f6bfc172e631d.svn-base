<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" title="确认订单">
        <div slot="left" @click="backTo()">
          <yd-navbar-back-icon></yd-navbar-back-icon>
        </div>
      </yd-navbar>
      <div class="my-container">
        <div class="my-box ord-box">
          <div class="ord-item ord-list" v-for="item, index in confirmList">
            <yd-flexbox>
              <yd-flexbox-item>
                <div class="ord-list-name">
                  <span class="ord-list-name-give" v-if="item.type == 2">赠</span>
                  <span>{{item.dishesName}}</span>
                </div>
                <div class="ord-list-format fc-theme" v-if="item.packageType == 0">
                  <template >{{item.spec.pageName}}</template>
                  <template v-for="value, key in item.spec.remarkArr">{{value}}&nbsp;</template>
                  <template v-if="item.spec.remark!==''">{{item.spec.remark}}</template>
                </div>
                <div class="ord-list-format fc-theme" v-if="item.packageType == 1">

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
              <span class="my-buy-pay-text">下单</span>
            </button>
          </div>
        </yd-flexbox>
      </div>
    </yd-layout>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'

import Vue from 'vue'


export default {
  data() {
    return {
      confirmList: [],
      sum: 0,
      pickList:[],
      salesList:[],
      selectSalesArr:[],
      getSalesList:[]
    }
  },
  computed: {
    ...mapGetters([ 'getPick','getOrderId','getSeatId','getSum','getOpenId','getShopId','setSales','setFoodOrder'])
  },

  mounted(){


  },
  created() {
    this.sum = this.getSum
//    this.pickList = this.getPick //已点还没下单
//    this.confirmList = this.getPick
    this.salesList = this.setSales //套餐规则

//已点已经下单菜品
    for (let m = 0; m < this.setFoodOrder.length; m++) {
        this.getSalesList.push(this.setFoodOrder[m])
    }
    console.log(this.getSalesList);
    console.log(this.salesList);
    for (let i = 0; i < this.salesList.length; i++) {
      for (let j = 0; j < this.getPick.length; j++) {
        let objPick = this.getPick[j];
        if(this.salesList[i].buyid === objPick.id &&
          objPick.spec.id === this.salesList[i].buyspecificationid){
          if(this.salesList[i].is_add === "Y"){
            if(this.getSalesList.length > 1){
              let getPickQuantity = 0,getSalesQuantity = 0;
              for (let k = 0; k < this.getSalesList.length; k++) {
//                已下单赠送的数量
                if(this.getSalesList[k].type === 2 && this.salesList[i].freespecificationid === this.getSalesList[k].specificationsId ){
                  getPickQuantity =getPickQuantity + this.getSalesList[k].quantity
                }
//                已下单的数量（不包括赠送的）
                if(this.getSalesList[k].type !== 2 && objPick.id === this.getSalesList[k].foodId && objPick.spec.id === this.getSalesList[k].specificationsId){
                  getSalesQuantity =getSalesQuantity + this.getSalesList[k].quantity
                }
              }
              this.salesList[i].quantity = (Math.floor((objPick.quantity + getSalesQuantity )/this.salesList[i].buynum))*this.salesList[i].freenum - getPickQuantity;
            }else {
              this.salesList[i].quantity = (Math.floor(objPick.quantity/this.salesList[i].buynum))*this.salesList[i].freenum;
            }

          }else {
            if(this.getSalesList.length > 1){
              for (let k = 0; k < this.getSalesList.length; k++) {
                if(this.salesList[i].buyid === this.getSalesList[k].foodId && objPick.spec.id === this.getSalesList[k].specificationsId){
                  this.salesList[i].quantity = 0;
                  break;
                }else {
                  if(objPick.quantity > this.salesList[i].buynum || objPick.quantity === this.salesList[i].buynum){
                    this.salesList[i].quantity = this.salesList[i].freenum
                  }
                }
              }
            }else {
              if(objPick.quantity > this.salesList[i].buynum || objPick.quantity === this.salesList[i].buynum){
                this.salesList[i].quantity = this.salesList[i].freenum
              }else {
                this.salesList[i].quantity = 0;
              }
            }
          }
          this.salesList[i].specificationsList =[];
          this.salesList[i].id =this.salesList[i].freeid;
          this.salesList[i].unit =objPick.unit;
          this.salesList[i].unitName =objPick.unitName;
          this.salesList[i].spec = {};
          this.salesList[i].spec.pageName =  this.salesList[i].freespecificationname;
          this.salesList[i].type =  2;
          this.salesList[i].spec.id =  this.salesList[i].freespecificationid;
          this.salesList[i].spec.unitPrice =  0;
          this.salesList[i].spec.remark =  '';
          this.salesList[i].spec.remarkArr =  [];
          this.salesList[i].packageType = 0;
          this.salesList[i].dishesName = this.salesList[i].freename;
          if(this.salesList[i].quantity != 0){
            this.selectSalesArr.push(this.salesList[i])
          }
        }
      }
    }
    let SalesArr = Array.from(new Set(this.selectSalesArr))
    this.confirmList = [...this.getPick,...SalesArr]
    this.pickList = [...this.getPick,...SalesArr]

  },
  methods: {
    goPay() {
      // 调用下单的的接口
      let that=this;
      let foodorderDOList = new Array()
      if(this.pickList.length==0){
        return false;
      }
      //封装后台要用的数据格式
      for (let i = 0; i < this.pickList.length; i++) {
        let food = this.pickList[i]
        let remarkArr = '', foodList;

        if(food.type == "package"){
          let listArr = [],packageRemark = [];
          for (let k = 0; k < food.spec.food.setmealSishesList.length; k++) {
            for (let n = 0; n < food.spec.food.setmealSishesList[k].selectList.length; n++) {
              let obj = food.spec.food.setmealSishesList[k].selectList[n];
              packageRemark.push(obj.dishesName)
              listArr.push(
                {
                  'foodId':obj.dishesId,
                  'quantity':obj.quantity,
                  'specificationsId':'',
                  'specificationsName':'普通',
                  'unitCode':obj.dishesUnitCode,
                  'unitName':obj.dishesUnit,
                  'price':0,
                  'packageType':2,
                }
              )
            }

          }
          for (let j = 0; j < food.spec.remarkArr.length; j++) {
            if(packageRemark.indexOf(food.spec.remarkArr[j]) == -1){
              remarkArr = remarkArr + food.spec.remarkArr[j]
            }
          }
          for (let p = 0; p < food.quantity; p++) {
            foodList = {
              'foodId': food.id,
              'quantity': 1,
              'specificationsId': '',
              'specificationsName': "普通",
              'unitCode': food.unit,
              'unitName': food.unitName,
              'price': food.spec.unitPrice,
              'remark': remarkArr,
              'list': listArr,
              'packageType': 1
            }
            if(food.type === 2){
              foodList.type = 2;
              foodList.price = 0;
            }
            foodorderDOList.push(foodList)
          }
        }else {
          for (let j = 0; j < food.spec.remarkArr.length; j++) {
            remarkArr = remarkArr + food.spec.remarkArr[j]
          }
          for (let k = 0; k < food.quantity; k++) {
            foodList = {
              'foodId': food.id,
              'quantity': 1,
              'specificationsId': food.spec.id,
              'specificationsName': food.spec.pageName,
              'unitCode': food.unit,
              'unitName': food.unitName,
              'price': food.spec.unitPrice,
              'remark': remarkArr,
              'list': [],
              'packageType': 0
            }
            if(food.type === 2){
              foodList.type = 2;
              foodList.price = 0;
            }
            foodorderDOList.push(foodList)
          }

        }

//        foodorderDOList.push(foodList)
      }

      let foodOrderParamsDTOListJson = {
        "maroClientServerorderDO": {
          "id": this.getOrderId,
          "kitchenNotify": 1,
        },
        "maroShopSeatEntity": {
          "id": this.getSeatId
        },
        "maroClientFoodorderDOList": foodorderDOList
      };
      let data = new URLSearchParams()
      data.append('foodOrderParamsDTOString',JSON.stringify(foodOrderParamsDTOListJson));
      let param={
        loadingText:'下单中...',
        isLoading:true,
        data:data,
        myVue:this
      }
      this.common.$ajax('/maroClientServerorderController.do?orderFood',param,function(data){
        that.$dialog.toast({
          mes: '下单成功',
          timeout: 1500
        });
        that.isBack = true;
        //下单成功后将vuex数据管理器中的数据全部清空
        that.$store.dispatch('setPick', [])
        that.$store.dispatch('setSum', 0)
        that.$store.dispatch('setAmount', 0)
        //延迟1.5秒跳转到订单详情页。
        setTimeout(function(){
          that.$router.push({
            path:'/detail'
          })
        },1500);
      })
    },
    backTo(){
      this.isBack = false;
      this.$router.back(-1);
    }
  }
}

</script>
<style scoped>
  .ord-list-name-give{
    background: #ffb400;
    color: #ffffff;
    padding: 0.03rem;
    border-radius: 0.1rem;
  }
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
