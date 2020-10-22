<template>
  <div class="opt">
    <yd-grids-group :rows="2">
      <yd-grids-item type="link" v-for="item, index in optArr" :key="index" :link="item.routerObj">
        <div class="my-opt-con" slot="else">
          <button type="button" class="my-opt-btn" @click="clsOptModal">
            <div class="my-opt-btn-text" v-text="item.text"></div>
          </button>
        </div>
      </yd-grids-item>
    </yd-grids-group>
  </div>
</template>
<script>
import Vue from 'vue'
import pub from '@/assets/js/publish.js'
export default {
  props: {},
  data() {
    return {
      optArr: [{
          text: '订单资料',
          routerObj: {
            name: 'OrderDetail',
            query:{page:1}
          }
        },
        {
          text: '催菜',
          routerObj: {
            name: 'OrderUrge'
          }
        }
      ]
    }
  },
  methods: {
    clsOptModal() {
      this.$emit('clsOptionPopup', '0')
    }
  }
}

</script>
<style>
.opt {
  width: 100%;
  padding: .2rem .4rem;
  background-color: #fff;
}

.opt .yd-grids-item {
  padding: 0;
}

.opt .yd-grids-2:before,
.opt .yd-grids-item:after,
.opt .yd-grids-2 .yd-grids-item:not(:nth-child(2n)):before {
  content: none !important
}

.my-opt-con {
  padding: .2rem .28rem;
}

.my-opt-btn {
  width: 100%;
  height: .8rem;
  position: relative;
  border-radius: .4rem;
  border: .04rem solid transparent;
  background-color: #fff;
  background-clip: padding-box;
}

.my-opt-btn:after,
.my-opt-btn-text {
  position: absolute;
  top: -.04rem;
  right: -.04rem;
  bottom: -.04rem;
  left: -.04rem;
  background: linear-gradient(to right, #f05f3e 0%, #ed3269 100%);
  border-radius: .4rem;
}

.my-opt-btn:after {
  content: "";
  z-index: -1;
}

.my-opt-btn-text {
  font-size: .28rem;
  -webkit-background-clip: text;
  color: transparent;
  line-height: 1.25;
  padding: .22rem .2rem;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.my-opt-btn:active .my-opt-btn-text,
.my-opt-btn.active .my-opt-btn-text {
  background-clip: border-box;
  color: #fff;
}

</style>
