package com.jfinal.weixin.demo;

import com.jfinal.core.Controller;

/**
 * Created by alpha on 2018-11-17.
 */
public class WeixinMemberController extends Controller {

    public void index(){
        String card_id=getPara("card_id");
        String encrypt_code=getPara("encrypt_code");
        String openid=getPara("openid");
        setAttr("card_id",card_id);
        setAttr("encrypt_code",encrypt_code);
        setAttr("openid",openid);
        render("bindMember.html");
    }
    public void statement(){
        render("statement.html");
    }

}
