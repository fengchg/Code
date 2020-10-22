
  <template>
    <div>
  <yd-slider autoplay="5000">
    <yd-slider-item v-for="item,index in imgs" :key="index">
      <a href="">
        <img :src="item.imgurl">
      </a>
    </yd-slider-item>

  </yd-slider>

    <yd-list theme="4">
      <yd-list-item v-for="(item,index) in shopList" @click.native="pick(item)"   :key="index">
        <img slot="img" :src="img">
        <span slot="title">{{item.name}}</span>
        <yd-list-other slot="other">
          <div>
            <span class="demo-list-price">{{item.position}}</span>
            <span class="demo-list-del-price"></span>
          </div>

          <div>
            <!--<yd-button type="primary" @click.native="pick(item)">在线排号</yd-button>-->


          </div>
        </yd-list-other>
      </yd-list-item>
    </yd-list>


    <!--<yd-cell-group v-for="(item,index) in shopList"  :key="index"  @click.native="pick(item)">
      <yd-cell-item>
        <span slot="left">商户</span>
        <span slot="right">{{item.name}}</span>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">地址</span>
        <span slot="right">{{item.position}}</span>
      </yd-cell-item>
    </yd-cell-group>-->
    </div>
</template>

<script type="text/babel">


export default {

  data () {

    return {
         shopList:[],
         imgs:[
           {
           imgurl:require("../../static/1.png")
           },
           {
             imgurl:require("../../static/2.png")
           }

         ],
         img:require("../../static/3.png")
    }
  },
  methods:{
    pick(e){
      //window.location.href="http://hcb601.bjyfkj.net/index.php/index/weixin/wx_code?user_id="+e.equipment_number;
    },
    getData(){
      let param = new URLSearchParams()
      let that=this;
      this.$http.post('maroShopController.do?getAllShop', param)

        .then((res) => {


          if (res.data.success) {

            that.shopList=res.data.obj;

          } else {

          }
        })
    }
  },

  created(){
    this.getData();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
