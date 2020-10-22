BMSApp.ns('BMSApp.pages');
BMSApp.pages.BorrowBookController = function () {
    //this.bookListFunc = Template7.compile($$("#BookListTemplate").html());
};
BMSApp.pages.BorrowBookController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.BorrowBookController.prototype.pageInit = function (page) {
    var self = this;
    if (!$$('div[data-page="borrowBookPage"] #picker-dependent').val()) {
        $$('div[data-page="borrowBookPage"] #borrow-btn').addClass("disabled");
    }
    $$('#picker-dependent').on('change', function () {
        if ($$('div[data-page="borrowBookPage"] #picker-dependent').val()) {
            $$('div[data-page="borrowBookPage"] #borrow-btn').removeClass("disabled");
        }
    });
    //获取地址信息
    $$('#picker-dependent').on('click', function (e) {
        myApp.mainView.router.loadPage({
            url: 'pages/selectUser.html',
            query: {
                //backOnSelect: false,
                //pageTitle: "选择地址",
                //fieldValue: 'id',
                //fieldName: 'shortName',
                //serverUrl: ['ma/BaseData/getProvincesWithWordGroup', 'ma/BaseData/getCitysFromProvince', 'ma/BaseData/getDistrictFromCity'],
                container: $$('#picker-dependent')
            }
        });
    });
    //监听基础信息页面返动作并执行相应逻辑
    $$(document).on('pageAfterBack', '.page[data-page="selectUserPage"]', function (e) {
        var page = e.detail.page;
        if (page.query) {
            page.query.container.data('value', page.query.value).val(page.query.name).trigger('change'); 
        }
    });
    $$('div[data-page="borrowBookPage"] #borrow-btn').on('click', function () {
        //var id = page.query.id;
        //if (!id) return;
        cb.confirm('确定将图书借出吗？', '提示信息', function () {
            //cb.rest.postData('', { }, function (data) {
            //    if (data.code != 200) {
            //        myApp.toast(data.message, 'error').show(true);
            //        return;
            //    }
            //    myApp.toast('图书借阅成功！', 'success').show(true);
            //    myApp.mainView.router.back({ url: 'pages/borrowList.html', force: true });
            //});
            myApp.toast('图书借阅成功！', 'success').show(true);
            myApp.mainView.router.back({ url: 'pages/borrowList.html', force: true });
        });
    });
};
