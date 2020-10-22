<template>
  <div class="my-list-frm" v-if="food">
    <div class="my-format-con">
      <div class="my-format-dishes">{{food.dishesName}}</div>
      <div class="my-format" v-if="isMultiFormat">
        <div class="my-format-title">规格</div>
        <div class="my-format-box">
          <div class="my-format-item" v-if="food.type == 'ordinary'" v-for="value, key in food.specificationsList" :class="{'active': index===key}" @click="pickFormat(value, key)">{{value.pageName}}</div>
          <div class="my-format-item" v-if="food.type == 'package'" v-for="value, key in food.setmealSishesList" :class="{'active': index===key}" @click="pickFormat(value, key)">{{value.className}}</div>
        </div>
      </div>
      <div class="my-format">
        <div class="my-format-title">备注</div>
        <div class="my-format-box">
          <div class="my-format-item" v-for="value, key in remarkArr" :class="{'active': remarkActiveArr.indexOf(value.text)>-1}" @click="pickRemark(value, key)">{{value.text}}</div>
        </div>
        <!--套餐列表-->
        <div v-if="food.type == 'package'">
          <!--<div class="my-format-title">套餐</div>-->
          <div class="my-format-box">
            <div class="my-format-type" v-for="value, key in food.setmealSishesList" >
              <div class="my-format-title">{{value.className}}:</div>
              <div class="my-format-dishesName" >
                <div v-for="items, keys in value.setmealDishesSelectList" class="my-format-pick">
                  <div class="my-format-item"
                       :class="{'active': JSON.stringify(value.selectList).indexOf(JSON.stringify(items))>-1 }"
                       @click="pickPackage(items, keys,value)">
                    {{items.dishesName}}

                  </div>
                  <div class="my-format-counter " v-if="items.isRepetitionhidde&&value.isRepetition == 0">
                    <div class="my-format-counter-btn" @click="pickRemarkNum(items,-1,value)">-</div>
                    <div class="my-format-counter-num">{{items.quantity}}</div>
                    <div class="my-format-counter-btn" @click="pickRemarkNum(items,1,value)">+</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <label class="my-format-input">
          <input type="text" name="" v-model="remark" placeholder="请输入其他备注">
        </label>
      </div>
    </div>
    <div class="my-format-btm">
      <yd-flexbox>
        <yd-flexbox-item>
          <yd-flexbox v-if="food.type == 'ordinary'">
            <div class="my-price my-format-price fc-theme"><em>¥</em>{{food.specificationsList[index].unitPrice}}</div>
            <div class="my-format-remark" v-if="isMultiFormat || remarkActiveArr.length || remark">
              <span>(</span>
              <span v-if="isMultiFormat">{{food.specificationsList[index].pageName}}</span>
              <span>{{remark}}</span>
              <span v-for="value, key in remarkActiveArr">&nbsp;{{value}}</span>
              <span>)</span>
            </div>
          </yd-flexbox>
          <yd-flexbox v-if="food.type == 'package'">
            <div class="my-price my-format-price fc-theme"><em>¥</em>{{food.packagePrice}}</div>
            <div class="my-format-remark" v-if="remarkActiveArr.length || remark">
              <span>(</span>
              <span>{{remark}}</span>
              <span v-for="value, key in remarkActiveArr">&nbsp;{{value}}</span>
              <span>)</span>
            </div>
          </yd-flexbox>
        </yd-flexbox-item>
        <div class="my-format-confirm bg-theme" @click="confirmFormat">确定</div>
      </yd-flexbox>
    </div>
    <div class="my-list-frm-cls" @click="clsFormatPopup">×</div>
  </div>
