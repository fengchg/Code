<template>
  <div class="cartcontrol">
    <transition name="move">
      <div class="cart-decrease" v-if="food[field]>0" @click.stop.prevent="beforeDecFood">
        <span class="inner">-</span>
      </div>
    </transition>
    <div class="cart-count" v-if="food[field]>0">{{this.food[field]}}</div>
    <div class="cart-add" @click.stop.prevent="beforeAddFood">
      <span class="inner">+</span>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    food: {// 餐品对象
      type: Object
    },
    judge: {// 是否要判断多规格
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      field: 'quantity'
    }
  },
  created() {
    if (this.fields) {
      this.field = this.fields
    }
  },
  methods: {
    beforeAddFood(event) {

      if (!this.food[this.field]) {
        this.$set(this.food, this.field, 0);
      }

      // 判断是否多规格
      if(this.food.packageType == 0){
        if (this.food.specificationsList.length > 1 && this.judge) {
          this.$emit('getFoodQuan',  {
            'obj': this.food,
            'isMulti': true,
            'evt': e
          })
        } else {
          this.addFood(event);
        }
      }else {
        this.addFood(event);
      }

    },
    beforeDecFood(event) {
      if(this.food.packageType == 0){
        if (this.food.specificationsList.length > 1 && this.judge) {
          this.$dialog.notify({
            mes: '多规格商品只能去购物车删除噢！',
            timeout: 5000
          })
        } else {
          this.decreaseFood(event);
        }
      }else {
        this.decreaseFood(event);
      }
    },
    addFood(e) {
      this.food[this.field]++;
      if (this.judge) {
        this.$emit('getFoodQuan', {
          'obj': this.food,
          'isMulti': false,
          'evt': e
        })
      }
    },
    decreaseFood(e) {
      if (this.food[this.field]) {
        this.food[this.field]--;
      }

      if (this.food[this.field] === 0) {
        this.$emit('zeroFoodQuan', {
          'obj': this.food,
          'evt': e
        })
      }
    }
  }
};

</script>
<style scoped>
.cartcontrol {
  font-size: 0;
  text-align: center;
}

.cart-decrease,
.cart-add {
  display: inline-block;
  width: .4rem;
  height: .4rem;
  line-height: .4rem;
  border-radius: .4rem;
  color: rgb(240, 93, 64);
  transition: .4s;
}

.cart-decrease {
  background-color: rgb(229, 229, 229);
}

.cart-add {
  background-color: rgb(251, 214, 207);
}

.cart-decrease.move-enter-active,
.cart-decrease.move-leave {
  opacity: 1;
  transform: translate3d(0, 0, 0);
}

.cart-decrease.move-enter,
.cart-decrease.move-leave-active {
  opacity: 0;
  transform: translate3d(.24rem, 0, 0);
}

.inner {
  display: block;
  font-size: .4rem;
  height: 100%;
  transition: .4s;
  transform: rotate3d(0, 0, 0);
}

.cart-decrease.move-enter .inner,
.cart-decrease.move-leave-active .inner {
  transform: rotate3d(180deg, 0, 0);
}

.cart-count {
  display: inline-block;
  vertical-align: top;
  width: 1.5em;
  padding-top: .1rem;
  line-height: .28rem;
  text-align: center;
  font-size: .28rem;
  color: rgb(147, 153, 159);
}

</style>
