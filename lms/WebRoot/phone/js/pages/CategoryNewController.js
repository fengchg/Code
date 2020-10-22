BMSApp.ns('BMSApp.pages');
BMSApp.pages.CategoryNewController = function () {
    this.categoryListFunc = Template7.compile($$("#CategoryInfoTemplate").html());
};
BMSApp.pages.CategoryNewController.prototype.preprocess = function (content, url, next) {
    next(content);
};

BMSApp.pages.CategoryNewController.prototype.pageInit = function (page) {
    var self = this;
    var isNewCategory = $$.parseUrlQuery(page.url);
    var data = page.query;
    if (isNewCategory.newCategory == "true") {
    	var context = {name:'',remark:''};
    	$$('#id_typelistdiv').html(self.categoryListFunc(context));
        $$('div[data-page="categoryNewPage"] .center').text("新增图书类型");
        $$("#delete-category").hide();
        

        $$("#id_typesaveBtn").on("click",function(){
        	var remark = $$("#id_tprmtext").val();
        	var name = $$("#id_tpnmtext").val();
        	 $$.post('lms/phoneAction!addBookType.action', {"bookType.name":name,"bookType.remark":remark}, function (data) {
        		 data = eval('(' +data+ ')');
        		 if (data.code != 200) {
                     myApp.toast(data.data.tip, 'error').show(true);
                     return;
                 }
                 myApp.toast(data.data.tip, 'success').show(true);
                 myApp.mainView.router.back({ url: '../categoryList.html'});
             });
        });
    } else {
    	
    	$$.getJSON("lms/phoneAction!viewBookType.action",{"bookType.id":data.id},function(data){
    		$$('#id_typelistdiv').html(self.categoryListFunc(data.data));
    	});
    	
    	
        $$('div[data-page="categoryNewPage"] .center').text("查看图书类型");
        $$("#delete-category").show();
    }
    $$('#AddressDetail li.isDefault').on('click', function () {
        $$(this).toggleClass('checked');
    });
    
    $$("#id_typesaveBtn").on("click",function(){
    	
    	var remark = $$("#id_tprmtext").val();
    	var name = $$("#id_tpnmtext").val();
//    	var id = $$("#id_tpidhdn").attr("value");
    	
    	$$.post("lms/phoneAction!saveBookType.action",{"bookType.id":data.id,"bookType.name":name,"bookType.remark":remark},function(data){
    		 data = eval('(' +data+ ')');
    		 if (data.code == 200) {
    	            myApp.toast('保存成功', 'error').show(true);
    	     }else{
    	    	 myApp.toast('保存失败', 'error').show(true);
    	     }
    	});
    });
    
    $$("#id_dtpdelbtn").on("click",function(){
    	
    	cb.confirm('确定要删除该项吗？', '提示信息', function () {
            $$.getJSON('lms/phoneAction!deleteBookType.action', {"bookType.id":data.id}, function (data) {
                if (data.code != 200) {
                    myApp.toast(data.data.tip, 'error').show(true);
                    return;
                }
                myApp.toast(data.data.tip, 'success').show(true);
                myApp.mainView.router.back({ url: '../categoryList.html'});
            });
        });

    });
};