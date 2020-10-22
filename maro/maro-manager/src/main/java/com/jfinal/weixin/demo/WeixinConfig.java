/**
 * Copyright (c) 2011-2014, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.jfinal.weixin.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.template.Engine;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MemberCardApi;
import com.jfinal.weixin.sdk.cache.LocalTestTokenCache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.poi.hslf.record.RecordTypes.List;

public class WeixinConfig extends JFinalConfig {
    // 本地开发模式
    private boolean isLocalDev = false;
    
    /**
     * 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
     * @param pro 生产环境配置文件
     * @param dev 开发环境配置文件
     */
    public void loadProp(String pro, String dev) {
        try {
            PropKit.use(pro);
        }
        catch (Exception e) {
            PropKit.use(dev);
            isLocalDev = true;
        }
    }

    public void configConstant(Constants me) {
        loadProp("weixin_config.txt", "weixin_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", true));

        // ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
        ApiConfigKit.setDevMode(me.getDevMode());
    }

    public void configRoute(Routes me) {
        me.setBaseViewPath("/webpage");
        me.add("/weixin/card", WeixinCardController.class);
        me.add("/weixin/msg", WeixinMsgController.class);
        me.add("/weixin/api", WeixinApiController.class);
        me.add("/weixin/pay", WeixinPayController.class);
        me.add("/weixin/member", WeixinMemberController.class);
        me.add("/weixin/wxa/user", WxaUserApiController.class);
    }

    public void configPlugin(Plugins me) {
        // C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        // me.add(c3p0Plugin);

        // EhCachePlugin ecp = new EhCachePlugin();
        // me.add(ecp);

        // 使用redis分布accessToken
        // RedisPlugin redisPlugin = new RedisPlugin("weixin", "127.0.0.1");
        // redisPlugin.setSerializer(JdkSerializer.me); // 需要使用fst高性能序列化的用户请删除这一行（Fst jar依赖请查看WIKI）
        // me.add(redisPlugin);
    }

    public void configInterceptor(Interceptors me) {
        // 设置默认的 appId 规则，默认值为appId，可采用url挂参数 ?appId=xxx 切换多公众号
        // ApiInterceptor.setAppIdParser(new AppIdParser.DefaultParameterAppIdParser("appId")); 默认无需设置
        // MsgInterceptor.setAppIdParser(new AppIdParser.DefaultParameterAppIdParser("appId")); 默认无需设置
    }

    public void configHandler(Handlers me) {
        //给前台一个相对路径contextPath 引用。
        me.add(new ContextPathHandler("ctx"));
    }

    public void afterJFinalStart() {
        // 1.5 之后支持redis存储access_token、js_ticket，需要先启动RedisPlugin
//        ApiConfigKit.setAccessTokenCache(new RedisAccessTokenCache());
        // 1.6新增的2种初始化
//        ApiConfigKit.setAccessTokenCache(new RedisAccessTokenCache(Redis.use("weixin")));
//        ApiConfigKit.setAccessTokenCache(new RedisAccessTokenCache("weixin"));

        ApiConfig ac = new ApiConfig();
        // 配置微信 API 相关参数
        ac.setToken(PropKit.get("token"));
        ac.setAppId(PropKit.get("appId"));
        ac.setAppSecret(PropKit.get("appSecret"));

        /**
         *  是否对消息进行加密，对应于微信平台的消息加解密方式：
         *  1：true进行加密且必须配置 encodingAesKey
         *  2：false采用明文模式，同时也支持混合模式
         */
        ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
        ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));

        /**
         * 多个公众号时，重复调用ApiConfigKit.putApiConfig(ac)依次添加即可，第一个添加的是默认。
         */
        ApiConfigKit.putApiConfig(ac);
        
        /**
         * 1.9 新增LocalTestTokenCache用于本地和线上同时使用一套appId时避免本地将线上AccessToken冲掉
         * 
         * 设计初衷：https://www.oschina.net/question/2702126_2237352
         * 
         * 注意：
         * 1. 上线时应保证此处isLocalDev为false，或者注释掉该不分代码！
         * 
         * 2. 为了安全起见，此处可以自己添加密钥之类的参数，例如：
         * http://localhost/weixin/api/getToken?secret=xxxx
         * 然后在WeixinApiController#getToken()方法中判断secret
         * 
         * @see WeixinApiController#getToken()
         */
//        if (isLocalDev) {
//            String onLineTokenUrl = "http://localhost/weixin/api/getToken";
//            ApiConfigKit.setAccessTokenCache(new LocalTestTokenCache(onLineTokenUrl));
//        }
        
    }

    public static void main(String[] args) {
        String json="{\n" +
                "    \"errcode\": 0,\n" +
                "    \"errmsg\": \"ok\",\n" +
                "    \"openid\": \"obLatjjwDolFjRRd3doGIdwNqRXw\",\n" +
                "    \"nickname\": \"Fourier\",\n" +
                "    \"membership_number\": \"316510891298\",\n" +
                "    \"bonus\": 460,\n" +
                "    \"sex\": \"MALE\",\n" +
                "    \"user_info\": {\n" +
                "        \"common_field_list\": [\n" +
                "            {\n" +
                "                \"name\": \"USER_FORM_INFO_FLAG_MOBILE\",\n" +
                "                \"value\": \"15521328888\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"USER_FORM_INFO_FLAG_NAME\",\n" +
                "                \"value\": \"微信\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"custom_field_list\": []\n" +
                "    },\n" +
                "    \"user_card_status\": \"NORMAL\"\n" +
                "}";
        ApiResult api = new ApiResult(json);
        System.out.print(api.get("user_card_status"));
        Map<String, Object> user_info = api.get("user_info");

        Iterator<Object> common_field_list = ((ArrayList)user_info.get("common_field_list")).iterator();
        while (common_field_list.hasNext()) {
            Map<String, Object> a=(LinkedHashMap)common_field_list.next();
            if(a.get("name").equals("USER_FORM_INFO_FLAG_MOBILE"))
                System.out.print(a.get("value"));
            if(a.get("name").equals("USER_FORM_INFO_FLAG_NAME"))
                System.out.print(a.get("value"));
        }
    }

	@Override
	public void configEngine(Engine engine) {
		
	}
}
