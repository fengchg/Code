BMSApp.ns('BMSApp.pages');
BMSApp.pages.BookListController = function () {
    //this.bookListFunc = Template7.compile($$("#BookListTemplate").html());
};
BMSApp.pages.BookListController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.BookListController.prototype.pageInit = function (page) {
    var self = this;
    $$('div[data-page="bookListPage"] .page-content #id_searchbtn').on('click', function () {
        $$('.page[data-page="bookListPage"] .page-content .myDiv').addClass('showDiv');
    });
    //$$(document).on('click', function () {
    //    if (($$('.page[data-page="bookListPage"] .page-content .myDiv').hasClass('showDiv'))) {
    //            $$('.page[data-page="bookListPage"] .page-content .myDiv').removeClass('showDiv');
    //    }
    //});
    $$('div[data-page="bookListPage"] .page-content .myDiv ul').find("li").on('click', function () {
        var type = $$(this).html();
        $$('.page[data-page="bookListPage"] .page-content #id_searchbtn span').html(type);
    });
};
