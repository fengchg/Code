<template>
  <div id="app">
    <transition :name="transitionName">
      <keep-alive>
        <router-view class="child-view" v-if="$route.meta.keepAlive"></router-view>
      </keep-alive>
    </transition>
    <transition :name="transitionName">
      <router-view class="child-view" v-if="!$route.meta.keepAlive"></router-view>
    </transition>
  </div>
</template>
<script>

export default {
  name: 'App',
  data() {
    return {
      transitionName: 'slide-left'
    }
  },
  created(){

  },
  mounted() {
    var $_this = this;

  },
  // watch: {
  //   '$route' (to, from) {
  //     let isBack = this.$router.isBack
  //     if (isBack) {
  //       this.transitionName = 'slide-right'
  //     } else {
  //       this.transitionName = 'slide-left'
  //     }
  //     this.$router.isBack = false
  //   }
  // }
}

</script>
<style>
#app {
  height: 100%;
}

.child-view {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  transition: all .5s cubic-bezier(.55, 0, .1, 1);
}

.slide-left-enter,
.slide-right-leave-active {
  opacity: 0;
  transform: translate(30px, 0);
}

.slide-left-leave-active,
.slide-right-enter {
  opacity: 0;
  transform: translate(-30px, 0);
}

</style>
