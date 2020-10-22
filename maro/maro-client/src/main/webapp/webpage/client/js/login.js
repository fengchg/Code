Vue.directive('nextInput', {
	bind: function (el, binding, vnode) {
		el.addEventListener('keyup', function (ev) {
			if (ev.keyCode === 13) {
				if (binding.value !== '') {
					var nextInput = vnode.context.$refs[binding.value]
					if (nextInput && typeof nextInput.focus === 'function') {
						nextInput.focus()
					}
				} else {
					
				}
			}
		})
	}
})

new Vue({
	el: '#login',
	data: {
		'user': '',
		'pswd': '',
		'clrIdx': -1,
		'isRe': false,
        'options':[],
		'shiftCode':''
	},
	computed: {
		
	},
    created:function(){
        this.loadClasses();
	},
	methods: {
		loadClasses:function(){
			var that=this;
            ajaxRequest({
                path: 'clientUserController.do?getShift',
                data: {
                }
            }, function (data) {
                that.options=that.options.concat(data.obj);
                if(that.options.length>0){
                    that.shiftCode=that.options[0].shift_code;
				}

				console.log(that.options);
            }),function(data){

            }
		},
		clearIpt: function (i) {
			if (i === 1) {
				this.user = ''
			} else if (i === 2) {
				this.pswd = ''
			}
			
			this.clearBtnHide()
		},
		clearBtnShow: function (i) {
			if ((i === 1 && this.user !== '') || (i === 2 && this.pswd !== '')) {
				this.clrIdx = i
			} else {
				this.clrIdx = -1
			}
		},
		clearBtnHide: function () {
			this.clrIdx = -1
		},
		remember: function () {
			this.isRe = !this.isRe
		},
		submit: function () {
			var that = this;
			if (that.user.trim() === '') {
				layerToast('请输入用户名。');
			} else if (that.pswd === '') {
				layerToast('请输入密码。');
			} else {
				ajaxRequest({
					path: 'clientUserController.do?login',
					data: {
                        "user": that.user.trim(),
                        "pass": that.pswd,
						"isLogin":true,
						"shiftCode":that.shiftCode
					}
				}, function (data) {
                    console.log(data);
                    localStorage.sessionId=data.attributes.sessionId;
                    window.localStorage.setItem('user',that.user);
                    window.localStorage.setItem('pass',that.pswd);
					window.location.href = 'index.html'
				}),function(data){
						console.log(data);
				}
			}
		}
	}
})