</template>
<script>
export default {
  props: {
    food: {
      type: Object
    },
    flag: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      remarkArr: [
        { text: '不吃葱' },
        { text: '不吃蒜' },
        { text: '不吃香菜' },
        { text: '不放辣' },
        { text: '少放辣' },
        { text: '多放辣' }
      ],
      showPackage:true,//显示套餐
      remarkActiveArr: [],
      remark: '',
      index: 0
    }
  },
  watch: {
    flag(v) {
      if (!v) {
        setTimeout(() => {
          this.index = 0
          this.remarkActiveArr.splice(0, this.remarkActiveArr.length)
          this.remark = ''
        }, 201)
      }
    }
  },
  computed: {
    isMultiFormat() {
      return this.food.specificationsList && this.food.specificationsList.length > 1
    }
  },
  methods: {
    pickFormat(v, k) {
      // 选择规格
      this.index = k
    },
    pickRemark(v, k) {
      // 选择备注
      let fg = false
      for (let i = 0; i < this.remarkActiveArr.length; i++) {
        if (this.remarkActiveArr[i] === v.text) {
          this.remarkActiveArr.splice(i, 1)
          fg = true
          break
        }
      }

      if (!fg) {
        this.remarkActiveArr.push(v.text)
      }
    },
//    点击套餐
    pickPackage(v,k,p){

      let fg = false,numtotal = 0;
        for (let i = 0; i < p.selectList.length; i++) {
          if (p.selectList[i] == v) {
            p.selectList.splice(i, 1);
            this.$set(v, 'isRepetitionhidde', false);
            fg = true
            break
          }
        }
      //如果只能选一个就可以自由切换
      if(p.selectNum == 1 && p.isRepetition == 1){
        this.$set(p, 'selectList', []);
      }

      if (!fg) {
        for (let j = 0; j < p.selectList.length; j++) {
          let obj = p.selectList[j];
          numtotal += obj.quantity
        }
        if(p.selectNum >  numtotal){
          this.$delete(v, 'quantity');
          p.selectList.push(v);
          this.$set(v, 'isRepetitionhidde', true);
          //点选菜品规格
          if (!v.hasOwnProperty('quantity')) {
            this.$set(v, 'quantity', 1);
          } else {
            this.$delete(v, 'quantity');
          }
        }
      }
      //添加选中的套餐名字到 remarkActiveArr 数组当中
      if(this.remarkActiveArr.length != 0){
        for (let l = 0; l < this.remarkActiveArr.length; l++) {
          for (let k = 0; k < p.setmealDishesSelectList.length; k++) {
            if (this.remarkActiveArr[l] === p.setmealDishesSelectList[k].dishesName) {
              this.remarkActiveArr.splice(l, 1)
            }
          }
        }
      }

      for (let q = 0; q < p.selectList.length; q++) {
        this.remarkActiveArr.push(p.selectList[q].dishesName)
      }

    },
//   添加套餐数量
    pickRemarkNum(v,k,p){
      //点选菜品加减
      let numtotal = 0;
      if(k === 1){
        for (let i = 0; i < p.selectList.length; i++) {
          let obj = p.selectList[i];
          numtotal += obj.quantity
        }
        if(p.selectNum >  numtotal){
          v.quantity = v.quantity + k;
        }
      }else {
        v.quantity = v.quantity + k;
        if(v.quantity === 0){
          for (let j = 0; j < p.selectList.length; j++) {
            if (p.selectList[j] == v) {
              p.selectList.splice(j, 1);
              this.$set(v, 'isRepetitionhidde', false);
              //添加选中的套餐名字到 remarkActiveArr 数组当中
              if(this.remarkActiveArr.length != 0){
                for (let l = 0; l < this.remarkActiveArr.length; l++) {
                  for (let k = 0; k < p.setmealDishesSelectList.length; k++) {
                    if (this.remarkActiveArr[l] === p.setmealDishesSelectList[k].dishesName) {
                      this.remarkActiveArr.splice(l, 1)
                    }
                  }
                }
              }
              break
            }
          }
        }
      }
    },
    clsFormatPopup() {
      // 关闭popup
      this.$emit('clsFormatPopup')
    },
    confirmFormat() {
      //点击确定按钮
      // id: 菜品规格id (单规格为73)
      // pageName: 规格名称 (单规格为‘普通’)
      // unitPrice: 该规格的单价
      // remarkArr: 忌口备注数组
      // remark: 忌口备注输入项

      if(this.food.type == "package"){ //套餐
        let n = 0;
        for (let i = 0; i < this.food.setmealSishesList.length; i++) {
            n += this.food.setmealSishesList[i].selectList.length;
        }
        if(n == 0){
          this.$dialog.toast({
            mes: '请选择套餐！',
            timeout: 1500
          });
          return
        }
        let jsonSpec = {
          food:this.food,
          pageName: '普通',
          unitPrice: this.food.packagePrice,
          remarkArr: JSON.parse(JSON.stringify(this.remarkActiveArr)),
          remark: this.remark.trim()
        };
        this.$emit('clsFormatPopup', jsonSpec)
      }else {
        var spec = this.food.specificationsList[this.index]
        this.food.packageType=0;
        var jsonSpec = {
          food:this.food,
          id: spec.id,
          pageName: spec.pageName,
          unitPrice: spec.unitPrice,
          remarkArr: JSON.parse(JSON.stringify(this.remarkActiveArr)),
          remark: this.remark.trim()
        }
        this.$emit('clsFormatPopup', jsonSpec)
      }

    }
  }
};

