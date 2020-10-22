BMSApp.ns('BMSApp.pages');
BMSApp.pages.BookNewController = function () { };
BMSApp.pages.BookNewController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.BookNewController.prototype.pageInit = function (page) {
    var self = this;
    
};