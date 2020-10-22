<template>
  <div class="my-list-frm" v-if="food">
    <div class="my-format-con">
      <div class="my-format-dishes">{{food.dishesName}}</div>
      <div class="my-format" v-if="isMultiFormat">
        <div class="my-format-title">规格</div>
        <div class="my-format-box">
          <div class="my-format-item" v-for="value, key in food.specificationsList" :class="{'active': index===key}" @click="pickFormat(value, key)">{{value.pageName}}</div>
        </div>
      </div>
      <div class="my-format">
        <div class="my-format-title">备注</div>
        <div class="my-format-box">
          <div class="my-format-item" v-for="value, key in remarkArr" :class="{'active': remarkActiveArr.indexOf(value.text)>-1}" @click="pickRemark(value, key)">{{value.text}}</div>
        </div>
        <label class="my-format-input">
          <input type="text" name="" v-model="remark" placeholder="请输入其他备注">
        </label>
      </div>
    </div>
    <div class="my-format-btm">
      <yd-flexbox>
        <yd-flexbox-item>
          <yd-flexbox>
            <div class="my-price my-format-price fc-theme"><em>¥</em>{{food.specificationsList[index].unitPrice}}</div>
            <div class="my-format-remark" v-if="isMultiFormat || remarkActiveArr.length || remark">
              <span>(</span>
              <span v-if="isMultiFormat">{{food.specificationsList[index].pageName}}</span>
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
      var spec = this.food.specificationsList[this.index]
      var jsonSpec = {
        id: spec.id,
        pageName: spec.pageName,
        unitPrice: spec.unitPrice,
        remarkArr: JSON.parse(JSON.stringify(this.remarkActiveArr)),
        remark: this.remark.trim()
      }
      this.$emit('clsFormatPopup', jsonSpec)
    }
  }
};

</script>
<style scoped>
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
  padding: ;
  border: 1px solid rgb(230, 230, 230);
  border-radius: .08rem;
  background-color: rgb(247, 247, 247);
}

.my-format-input>input {
  border: none;
  display: block;
  width: 100%;
  height: 100%;
  font-size: .28rem;
  color: #333;
  padding: 0 1em;
}

.my-format-input>input::-webkit-input-placeholder {
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

.my-format-remark>span{
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
