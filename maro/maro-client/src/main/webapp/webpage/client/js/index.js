Vue.directive('numOnly', {
	bind: function(el, binding, vnode) {
		this.handler = function() {
			el.value = parseInt(el.value.trim().replace(/[^\d]/g, ''))

			if(el.value > parseInt(el.getAttribute('max'))) {
				el.value = parseInt(el.getAttribute('max'))
			}
		};

		el.addEventListener('input', this.handler);
		el.addEventListener('paste', this.handler);
	},
	unbind: function(el, binding, vnode) {
		el.removeEventListener('input', this.handler);
		el.removeEventListener('paste', this.handler);
	}
})

/*
 * tab: 房间类型标签的角标
 * info: 房间/餐桌所有数据
 * switchIdx: 餐桌类型筛选的角标
 * switchPrp: 餐桌类型对应编号
 * switchArr: 餐桌类型数据
 * myModal: 自己写的模态窗口的编号
 * objModal: 模态窗口相关数据, 每个都不一样
 * curBook: 选中的那条预订记录
 */
new Vue({
	el: '#index',
	data: {
		//收费类型
        bbskqk:[],
		//营业情况
        bbyyqk:[],
		//应收金额
        ysje:0,
		//实收金额
        ssje:0,
        openPersonName:'',
		openTime:'',
		nowTime:'',
        consumeAmount:0,
        gatheringAmount:0,
		tab: 0,
		info: [],
		switchIdx: 0,
		switchPrp: null,
		deskIdx: null,

		switchArr: [{
				'type': '全部',
				'prop': null
			},
			{
				'type': '空闲',
				'prop': 0
			},
			{
				'type': '使用',
				'prop': 1
			},
			{
				'type': '预定',
				'prop': -1
			},
			{
				'type': '已结账',
				'prop': 2
			}
		],
		myModal: -1,
        myModalShow:false,
		objModal: null,
		curBook: null,
		usage: [{
				"usageName": "普通",
				"usageVal": 0
			},
			{
				"usageName": "婚庆",
				"usageVal": 1
			},
			{
				"usageName": "寿庆",
				"usageVal": 2
			},
			{
				"usageName": "公司活动",
				"usageVal": 3
			},
			{
				"usageName": "其他",
				"usageVal": 4
			}
		],
		waiter: []
	},
	computed: {},
	watch: {},
	created: function() {
		var that = this;
		var example = [{
			'type': '大厅',
			'id': '001',
			'list': [{
				'name': '1号桌',
				'no': '1',
				'id': '001001',
				'peopleMax': 4,
				'bookInfo': [{
					'id': '201802231115',
					'bookDate': '1522204910',
					'bookName': '张三',
					'phone': '13987654321',
					'people': 2
				}, {
					'id': '201802231125',
					'bookDate': '1522254474',
					'bookName': '李四',
					'phone': '13579246800',
					'people': 2
				}],
				'openInfo': null
			}, {
				'name': '2号桌',
				'no': '2',
				'id': '001002',
				'peopleMax': 4,
				'bookInfo': [],
				'openInfo': null
			}, {
				'name': '3号桌',
				'no': '3',
				'id': '001003',
				'peopleMax': 4,
				'bookInfo': [],
				'openInfo': {
					'id': '201802231117',
					'openDate': '1522207217',
					'people': 2,
					'amount': 24,
					'isPrepay': false,
					'isPaid': false
				}
			}, {
				'name': '4号桌',
				'no': '4',
				'id': '001004',
				'peopleMax': 4,
				'bookInfo': [{
					'id': '201802231116',
					'bookDate': '1521727825',
					'bookName': '王五',
					'phone': '13888888888',
					'people': 4
				}],
				'openInfo': {
					'id': '201802231118',
					'openDate': '1522207218',
					'people': 4,
					'amount': 100,
					'isPrepay': false,
					'isPaid': true
				}
			}, {
				'name': '5号桌',
				'no': '5',
				'id': '001005',
				'peopleMax': 6,
				'bookInfo': [{
					'id': '201803231116',
					'bookDate': '1522727825',
					'bookName': '赵六',
					'phone': '13666666666',
					'people': 3
				}],
				'openInfo': {
					'id': '201803271816',
					'openDate': '1522245873',
					'people': 3,
					'amount': 130,
					'isPrepay': true,
					'isPaid': false
				}
			}]
		}, {
			'type': '房间',
			'id': '002',
			'list': [{
				'name': '1号房',
				'no': '6',
				'id': '002001',
				'peopleMax': 12,
				'bookInfo': [],
				'openInfo': null
			}]
		}];

		ajaxRequest({
			path: 'maroClientServerorderController.do?listSeat',
			data: {}
		}, function(data) {
			console.log(data);
			that.handleData(data.obj)
			setInterval(function() {
				that.loadDataBySetTime();
			}, 30000)
		}, function(data) {});
		ajaxRequest({
			path: 'clientUserController.do?tsUserList',
			data: {}
		}, function(data) {

			that.waiter = data.obj;
		}, function(data) {

		});
	},
	mounted: function() {
		var that = this;
		$('#datetime').mdatetimer({
			mode: 2,
			nowbtn: false,
			onOk: function() {
				that.objModal.bookDate = $('#datetime').val()
			}
		})
	},
	methods: {
		tabDeskType: function(i) {
			if(this.tab !== i) this.tab = i;
		},
		loadSeatList: function() {
			var that = this;
			ajaxRequest({
				path: 'maroClientServerorderController.do?listSeat',
				data: {}
			}, function(data) {
				console.log(data.obj)
				that.handleData(data.obj)
			}, function(data) {

			})
		},
		loadDataBySetTime: function() {
			console.log(11111111111111111);
			var that = this;
			ajaxRequest({
				path: 'maroClientServerorderController.do?listSeat',
				data: {},
				layer: false
			}, function(data) {
				console.log(data.obj)
				that.handleData(data.obj)
			}, function(data) {

			})
		},
		getHrsMin: function(seconds) {
			var sa = [
				parseInt(seconds / 60 / 60),
				parseInt(seconds / 60 % 60),
				parseInt(seconds % 60)
			];

			if(sa[0] == 0) {
				return sa[1] == 0 ? '刚刚' : sa[1] + '分';
			} else if(sa[0] < 6) {
				return sa[0] + '时' + sa[1] + '分';
			} else {
				return '>6时'
			}
		},
		getFullDate: function(timestamp) {
			var ts = (timestamp + '').length === 10 ? parseInt(timestamp) * 1000 : parseInt(timestamp),
				date = new Date(ts);

			var yr = date.getFullYear();
			mh = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1),
				dt = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()),
				hr = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()),
				mn = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()),
				sc = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
			return {
				fen: yr + '-' + mh + '-' + dt + ' ' + hr + ':' + mn
			};
		},
		getTimeStamp: function() {
			return Date.parse(new Date());
		},
		handleData: function(data) {
			//处理数据
			var that = this,
				nowStamp = Date.parse(new Date()),
				halfHour = 1800000,
				expireHour = 21600;
			console.log(data);
			var arr = [];
			data.forEach(function(n, i) {
				arr = arr.concat(n.list);
				n.list.forEach(function(o, j) {

					//-1预定, 0为空闲, 1为使用中, 2为已结账
					if(o.maroClientSeatchangeVO) {

						switch(o.maroClientSeatchangeVO.type) {
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
						if(o.maroClientSeatchangeVO.maroClientServerorderVO.status == 2) {
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
					if(o.status != 1 && o.status != 2) {
						//表示有预订记录
						if(o.maroClientReserveVOList.length > 0) {
							console.log(o.maroClientReserveVOList);
							//Vue.set(o, 'status', -1);
							//当前时间在预约时间前后半小时内, 显示为预约状态, 否则都为空闲状态
							for(var i = 0; i < o.maroClientReserveVOList.length; i++) {

								if(Math.abs(Number(o.maroClientReserveVOList[i].periodStartTime)) < nowStamp && Math.abs(Number(o.maroClientReserveVOList[i].periodEndTime)) > nowStamp) {
									Vue.set(o, 'status', -1);
									break;
								} else {
									Vue.set(o, 'status', 0);
								}
							}

						}
					}

				})
			})
			data.unshift({
				"type": 0,
				"list": arr,
				"typeString": "全部"
			})
			console.log(arr);
			that.info = data;
		},
		filterDesk: function(n, i) {
			//按类型过滤餐桌
			this.switchIdx = i;
			this.switchPrp = n.prop;
		},
		lenSwitch: function(f) {
			//返回某类型餐桌的数组
			return this.info.length && this.info[this.tab].list.filter(function(m) {
				return f !== null ? m.status === f : true
			})
		},
		openDeskModal: function() {

			var obj = "";
			for(var i = 0; i < this.info.length; i++) {
				for(var j = 0; j < this.info[i].list.length; j++) {
					var o = this.info[i].list[j];
					if(o.flag == this.deskIdx) {
						obj = o;
						break;
					}
				}
			}
			console.log(obj);
			this.alarm(obj);
			//输入餐桌编号直接弹出按钮框, 待开发
		},
		openMenu: function(m) {
			var that = this;
			window.localStorage.setItem('orderTableJson', JSON.stringify(m));
			//window.localStorage.setItem('info', JSON.stringify(that.info));
			window.location.href = 'menu.html';
		},
		//
		alarm: function(m) {
			console.log(m)
			//点击桌子弹出 的按钮框
			var that = this;
			switch(m.status) {
				case 0:
					var buttons = {
						cancel: false,
						confirm: false,
						openTable: {
							text: '餐桌开台',
							value: '0'
						},
						//							reversePay: {text: '反结账', value: '1'},
						bookTable: {
							text: '预定此桌',
							value: '2'
						},
						bookHistory: {
							text: '预定记录',
							value: '3'
						}
					}
					if(m.maroClientReserveVOList.length > 0) {
						buttons.reversePay = {
							text: '取消预定',
							value: '4'
						};
					}

					//空闲
					swal({
							title: m.name + ' 操作',
							buttons: buttons
						})
						.then(function(v) {
							switch(parseInt(v)) {
								case 0:
									that.openModal(0, m);
									break;
								case 1:
									break;
								case 2:
									that.openModal(1, m);
									break;
								case 3:
									that.openModal(2, m);
									break;
								case 4:
									that.openModal(6, m);
									break;
							}
						})
					break;
				case 1:
					var jsonBtn = {
						cancel: false,
						confirm: false,
						orderMeal: {
							text: '点餐',
							value: '0'
						},
						changeDesk: {
							text: '换桌',
							value: '1'
						},
						mergeDesk: {
							text: '并桌',
							value: '2'
						},
						//						prePay: {text: '预结账', value: '3'},
						bookHistory: {
							text: '预定记录',
							value: '4'
						},
						//						reversePay: {text: '反结账', value: '5'},
						orderPay: {
							text: '收银结账',
							value: '6'
						},

					};
					if(m.maroClientSeatchangeVO) {
						if(m.maroClientSeatchangeVO.groupString != null && m.maroClientSeatchangeVO.groupLead == false) {
							//并桌的不能换桌
							delete jsonBtn.mergeDesk;
							delete jsonBtn.changeDesk;
							jsonBtn.cancelMergeDesk = {
								text: '取消并桌',
								value: '7'
							};
						}
						if(m.maroClientSeatchangeVO.groupString != null && m.maroClientSeatchangeVO.groupLead == true) {
							delete jsonBtn.mergeDesk;
							delete jsonBtn.changeDesk;
							//jsonBtn.cancelMergeDesk={text: '取消并桌', value: '7'};
						}
					}

					//只有订单的金额为0时才显示取消订单。
					if(m.maroClientSeatchangeVO.maroClientServerorderVO.amount == 0) {
						delete jsonBtn.orderPay;
						jsonBtn.orderCancel = {
							text: '取消订单',
							value: '-1'
						};
					}
					swal({
							title: m.name + ' 操作',
							buttons: jsonBtn
						})
						.then(function(v) {
							switch(parseInt(v)) {
								case 0:

									var num = 0;
									var waiterId, remark;
									if(m.maroClientSeatchangeVO.length == 0) {
										num = m.number;
									} else {
										num = m.maroClientSeatchangeVO.maroClientServerorderVO.personNumber;
										waiterId = m.maroClientSeatchangeVO.maroClientServerorderVO.waiterId;
										remark = m.maroClientSeatchangeVO.maroClientServerorderVO.remark;
									}
									var orderTableJson = {
										serverOrderId: m.maroClientSeatchangeVO.serverOrderId,
										destSeatName: m.name,
										tableId: m.id,
										personNumber: num,
										waiterId: waiterId,
										remark: remark
									}

									that.openMenu(orderTableJson);
									break;
								case 1:
									//换桌
									that.openModal(3, m);
									break;
								case 2:
									that.openModal(4, m);
									break;
								case 3:
									if(!m.openInfo.isPrepay) that.prepay(m);
									break;
								case 4:
									that.openModal(2, m);
									break;
								case 5:
									break;
								case 6:
									var num = 0;
									var waiterId, remark;
									if(m.maroClientSeatchangeVO.length == 0) {
										num = m.number;
									} else {
										num = m.maroClientSeatchangeVO.maroClientServerorderVO.personNumber;
										waiterId = m.maroClientSeatchangeVO.maroClientServerorderVO.waiterId;
										remark = m.maroClientSeatchangeVO.maroClientServerorderVO.remark;
									}
									var orderTableJson = {
										serverOrderId: m.maroClientSeatchangeVO.serverOrderId,
										destSeatName: m.name,
										tableId: m.id,
										personNumber: num,
										waiterId: waiterId,
										remark: remark
									}
									window.localStorage.setItem('orderTableJson', JSON.stringify(orderTableJson));
									window.location.href = 'pay.html';
									break;
								case 7:
									//取消并桌
									that.cancelMergeSeat(m);
									//that.openModal(7, m);
									break;
								case -1:
									that.openModal(5, m);
									break;
							}
						})
					break;
				case 2:
					//已结账
					swal({
							title: m.name + ' 操作',
							buttons: {
								cancel: false,
								confirm: false,
								clearTable: {
									text: '清台',
									value: '0'
								},
								orderMeal: {
									text: '点餐',
									value: '1'
								},
							}
						})
						.then(function(v) {
							switch(parseInt(v)) {
								case 0:
									ajaxRequest({
										path: 'maroClientServerorderController.do?clear',
										data: {
											'serverorderId': m.maroClientSeatchangeVO.serverOrderId

										},
										layer: false
									}, function(data) {
										that.loadSeatList();
									})
									break;
								case 1:
									var num = 0;
									var waiterId, remark;
									if(m.maroClientSeatchangeVO.length == 0) {
										num = m.number;
									} else {
										num = m.maroClientSeatchangeVO.maroClientServerorderVO.personNumber;
										waiterId = m.maroClientSeatchangeVO.maroClientServerorderVO.waiterId;
										remark = m.maroClientSeatchangeVO.maroClientServerorderVO.remark;
									}
									var orderTableJson = {
										serverOrderId: m.maroClientSeatchangeVO.serverOrderId,
										destSeatName: m.name,
										tableId: m.id,
										personNumber: num,
										waiterId: waiterId,
										remark: remark
									}

									that.openMenu(orderTableJson);
									break;
							}
						})
					break;
				case -1:
					//预定
					swal({
							title: m.name + ' 操作',
							buttons: {
								cancel: false,
								confirm: false,
								openTable: {
									text: '预定开台',
									value: '0'
								},
								reversePay: {
									text: '取消预定',
									value: '1'
								},
								//bookTable: {text: '反结账', value: '2'},
								bookHistory: {
									text: '预定记录',
									value: '3'
								}
							}
						})
						.then(function(v) {
							switch(parseInt(v)) {
								case 0:
									that.openModal(0, m);
									break;
								case 1:

									that.openModal(6, m);
									break;
								case 2:
									break;
								case 3:
									that.openModal(2, m);
									break;
							}
						})
					break;
			}
		},
		//取消并桌
		cancelMergeSeat: function(m) {
			var that = this;
			ajaxRequest({
				path: 'maroClientServerorderController.do?cancelMergeSeat',
				data: {
					'maroClientServerorderDO.id': m.maroClientSeatchangeVO.serverOrderId,
					'mergeMaroShopSeatEntity.id': m.id

				},
				layer: true
			}, function(data) {
				console.log(data);
				//提交成功后, 重新请求一遍info
				that.loadSeatList();
				that.clsModal();
			})
		},
		openModal: function(i, obj) {
			//打开自己写的模态框
			this.myModal = i;
			switch(i) {
				case 0:
					var reserveId = "";
					if(obj.status == -1) {
						if(obj.maroClientReserveVOList.length > 0) {
							reserveId = obj.maroClientReserveVOList[0].id;
						}
					}
					//餐桌开台
					this.objModal = {
						name: obj.name,
						id: obj.id,
						people: obj.number,
						reserveId: reserveId,
						waiter: this.waiter,
						ownWaiter: this.waiter[0].id,
						remark: '',
						after: 1
					};
					break;
				case 1:
					//预定就餐
					this.objModal = {
						name: obj.name,
						id: obj.id,
						number: obj.number,
						people: obj.number,
						bookDate: this.getNowDate(),
						phone: '',
						bookName: '',
						usage: '',
						remark: '',
						deposit: '',
						period: -1,
						obj: obj

					};
					break;
				case 2:
					//查看预订记录
					this.objModal = {
						name: obj.name,
						id: obj.id,
						bookInfo: obj.maroClientReserveVOList,
						status: obj.status
					};
					break;
				case 3:
					//3换桌
					this.objModal = {
						oldId: obj.id,
						newId: null,
						type: i,
						obj: obj,
						stuts: 1
					};
					break;
				case 4:
					//4并桌
					this.objModal = {
						oldId: obj.id,
						oldOrderId: obj.maroClientSeatchangeVO.serverOrderId,
						newId: [],
						type: i,
						obj: obj,
						stuts: 2,
						newIdArr: []
					};
					break;
				case 5:
					//取消订单
					console.log(obj)
					this.objModal = {
						name: obj.name,
						//订单号
						id: obj.maroClientSeatchangeVO.serverOrderId,
						reason: ''
					};
					break;
				case 6:
					console.log(obj)
					//取消预订
					this.objModal = {
						name: obj.name,
						id: obj.id,
						bookInfo: obj.maroClientReserveVOList,
						status: obj.status
					};
					console.log(obj)
					break;
				case 7:
					//取消并桌
					this.objModal = {
						name: obj.name,
						//预订的id
						reserveId: obj.maroClientReserveVOList.id,
						reason: ''
					};
					break;
				case -2:
					//退出登录
					this.objModal = {
						name: '退出登录'
					};
					break;
                case -3:

                    //交班
                    this.objModal = {
                        name: '交班'
                    };
					this.loadShiftData();
                    break;
			}
		},
		//获取交班信息
		loadShiftData:function(){
			var that=this;
            ajaxRequest({
                path: 'clientUserController.do?getShiftInfo',
                data: {},
                layer: false
            }, function(data) {
                that.bbskqk=data.obj.bbskqk;
                that.bbyyqk=data.obj.bbyyqk;
                that.openPersonName=data.obj.name;
                that.openTime=timestampToTime(data.obj.loginTime);
				that.nowTime=timestampToTime(data.obj.nowTime);
				that.ysje=data.obj.ysje;
                that.ssje=data.obj.ssje;
                //收费总数
                var consumeAmount=0;
                //收款金额总数
                var gatheringAmount=0;
                for(var i=0;i<data.obj.bbskqk.length;i++){
                    consumeAmount=consumeAmount+data.obj.bbskqk[i].num;
                    gatheringAmount=gatheringAmount+data.obj.bbskqk[i].amountpart;
				}
				that.consumeAmount=consumeAmount;
                that.gatheringAmount=gatheringAmount;
				console.log(data);
            }, function(data) {

                layerToast(data.msg, 3);
            })
		},
		//交班并退出
        shiftAndBack:function(){
            var that=this;
            addConfirm({
                content: '确定交班嘛？',
                yes: function(i){
                    layerRemove(i);
                    ajaxRequest({
                        path: 'clientUserController.do?confirmShift',
                        data: {},
                        layer: true
                    }, function(data) {
                        layerToast('交班成功', 3);
						setTimeout(function(){
                            window.localStorage.removeItem('user');
                            window.localStorage.removeItem('pass');
                            window.location.href = 'login.html';
						},3000)
                    }, function(data) {
                        layerToast(data.msg, 3);
                    })
                }
            });



		},
		clsModal: function() {
			//关闭自己写的模态框
			this.myModal = -1;
			this.objModal = null;
			this.curBook = null;
			$('#datetime').val('');
		},
		openDesk: function() {
			//开台

			var that = this;

			var waiterName = ""
			for(var i = 0; i < that.objModal.waiter.length; i++) {
				if(that.objModal.waiter[i].id == that.objModal.ownWaiter) {
					waiterName = that.objModal.waiter[i].realName;
					break;
				}
			}
			ajaxRequest({
				path: 'maroClientServerorderController.do?open',
				data: {
					'maroClientServerorderDO.seatId': that.objModal.id,
					'maroClientServerorderDO.personNumber': that.objModal.people,
					'maroClientServerorderDO.reserveId': that.objModal.reserveId,
					'maroClientServerorderDO.remark': that.objModal.remark,
					'maroClientServerorderDO.waiterId': that.objModal.ownWaiter,
					'maroClientServerorderDO.waiterName': waiterName

				},
				layer: false
			}, function(data) {
				console.log(data);
				//alert(data.obj.id);
				//alert(data.obj.seatName);
				//alert(data.obj.seatId);
				//alert(data.obj.personNumber);

				//return;
				//return;
				//alert(2234543);
				//return;
				if(that.objModal.after) {
					//开台后点餐
					var orderTableJson = {
						serverOrderId: data.obj.id,
						destSeatName: data.obj.seatName,
						tableId: data.obj.seatId,
						personNumber: data.obj.personNumber,
						waiterId: data.obj.waiterId,
						remark: data.obj.remark

					};
					//alert("destSeatName"+data.seatName);
					//alert("personNumber"+data.personNumber);

					that.openMenu(orderTableJson);
					return;
				}

				that.loadSeatList();
				that.clsModal();
			}, function(data) {
				that.loadDataBySetTime()
				that.clsModal();
				layerToast(data.msg, 3);
			})
		},
		callMdatetimer: function() {
			//弹出日期选择插件
			$('#datetime').click();
		},
		pickBookHistory: function(obj) {
			//点选预定记录后存到vue
			this.curBook = obj;
		},
		bookDesk: function() {
			var that = this,
				ar = this.info[this.tab].list;

			if(that.objModal.people === '') {
				layerToast('就餐人数必填。');
				return;
			} else if(Number(that.objModal.people) <= 0) {
				layerToast('就餐人数填写不正确。');
				return;
			} else if(that.objModal.bookDate === '') {
				layerToast('预定日期必填。');
				return;
			} else if(that.objModal.phone === '') {
				layerToast('顾客手机必填。');
				return;
			} else if(!isPhoneNumber(that.objModal.phone)) {
				layerToast('顾客手机格式有误。');
				return;
			} else if(that.objModal.period == -1) {
				layerToast('请选择预订时段。');
				return;
			} else if(that.objModal.deposit < 0) {
				layerToast('预订金额必须大于等于0。');
				return;
			}
			/*else if(typeof that.objModal.deposit!='number'){
			                layerToast('预订金额必须为数字');
			                return;
			            }*/
			//判断当前选择的日期是否有预定记录。
			var flag = true;
			if(that.objModal.obj.maroClientReserveVOList.length > 0) {
				for(var i = 0; i < that.objModal.obj.maroClientReserveVOList.length; i++) {
					var maroClientVO = that.objModal.obj.maroClientReserveVOList[i];
					//表示预定列表中有当前选择的时间的预定记录。
					var thatTime = that.objModal.bookDate.substring(0, 10);
					if(maroClientVO.reserveTimeString == thatTime && that.objModal.period == maroClientVO.period) {
						flag = false;
						break;
					}
				}
			}
			if(new Date(that.objModal.bookDate).getTime() < new Date().getTime()) {
				layerToast('预定时间不能小于当前时间');
				return;
			}
			if(!flag) {
				layerToast('此时间段您不能预定，因为这桌此时间段已有预定记录！');
				return;
			}

			/*for (var r = 0; r < ar.length; r++) {
				if (ar[r].id === that.objModal.id) {
					that.objModal.bookDate = new Date(that.objModal.bookDate).getTime();
					ar[r].bookInfo.push(that.objModal);
					break;
				}
			}*/

			ajaxRequest({
				path: 'maroClientReserveControllerImpl.do?reserve',
				data: {
					//餐桌id
					'seatId': that.objModal.id,
					//预订时间
					'date': new Date(that.objModal.bookDate).getTime(),
					'planComeTime': new Date(that.objModal.bookDate).getTime(),
					//预订人数
					'total': Number(that.objModal.people),
					//预订电话
					'phone': that.objModal.phone,
					//预订人名
					'name': that.objModal.bookName,
					//用途
					'purpose': that.objModal.usage,
					//定金
					'deposit': Number(that.objModal.deposit),
					//备注
					'remarks': that.objModal.remark,
					'period': that.objModal.period
					//'reserveParamsDTO.period':
				},
				layer: true
			}, function(data) {
				layerToast('预订成功。', 3);
				//重新加载餐桌数据。
				that.loadSeatList();
				that.curBook = null;
				that.clsModal();
			}, function(data) {
				that.clsModal();
				that.loadDataBySetTime();
				layerToast(data.msg, 3);
			})
		},
		bookOpenDesk: function() {
			//点击一条预定记录后开台
			var that = this;

			//if (that.objModal.status !== 0) {
			//layerToast('开桌失败，该桌已被占用。', 3);
			//that.clsModal();
			//} else if(that.curBook!=null) {
			if(that.curBook != null) {
				//console.log(that.curBook);
				ajaxRequest({
					path: 'maroClientServerorderController.do?open',
					data: {
						'maroClientServerorderDO.seatId': that.objModal.id,
						'maroClientServerorderDO.personNumber': that.curBook.personNumber,
						'maroClientServerorderDO.reserveId': that.curBook.id,
						'maroClientServerorderDO.remark': that.curBook.content,
						'maroClientServerorderDO.waiterId': '',
						'maroClientServerorderDO.waiterName': ''
					},
					layer: false
				}, function(data) {
					var orderTableJson = {
						serverOrderId: data.obj.id,
						destSeatName: data.obj.seatName,
						tableId: data.obj.seatId,
						personNumber: data.obj.personNumber

					}
					//alert(data.seatName)
					that.openMenu(orderTableJson);
					that.clsModal();
				}, function(data) {
					that.loadDataBySetTime();
					that.clsModal();
					layerToast(data.msg, 3);
				})
			} else {
				layerToast('请选中某一条预订记录！', 3);
				that.clsModal();
			}
		},
		pickDesk: function(obj) {
			var b = 0;
			if(this.myModal === 3) {
				this.objModal.newId = obj.id;
			} else if(this.myModal === 4) {

				if(this.objModal.newId.indexOf(obj.id) === -1) {
					this.objModal.newId.push(obj.id);
					var orderId = "";
					//排除主桌
					if(obj.id != this.objModal.oldId) {
						if(obj.maroClientSeatchangeVO) {
							orderId = obj.maroClientSeatchangeVO.serverOrderId;
						}
						var newId = {
							'maroClientServerorderDO': {
								'id': orderId
							},
							'mergeMaroShopSeatEntity': {
								'id': obj.id
							}
						};
						this.objModal.newIdArr.push(newId)
					}
				} else {
					for(var i = 0; i < this.objModal.newIdArr.length; i++) {
						if(this.objModal.newIdArr[i].mergeMaroShopSeatEntity.id == obj.id) {
							this.objModal.newIdArr.splice(i, 1);
						}
					}
					//this.objModal.newIdArr.splice(this.objModal.newIdArr(obj.id), 1);
					this.objModal.newId.splice(this.objModal.newId.indexOf(obj.id), 1);
				}
				console.log(this.objModal.newIdArr);
			}
		},
		optDesk: function() {

			//提交换桌or并桌数据

			var that = this;
			//that.objModal.stuts为1时表示换桌，2表示并桌
			if(that.objModal.stuts == 1) {
				ajaxRequest({
					path: 'maroClientServerorderController.do?changeSeat',
					data: {
						'maroClientServerorderDO.id': that.objModal.obj.maroClientSeatchangeVO.serverOrderId,
						'srcMaroShopSeatEntity.id': that.objModal.oldId,
						'destMaroShopSeatEntity.id': that.objModal.newId
					},
					layer: true
				}, function(data) {
					//提交成功后, 重新请求一遍info
					that.loadSeatList();
					that.clsModal();
				}, function(data) {
					that.clsModal();
					that.loadDataBySetTime();
					layerToast(data.msg, 3);
				})
			} else {

				var newOwnerId = {
					'maroClientServerorderDO': {
						'id': this.objModal.oldOrderId
					},
					'mergeMaroShopSeatEntity': {
						'id': this.objModal.oldId
					}
				};
				//最后把主桌加到数组的最前面。
				this.objModal.newIdArr.unshift(newOwnerId);
				console.log(that.objModal.newIdArr);
				ajaxRequest({
					path: 'maroClientServerorderController.do?mergeListSeat',
					data: {
						'mergeListSeatJson': JSON.stringify(that.objModal.newIdArr)
					},
					layer: true
				}, function(data) {
					//提交成功后, 重新请求一遍info
					that.loadSeatList();
					that.clsModal();
				}, function(data) {
					that.clsModal();
					that.loadDataBySetTime();
					layerToast(data.msg, 3);
				})
			}

		},
		prepay: function(obj) {
			//预结账
			var that = this;
			ajaxRequest({
				path: 'http://jsonplaceholder.typicode.com/posts',
				data: {
					date: that.getTimeStamp(),
					id: obj.id,
					orderId: obj.openInfo.id
				},
				layer: true
			}, function(data) {
				//提交成功后, 重新请求一遍info
				obj.openInfo.isPrepay = true;

				that.clsModal();
			})
		},
		cancelOrder: function() {
			var that = this;

			if(that.myModal === 5) {
				//取消订单
				ajaxRequest({
					path: 'maroClientServerorderController.do?cancel',
					data: {
						reason: that.objModal.reason,
						serverorderId: that.objModal.id
					},
					layer: true
				}, function(data) {
					/*var ar = that.info[that.tab].list;
					console.log(ar);
					for (var r = 0; r < ar.length; r++) {
						if (ar[r].id === that.objModal.id) {
							ar[r].openInfo = null;
							ar[r].status = ar[r].bookInfo.length && Math.abs(Number(ar[r].bookInfo[0].bookDate) - Date.parse(new Date())/1000) < 1800 ? -1 : 0;
						}
					}*/
					that.loadSeatList();
					that.clsModal();
				})
			} else if(that.myModal === 6) {

				//取消预定
				ajaxRequest({
					path: 'maroClientReserveControllerImpl.do?cancelReserve',
					data: {
						reserveId: this.curBook.id,
					},
					layer: true
				}, function(data) {
					/*var ar = that.info[that.tab].list;
					console.log(ar);
					for (var r = 0; r < ar.length; r++) {
					    if (ar[r].id === that.objModal.id) {
					        ar[r].openInfo = null;
					        ar[r].status = ar[r].bookInfo.length && Math.abs(Number(ar[r].bookInfo[0].bookDate) - Date.parse(new Date())/1000) < 1800 ? -1 : 0;
					    }
					}*/
					that.loadSeatList();
					that.clsModal();
				})
				//取消预定
			}
		},
		getNowDate: function() {
			var date = new Date();
			var seperator1 = "-";
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var strDate = date.getDate();
			var hours = date.getHours();
			var minuts = date.getMinutes();
			if(month >= 1 && month <= 9) {
				month = "0" + month;
			}
			if(strDate >= 0 && strDate <= 9) {
				strDate = "0" + strDate;
			}
			if(hours >= 0 && hours <= 9) {
				hours = "0" + hours;
			}
			if(minuts >= 0 && minuts <= 9) {
				minuts = "0" + minuts;
			}
			var currentdate = year + seperator1 + month + seperator1 + strDate + " " + hours + ":" + minuts;
			return currentdate;
		},
		exit: function () {
            window.localStorage.removeItem('user');
            window.localStorage.removeItem('pass');
            window.location.href = 'login.html'
		}
	}
})