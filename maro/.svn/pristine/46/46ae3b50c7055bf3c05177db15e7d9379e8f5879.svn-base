<template>
  <div class="page" v-cloak>
    <yd-layout class="content">
      <yd-navbar class="bg-theme" slot="navbar" :title="title">
      </yd-navbar>
      <div class="tab-con" v-show="active1">
        <yd-tab>
          <yd-tab-panel :label="item.typeString" v-for="item,index in listSeat" :key="index">
            <!--  <yd-grids-group :rows="3">
              <yd-grids-item v-for="it,key in item.list" :class="it.useCount?'bg-theme-use':''" :key="key" @click.native="open(it)">
                <span slot="text" :class="it.useCount?'use-text-color':''">{{it.name}} 号桌</span>
                <div class="span-text" slot="else">
                  <span v-if="!it.useCount">{{it.number}}人桌</span>
                  <span v-if="it.useCount" class="use-text-color">¥{{it.maroClientSeatchangeVO.maroClientServerorderVO.amount}}</span>
                </div>
              </yd-grids-item>
            </yd-grids-group>-->
            <div class="my-seat-con">
              <div class="my-seat-item" v-for="it,key in item.list" :key="key" @click="open(it)">
                <div class="my-seat-box" :class="it.useClass">
                  <div class="my-seat-top">
                    <div class="my-seat-name">{{it.name}}</div>
                  </div>
                  <div class="my-seat-price">
                    <span class="my-seat-price-text" v-if="it.useCount==0">￥{{it.maroClientSeatchangeVO.maroClientServerorderVO.amount}}</span>
                    <span class="my-seat-price-text" v-if="it.useCount==1">已结账</span>
                  </div>
                  <div class="my-seat-time">
                    <yd-flexbox>
                      <yd-flexbox-item>
                        <span class="my-seat-time-text" v-if="it.useCount==0">{{it.openTime}}</span>
                      </yd-flexbox-item>
                      <template v-if="it.useCount==0">
                        <div class="my-seat-renshu">{{it.maroClientSeatchangeVO.maroClientServerorderVO.personNumber}}/{{it.number}}</div>
                      </template>
                      <template v-else-if="it.useCount==2">
                        <div class="my-seat-renshu">0/{{it.number}}</div>
                      </template>
                    </yd-flexbox>
                  </div>
                </div>
              </div>
            </div>
          </yd-tab-panel>
        </yd-tab>
      </div>
      <div class="tab-con" v-show="active3">
        <yd-cell-group>
          <yd-cell-item style="height: 2rem;" arrow>
            <span slot="left">{{waiterName}}</span>
          </yd-cell-item>
          <yd-cell-item arrow @click.native="clearBaseUrl">
            <span slot="left">清除配置地址</span>
          </yd-cell-item>
          <yd-cell-item arrow>
            <span slot="left">关于</span>
          </yd-cell-item>
        </yd-cell-group>
        <div class="my-btn-box">
          <yd-button size="large" type="primary" shape="circle" class="my-btn my-btn-shade bg-theme" @click.native="logOut">退出登录</yd-button>
        </div>
      </div>
      <yd-tabbar slot="tabbar" active-color="#FF685D">
        <yd-tabbar-item title="餐台" link="#" :active="active1" @click.native="active1func">
          <img slot="icon" style="height: 25px;" :src="chose" v-if="active1">
          <img slot="icon" style="height: 25px;" :src="unChose" v-else>
        </yd-tabbar-item>
        <yd-tabbar-item title="我的" link="#" :active="active3" @click.native="active3func">
          <img slot="icon" style="height: 25px;" :src="myChose" v-if="active3">
          <img slot="icon" style="height: 25px;" :src="myUnChose" v-else>
        </yd-tabbar-item>
      </yd-tabbar>
    </yd-layout>
    <yd-popup v-model="showOpen" position="center" width="80%" style="">
      <div style="background-color:beige;border-radius: 1.2em">
        <yd-navbar title="开台" class="bg-theme" style="border-top-left-radius:1.2em;border-top-right-radius:1.2em;"></yd-navbar>
        <yd-cell-item style="margin: 0.5rem;background-color:#ffffff">
          <span slot="left">人数：</span>
          <yd-input slot="right" required v-model="pepoleCount" type="number" max="20" placeholder="请输入用餐人数"></yd-input>
        </yd-cell-item>
        <yd-cell-group title="备注" style="margin: 0.5rem;">
          <yd-cell-item>
            <yd-textarea slot="right" placeholder="" v-model="remark" maxlength="100"></yd-textarea>
          </yd-cell-item>
        </yd-cell-group>
        <div slot="bottom" class="my-btn-box">
          <yd-button size="large" type="primary" shape="circle" class="my-btn my-btn-shade bg-theme" @click.native="openSeat">开台</yd-button>
        </div>
      </div>
    </yd-popup>
  </div>
