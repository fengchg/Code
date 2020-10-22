BMSApp.ns('BMSApp.pages');
BMSApp.pages.CategoryListController = function () {
    this.categoryListFunc = Template7.compile($$("#CategoryListTemplate").html());
};
BMSApp.pages.CategoryListController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.CategoryListController.prototype.pageInit = function (page) {
    var self = this;

    $$(document).on('pageAfterBack', '.page[data-page="categoryNewPage"]', function (e) {
        self.loadData();
    });
    self.loadData();
};
BMSApp.pages.CategoryListController.prototype.loadData = function () {
	var self = this;
    //加载图书类型列表
    cb.rest.getJSON("lms/phoneAction!queryBookType.action", function (data) {
        if (data.code != 200) {
            myApp.toast('获取图书类型列表失败', 'error').show(true);
            return;
        }
        
        var types = data.data.types;
        
        for(var i=0;i<types.length;i++){
        	var row = types[i];
        	row.colorId = row.id % 4;
        	row.imgName = row.name.substr(0,1);
        }
        
        $$('#categoryList').html(self.categoryListFunc(data.data));

        //查看
        $$('#categoryList .last-icon').find('.view-category').on('click', function (e) {
            var aid = $$(this).attr('data-id');
            var categoryDetail = {};
            for (var i = 0; i < data.data.types.length; i++) {
                if (data.data.types[i].id == aid)
                    categoryDetail = data.data.types[i];
            }
            myApp.mainView.router.loadPage({
                url: 'pages/categoryNew.html?newCategory=false', query: categoryDetail
            });
        });
    });
};
