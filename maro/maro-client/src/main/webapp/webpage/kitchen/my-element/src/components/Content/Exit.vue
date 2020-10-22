<template>
  <div class="my-exit">
    <el-dialog title="" :visible.sync="flag" width="55%" :before-close="close" center>
      <div class="dialog-body">确定要退出登录吗？</div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="exitModalNo()">取 消</el-button>
        <el-button type="primary" @click="exitModalYes()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: 'app-exit',
  props: {
    flag: {
      type: Boolean,
      default: false
    }
  },
  components: {},
  data() {
    return {};
  },
  methods: {
    close() {
      this.$emit('exitFlagChange', false);
    },
    exitModalNo() {
      this.close()
    },
    exitModalYes() {
      this.close()
      this.$router.push({
        path: '/'
      })
    }
  }
}

</script>
<style>
.my-exit .dialog-body {
  font-size: .28rem;
  line-height: .48rem;
  text-align: center;
}

</style>
