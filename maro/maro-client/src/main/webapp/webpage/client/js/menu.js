new Vue({
	el: '#menu',
	data: {
		order: {
			deskName: '',
			people: null,
			reject: []
		},
        orderZo: {
            deskName: '',
            people: null,
            reject: []
        },
		menu: [],
		menuType: [
			{
				'type': '全部',
				'typeId': -1
			}
		],
        orderTableJson:"",
		menuThis: -1,
		pickMenu: [],
        pickMap:{},
        ruleMap:{},
        pickSendMap:{},
		myModal: -1,
		objModal: null,
		tab: 0,
		info: [],
        rejectList:[],
        waiter:[],
        modelStatus:0,
        //存储买几送几的规则
        salesPromotionList:[],
        //讲所有的菜存入list中，然后方便取
        allMenuList:[],
        pickArray:[],
        //规则存好数据
        mayChoseArray:[],
        pickArr:[],
        pickSendArray:[]

	},
	watch: {
		pickMenu: function () {
			//console.log(JSON.parse(JSON.stringify(this.pickMenu)))

		}
	},
	computed: {
		orderComputed: function () {
			var sum = 0, pce = 0;
			
			this.pickMenu.forEach(function (n, i) {
				 if(n.type!=1){
                     if(n.status==-1 && n.packageType == 0){
                         sum = sum + n.quantity * n.spec.price;
                     }else{
                         sum = sum + n.quantity * n.price;
                     }
				 }


				pce = pce + n.quantity;
			})

			return {
				sum: sum.toFixed(2),
				piece: pce
			};
		},
		multiTitleOne: function () {
			var str = '';
			switch (Number(this.myModal)) {
				case 2:
					str =  '催菜';
					break;
				case 7:
					str =  '起菜';
					break;
				case 8:
					str =  '重打厨单';
					break;
			}
			return str;
		}
	},
	created: function () {
		var that = this;
		//var exampleOrder = {'orderId':'201803291933','openDate':'1522323852','deskName':'5号桌','deskId':'01005','people':4,'waiter':null,'remark':null,'isPrepay':false,'list':[{'name':'雪碧（1.25L）','number':1,'id':'04002','price':22,'amount':1,'type':'酒水','typeId':'04','status':'0'},{'name':'雪碧（1.25L）','number':1,'id':'04002','price':22,'amount':2,'type':'酒水','typeId':'04','status':'1'}],'reject':[{'name':'蔬菜汤','number':2,'id':'01002','price':38,'amount':1,'format':'例','type':'汤','typeId':'01','date':1522393041}]};
		
		//var exampleMenu = [{'name':'紫菜蛋花汤','number':1,'id':'01001','price':8,'format':'例','store':30,'type':'汤','typeId':'01'},{'name':'蔬菜汤','number':2,'id':'01002','price':38,'format':'例','store':24,'type':'汤','typeId':'01'},{'name':'西红柿炒蛋','number':5,'id':'02002','price':20,'format':'碟','store':10,'type':'炒菜','typeId':'02'},{'name':'小鸡炖蘑菇','number':9,'id':'03003','price':40,'format':'碟','store':3,'type':'烧菜','typeId':'03'},{'name':'雪碧（1.25L）','number':11,'id':'04002','price':22,'format':'瓶','store':99,'type':'酒水','typeId':'04'}];
        this.orderTableJson=JSON.parse(window.localStorage.getItem("orderTableJson"));
        
        Vue.set(that.orderZo, 'deskName', that.orderTableJson.destSeatName);
        Vue.set(that.orderZo, 'people', that.orderTableJson.personNumber);
		//this.order.deskName=this.orderTableJson.destSeatName;
        //this.order.people=this.orderTableJson.personNumber;
        
		//获取订单
		ajaxRequest({
			path: 'maroClientServerorderController.do?listMenu',
			data: {
                serverOrderId: this.orderTableJson.serverOrderId,
                seatId:that.orderTableJson.tableId
			},
            layer: true
		}, function (data) {
			// console.log(data.obj);
            that.salesPromotionList=data.obj.salesPromotionList;
            //console.log(that.salesPromotionList);
            that.init();
			//处理菜的类型及菜基本数据
            that.handleDataMenu(data.obj.menuItemGroupResultDTOList);
            //处理右边已点的菜
			that.handleDataOrder(data.obj.maroClientFoodorderVOList);
		})
        ajaxRequest({
            path: 'clientUserController.do?tsUserList',
            data: {}
        }, function (data) {

            that.waiter=data.obj;
        } ,function (data) {

        });
	},
	methods: {
	    init(){
	        //1.已点菜品初始化到pickMap
            //2.转换rule到map
            /*if(this.salesPromotionList && this.salesPromotionList.length > 0){
                for(var i=0;i<this.salesPromotionList.length;i++) {
                    var row = this.salesPromotionList[i];
                    this.ruleMap[row.buyid+row.] = row;
                }
            }*/
            //console.log(this.ruleMap);
        },
		back: function (flag) {
			if (flag==1 || flag==3) {
				var foodorderDOList=[];

				//this.pickDiscount();
				console.log(this.pickMenu)
				//
                for(var i=0;i<this.pickMenu.length;i++){
                    var t=this.pickMenu[i];

                    if(t.status==-1){
                        var j;
                        if(t.spec) {

                            j = {
                                'foodId': t.foodCode,
                                'quantity': t.spec.amount,
                                'specificationsId': t.spec.id,
                                'specificationsName': t.spec.name,
                                'unitCode':t.unit,
                                'unitName':t.unitName,
                                'price':t.spec.price,
                                'remark':t.remark,
                                // 'type':t.type,
                                'list':[],
                                'packageType':0

                            }
                            if(t.type==2){
                                j.type=2;
                                j.price=0;
                            }

                        }else if(t.packageType == 1){
                            let listArr = [];
                            for (let k = 0; k < t.list.length; k++) {
                                var o={
                                    'foodId':t.list[k].dishesId,
                                    'quantity':t.list[k].quantity,
                                    'specificationsId':t.list[k].specificationsId,
                                    'specificationsName':'普通',
                                    'unitCode':t.list[k].dishesUnitCode,
                                    'unitName':t.list[k].dishesUnit,
                                    'price':t.list[k].price,
                                    // 'type':t.list[k].type,
                                    'packageType':t.list[k].packageType,
                                };
                                if(t.list[k].type==2){
                                    o.type=2;
                                    o.price=0;
                                }
                                listArr.push(o)
                            }
                            var specId="";
                            if(t.packageType==0){
                                specId=t.spec.specificationsId;
                            }else{
                                specId=t.specificationsId;
                            }
                            j = {
                                'foodId':t.foodCode,
                                'quantity':t.quantity,
                                'specificationsId':specId,
                                'specificationsName':'普通',
                                'unitCode':t.unit,
                                'unitName':t.unitName,
                                'price':t.price,
                                'list':listArr,
                                // 'type':t.type,
                                'packageType':1,
                            }
                            if(t.type==2){
                                j.type=2;
                                j.price=0;
                            }
                        }else{
                            var specId="";
                            if(t.packageType==0){
                                specId=t.spec.specificationsId;
                            }else{
                                specId=t.specificationsId;
                            }
                            j = {
                                'foodId':t.foodCode,
                                'quantity':t.quantity,
                                'specificationsId':specId,
                                'specificationsName':'普通',
                                'unitCode':t.unit,
                                'unitName':t.unitName,
                                'price':t.spec.price,
                                'list':[],
                                // 'type':t.type,
                                'packageType':0
                            }
                            if(t.type==2){
                                j.type=2;
                                j.price=0;
                            }
                        }

                        foodorderDOList.push(j);
                    }
                }
                console.log(foodorderDOList);

                if(foodorderDOList.length==0){
                    layerToast('请选择您要点的菜品！');
                    return;
				}
                var index = layerLoading();
				//落单不打厨字段；0是不打厨1为大厨
				var kitchenNotify=0;
				if(flag==1){
                    kitchenNotify=1;
				}
				var data = {
				   "maroClientServerorderDO":{
						 "id":this.orderTableJson.serverOrderId,
					   "kitchenNotify":kitchenNotify
				   },
				   "maroShopSeatEntity":{
						 "id":this.orderTableJson.tableId
				   },
				   "maroClientFoodorderDOList":foodorderDOList
				};

				ajaxRequest({
					path: 'maroClientServerorderController.do?orderFood',
					data: { 'foodOrderParamsDTOString':JSON.stringify(data)},
					layer: false
				}, function (data) {
					this.pickMenu=[];
					this.objModal=null;
                    if(window.print1!="undefined" && window.print1!=undefined){
                    	if(data.attributes.printJson.dateTime=="null"){
                            print1.SetDatetime("");
						}else{
                            print1.SetDatetime(data.attributes.printJson.dateTime);
						}
						if(data.attributes.printJson.guests==""|| data.attributes.printJson.guests=="null"){
                            print1.SetGuests(0);
						}else{
                            print1.SetGuests(Number(data.attributes.printJson.guests));
						}
						if(data.attributes.printJson.orderNum==""|| data.attributes.printJson.orderNum=="null"){
                            print1.SetOrdernum("");
						}else{
                            print1.SetOrdernum(data.attributes.printJson.orderNum);
						}
						if(data.attributes.printJson.table==""|| data.attributes.printJson.table=="null"){
                            print1.SetTable("");
						}else{
                            print1.SetTable(data.attributes.printJson.table);
						}
						if(data.attributes.printJson.waiter==""|| data.attributes.printJson.waiter=="null"){
                            print1.SetWaiter("");
						}else{
                            print1.SetWaiter(data.attributes.printJson.waiter);
						}
                        if(data.attributes.printJson.remark==""|| data.attributes.printJson.remark=="null"){
                            print1.SetRemark("");
                        }else{
                            print1.SetRemark(data.attributes.printJson.remark);
                        }
                        if(data.attributes.printJson.dishes=="" || data.attributes.printJson.dishes=="null" ||data.attributes.printJson.dishes=="[]" ){
                            print1.SetDishes("[]");
						}else{
                            print1.SetDishes(data.attributes.printJson.dishes);
						}
                        print1.Print();
                    }
					window.localStorage.removeItem('orderTableJson');
					window.history.go(-1)
				})
            } else {
                this.pickMenu=[];
                this.objModal=null;
                window.localStorage.removeItem('orderTableJson');
                window.history.go(-1)
			}
		},
        handleTableData:function(data){
            var that = this,
                nowStamp = Date.parse(new Date()),
                halfHour = 1800000,
                expireHour = 21600;
            data.forEach(function (n, i) {
                n.list.forEach(function (o, j) {

                    //-1预定, 0为空闲, 1为使用中, 2为已结账
                    if (o.maroClientSeatchangeVO) {

                        switch (o.maroClientSeatchangeVO.type) {
                            //开台
                            case 0:
                                Vue.set(o, 'status', 1);
                                break;
                            //换桌
                            case 11:
                                Vue.set(o, 'status', 1);
                                break;
                            //并桌
                            case 12:
                                Vue.set(o, 'status', 1);
                                break;
                            //换桌
                            case 13:
                                Vue.set(o, 'status', 1);
                                break;
                        }
                        if(o.maroClientSeatchangeVO.maroClientServerorderVO.status==2){
                            //结账
                            Vue.set(o, 'status', 2);
                        }
                        /*	if (o.openInfo.isPaid) {
                                Vue.set(o, 'status', 2);
                            } else {
                                Vue.set(o, 'status', 1);
                                Vue.set(o, 'openLast', that.getHrsMin( (nowStamp - Number(o.openInfo.openDate)) ));
                            }*/

                    } else {

                        Vue.set(o, 'status', 0)
                    }
                    //console.log(o.maroClientReserveVOList);
                    if(o.status!=1){
                        //表示有预订记录
                        if(o.maroClientReserveVOList.length>0){
                            //Vue.set(o, 'status', -1);
                            //当前时间在预约时间前后半小时内, 显示为预约状态, 否则都为空闲状态
                            Vue.set(o, 'status', o.maroClientReserveVOList.length && Math.abs(Number(o.maroClientReserveVOList[0].reserveTime) - nowStamp) < halfHour ? -1 : 0)
                        }
                    }

                })
            })

            that.info = data;
		},
		realoadData:function(){
			var that=this;
            //获取订单
            ajaxRequest({
                path: 'maroClientServerorderController.do?listMenu',
                data: {
                    serverOrderId: that.orderTableJson.serverOrderId,
                    seatId:that.orderTableJson.tableId
                },
                layer:false
            }, function (data) {
                //处理菜的类型及菜基本数据
                that.handleDataMenu(data.obj.menuItemGroupResultDTOList);
                //处理右边已点的菜
                that.handleDataOrder(data.obj.maroClientFoodorderVOList);
            })
		},
		handleDataOrder: function (data) {
			var that = this,
				arrStatus = ['即起', '打厨', '出锅', '加急','催菜','','已上'];
			
			that.order = data;
            //Vue.set(that.order, 'deskName', that.orderTableJson.destSeatName);
            //Vue.set(that.order, 'people', that.orderTableJson.personNumber);
			that.pickMenu = [].concat(this.order);
			
			that.pickMenu.forEach(function (n, i) {
				n.status = Number(n.status);
				Vue.set(n, 'statusText', arrStatus[n.status])
			})
            that.reckonAmount();
			/*that.order.reject.forEach(function (n, i) {
				Vue.set(n, 'datetime', that.getFullDate(n.date).fen)
			})*/
		},
		orderCount: function () {
			
		},
		handleDataMenu: function (data) {
			var that = this,
				foodList = [];
			
            for (var i = 0; i < data.length; i++) {
            	var flag=true;
            	 for(var j=0;j< that.menuType.length;j++){
            	 	if(that.menuType[j].typeId==data[i].type){
            	 		flag=false;
            	 	   break;
            	 	}
                 }
				 if(flag){
                     if(data[i].type){
                         that.menuType.push({
                             type: data[i].typeString.trim(),
                             typeId: data[i].type
                         });
					 }else {
                         data[i].type = -2;
                         data[i].typeString = "套餐";
                         that.menuType.push({
                             type: "套餐",
                             typeId: -2
                         });
					 }

				 }

                
            	for(var j = 0; j < data[i].menuItemResultDTOList.length; j++){
        			var dto = data[i].menuItemResultDTOList[j];
            	    //数量
                    dto.maroDishesEntity.quantity = dto.quantity;

                    //菜的id
                    dto.maroDishesEntity.foodCode = dto.maroDishesEntity.id;
                    //菜名
                    dto.maroDishesEntity.foodName = dto.maroDishesEntity.dishesName;
                    //判断是否套餐价
					if(dto.maroDishesEntity.type === "package"){//套餐
                        //单价
                        dto.maroDishesEntity.price = dto.maroDishesEntity.packagePrice;
					}else {
                        //单价
                        dto.maroDishesEntity.price = dto.maroDishesEntity.salesPrice;
					}
                    //菜品类型id
                    dto.maroDishesEntity.typeId = data[i].type;
                    foodList.push(dto.maroDishesEntity);
                    var objAll={};
                    //var key=dto.maroDishesEntity.id+'';
                        //dto.maroDishesEntity.spec={};
                    /*var o=dto.maroDishesEntity;
                    o.spec={};*/

                    objAll={'freeFoodId':dto.maroDishesEntity.id,'freeEntity':dto.maroDishesEntity};
                    that.allMenuList.push(objAll);
				}

			}
            
			/*
			data.forEach(function (n, i) {
				var flagEcho = false;
				Vue.set(n, 'amount', 0);

				for (var p in that.menuType) {
					//遍历菜品类数组, 如无重复则push
					if (that.menuType[p].typeId === n.typeId) {
						flagEcho = true;
						continue;
					}
				}

				if (!flagEcho) {
					that.menuType.push({
						type: n.type.trim(),
						typeId: n.typeId
					})
				}
			})*/

			this.menu = foodList;
            for(var i=0;i< this.menu.length;i++){
                for(var j=0;j<this.pickMenu.length;j++){
                    if(this.menu[i].id==this.pickMenu[j].id){
                        this.menu[i].quantity=this.menu[i].quantity+this.pickMenu[j].quantity;
                    }
                }
            }
		},
		menuSort: function (obj) {
			this.menuThis = obj.typeId;
		},
		getFullDate: function (timestamp){
			var ts = (timestamp + '').length === 10 ? parseInt(timestamp)*1000 : parseInt(timestamp),
				date = new Date(ts);
			
			var yr = date.getFullYear();
				mh = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1),
        		dt = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()),
        		hr = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()),
        		mn = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()),
        		sc = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());
    		
        	return {
        		fen: yr+'-'+mh+'-'+dt+' '+hr+':'+mn
        	};
    	},
		pick: function (thisObj) {
			//点选菜单中的菜品加到右侧
			var obj = JSON.parse(JSON.stringify(thisObj));

            //判断是否有套餐
            if(obj.type === "package"){//套餐
                obj.type=0;
                this.openModal(12, obj);
			}else if(obj.type === "ordinary" && obj.specificationsList.length > 1){//普通 多规格
                obj.packageType = 0;
                obj.type=0;
                this.openModal(10, obj);
            }else {
                //只有1个规格
                var fg = false, i = 0;
                if(obj.quantity==0){
                    obj.quantity=1;
                }
                var objSpec = {
                    id: obj.specificationsList[0].id,
                    name: obj.specificationsList[0].pageName,
                    price: obj.specificationsList[0].unitPrice,
                    amount: obj.quantity,
                };
                this.pickMenu.unshift(obj);
                Vue.set(this.pickMenu[0], 'quantity', objSpec.amount);
                Vue.set(this.pickMenu[0], 'packageType', 0);
                Vue.set(this.pickMenu[0], 'type', 0);
                Vue.set(this.pickMenu[0], 'status', -1);
                Vue.set(this.pickMenu[0], 'spec', objSpec);

                this.pickDiscount();
            }

            var size = this.pickMap[obj.id];
            if(!size){
                this.pickMap[obj.id] = 1;
            }else{
                size++;
                this.pickMap[obj.id] = size;
            }
//            console.log(this.pickMap);
/*
			if (obj.specificationsList.length > 1) {
				//多规格
                this.openModal(10, obj);
			} else {

				//只有1个规格
				var fg = false, i = 0;
				if(obj.quantity==0){
                    obj.quantity=1;
				}
				var objSpec = {
					id: obj.specificationsList[0].id,
					name: obj.specificationsList[0].pageName,
					price: obj.specificationsList[0].unitPrice,
					amount: obj.quantity
				};
				// //判断是否在右侧新加过
				// for (i; i < this.pickMenu.length; i++) {
				// 	var thisPick = this.pickMenu[i];
				// 	if (obj.id === thisPick.foodCode && objSpec.id === thisPick.spec.id && thisPick.status === -1) {
				// 		thisPick.quantity += objSpec.amount;
                 //        objSpec.amount=thisPick.quantity;
                //
                 //        Vue.set(thisPick, 'spec', objSpec);
                 //        console.log(thisPick);
				// 		fg = true;
				// 		break;
				// 	}
				// }
				//
				// //如果右侧没有新加过, 就新建一条
				// if (!fg) {
					this.pickMenu.unshift(obj);
					Vue.set(this.pickMenu[0], 'quantity', objSpec.amount);
					Vue.set(this.pickMenu[0], 'status', -1);
					Vue.set(this.pickMenu[0], 'spec', objSpec);
				//}
			}
*/

            this.reckonAmount();
		},
        //处理折扣列表
        pickDiscount:function(){


	        // for(var key in this.pickMap){
	        //     var id = key;
            //     var size = this.pickMap[row];
            //     var rule = this.ruleMap[id];
            //     var buynum = rule.buynum;
            //
            //     var sendNum = (size / buynum) * rule.freenum;//id对应菜品应送数量 size为6，buynum3
            //
            //     var sendedNum = this.pickSendMap[id]; // ID对应菜品已送数量
            //     if(!sendedNum){
            //         sendedNum = 0;
            //     }
            //
            //     if(sendNum > sendedNum){
            //         //
            //         this.pickSendMap[id] = sendNum;
            //     }
            //
            //
            //     //sendNum
            //
            // }




		    this.pickArray=[];
            this.pickSendArray=[];
		    this.mayChoseArray=[];
		    this.pickArr=[];
            console.log('pickMenu==',this.pickMenu);
		    //用来存储所有选择的菜的总数。
		    for(var i=0;i<this.pickMenu.length;i++){
                /*if(this.pickMenu[i].hasOwnProperty('sea')){
                    this.pickMenu.splice(i,1);
                    break;
                }*/
		        if(this.pickMenu[i].status==-1){
                    this.pickMenu[i].foodId=this.pickMenu[i].id;
                    if(this.pickMenu[i].spec){
                        this.pickMenu[i].specificationsId=this.pickMenu[i].spec.id;
                    }
                    else{
                        if(this.pickMenu[i].packageType==0){
                            this.pickMenu[i].specificationsId=this.pickMenu[i].specificationsList[0].id;
                        }
                    }
                    this.pickMenu[i].isFavourable=200;
                }
		        //表示是刚刚选择的还没有点的菜

                var hasSame=false;
                for(var j=0;j<this.pickArray.length;j++){
                    if( this.pickArray[j].foodId==this.pickMenu[i].foodId &&  this.pickArray[j].specificationsId==this.pickMenu[i].specificationsId && this.pickMenu[i].type==this.pickArray[j].type){
                        this.pickArray[j].quantity=this.pickArray[j].quantity+1;
                        hasSame=true;
                    }
                }
                if(!hasSame){
                    var b = JSON.parse(JSON.stringify(this.pickMenu[i]));
                    this.pickArray.push(b);
                }

            }
            console.log('pickArray==',this.pickArray);

            //存储规则整理好的数据
            for(var i=0;i<this.salesPromotionList.length;i++){
                for(var j=0;j<this.pickArray.length;j++){
                    if(this.pickArray[j].foodId==this.salesPromotionList[i].buyid && this.pickArray[j].specificationsId==this.salesPromotionList[i].buyspecificationid && this.pickArray[j].type!=2){
                        var count,remainderCount;
                        //Y表示是叠加
                        if(this.salesPromotionList[i].is_add=='Y'){
                            console.log(this.pickArray[j].quantity,this.salesPromotionList[i].buynum,this.salesPromotionList[i].freenum);
                            console.log(this.pickArray[j].quantity,this.salesPromotionList[i].buynum,this.salesPromotionList[i].freenum)
                            //表示送几个。
                            count=(Math.floor(this.pickArray[j].quantity/this.salesPromotionList[i].buynum))*this.salesPromotionList[i].freenum;

                        }else{
                            //表示送几个。
                            if(this.pickArray[j].quantity<this.salesPromotionList[i].buynum){
                                count=0;
                            }else{
                                count=this.salesPromotionList[i].freenum;
                            }

                        }
                         this.mayChoseArray.push({
                             sendCount:count,
                             buyFoodId:this.salesPromotionList[i].buyid,
                             buyFoodSpecificationsId:this.salesPromotionList[i].buyspecificationid,
                             freeFoodId:this.salesPromotionList[i].freeid,
                             freeSpecificationsId:this.salesPromotionList[i].freespecificationid,
                             freespecificationName:this.salesPromotionList[i].freespecificationname
                         })
                    }
                }
            }
            console.log(this.mayChoseArray);
            for(var j=0;j<this.mayChoseArray.length;j++){
                for(var h=0;h<this.pickArray.length;h++){
                    if(this.pickArray[h].foodId==this.mayChoseArray[j].freeFoodId && this.pickArray[h].specificationsId== this.mayChoseArray[j].freeSpecificationsId && this.pickArray[h].type==2){
                        this.mayChoseArray[j].sendCount=this.mayChoseArray[j].sendCount-this.pickArray[h].quantity;
                    }
                }
                    for(var k=0;k<this.allMenuList.length;k++){
                        if(this.allMenuList[k].freeFoodId==this.mayChoseArray[j].freeFoodId){
                            for(var l=0;l<this.mayChoseArray[j].sendCount;l++){

                                // var b=this.allMenuList[k].freeEntity;
                                var b = JSON.parse(JSON.stringify(this.allMenuList[k].freeEntity));

                                b.spec={'id':'','name':'','price':'','amount':''};
                                b.spec.id=this.mayChoseArray[j].freeSpecificationsId;
                                b.spec.name=this.mayChoseArray[j].freespecificationName;
                                for(var h=0;h<b.specificationsList.length;h++){
                                    if(this.mayChoseArray[j].freeSpecificationsId==b.specificationsList[h].id){
                                        b.spec.price=b.specificationsList[h].unitPrice;
                                    }
                                }
                                b.spec.amount= 1;
                                b.status=-1;
                                b.type=2;
                                b.quantity=1;
                                b.price=0;
                                b.salesPrice=0;
                                b.sea=-1;
                                //this.pickSendArray.push(b);
                                //console.log(this.pickSendArray);
                                this.pickMenu.push(b);
                            }
                        }
                    }
              //  console.log(this.pickSendArray);
                //this.pickMenu = this.pickMenu.concat(this.pickSendArray)


            }


        },
        pickFormat: function () {
            var that = this;
            this.objModal.specArr.specificationsList.forEach(function (n, i) {
                if (n.hasOwnProperty('amountSpe')) {
                    //有关规格的键值对
                    var objSpec = {
                        id: n.id,
                        name: n.pageName,
                        price: n.unitPrice,
                        amount: n.amountSpe
                    };

                    //只有1个规格
                    var fh = false, k = 0;

                    //判断是否在右侧新加过
                    // for (k; k < that.pickMenu.length; k++) {
                    // 	var thisPick = that.pickMenu[k];
                    // 	if (that.objModal.specArr.id === thisPick.foodCode && objSpec.id === thisPick.spec.id && thisPick.status === -1) {
                    // 		thisPick.quantity += objSpec.amount;
                    // 		fh = true;
                    // 		break;
                    // 	}
                    // }
                    //
                    // //如果右侧没有新加过, 就新建一条
                    // if (!fh) {
                    //原菜品的json
                    var objTarget = JSON.parse(JSON.stringify(that.objModal.specArr));
                    objTarget.spec = objSpec;
                    Vue.set(objTarget, 'quantity', objSpec.amount);
                    Vue.set(objTarget, 'status', -1);
                    that.pickMenu.unshift(objTarget);
                    //}
                }
            })


            that.pickDiscount();
            that.reckonAmount();
            that.clsModal();
        },
        //套餐
        pickRemark:function (val,key,allVal) {
            console.log(allVal);
            console.log(val);
            let fg = false,numtotal = 0;
            for (let i = 0; i < allVal.selectList.length; i++) {
                if (allVal.selectList[i] == val) {
                    allVal.selectList.splice(i, 1);
                    Vue.set(val, 'isRepetitionhidde', false);
                    fg = true
                    break
                }
            }
            //如果只能选一个就可以自由切换
            if(allVal.selectNum == 1 && allVal.isRepetition == 1){
                Vue.set(allVal, 'selectList', []);
            }
            if (!fg) {

                for (let i = 0; i < allVal.selectList.length; i++) {
                    let obj = allVal.selectList[i];
                    numtotal += obj.quantity
                }
                if(allVal.selectNum >  numtotal){
                    allVal.selectList.push(val)
                    Vue.set(val, 'isRepetitionhidde', true);
                    Vue.delete(val, 'quantity');

                    //点选菜品规格
                    if (!val.hasOwnProperty('quantity')) {
                        Vue.set(val, 'quantity', 1);
                    } else {
                        Vue.delete(val, 'quantity');
                    }
				}

            }
        },
        pickRemarkNum:function (item,num,allItem) {
            //点选菜品加减
            let numtotal = 0;
			if(num === 1){
                for (let i = 0; i < allItem.selectList.length; i++) {
                    let obj = allItem.selectList[i];
                    numtotal += obj.quantity
                }
                if(allItem.selectNum >  numtotal){
                    item.quantity = item.quantity + num;
                }
			}else {
                item.quantity = item.quantity + num;
                if(item.quantity === 0){
                    for (let j = 0; j < allItem.selectList.length; j++) {
                        if (allItem.selectList[j] == item) {
                            allItem.selectList.splice(j, 1);
                            Vue.set(item, 'isRepetitionhidde', false);
                            break
                        }
                    }
                }
			}
        },
        //套餐确定按钮
        pickPackage:function () {
             console.log(this.objModal.packageArr);
            let allSelectList = [];
            for (var i = 0; i < this.objModal.packageArr.setmealSishesList.length; i++) {
                var obj = this.objModal.packageArr.setmealSishesList[i];
                for (var j = 0; j < obj.selectList.length; j++) {
                    obj.selectList[j].packageType = 2;
                    obj.selectList[j].price = 0;
                    allSelectList.push(obj.selectList[j])
                }
            }

            if(allSelectList.length == 0 ){
                layerToast('请选择套餐');
                return;
            }
            this.objModal.packageArr.list = allSelectList;
            this.objModal.packageArr.packageType = 1;
            this.objModal.packageArr.quantity = 1;
            this.objModal.packageArr.status = -1;

            this.pickMenu.unshift(this.objModal.packageArr);

            this.pickDiscount();
            this.reckonAmount();
            this.clsModal();
        },
		menuAdjust: function (obj, idx, unit) {

            //调整菜品数量
			obj.quantity = obj.quantity + unit;
			if(obj.packageType!=1){
                Vue.set(obj.spec, 'amount', obj.quantity);
            }

			if (obj.quantity === 0) this.pickMenu.splice(idx, 1);
             var arr=[];
             var that=this;
            (function () {
            for(var i=that.pickMenu.length-1;i>=0;i--){
                if(that.pickMenu[i].hasOwnProperty('sea')){
                    that.pickMenu.splice(i,1);
                }
            }
            })();
            console.log(arr);
            // for(var i=0;i<arr.length;i++){
            //     if(i==0){
            //         this.pickMenu.splice(arr[i],1);
            //     }else{
            //         this.pickMenu.splice(arr[i]-1,1);
            //     }
            // }

		},
        reckonAmount:function(){
            var arr=[];
            for(var i=0;i<this.pickMenu.length;i++){
                var arrStatus = 0;
                for(var j=0;j<arr.length;j++){
                    if(this.pickMenu[i].hasOwnProperty("foodId")){
                        foodId=this.pickMenu[i].foodId;
                    }else{
                        foodId=this.pickMenu[i].id;
                    }
                    if(foodId==arr[j].foodId){
                        arrStatus=1;
                        arr[j].quantityAll=arr[j].quantityAll+this.pickMenu[i].quantity
                        break;
                    }
                }
                if(arrStatus==0){
					var foodId="";
                	if(this.pickMenu[i].hasOwnProperty("foodId")){
                        foodId=this.pickMenu[i].foodId;
					}else{
                        foodId=this.pickMenu[i].id;
					}
                    var arrJson={
                        foodId:foodId,
                        quantityAll:this.pickMenu[i].quantity
                    };
                    arr.push(arrJson);
                }
            }
            for(var i=0;i<this.menu.length;i++){
                if(arr.length==0){
                    Vue.set(this.menu[i],"quantityAll",0);
                }
                for(var j=0;j<arr.length;j++){
                    if(this.menu[i].id==arr[j].foodId){
                        Vue.set(this.menu[i],"quantityAll",arr[j].quantityAll);
                        break;
                    }else{
                        Vue.set(this.menu[i],"quantityAll",0);
					}
                }
            }
		},
		clsModal: function () {
			//关闭自己写的模态框
			this.myModal = -1;
			this.objModal = null;
			this.pickMenu.forEach(function (n, i) {
				Vue.delete(n, 'amountStill');
				Vue.delete(n, 'amountRej');
			})
		},
		more: function () {
			//点击右下角更多按钮
			var that = this;
			swal({
				title: '操作',
				buttons: {
					cancel: false,
					confirm: false,
					sendKitNo: {text: '落单不打厨', value: '0'},
					dishRejectHistory: {text: '查看退菜', value: '1'},
					dishTrans: {text: '菜品转台', value: '2'},
					dishUrge: {text: '催菜', value: '3'},
					/*dishFetch: {text: '起菜', value: '4'},*/
					orderInfo: {text: '订单资料', value: '5'},
					dishOpt: {text: '赠菜/退菜', value: '6'},
					orderPay: {text: '结账', value: '7'},
					/*resendKit: {text: '重打厨单', value: '8'},*/
					multiMenu: {text: '多桌点餐', value: '9'}
				}
			})
			.then (function (v) {
				switch (parseInt(v)) {
					case 0:
						that.back(3);
						break;
					case 1:
						that.openModal(0);
						break;
					case 2:
						that.openModal(1);
						break;
					case 3:
						//催菜
						that.openModal(2);
						break;
					case 4:
						that.openModal(7);
						break;
					case 5:
						that.openModal(3);
						break;
					case 6:
						//退菜或增菜
						that.openModal(4);
						break;
					case 7:
						window.location.href = 'pay.html';
						break;
					case 8:
						that.openModal(8);
						break;
					case 9:
						that.openModal(9);
						break;
				}
			})
		},
		openModal: function (i, obj) {
			//打开自己写的弹出面板
			var that = this;
			that.myModal = i;

			switch (i) {
				case 0:
					var that=this;
					//查看退菜
                    ajaxRequest({
                        path: 'maroClientServerorderController.do?listRefundFood',
                        data: {
                            'serverorderId':that.orderTableJson.serverOrderId,
                            'seatId':that.orderTableJson.tableId
                        },
						layer:false
                    }, function (data) {
                    	console.log(data);
                    	let objArr = new Array();
                        for (let j = 0; j < data.obj.length; j++) {
                          if(data.obj[j].packageType != 2){
                              objArr.push(data.obj[j])
                          }
                        }
                    	that.rejectList=objArr;
                        //that.clsModal();
                        //that.realoadData();

                       // layerToast('操作成功。')
                    })


					break;
				case 1:
                    //1菜品转台9多桌点餐
                    var pi = that.pickMenu;

                    pi.forEach(function (n, i) {
                        Vue.set(n, 'amountStill', n.quantity);
                        Vue.set(n, 'amountRej', 0);
                    })

                    that.objModal = {
                        menuList: pi,
                        menuPick: [],
                        reasonList: [
                            {'id': 0,'text': '下错单'},
                            {'id': 1,'text': '上错台'}
                        ],
                        reason: null,
                        chuiArrNew:[],
                        newIdArr:[]

                    };
                    that.modelStatus=1;
                    break;
				case 9:
					//1菜品转台9多桌点餐
					var pi = that.pickMenu;

					pi.forEach(function (n, i) {
						Vue.set(n, 'amountStill', n.quantity);
						Vue.set(n, 'amountRej', 0);
					})
					
					that.objModal = {
						menuList: pi,
						menuPick: [],
						reasonList: [
							{'id': 0,'text': '下错单'}, 
							{'id': 1,'text': '上错台'}
						],
						reason: null,
                        chuiArrNew:[],
                        newId: [],
                        newIdArr:[]


					};
					that.modelStatus=9;
					break;
				case 2:
					//催菜
					that.objModal = {
						menuList: that.pickMenu.filter(function (m) {
							return m.status !== -1 && m.status !== 6
						}),
						chuiArr: [],
						//用来封装催菜数组。
						chuiArrNew:[]

					};
					break;
				case 3:
					//订单资料

					that.objModal = {
						people: that.orderTableJson.personNumber,
						waiter: "",
                        ownWaiter:that.orderTableJson.waiterId,
                        waiter:that.waiter,
						remark: that.orderTableJson.remark
					};
					break;
				case 4:
					//退菜or赠菜
					var pj = that.pickMenu;
					pj.forEach(function (n, i) {
						Vue.set(n, 'amountStill', n.quantity);
						Vue.set(n, 'amountRej', 0);
					})
					
					that.objModal = {
						type: 0,
						menuList: pj,
						reasonList: [
							[
								{'id': 00,'text': '菜品问题'}, 
								{'id': 01,'text': '上菜太慢'}, 
								{'id': 02,'text': '客人换菜'}
							], [
								{'id': 10,'text': '店内活动'}, 
								{'id': 11,'text': '服务补偿'}, 
								{'id': 12,'text': 'vip客户'}
							]
						],
						reason: null,
                        chuiArrNew:[]
					}
					break;
				case 5:
                    if(this.objModal.chuiArrNew.length==0){
                        layerToast("暂无已上的菜可选择换桌");
                        return;
                    }
					//菜品转台or多桌点餐, 要选桌
                    ajaxRequest({
                        path: 'maroClientServerorderController.do?listSeat',
                        data: {}
                    }, function (data) {
                        that.handleTableData(data.obj)
                    } ,function (data) {
                    });
					/*that.info = [].concat( JSON.parse(window.localStorage.getItem('info')) );
					
					if (!that.info[0]) {
						layerToast('获取桌位信息失败，请稍后重试。');
						that.info = [];
					}*/
					break;
				case 6:
					//that.objModal.



					//点击pickMenu中的某一项
					break;
				case 7:
					//起菜
					that.objModal = {
						menuList: that.pickMenu.filter(function (m) {
							return m.status !== -1
						}), //应该是放状态为[叫起]的菜品的数组~
						chuiArr: [],
                        chuiArrNew:[]
					};
					break;
				case 8:
					//重打厨单
					that.objModal = {
						menuList: that.pickMenu.filter(function (m) {
							return m.status !== -1
						}),
						chuiArr: [],
                        chuiArrNew:[]
					};
					break;
				case 10:
					//选择菜品规格
					that.objModal = {
						specArr: JSON.parse(JSON.stringify(obj))
					};
                    break;
                case 12:
                    that.objModal = {
                        packageArr: JSON.parse(JSON.stringify(obj))
                    };
                    for (var j = 0; j < that.objModal.packageArr.setmealSishesList.length; j++) {
                    	var obj1 = that.objModal.packageArr.setmealSishesList[j];
                        Vue.set(obj1, 'selectList', []);
                        for (var k = 0; k < obj1.setmealDishesSelectList.length; k++) {
                            Vue.set(obj1.setmealDishesSelectList[k], 'isRepetitionhidde', false);
                        }
                    }
                    break;
			}
		},
		openSingleModal: function (obj, i) {
            console.log(obj);
            console.log(i);
            //点击pickMenu中的某一项

			var type=0;
            if(obj.packageType == 1){
                 type = 5;
            }else {
                if(obj.status==-1){
                    type=2
                }
            }
			this.myModal = 6;
			this.objModal = {
				menuInfo: obj,
				menuIndex: i,
				type:type,
				reasonList: [
					{'id': 0,'text': '时价菜'}
				],
				reason: null,
                temporaryPrice:'',
                chuiArrNew:[],
				remark:''
			};
		},
		tabDeskType: function (i) {
			if (this.tab !== i) this.tab = i;
		},
		pickDesk: function (obj) {
			if(this.modelStatus==1){
                Vue.set(this.objModal, 'deskId', obj.id);
                this.objModal.newIdArr=[{
                	id:obj.id,
                    serverOrderId:obj.maroClientSeatchangeVO.serverOrderId
				}];
                console.log(this.objModal.newIdArr);
			}else if(this.modelStatus==9){
				if(this.objModal.newId.indexOf(obj.id)===-1){
                    this.objModal.newId.push(obj.id);
                    var serverOrderId="";
                    if(obj.maroClientSeatchangeVO){
                        serverOrderId=obj.maroClientSeatchangeVO.serverOrderId;
					}
                    var newId={
                        'id':obj.id,
						'serverOrderId':serverOrderId
                    };
                    this.objModal.newIdArr.push(newId)
				}else{
					for(var i=0;i<this.objModal.newIdArr.length;i++){
						  if(this.objModal.newIdArr[i].seatId==obj.id){
                              this.objModal.newIdArr.splice(i, 1);
						  }
					}
                    this.objModal.newId.splice(this.objModal.newId.indexOf(obj.id), 1);
				}
                console.log(this.objModal.newIdArr);
			}

			//this.objModal.deskId = obj.id;
		},
		orderInfoSave: function () {
			var that = this;
            var waiterName=""
            for(var i=0;i<that.objModal.waiter.length;i++){
                if(that.objModal.waiter[i].id==that.objModal.ownWaiter){
                    waiterName=that.objModal.waiter[i].realName;
                    break;
                }
            }
			ajaxRequest({
				path: 'maroClientServerorderController.do?updateServerorder',
				data: {
                    id: that.orderTableJson.serverOrderId,
                    personNumber: that.objModal.people,
                    remark: that.objModal.remark,
                    waiterName:waiterName,
                    waiterId:that.objModal.ownWaiter
				},
				layer: false
			}, function (data) {
                var orderTableJson={
                    serverOrderId:that.orderTableJson.serverOrderId,
                    destSeatName:that.orderTableJson.destSeatName,
                    tableId:that.orderTableJson.tableId,
                    personNumber:that.objModal.people
                }
                window.localStorage.setItem('orderTableJson', JSON.stringify(orderTableJson));
                Vue.set(that.orderZo, 'deskName', that.orderTableJson.destSeatName);
                Vue.set(that.orderZo, 'people', that.objModal.people);
				that.clsModal();
				that.realoadData();
				layerToast('修改成功。')
			})
		},
		pickModalMenu: function (obj) {
			console.log(obj);
			//转台or赠菜退菜, 点选菜品
			if (!obj.amountRej) {
				obj.amountRej = obj.quantity;
				obj.amountStill = 0;
			} else {
				obj.amountRej = 0;
				obj.amountStill = obj.quantity;
			}
			//表示数组中没有这个数据
			 var flag=false;
			 for(var i=0;i<this.objModal.chuiArrNew.length;i++){
				 if(this.objModal.chuiArrNew[i].id.indexOf(obj.id)!=-1){
                     flag=true;
                     this.objModal.chuiArrNew.splice(i,1);
                     break;
				 }
			 }
			 if(!flag){
                 console.log(obj);
                 var list=[];

                 if(obj.packageType==1){
                     list=obj.list;
                 }
                 var tuiArr={"id":obj.id,"remark":'','list':list,'packageType':obj.packageType,'foodName':obj.foodName,'unitName':obj.unitName,'remark':obj.remark,'quantity':obj.amountRej,'foodId':obj.foodId,'price':obj.price,'specificationsId':obj.specificationsId,'specificationsName':obj.specificationsName};
                 this.objModal.chuiArrNew.push(tuiArr);
			 }

		},
		pickModalMenuAll: function (f) {
			//转台, 全选or全不选
			this.objModal.menuList.forEach(function (n, i) {
				n.amountRej = f > 0 ? n.quantity : 0;
				n.amountStill = f > 0 ? 0 : n.quantity;
			})
			if(f==1){
                for(var i=0;i<this.objModal.menuList.length;i++){
                    var ob=this.objModal.menuList[i];
                    if(this.objModal.menuList[i].status!=-1){
                        var list=[];
                        if(ob.packageType==1){
                            list=ob.list;
                        }
                        var tuiArr={"id":ob.id,"remark":'','list':list,'packageType':ob.packageType,'foodName':ob.foodName,'unitName':ob.unitName,'remark':ob.remark,'quantity':ob.amountRej,'foodId':ob.foodId,'price':ob.price,'specificationsId':ob.specificationsId,'specificationsName':ob.specificationsName};
                        this.objModal.chuiArrNew.push(tuiArr);
                    }
                }
                if(this.objModal.chuiArrNew.length==0){
                    layerToast("暂无已上的菜可选择");
                }
			}else{
                this.objModal.chuiArrNew=[];
			}

			console.log(this.objModal.chuiArrNew);
		},
		rejAdjust: function (obj, i) {

		    //数字加减
			if (obj.amountRej + i >= 0 && obj.amountRej + i <= obj.quantity) {
				obj.amountRej = obj.amountRej + i;
				obj.amountStill = obj.quantity - obj.amountRej;
                for(var i=0;i<this.objModal.chuiArrNew.length;i++){
                	var t=this.objModal.chuiArrNew[i];
                	if(t.id==obj.id){
                        Vue.set(t, 'quantity', obj.amountRej);
                        //t.quantity=obj.amountRej;
					}
				}
			}

		},
		rejReason: function (obj) {
            this.objModal.chuiArrNew.forEach(function(n,i){
            	n.remark=obj.text;
			})
			//选择转台原因
			this.objModal.reason = this.objModal.reason === obj.id ? null : obj.id;
		},
		pickChui: function (obj) {
			//催菜or起菜, 选择菜品
			if (this.objModal.chuiArr.indexOf(obj.id) === -1) {
				this.objModal.chuiArr.push(obj.id);
				console.log(obj);
                var list=[];
                if(obj.packageType==1){
                    list=obj.list;
                }
                var chuiFood= {'id':obj.id,'list':list,'packageType':obj.packageType,'foodName':obj.foodName,'quantity':obj.quantity,'unitName':obj.unitName,'remark':obj.remark};
                this.objModal.chuiArrNew.push(chuiFood);
			} else {
				for(var i=0;i<this.objModal.chuiArrNew.length;i++){
					if(this.objModal.chuiArrNew[i].id==obj.id){
                        this.objModal.chuiArrNew.splice(i,1);
					}
				}
				this.objModal.chuiArr.splice(this.objModal.chuiArr.indexOf(obj.id), 1)
			}

		},
		pickChuiAll: function (f) {
			//催菜or起菜, 全选or全不选
			var that = this;
			that.objModal.chuiArr.splice(0, that.objModal.chuiArr.length);
            that.objModal.chuiArrNew=[];
			if (Number(f) > 0) {
				this.objModal.menuList.forEach(function (n, i) {
					that.objModal.chuiArr.push(n.id);
                    var list=[];
                    if(n.packageType==1){
                        list=n.list;
                    }
                    var chuiFood= {'id':n.id,'list':list,'packageType':n.packageType,'foodName':n.foodName,'quantity':n.quantity,'unitName':n.unitName,'remark':n.remark,};
                    that.objModal.chuiArrNew.push(chuiFood);
				})
			}
		},
		dishTrans: function () {
			//多桌点餐及转台
			console.log(this.objModal.chuiArrNew);
            console.log(this.objModal.newIdArr);

			var that = this;

            //转台
            if(that.modelStatus==1){
                var index = layerLoading();
            	for(var i=0;i<that.objModal.chuiArrNew.length;i++){
                    that.objModal.chuiArrNew[i].serverOrderId=this.orderTableJson.serverOrderId;
				}
                var data = {
                    "maroClientServerorderDO":{
                        "id":this.objModal.newIdArr[0].serverOrderId,
                    },
					"srcMaroClientServerorderDO":{
                    	"id":this.orderTableJson.serverOrderId
					},
					"srcMaroShopSeatEntity":{
                    	"id":this.orderTableJson.tableId
					},
                    "maroShopSeatEntity":{
                        "id":this.objModal.newIdArr[0].id
                    },
                    "maroClientFoodorderDOList":that.objModal.chuiArrNew
                };
            	console.log(data);

                ajaxRequest({
                    path: 'maroClientServerorderController.do?changeFoodListTo',
                    data: { 'foodOrderParamsDTOJson':JSON.stringify(data)},
                    layer: false
                }, function (data) {
                    this.pickMenu=[];
                    this.objModal=null;
                    window.localStorage.removeItem('orderTableJson');
                    window.history.go(-1)
                })
			}else if(that.modelStatus==9){
            	var foodOrderParamsDTOJson=[];
            	if(this.objModal.newIdArr.length==0){
            		layerToast("暂无已开的桌进行多桌点餐");
            		return;
				}
                var index = layerLoading();
              for(var i=0;i<this.objModal.newIdArr.length;i++){
                  var data = {
                      "maroClientServerorderDO":{
                          "id":this.objModal.newIdArr[i].serverOrderId,
                      },
                      "maroShopSeatEntity":{
                          "id":this.objModal.newIdArr[i].id,
                      },
                      "maroClientFoodorderDOList":that.objModal.chuiArrNew
                  };
                  foodOrderParamsDTOJson.push(data);
			  }
                ajaxRequest({
                    path: 'maroClientServerorderController.do?orderFoodToListSeat',
                    data: { 'foodOrderParamsDTOListJson':JSON.stringify(foodOrderParamsDTOJson)},
                    layer: false
                }, function (data) {
                    this.pickMenu=[];
                    this.objModal=null;
                    window.localStorage.removeItem('orderTableJson');
                    window.history.go(-1)
                })
			}

		},
		dishOpt: function () {
			var that = this;

            if(that.objModal.chuiArrNew.length==0){
            	if(this.objModal.type==0){
                    layerToast('无菜可退');

				}else{
                    layerToast('无菜可赠');
				}
                that.realoadData();
                that.clsModal();
				return;
			}
            
			if (this.objModal.type === 0) {
				//退菜
				ajaxRequest({
					path: 'maroClientServerorderController.do?refundFood',
					data: {"foodOrderParamsDTOJson": JSON.stringify({"maroClientFoodorderDOList":that.objModal.chuiArrNew,"maroClientServerorderDO":{"id":that.orderTableJson.serverOrderId},"maroShopSeatEntity":{"id":that.orderTableJson.tableId}})}
				}, function (data) {
                    that.realoadData();
                    that.clsModal();
					layerToast('操作成功。')
				})
			} else if (this.objModal.type === 1) {
				//赠菜
                ajaxRequest({
                    path: 'maroClientServerorderController.do?giftFood',
                    data: {"foodOrderParamsDTOJson": JSON.stringify({"maroClientFoodorderDOList":that.objModal.chuiArrNew,"maroClientServerorderDO":{"id":that.orderTableJson.serverOrderId},"maroShopSeatEntity":{"id":that.orderTableJson.tableId}})}
                }, function (data) {
                	console.log(data);
                    that.realoadData();
                    that.clsModal();
                    layerToast('操作成功。')
                })
			}
		},
		dishEdit: function () {

         //菜改价
			var that = this;
			if(that.objModal.type==0 && that.objModal.menuInfo.status!=-1){
				var reasonText="";
				if(that.objModal.reason!=null){
					for(var i=0;i<that.objModal.reasonList.length;i++){
						if(that.objModal.reason==that.objModal.reasonList[i].id){
                            reasonText=that.objModal.reasonList[i].text;
						}
					}
				}
				if(that.objModal.temporaryPrice==""||that.objModal.temporaryPrice==0){
                    layerToast('请填写真实价格。')
					return;
				}
                ajaxRequest({
                    path: 'maroClientServerorderController.do?changeFoodTempPrice',
                    data: {
                        'maroClientServerorderDO.id':that.orderTableJson.serverOrderId,
                        'maroShopSeatEntity.id':that.orderTableJson.tableId,
                        'maroClientFoodorderDO.id':that.objModal.menuInfo.id,
                        'maroClientFoodorderDO.remark':reasonText,
                        'maroClientFoodorderDO.price':that.objModal.temporaryPrice,
						'maroClientFoodorderDO.quantity':that.objModal.menuInfo.quantity,
                        'maroClientFoodorderDO.foodName':that.objModal.menuInfo.foodName
                    }
                }, function (data) {
                    that.clsModal();
                    that.realoadData();

                    layerToast('操作成功。')
                })
			}
			if(that.objModal.type==0&& that.objModal.menuInfo.status==-1){
				console.log(that.objModal);
			}if(that.objModal.type==2){
				Vue.set(that.pickMenu[that.objModal.menuIndex],'remark',that.objModal.remark);
                that.clsModal();
			}

		},
		chuiOpt: function () {

            var that=this;
			switch (Number(this.myModal)) {
				case 2:
                    ajaxRequest({
                        path: 'maroClientServerorderController.do?UrgeFood',
                        data:{ 'foodOrderParamsDTOJson': JSON.stringify(
                        	{
								"maroClientFoodorderDOList":that.objModal.chuiArrNew,
								"maroClientServerorderDO":{"id":that.orderTableJson.serverOrderId
                        	}
                        	}),
                               },
                        layer: true
                    }, function (data) {
                        //提交成功后, 重新请求一遍info
                        that.realoadData();
                        that.clsModal();
                    })


					//催菜
					break;
				case 7:
					//起菜
					break;
				case 8:
					//重打厨单
					break;
			}
		},
		pickFormatItem: function (obj, i) {
			//点选菜品规格
			if (!obj.hasOwnProperty('amountSpe')) {
				Vue.set(obj, 'amountSpe', 1);
			} else {
				Vue.delete(obj, 'amountSpe');
			}
		},
		speAdjust: function (obj, f) {
            //点选菜品加减
			obj.amountSpe = obj.amountSpe + f;
			
			if (obj.amountSpe === 0) {
				Vue.delete(obj, 'amountSpe');
			}
		},
		dishTick: function (j) {
			var that = this,
				arrStatus = ['即起','下单', '已上', '叫起', '催菜','','已上'];
			
			this.objModal.type = j;
			switch (Number(j)) {
				case 0:
					//临时改价
					break;
				case 1:
					//划菜
					//that.objModal.menuInfo.status = Number(that.objModal.menuInfo.status) === 0 ? 1 : 0;
					that.objModal.menuInfo.statusText = arrStatus[Number(that.objModal.menuInfo.status)];
					var path="maroClientServerorderController.do?finishFood";
					if(that.objModal.menuInfo.status==6){
                        path="maroClientServerorderController.do?unFinishFood"
					}
					ajaxRequest({
						path: path,
						data: {
							'maroClientServerorderDO.id':that.orderTableJson.serverOrderId,
							'maroShopSeatEntity.id':that.orderTableJson.tableId,
							'maroClientFoodorderDO.id':that.objModal.menuInfo.id,
                            'maroClientFoodorderDO.quantity':that.objModal.menuInfo.quantity,
                            'maroClientFoodorderDO.foodName':that.objModal.menuInfo.foodName

						}
					}, function (data) {
                       // that.clsModal();
						that.realoadData();

						layerToast('操作成功。')
					})
                    that.clsModal();
					break;
				case 2:
					//忌口备注
					break;
				case 3:
					//状态
					break;
				case 4:
                    var size = that.pickMap[that.objModal.menuInfo.id];
                    if(size){
                        size--;
                        that.pickMap[that.objModal.menuInfo.id] = size
                    }else{
                        that.pickMap[that.objModal.menuInfo.id] = 0;
                    }
					//移除
					that.menuAdjust(that.objModal.menuInfo, that.objModal.menuIndex, -Number(that.objModal.menuInfo.quantity));
                    console.log('this.pickMenu====',this.pickMenu);

                    console.log(this.pickMenu);
					that.pickDiscount();
                    that.reckonAmount();
					that.clsModal();

					break;
                case 5:
                    //套餐列表

                    break;
			}
		}
	}
})

window.addEventListener('beforeunload', function () {
	window.localStorage.removeItem('info');
});