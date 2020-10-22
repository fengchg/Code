BMSApp.ns('BMSApp.pages');
BMSApp.pages.UserMessageController = function () { };
BMSApp.pages.UserMessageController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.UserMessageController.prototype.pageInit = function (page) {
};