<template>
  <div class="table-undo">
    <el-tabs tab-position="left" class="1" @tab-click="tabClick" v-cloak>
      <el-tab-pane v-for="(item, index) in undo" :key="index" :label="item.typeName">
        <el-table :data="item.menu" :row-class-name="tableRowClassName" :cell-class-name="tableCellClassName" header-row-class-name="table-cutoff" :span-method="objectSpanMethod" size="medium" height="100%" style="width: 100%;" v-if="widthQuan !== 0" fit>
          <el-table-column label="菜品">
            <template slot-scope="scope">
              <span class="table-href" @click="toCook(scope.row, index, scope.$index,item)">{{scope.row.foodName}}</span>
            </template>
          </el-table-column>
          <el-table-column prop="quantity" label="总数" :width="widthQuan">
          </el-table-column>
          <el-table-column prop="seatName" label="桌号" :width="widthName">
          </el-table-column>
          <el-table-column prop="specificationsName" label="规格" :width="widthSpec">
          </el-table-column>
          <el-table-column prop="remark" label="备注">
          </el-table-column>
          <el-table-column prop="waitTime" label="时长">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="primary" @click="pickCook(scope.row,1,$event)">打厨</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
    <el-dialog :title="modalTitle" :visible.sync="modalFlag" width="60%" custom-class="dachu-modal" center>
      <el-table :data="modalObj" style="width: 100%;" height="45vh" fit>
        <el-table-column prop="seatName" label="桌号">
        </el-table-column>
        <el-table-column prop="specificationsName" label="规格">
        </el-table-column>
        <el-table-column prop="remark" label="备注">
        </el-table-column>
        <el-table-column prop="waitTime" label="已等待时长">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" @click="pickCook(scope.row,0,$event)" ref="btn" :disabled="scope.row.isDisabled">打厨</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="modalYes">全部打厨</el-button>
        <el-button @click="modalNo">返回</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import Vue from 'vue'
export default {
  name: 'table-undo',
  props: {
    undo: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      modalFlag: false,
      modalObj: [{
        'createTimeString': '2018-05-03 09:27',
        'foodName': '小蛋糕',
        'quantity': 1,
        'remark': null,
        'seatName': 'H座',
        'specificationsName': '小份'
      }, {
        'createTimeString': '2018-05-03 10:56',
        'foodName': '小蛋糕',
        'quantity': 2,
        'remark': '不加辣',
        'seatName': 'E座',
        'specificationsName': '小份'
      }],
      modalList: {
        obj: "",
        i: 0,
        j: 0
      },
      widthStandard: 50,
      widthQuan: 0,
      widthName: 0,
      widthSpec: 0
    }
  },
  computed: {
    modalTitle: function () {
      return this.modalFlag ? this.modalObj[0].foodName + '-' + this.modalObj[0].specificationsName : ''
    }
  },
  created () {
    let rootFz = document.getElementsByTagName('html')[0].style.fontSize,
      rootNum = rootFz.split('px')[0],
      targetNum = this.widthStandard*rootNum/50;

    this.widthQuan = targetNum;
    this.widthName = targetNum;
    this.widthSpec = targetNum;
  },
  methods: {
    objectSpanMethod ({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 0 || columnIndex === 1) {
        if (row.flag === 0) {
          return {
            rowspan: 2,
            colspan: 1
          }
        } else if (row.flag === 1) {
          return {
            rowspan: 0,
            colspan: 0
          }
        }
      }
    },
    tableCellClassName ({row, column, rowIndex, columnIndex}) {
      if ((columnIndex === 0 || columnIndex === 1) && row.flag == 0) {
        return 'table-curoff-cell'
      } else {
        return ''
      }
    },
    tableRowClassName ({row, rowIndex}) {
      return row.flag !== 0 ? 'table-cutoff' : ''
    },
    toCook: function(n, i, j,item) {
      for(let t=0;t<item.foodOrderItemGroupResultDTOList.length;t++){
        for(let h=0;h<item.foodOrderItemGroupResultDTOList[t].maroClientFoodorderVOList.length;h++){
            item.foodOrderItemGroupResultDTOList[t].maroClientFoodorderVOList[h].isDisabled=false;
        }
      }
     for(let t=0;t<item.foodOrderItemGroupResultDTOList.length;t++){
       for(let h=0;h<item.foodOrderItemGroupResultDTOList[t].maroClientFoodorderVOList.length;h++){
         if(item.foodOrderItemGroupResultDTOList[t].maroClientFoodorderVOList[h].id==n.id){
           this.modalObj=item.foodOrderItemGroupResultDTOList[t].maroClientFoodorderVOList;
           break;
         }
       }
     }
      // this.modalList.obj = n;
      // this.modalList.i = i;
      // this.modalList.j = j;
      // this.modalObj = n;
      this.modalFlag = true;
    },
    tabClick() {
      let a = JSON.stringify(this.undo)
      this.undo = JSON.parse(a)
    },
    modalNo() {
      this.modalFlag = false;
      //this.modalObj = null;
    },
    modalYes() {
      //indexType:第几个菜品类型数组
      //indexMenu:第几个菜品
      let arrPick=new Array();
      for(let i=0;i<this.modalObj.length;i++){
        arrPick.push(this.modalObj[i].id);
      }
      this.$emit('toCookHandle', {
        'obj': arrPick
      });
      this.modalNo();
    },
    pickCook(row,i,e){
      var arr=new Array();
      arr.push(row.id);
      this.$emit('toCookHandle', {
        'obj': arr
      });
      let btn = e.currentTarget;
      if(i==0){
         // btn.setAttribute('disabled',true);
          for(let t=0;t<this.modalObj.length;t++){
             if(row.id==this.modalObj[t].id){
               Vue.set(this.modalObj[t],'isDisabled',true);
               break
             }
          }
          this.modalObj=Object.assign([],this.modalObj)
      }

    }
  }
}

</script>
<style>
.table-undo {
  height: 100%;
}

.table-href {
  text-decoration: underline;
  color: #CC406D;
}

.table-cutoff > th,
.table-cutoff > td,
.table-curoff-cell {
  border-bottom-color: #bbb !important;
}

.el-tabs,
.el-tabs__content,
.el-tab-pane {
  height: 100%;
}

.el-tabs__header {
  background-color: rgb(247, 247, 247)
}

.el-table,
.el-tabs__item {
  font-size: .26rem;
}

.el-tabs__item {
  padding: 0 .3rem;
  height: .8rem;
  line-height: .8rem;
}

.el-tabs__item.is-active {
  color: #fff;
  background-color: #CC406D;
}

.el-table .cell {
  line-height: .36rem;
}

.el-table .caret-wrapper {
  width: .36rem;
  height: .66rem;
}

.el-table .sort-caret {
  border-width: .1rem;
}

.dachu-modal .el-dialog__body {
  padding: 0 .3rem;
}

.el-dialog__title {
  font-size: .36rem;
  line-height: .48rem;
}

.el-dialog__headerbtn {
  font-size: .32rem;
}



</style>
