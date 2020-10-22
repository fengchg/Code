var url = require("url");
var path = require('path');
var fs = require("fs");
var http = require("http");
var https = require("https");
var bufferhelper = require('bufferhelper');
var cb = require("./config");
var querystring = require('qs');
var express = require('express');
var router = express.Router();
var rootPath = path.dirname(path.dirname(__dirname));

router.all(/\public\//, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body, cb.publicFileUrl);
});
router.all(/\photo\//, function (req, res) {
    //var urlPath = url.parse(req.url).path; 
    //console.log("302的地址：" + cb.dataFileUrl + urlPath);
    //res.writeHead(302, { 'Location': cb.dataFileUrl + urlPath });
    //res.end();
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body, cb.dataFileUrl);
});
router.all(/\ma\//, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\mc/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\mlogin/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\getMVersion/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\wxlogin/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\mlogout/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\BaseData/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\Enums/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\Security/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});
router.all(/\/PayBack\/paymentNotify/, function (req, res) {
    Application.doService(req, res, req.method.toLocaleLowerCase() === "get" ? undefined : req.body);
});

router.get("/", function (req, res, next) {
    var pathName = path.join(rootPath, "index.html");
    Application.render(res, pathName);
});
router.get("/reg", function (req, res, next) {
    var pathName = path.join(rootPath, "register.html");
    Application.render(res, pathName);
});
router.get("/demo", function (req, res, next) {
    var pathName = path.join(rootPath, "demo.html");
    Application.render(res, pathName);
});

router.all(/\//, function (req, res, next) {
    var uri = url.parse(req.url);
    var urlPath = uri && uri.path && uri.pathname;
    if (!urlPath) return;
    var isMatch = urlPath && urlPath.match(new RegExp("/"));
    if (isMatch) {
        var pathName = rootPath + urlPath;
        Application.render(res, pathName);
    }
});

var Application = {
    render: function (response, pathname) {
        fs.exists(pathname, function (exists) {
            if (exists) {
                var extName = path.extname(pathname);
                response.writeHead(200, (cb.webserver.headerConfig[extName] || cb.webserver.headerConfig["default"]));
                fs.readFile(pathname, function (err, data) {
                    response.end(data);
                });
            }
            else
                Application.errorPage(response, pathname);
        });
    },
    doService: function (request, response, bodyData, callback) {
        var fileUrl = cb.webserver.UapServiceBaseUrl;
        if (typeof callback == "string") { //如果是字符串，则为文件转发地址，并执行文件转发操作
            fileUrl = callback;
            callback = undefined;
        }
        var urlPath = url.parse(request.url).path;
        //var uapServiceUrl = /(\w+):\/\/([^/:]+)(:\d*)/.exec(fileUrl)[0] + urlPath;
        var uapServiceUrl = fileUrl + urlPath;
        ServiceProxy.init({ url: uapServiceUrl, request: request, response: response, bodyData: bodyData, callback: callback });
        ServiceProxy.doRequest(request.method);
    },
    renderJson: function (response, obj) {
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.end(JSON.stringify(obj));
    },
    errorPage: function (response, pathname) {
        console.log("发生了错误！！！response pathname:" + pathname);
        response.writeHead(404, { "Content-Type": "text/html" });
        response.end("<h1>404 Not Found</h1>");
    }
};

var ServiceProxy = {
    //contest:{url:"",request:null,response:null,method:"GET"}
    init: function (context) {
        this._context = context;
        return this;
    },
    get: function () {
        //http.get(context.url, function (proxyResponse) {});
        this.doRequest("GET");
    },

    post: function () {
        this.doRequest("POST");
    },
    doRequest: function (method) {
        var context = this._context;
        var options = url.parse(context.url);
        options.method = method || "GET";
        options.timeout = 3000;
        options.headers = {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
        };
        console.log("1→→→→→ 转发开始");
        if (context.url.indexOf('.com:') > -1) {
            var pointStartStr = context.url.split(".com:")[1];
            var point = parseInt(pointStartStr);
            if (!isNaN(point) && cb.httpsPorts.indexOf(point) > -1) {
                http = https;
            }
        }

        console.log("2========== 方法：" + options.method + " 地址：" + context.url);
        if (context.bodyData) {
            options.method = "POST";
            console.log("3========== 参数：");
            console.log(context.bodyData);
        }
        var proxyRequest = http.request(options, function (proxyResponse) {
            var bufferHelper = new bufferhelper();
            var contentEncoding = proxyResponse.headers["content-encoding"];
            proxyResponse.on("data", function (chunk) {
                bufferHelper.concat(chunk);
            });

            proxyResponse.on("end", function () {
                var resData = bufferHelper.toBuffer();
                if (context.callback) {
                    context.callback.call(this, resData, contentEncoding);
                } else {
                    context.response.end(resData);
                }
                proxyRequest.end();
                console.log("5========== 返回数据长度:" + resData.length);
                console.log("6←←←←← 转发结束 ");
            });
            var contentType = proxyResponse.headers["content-type"] || "application/json;charset=UTF-8";
            context.response.setHeader("Content-Type", contentType);
            var contentDisposition = proxyResponse.headers["content-disposition"];
            if (contentDisposition)
                context.response.setHeader("Content-Disposition", contentDisposition);
            if (contentEncoding)
                context.response.setHeader("Content-Encoding", contentEncoding);
            context.response.setHeader("Redirect-To-UPService-URL", context.url);
            console.log("4========== 响应状态码: " + proxyResponse.statusCode);
        });
        proxyRequest.on("error", function (e) {
            if (context.callback) {
                context.callback.call(this, { "error": e.message });
            } else {
                context.response.end(e.message);
            }
            proxyRequest.end();
            console.log("★★★★★★转发出现错误:" + e.message);
        });
        if (context.bodyData) {
            var data = querystring.stringify(context.bodyData);
            proxyRequest.write(data);
        }
        proxyRequest.end();
    }
};

module.exports = router;