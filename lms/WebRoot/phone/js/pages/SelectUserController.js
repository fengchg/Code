BMSApp.ns('BMSApp.pages');
BMSApp.pages.SelectUserController = function () {
    //this.bookListFunc = Template7.compile($$("#BookListTemplate").html());
};
BMSApp.pages.SelectUserController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.SelectUserController.prototype.pageInit = function (page) {
    var self = this, indexCount = 0, value = new Array(), name = new Array();
    //注册事件
    $$('div[data-page="selectUserPage"] .selectUser-Container').find('li').on('click', function () {
            value.push($$(this).attr('data-value'));
            name.push($$(this).attr('data-name'));

        var backData = {
            container: page.query.container,
            value: value,
            name: name.join().replace(/,/g, ' ')
        };

        var pageVewList = $$(myApp.mainView.pagesContainer).find('.page');
        $$(myApp.mainView.pagesContainer).find('.page')[pageVewList.length - 1].f7PageData.query = backData;
        myApp.mainView.router.back({
            query: backData
        });
    });
};
