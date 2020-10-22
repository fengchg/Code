package com.maro.client.module.pay.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpay.vo.AjaxResult;
import com.jpay.weixin.api.WxPayApiConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WechatUtil {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private AjaxResult result = new AjaxResult();
    public static final String appID="wx230c617d7f6c9677";
    public static final String secret="ce79ccd023ae70777e848c0ed90864a3";
    public static final String mchID="1507628441";
    public static final String partnerKey="wx230c617d7f6c9677CDZX168CDZXZIX";
    public static String notify_url = "http://www.zzw777.com";



    public static WxPayApiConfig getApiConfig() {
        return WxPayApiConfig.New()
                .setAppId(appID)
                .setMchId(mchID)
                .setPaternerKey(partnerKey)
                .setPayModel(WxPayApiConfig.PayModel.BUSINESSMODEL);
    }

    /**
     * 通过微信用户的code换取网页授权access_token
     * @return
     * @throws IOException
     * @throws
     */
    public static List<Object> accessToken(String code) throws IOException {
        List<Object> list = new ArrayList<Object>();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                +  appID + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        HttpResponse res = client.execute(post);
        if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = res.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            ObjectMapper mapper=new ObjectMapper();
            Map<String,Object> jsonOb=mapper.readValue(str, Map.class);
            list.add(jsonOb.get("access_token"));
            list.add(jsonOb.get("openid"));
        }
        return list;
    }

    public static String getOpenId(String code){
        String openId=null;
        try {
            List<Object> list = WechatUtil.accessToken(code);
            openId=list.get(1).toString();
        } catch (IOException e) {
            System.out.println("--openid获取错误");
        }
        return openId;
    }

}
