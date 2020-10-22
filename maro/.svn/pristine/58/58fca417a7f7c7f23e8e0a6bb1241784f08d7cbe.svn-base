<template>
  <div class="table-done">
  <el-table :data="done" row-class-name="table-cutoff" header-row-class-name="table-cutoff" height="100%" style="width: 100%;" size="medium" fit v-cloak>
    <el-table-column prop="maroClientFoodorderVO.foodName" label="菜品">
    </el-table-column>
    <el-table-column prop="maroClientFoodorderVO.specificationsName" label="规格">
    </el-table-column>
    <!--<el-table-column prop="maroClientFoodorderVO.remark" label="忌口">
    </el-table-column>-->
    <el-table-column prop="maroClientFoodorderVO.typeName" label="分类">
    </el-table-column>
    <el-table-column prop="maroClientFoodorderVOList[0].createTimeMMSSString" label="时间">
    </el-table-column>
    <!-- <el-table-column prop="maroClientFoodorderVO.quantity" label="总份数">
    </el-table-column> -->
    <el-table-column prop="maroClientFoodorderVOList[0].seatName" label="桌号">
      <!--<template slot-scope="scope">
        <span v-for="(val, key) in done.maroClientFoodorderVOList">{{val.seatName}}({{val.quantity}}) </span>
      </template>-->
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button type="primary" @click="outDish(scope.row, scope.$index)">出菜</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>
<script>
export default {
  name: 'table-done',
  props: {
    done: {
      type: Array,
      required: true
    }
  },
  data() {
    return {}
  },
  methods: {
    outDish: function(n, i) {
      let that=this;
      let data = new URLSearchParams();
      data.append("foodorderId",n.maroClientFoodorderVOList[0].id);
      let j=n.maroClientFoodorderVOList[0].quantity;
      let param = {
        data: data,
        myVue: this,
        baseUrl:this.BaseUrl
      }
      this.common.$ajax(this.BaseUrl+'maroClientServerorderController.do?cookedFood', param, function(data) {
        if(window.print3!="undefined" && window.print3!=undefined){
          for(let h=1;h<=j;h++){

            if(data.attributes.printJson.table=="null"){
              print3.SetTable("");
            }else{
              print3.SetTable(data.attributes.printJson.table); // 店铺名称
            }
            if(data.attributes.printJson.orderNum=="null"){
              print3.SetOrdernum("");
            }else{
              print3.SetOrdernum(data.attributes.printJson.orderNum);
            }
            if(data.attributes.printJson.waiter=="null"){
              print3.SetWaiter("");
            }else{
              print3.SetWaiter(data.attributes.printJson.waiter);
            }
            if(data.attributes.printJson.guests=="null"){
              print3.SetGuests(0);
            }else{
              print3.SetGuests(data.attributes.printJson.guests);
            }
            if(data.attributes.printJson.dateTime1=="null"){
              print3.SetDatetime1("");
            }else{
              print3.SetDatetime1(data.attributes.printJson.dateTime1);
            }
            if(data.attributes.printJson.dateTime2=="null"){
              print3.SetDatetime2("");
            }else{
              print3.SetDatetime2(data.attributes.printJson.dateTime2);
            }
            if(data.attributes.printJson.dishes=="null"){
              print3.SetDishes("");
            }else{
              let foodName=JSON.parse(data.attributes.printJson.dishes).name;
              print3.SetDishes(foodName);
            }
            if(data.attributes.printJson.remark=="null"){
              print3.SetRemark("");
            }else{
              print3.SetRemark(data.attributes.printJson.remark);
            }
            print3.Print();
          }
        }
        that.$emit('outDish', {
          'obj': '',
        });
      },function () {
        that.$message.error('出菜失败!');
      })




      // let param = new URLSearchParams()
      // let that = this
      // param.append("foodorderId", n.maroClientFoodorderVOList[0].id)
      // let j=n.maroClientFoodorderVOList[0].quantity;
      // this.$http.post(that.BaseUrl + 'maroClientServerorderController.do?cookedFood', param, {
      //     withCredentials: true
      //   })
      //   .then(function(response) {
      //     if (response.data.success) {
      //
      //       if(window.print3!="undefined" && window.print3!=undefined){
      //         for(let h=1;h<=j;h++){
      //
      //           if(response.data.attributes.printJson.table=="null"){
      //             print3.SetTable("");
      //           }else{
      //             print3.SetTable(response.data.attributes.printJson.table); // 店铺名称
      //           }
      //           if(response.data.attributes.printJson.orderNum=="null"){
      //             print3.SetOrdernum("");
      //           }else{
      //             print3.SetOrdernum(response.data.attributes.printJson.orderNum);
      //           }
      //           if(response.data.attributes.printJson.waiter=="null"){
      //             print3.SetWaiter("");
      //           }else{
      //             print3.SetWaiter(response.data.attributes.printJson.waiter);
      //           }
      //           if(response.data.attributes.printJson.guests=="null"){
      //             print3.SetGuests(0);
      //           }else{
      //             print3.SetGuests(response.data.attributes.printJson.guests);
      //           }
      //           if(response.data.attributes.printJson.dateTime1=="null"){
      //             print3.SetDatetime1("");
      //           }else{
      //             print3.SetDatetime1(response.data.attributes.printJson.dateTime1);
      //           }
      //           if(response.data.attributes.printJson.dateTime2=="null"){
      //             print3.SetDatetime2("");
      //           }else{
      //             print3.SetDatetime2(response.data.attributes.printJson.dateTime2);
      //           }
      //           if(response.data.attributes.printJson.dishes=="null"){
      //             print3.SetDishes("");
      //           }else{
      //             let foodName=JSON.parse(response.data.attributes.printJson.dishes).name;
      //             print3.SetDishes(foodName);
      //           }
      //           if(response.data.attributes.printJson.remark=="null"){
      //             print3.SetRemark("");
      //           }else{
      //             print3.SetRemark(response.data.attributes.printJson.remark);
      //           }
      //           print3.Print();
      //         }
      //       }
      //
      //
      //
      //
      //       that.$emit('outDish', {
      //         'obj': '',
      //       });
      //     } else {
      //       that.$message.error('出菜失败!');
      //     }
      //
      //   })
      //   .catch(function(error) {
      //     that.$alert('登录超时，请重新登录', '登录超时', {
      //       confirmButtonText: '确定',
      //       callback: action => {
      //         that.$router.push({
      //           path: '/'
      //         })
      //       }
      //     });
      //   })


      /*if (n.sum === 1) {
        this.done.splice(i, 1)
      } else{
        n.sum--;
        for(let p = 0; p < n.desk.length; p++) {
          if (n.desk[p].amount === 1) {
            n.desk.splice(p, 1);
          } else {
            n.desk[p].amount--;
          }
          break;
        }
      }*/

    }
  }
}

</script>
<style scoped>
.table-label {
  float: left;
}
.table-done {
  height: 100%;
}
</style>
