webpackJsonp([1],{"5ZCM":function(t,e){},Bx4J:function(t,e){},DRAD:function(t,e){},GPb2:function(t,e){},LIPj:function(t,e){},NHnr:function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=o("7+uW"),n={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticStyle:{height:"100%"},attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var r=o("VU/8")({name:"App"},n,!1,function(t){o("LIPj")},null,null).exports,i=o("/ocq"),l=o("mvHQ"),s=o.n(l),c={name:"app-exit",props:{flag:{type:Boolean,default:!1}},components:{},data:function(){return{}},methods:{close:function(){this.$emit("exitFlagChange",!1)},exitModalNo:function(){this.close()},exitModalYes:function(){this.close(),this.$router.push({path:"/"})}}},d={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("el-dialog",{attrs:{title:"",visible:t.flag,width:"55%","before-close":t.close,center:""},on:{"update:visible":function(e){t.flag=e}}},[o("div",{staticClass:"dialog-body"},[t._v("确定要退出登录吗？")]),t._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(e){t.exitModalNo()}}},[t._v("取 消")]),t._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:function(e){t.exitModalYes()}}},[t._v("确 定")])],1)])],1)},staticRenderFns:[]};var u=o("VU/8")(c,d,!1,function(t){o("Bx4J")},"data-v-6e412b84",null).exports,m={name:"app-header",props:{title:{type:Object,default:function(){return{titleText:"",btns:[]}}}},components:{exit:u},data:function(){return{exitFlag:!1}},methods:{btnHandle:function(t,e){switch(t.usage){case"exit":this.exitFlag=!0}},exitFlagUpdate:function(t){this.exitFlag=t}}},f={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"my-header"},[o("div",{staticClass:"my-header-title"},[o("span",[t._v(t._s(t.title.titleText))])]),t._v(" "),t._l(t.title.btns,function(e,a){return t.title.btns.length?o("div",{staticClass:"my-header-icon",on:{click:function(o){t.btnHandle(e,a)}}},[o("i",{class:e.class})]):t._e()}),t._v(" "),o("exit",{attrs:{flag:t.exitFlag},on:{exitFlagChange:function(e){t.exitFlagUpdate(e)}}})],2)},staticRenderFns:[]};var p=o("VU/8")(m,f,!1,function(t){o("5ZCM")},"data-v-01dca2fa",null).exports,h={name:"table-done",props:{done:{type:Array,required:!0}},data:function(){return{}},methods:{outDish:function(t,e){var o=new URLSearchParams,a=this;o.append("foodorderId",t.maroClientFoodorderVOList[0].id),this.$http.post(a.BaseUrl+"maroClientServerorderController.do?cookedFood",o,{withCredentials:!0}).then(function(t){console.log(t),t.data.success?a.$emit("outDish",{obj:""}):a.$message.error("出菜失败!")}).catch(function(t){var e=this;this.$alert("登录超时，请重新登录","登录超时",{confirmButtonText:"确定",callback:function(t){e.$router.push({path:"/"})}})})}}},b={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("el-table",{staticStyle:{width:"100%"},attrs:{data:t.done,height:"100%",fit:""}},[o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.foodName",label:"菜品",fixed:""}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.specificationsName",label:"规格"}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.typeName",label:"分类"}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.createTimeString",label:"时间",sortable:""}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.quantity",label:"总份数"}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.seatNameList",label:"桌号"}}),t._v(" "),o("el-table-column",{attrs:{label:"操作",fixed:"right"},scopedSlots:t._u([{key:"default",fn:function(e){return[o("el-button",{attrs:{type:"primary"},on:{click:function(o){t.outDish(e.row,e.$index)}}},[t._v("出菜")])]}}])})],1)},staticRenderFns:[]};var v=o("VU/8")(h,b,!1,function(t){o("yHfP")},"data-v-658d5d31",null).exports,g={name:"table-undo",props:{undo:{type:Array,required:!0}},data:function(){return{modalFlag:!1,modalObj:[{createTimeString:"2018-05-03 09:27",foodName:"小蛋糕",quantity:1,remark:null,seatName:"H座",specificationsName:"小份"},{createTimeString:"2018-05-03 10:56",foodName:"小蛋糕",quantity:2,remark:"不加辣",seatName:"E座",specificationsName:"小份"}],modalList:{obj:"",i:0,j:0}}},computed:{modalTitle:function(){return this.modalFlag?this.modalObj[0].foodName+"-"+this.modalObj[0].specificationsName:""}},methods:{toCook:function(t,e,o){this.modalList.obj=t,this.modalList.i=e,this.modalList.j=o,console.log(t,e,o),this.modalObj=t.maroClientFoodorderVOList,this.modalFlag=!0},tabClick:function(){this.undo=JSON.parse(s()(this.undo))},modalNo:function(){this.modalFlag=!1},modalYes:function(){this.$emit("toCookHandle",{obj:this.modalList.obj,indexType:this.modalList.i,indexMenu:this.modalList.j}),this.modalNo()}}},y={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"table-undo"},[o("el-tabs",{attrs:{"tab-position":"left"},on:{"tab-click":t.tabClick}},t._l(t.undo,function(e,a){return o("el-tab-pane",{key:a,attrs:{label:e.typeName}},[o("el-table",{staticStyle:{width:"100%"},attrs:{data:e.foodOrderItemGroupResultDTOList,height:"100%",fit:""}},[o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.foodName",label:"菜品",fixed:""}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.specificationsName",label:"规格"}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.createTimeString",label:"时间",sortable:""}}),t._v(" "),o("el-table-column",{attrs:{prop:"maroClientFoodorderVO.quantity",label:"份数"}}),t._v(" "),o("el-table-column",{attrs:{label:"操作",fixed:"right"},scopedSlots:t._u([{key:"default",fn:function(e){return[o("el-button",{attrs:{type:"primary"},on:{click:function(o){t.toCook(e.row,a,e.$index)}}},[t._v("打厨")])]}}])})],1)],1)})),t._v(" "),o("el-dialog",{attrs:{title:t.modalTitle,visible:t.modalFlag,width:"60%","custom-class":"dachu-modal",center:""},on:{"update:visible":function(e){t.modalFlag=e}}},[o("el-table",{staticStyle:{width:"100%"},attrs:{data:t.modalObj,height:"45vh",fit:""}},[o("el-table-column",{attrs:{prop:"seatName",label:"桌号"}}),t._v(" "),o("el-table-column",{attrs:{prop:"quantity",label:"份数",sortable:""}}),t._v(" "),o("el-table-column",{attrs:{prop:"createTimeString",label:"时间",sortable:"",width:"170"}}),t._v(" "),o("el-table-column",{attrs:{prop:"remark",label:"忌口备注"}})],1),t._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:t.modalNo}},[t._v("取消")]),t._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:t.modalYes}},[t._v("确定打厨")])],1)],1)],1)},staticRenderFns:[]};var _={name:"app-main",components:{myHeader:p,tableDone:v,tableUndo:o("VU/8")(g,y,!1,function(t){o("GPb2"),o("qwcB")},"data-v-38f3fbdd",null).exports},data:function(){return{title_01:{titleText:"已做菜单",btns:[{class:"el-icon-back",usage:"exit"}]},title_02:{titleText:"未做菜单"},done:[],undo:[]}},mounted:function(){},methods:{toCookHandle:function(t){var e=new URLSearchParams,o=this,a=[];t.obj.maroClientFoodorderVOList.forEach(function(t,e){a.push(t.id)}),e.append("foodorderIdListJson",s()(a)),this.$http.post(o.BaseUrl+"maroClientServerorderController.do?cookFood",e,{withCredentials:!0}).then(function(t){console.log(t),t.data.success?o.loadData():o.$message.error("打厨失败!")}).catch(function(t){var e=this;this.$alert("登录超时，请重新登录","登录超时",{confirmButtonText:"确定",callback:function(t){e.$router.push({path:"/"})}})})},outDish:function(){this.loadData()},handleData:function(t){var e=this;t.forEach(function(t,o){t.foodOrderItemGroupResultDTOList.forEach(function(o,a){e.$set(o.maroClientFoodorderVO,"typeName",t.typeString),e.$set(o.maroClientFoodorderVO,"typeId",t.type)}),e.$set(t,"typeName",t.typeString),e.$set(t,"typeId",t.type)});for(var o=0;o<t.length;o++)t[o].type,t[o].typeId,t[o].typeName,t[o].typeString;e.undo=t},handleDoneData:function(t){var e=this;e.done=[],t.forEach(function(t,o){t.foodOrderItemGroupResultDTOList.forEach(function(o,a){var n="";o.maroClientFoodorderVOList.forEach(function(t,e){n=n+","+t.seatName+"("+t.quantity+")"}),","==n.substring(0,1)&&(n=n.substring(1,n.length)),o.maroClientFoodorderVO.seatNameList=n;var r={maroClientFoodorderVO:o.maroClientFoodorderVO,maroClientFoodorderVOList:o.maroClientFoodorderVOList};e.done.push(r),e.$set(o.maroClientFoodorderVO,"typeName",t.typeString),e.$set(o.maroClientFoodorderVO,"typeId",t.type)})})},loadData:function(){var t=this;console.log(222),this.$http.get(this.BaseUrl+"maroClientServerorderController.do?listFoodToKitchen",{withCredentials:!0}).then(function(e){console.log(e.data),e.data.success&&(t.handleData(e.data.obj.foodOrderItemResultDTOList),t.handleDoneData(e.data.obj.doneFoodOrderItemResultDTOList))}).catch(function(e){t.$alert("登录超时，请重新登录","登录超时",{confirmButtonText:"确定",callback:function(e){t.$router.push({path:"/"})}}),console.log(22222223344444)})}},created:function(){this.loadData()}},C={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("el-container",{attrs:{direction:"vertical"}},[o("el-main",[o("my-header",{attrs:{title:t.title_01}}),t._v(" "),o("div",{staticClass:"my-table-container"},[o("table-done",{attrs:{done:t.done},on:{outDish:function(e){t.outDish(e)}}})],1)],1),t._v(" "),o("el-main",[o("my-header",{attrs:{title:t.title_02}}),t._v(" "),o("div",{staticClass:"my-table-container"},[o("table-undo",{attrs:{undo:t.undo},on:{toCookHandle:function(e){t.toCookHandle(e)}}})],1)],1)],1)},staticRenderFns:[]};var F=o("VU/8")(_,C,!1,function(t){o("g+zO"),o("zjrU")},"data-v-7395abb8",null).exports,x={data:function(){return{form:{name:"",pass:"",mark:!1},rules:{name:[{validator:function(t,e,o){if(!e)return o(new Error("账号不能为空"));setTimeout(function(){o()},300)},trigger:"blur"}],pass:[{validator:function(t,e,o){if(!e)return o(new Error("密码不能为空"));setTimeout(function(){o()},300)},trigger:"blur"}]}}},created:function(){null!=localStorage.getItem("name")?(this.form.name=localStorage.getItem("name"),this.form.pass=localStorage.getItem("pass"),this.form.mark=!0):this.form.mark=!1},methods:{onSubmit:function(t){var e=this;this.$refs[t].validate(function(t){if(!t)return!1;var o=new URLSearchParams;o.append("user",e.form.name),o.append("pass",e.form.pass),o.append("isLogin",!0);var a=e.$loading({lock:!0,text:"正在登录……",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)",customClass:"login-loading"}),n=e;e.$http.post(e.BaseUrl+"clientUserController.do?login",o,{withCredentials:!0}).then(function(t){console.log(t),a.close(),t.data.success?(n.$message.success("登录成功!"),n.$router.push({path:"/main"}),n.form.mark?(localStorage.setItem("name",n.form.name),localStorage.setItem("pass",n.form.pass)):(localStorage.removeItem("name"),localStorage.removeItem("pass"))):n.$message.error("登录失败!")}).catch(function(t){console.log(t),a.close(),n.$message.error("登录失败!")})})}}},O={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"login-bg"},[o("div",{staticClass:"login-box"},[o("el-form",{ref:"ruleForm",attrs:{model:t.form,"status-icon":"",rules:t.rules,"label-width":"80px",size:"large"}},[o("el-form-item",{attrs:{label:"账号",prop:"name"}},[o("el-input",{model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),t._v(" "),o("el-form-item",{attrs:{label:"密码",prop:"pass"}},[o("el-input",{attrs:{type:"password","auto-complete":"off"},model:{value:t.form.pass,callback:function(e){t.$set(t.form,"pass",e)},expression:"form.pass"}})],1),t._v(" "),o("el-form-item",{attrs:{label:"记住密码",prop:"mark"}},[o("el-switch",{model:{value:t.form.mark,callback:function(e){t.$set(t.form,"mark",e)},expression:"form.mark"}})],1),t._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:function(e){t.onSubmit("ruleForm")}}},[t._v("登录")]),t._v(" "),o("el-button",[t._v("取消")])],1)],1)],1)])},staticRenderFns:[]};var k=o("VU/8")(x,O,!1,function(t){o("DRAD"),o("cfp2")},"data-v-c12ead16",null).exports;a.default.use(i.a);var $,w,S,N,V,L,D=new i.a({routes:[{path:"/",name:"Login",component:k},{path:"/main",name:"Main",component:F}]}),T=o("mtWM"),j=o.n(T),U=o("zL8q"),I=o.n(U);o("bewX");a.default.use(I.a,{size:"medium"}),a.default.prototype.$http=j.a,$=window.document.location.href,w=window.document.location.pathname,S=$.indexOf(w),N=$.substring(0,S),V=w.substring(0,w.substr(1).indexOf("/")+1),L=N+V+"/",a.default.prototype.BaseUrl=L,a.default.config.productionTip=!1,new a.default({el:"#app",router:D,render:function(t){return t(r)},template:"<App/>"})},bewX:function(t,e){},cfp2:function(t,e){},"g+zO":function(t,e){},qwcB:function(t,e){},yHfP:function(t,e){},zjrU:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.8a4116b6e35b7729fca0.js.map