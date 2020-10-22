BMSApp.ns('BMSApp.pages');
BMSApp.pages.UserListController = function () { };
BMSApp.pages.UserListController.prototype.preprocess = function (content, url, next) {
    next(content);
};
BMSApp.pages.UserListController.prototype.pageInit = function (page) {
    var self = this;

    $$(document).on('pageAfterBack', '.page[data-page="userListPage"]', function (e) {
        self.loadData();
    });
    self.loadData();
};
BMSApp.pages.UserListController.prototype.loadData = function () {
	var self = this;
	$$.getJSON("lms/phoneAction!query.action",{},function(data){
		if (data.code != 200) {
            myApp.toast('获取用户列表失败', 'error').show(true);
            return;
        }
		
		var template = $$('#template').html();
		 
		// compile it with Template7
		var compiledTemplate = Template7.compile(template);
		 
		// Now we may render our compiled template by passing required context
		var context = data.data;
		var html = compiledTemplate(context);
		
        $$('.page[data-page="userListPage"] .contactsListPage-container').html(html);
        
        //查看
        $$('.usersList').find('.addressList').on('click', function (e) {
            var aid = $$(this).attr('data-id');
            var categoryDetail = {};
            for (var i = 0; i < data.data.users.length; i++) {
                if (data.data.users[i].id == aid)
                    categoryDetail = data.data.users[i];
            }
            myApp.mainView.router.loadPage({
                url: 'pages/userInfo.html?newCategory=false',query:categoryDetail
            });
        });
	});
};