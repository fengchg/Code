BMSApp.ns('BMSApp.pages');
BMSApp.pages.UserInfoController = function () {
    this.userInfoFunc = Template7.compile($$("#userInfoTemplate").html());
//    this.userInfoBtnFunc = Template7.compile($$("#userInfoBtnTemplate").html());
};
BMSApp.pages.UserInfoController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.UserInfoController.prototype.pageInit = function (page) {
    var self = this;
    var isNewCategory = $$.parseUrlQuery(page.url);
	var data = page.query;
    if (isNewCategory.newCategory == "true") {
    	var context = {id:0,userName:'',realName:'',age:'',gender:'',email:'',address:'',code:'',remark:'',phoneNumber:''};
		var html = self.userInfoFunc(context);
    	$$('#id_userInfoPanel').html(html);
    }else{
		$$.getJSON("lms/phoneAction!viewUser.action",{"user.id":data.id},function(json){
			var html = self.userInfoFunc(json.data);
			$$('#id_userInfoPanel').html(html);
			
			var status = json.data.status;
			if(status == 0){//正常
				json.data.action = "lms/phoneAction!disEnableUser.action";
				json.data.btnName="停用";
			}else{ //禁用
				json.data.action = "lms/phoneAction!enableUser.action";
				json.data.btnName="启用";
			}
			var btn_disEna = $$("#id_disEnaUserBtn");
			btn_disEna.attr("action",json.data.action);
			btn_disEna.text(json.data.btnName);
//			$$('#id_userInfoBtnPanel').html(self.userInfoBtnFunc(json.data));
		});
		$$("#id_userAddBtn").on("click",function(){
			var form = $$("#id_userInfoForm");
			var paramArray = form.serializeArray();
			$$.post("lms/phoneAction!addUser.action",paramArray,function(json){
				var html = self.userInfoFunc(json.data);
				$$('#id_userInfoPanel').html(html);
			});
		});
		$$("#id_deleteUserBtn").on("click",function(){
			cb.confirm('确定要删除该用户吗？', '提示信息', function () {
				$$.getJSON("lms/phoneAction!deleteUser.action",{"userId":data.id},function(json){
					 if (json.code != 200) {
		                    myApp.toast(json.data.tip, 'error').show(true);
		                    return;
		                }
		                myApp.toast(json.data.tip, 'success').show(true);
		                myApp.mainView.router.back({ url: '../userList.html'});
				});
			 });
		});

		$$("#id_disEnaUserBtn").on("click",function(){
			var action = $$(this).attr("action") + '';
			var text = $$(this).text();
			cb.confirm('确定要'+text+'该用户吗？', '提示信息', function () {
				$$.getJSON(action,{"user.id":data.id},function(json){
					 if (json.code != 200) {
		                    myApp.toast(json.data.tip, 'error').show(true);
		                    return;
		                }
		                myApp.toast(json.data.tip, 'success').show(true);
		                myApp.mainView.router.back({ url: '../userList.html'});
				});
			 });
		});
    }
};