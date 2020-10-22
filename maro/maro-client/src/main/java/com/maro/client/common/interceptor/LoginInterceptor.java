package com.maro.client.common.interceptor;

import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.interceptors.AuthInterceptor;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.pojo.base.TSUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor extends AuthInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 用户访问的资源地址
        String requestPath = ResourceUtil.getRequestPath(request);
        //判断会话超时，登录接口除外
        if(!requestPath.contains("login")){
            TSUser sessionUser = ResourceUtil.getSessionUser();
            if(sessionUser == null){
                PrintWriter writer = response.getWriter();
                AjaxJson ajaxJson = new AjaxJson();
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg("会话超时，请重新登录!");
                ajaxJson.setObj(100);
                String jsonStr = ajaxJson.getJsonStr();
                writer.println(jsonStr);
                writer.flush();
                return false;
            }
        }

        return  super.preHandle(request,response,handler);
    }

}
