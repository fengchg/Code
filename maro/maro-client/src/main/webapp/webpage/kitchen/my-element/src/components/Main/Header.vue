<template>
  <div class="my-header">
    <div class="my-header-title"><span>{{title.titleText}}</span></div>
    <div class="my-header-icon" v-if="title.btns.length" v-for="(item, index) in title.btns" @click="btnHandle(item, index)">
      <i :class="item.class"></i>
    </div>
    <exit :flag="exitFlag" @exitFlagChange="exitFlagUpdate($event)"></exit>
  </div>
</template>
<script>
import exit from '../Content/Exit'
export default {
  name: 'app-header',
  props: {
    title: {
      type: Object,
      default: function() {
        return {
          titleText: '',
          btns: []
        }
      }
    }
  },
  components: {
    exit
  },
  data () {
    return {
      exitFlag: false
    };
  },
  methods: {
    btnHandle (obj, i) {
      switch (obj.usage) {
        case 'exit':
          this.exitFlag = true;
          break;
      }
    },
    exitFlagUpdate (v) {
      this.exitFlag = v
    }
  }
}

</script>
<style scoped>
.my-header {
  display: flex;
  height: .64rem;
  padding: 0 .2rem;
  color: #fff;
  background: linear-gradient(to right, #ef5c48 0%, #cc406d 100%);
}

.my-header-title {
  flex: 1;
  display: flex;
  align-items: center;
  font-size: .32rem;
}

.my-header-icon {
  min-width: .64rem;
  display: flex;
  align-items: center;
  justify-content: center;
}

.my-header-icon>i {
  font-size: .48rem
}

</style>