</script>
<style scoped>
  .my-format-counter {
    padding-top: .9rem;
    text-align: center;
  }

  .my-format-counter-btn {
    display: inline-block;
    font-size: .16rem;
    font-weight: bold;
    width: .3rem;
    height: .3rem;
    line-height: .3rem;
    color: rgb(255, 46, 49);
    border-radius: 9999px;
    text-align: center;
    border: 1px solid rgb(128, 128, 128);
    background-color: rgba(255, 255, 255, .8);
  }

  .my-format-counter-num {
    display: inline-block;
    font-size: .14rem;
    width: .4rem;
    height: .3rem;
  }

  .my-format-pick {
    margin: 0 7.25% .28rem 0;
  }

  .my-format-item {
    float: left;
    font-size: .28rem;
    min-width: 28.5%;
    color: #999;
    background-color: #fff;
    border: 1px solid #e6e6e6;
    border-radius: .08rem;
    text-align: center;
    padding: .2rem .05rem;
    margin: 0 7.25% .28rem 0;
  }

  .my-format-type {
    display: flex;
    flex-direction: column;
  }

  .my-format-dishesName {
    padding-top: .1rem;
    display: flex;
    flex-wrap: wrap;
  }

  .my-format-dishesName .my-format-item {
    margin: 0;
    min-width: 1.2rem;
  }

  .my-list-frm {
    position: relative;
    border-radius: .32rem;
    max-height: 80vh;
    overflow: hidden;
    display: flex;
    flex-direction: column;
  }

  .my-format-con {
    overflow-y: auto;
    background-color: #fff;
    padding: .6rem;
  }

  .my-format-dishes {
    font-size: .48rem;
    font-weight: 800;
    line-height: .64rem;
    color: rgb(237, 51, 104);
    margin-bottom: .4rem;
  }

  .my-format-title {
    font-size: .28rem;
    margin-bottom: .16rem;
    color: #999;
  }

  .my-format-box {
    width: 100%;
    overflow-x: hidden;
  }

  .my-format-item:nth-child(3n) {
    margin: 0 0 .28rem 0;
  }

  .my-format-item.active {
    color: rgb(237, 51, 104);
    border-color: currentColor;
  }

  .my-format-input {
    display: block;
    height: .68rem;
    padding:;
    border: 1px solid rgb(230, 230, 230);
    border-radius: .08rem;
    background-color: rgb(247, 247, 247);
  }

  .my-format-input > input {
    border: none;
    display: block;
    width: 100%;
    height: 100%;
    font-size: .28rem;
    color: #333;
    padding: 0 1em;
  }

  .my-format-input > input::-webkit-input-placeholder {
    color: rgb(222, 222, 222);
  }

  .my-format-btm {
    height: .98rem;
    background-color: rgb(245, 245, 245);
  }

  .my-format-btm .yd-flexbox {
    height: 100%;
  }

  .my-format-price {
    font-size: .45rem;
    padding-left: .6rem;
    padding-right: .1rem;
  }

  .my-format-remark {
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    text-overflow: ellipsis;
    overflow: hidden;
    -webkit-line-clamp: 2;
  }

  .my-format-remark > span {
    font-size: .24rem;
    color: #333;
  }

  .my-format-confirm {
    width: 27%;
    height: 100%;
    font-size: .3rem;
    line-height: .98rem;
    color: #fff;
    text-align: center;
  }

  .my-list-frm-cls {
    position: absolute;
    right: 0;
    top: 0;
    color: #e6e6e6;
    width: .88rem;
    height: .88rem;
    line-height: .88rem;
    font-size: .64rem;
    text-align: center;
  }

</style>