</template>
<script>
export default {
  data() {
    return {
      active1: true,
      active2: false,
      active3: false,
      title: '',
      listSeat: [],
      showOpen: false,
      pepoleCount: '',
      remark: '',
      seatObject: {},
      waiterName: '',
      chose: require('../../../static/img/chose.png'),
      unChose: require('../../../static/img/unChose.png'),
      myChose: require('../../../static/img/myChose.png'),
      myUnChose: require('../../../static/img/myUnChose.png'),


    }
  },
  created() {
    this.title = window.localStorage.getItem('shopName');
    this.waiterName = window.localStorage.getItem('waiterName');
    //加载桌位信息
    this.loadListSeat(true);
    var that = this;

    setInterval(function() {
      if(window.localStorage.getItem('isLogin')=='true' || window.localStorage.getItem('isLogin')==true){
        that.loadListSeat(false);
      }

    }, 30000)
  },
  methods: {
    active1func() {
      this.active1 = true;
      this.active2 = false;
      this.active3 = false;
      this.title = window.localStorage.getItem('shopName');

    },
    active3func() {
      this.active1 = false;
      this.active2 = false;
      this.active3 = true;
      this.title = '我';
    },
    loadListSeat(isLoading) {
      let that = this;
      //定义请求参数
      let data = new URLSearchParams();
      //定义需要调用公共方法的ajax请求的参数
      let param = {
        loadingText: '加载中...',
        isLoading: isLoading,
        data: data,
        myVue: this
      }
      this.common.$ajax('/maroClientServerorderController.do?listSeat', param, function(obj) {
        console.log(obj);
        let allList = new Array();
        for (let i = 0; i < obj.obj.length; i++) {
          for (let j = 0; j < obj.obj[i].list.length; j++) {

            if (obj.obj[i].list[j].maroClientSeatchangeVO) {
              //使用中的桌
              obj.obj[i].list[j].useCount = 0;
              //使用中的桌
              obj.obj[i].list[j].useClass = 'bg-theme';
              if(obj.obj[i].list[j].maroClientSeatchangeVO.maroClientServerorderVO.status==2){
                //已结账
                obj.obj[i].list[j].useCount = 1;
                obj.obj[i].list[j].useClass = 'bg-disabled';
              }
              obj.obj[i].list[j].openTime=new Date(obj.obj[i].list[j].maroClientSeatchangeVO.maroClientServerorderVO.beginTime).getHours()+":"+new Date(obj.obj[i].list[j].maroClientSeatchangeVO.maroClientServerorderVO.beginTime).getMinutes()
            } else {
              obj.obj[i].list[j].useClass = '';
              obj.obj[i].list[j].useCount = 2;
            }
          }
          allList = allList.concat(obj.obj[i].list);
        }
        let allSeat = [{
          type: -1,
          typeString: '全部',
          list: allList
        }]
        that.listSeat = allSeat.concat(obj.obj);
      },function(err){
        that.$router.push({
          path: '/login'
        })
        console.log(err);
      })
    },

    //打开开台操作页面
    open(e) {
      if (e.useCount==2) {
        this.showOpen = true;
        this.pepoleCount = e.number;
        this.seatObject = e;
      } else {
        this.$store.dispatch('setOrderId', e.maroClientSeatchangeVO.serverOrderId);
        this.$store.dispatch('setSeatId', e.id);
        this.$store.dispatch('setSeatName', e.name);
        this.$store.dispatch('setFoodOrder', [])
        //路由跳转
        if(e.maroClientSeatchangeVO.maroClientServerorderVO.amount>0){
          this.$router.push({
            path: '/detail'
          })
        }else{
          this.$router.push({
            path: '/orderBase'
          })
        }


      }
    },
    //点击开台按钮进行开台操作
    openSeat() {
      let data = new URLSearchParams();
      let that = this;
      data.append('maroClientServerorderDO.seatId', this.seatObject.id);
      data.append('maroClientServerorderDO.personNumber', this.pepoleCount);
      //预定id先设置为空，以后有预定记录的得加上东西
      data.append('maroClientServerorderDO.reserveId', '');
      data.append('maroClientServerorderDO.remark', this.remark);
      //服务员默认为当前登录人，从缓存中读取
      let waiterId = window.localStorage.getItem('waiterId');
      let waiterName = window.localStorage.getItem('waiterName');
      data.append('maroClientServerorderDO.waiterId', waiterId);
      data.append('maroClientServerorderDO.waiterName', waiterName);
      let param = {
        loadingText: '开台中...',
        isLoading: true,
        data: data,
        myVue: this
      }
      this.common.$ajax('/maroClientServerorderController.do?open', param, function(data) {
        that.$dialog.toast({
          mes: '开台成功',
          timeout: 1500
        });
        that.showOpen = false;
        that.$store.dispatch('setOrderId', data.obj.id);
        that.$store.dispatch('setSeatId', data.obj.seatId);
        that.$store.dispatch('setSeatName', data.obj.seatName);
        that.$store.dispatch('setFoodOrder', [])
        setTimeout(function() {
          //路由跳转
          that.$router.push({
            path: '/orderBase'
          })
        }, 1500);
      },function(err){

      })
    },
    logOut() {
      let that = this;
      this.$dialog.confirm({
        title: '退出',
        mes: '确定退出',
        opts: () => {
          window.localStorage.removeItem('isLogin');
          window.localStorage.removeItem('user');
          window.localStorage.removeItem('pass');
          window.localStorage.removeItem('waiterId');
          window.localStorage.removeItem('baseUrlShow');
          window.localStorage.removeItem('waiterName');
          that.$router.push({
            path: '/login'
          })
        }
      });
    },
    clearBaseUrl() {
      let that = this;
      this.$dialog.confirm({
        title: '清除配置地址',
        mes: '确定清除配置地址',
        opts: () => {
          window.localStorage.removeItem('isLogin');
          window.localStorage.removeItem('user');
          window.localStorage.removeItem('pass');
          window.localStorage.removeItem('waiterId');
          window.localStorage.removeItem('waiterName');
          window.localStorage.removeItem('baseUrlShow');
          window.localStorage.removeItem('baseUrl');
          that.$router.push({
            path: '/login'
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.my-seat-panel {
  background-color: transparent;
}

.my-seat-con {
  padding: .15rem .2rem;
  overflow: hidden;
  width: 100%;
}

.my-seat-item {
  float: left;
  width: 33.3333%;
  padding: .15rem .1rem;
}

.my-seat-box {
  border-radius: .2rem;
  background-color: #fff;
  padding: .2rem .24rem;
  border: 1px solid #e6e6e6;
  box-shadow: 0 .1rem .3rem rgba(0,0,0,.1)
}

.my-seat-name {
  font-size: .3rem;
  line-height: .36rem;
  color: #333;
  white-space: nowrap;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
  overflow: hidden;
}

.my-seat-box.bg-theme .my-seat-name,
.my-seat-box.bg-theme .my-seat-renshu {
  color: #fff;
}

.my-seat-renshu {
  font-size: .24rem;
  color: #999;
}

.my-seat-price {
  height: .78rem;
  padding: .24rem 0;
}

.my-seat-price-text {
  font-size: .3rem;
  line-height: .3rem;
  color: #fff;
}

.my-seat-time {
  height: .3rem;
}

.my-seat-time-text {
  font-size: .24rem;
  line-height: .3rem;
  color: #fff;
}
</style>
