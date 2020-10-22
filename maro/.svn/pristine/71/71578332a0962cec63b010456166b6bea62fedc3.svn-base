package com.maro.client.common.interceptor;

import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域问题处理拦截器
 * @author 冯成果
 * @date 2018-4-12
 * @since 01.00.0001
*/
public class CrossDomainInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    	String url = request.getHeader("Origin");
//        if (!StringUtils.isEmpty(url)) {
//                response.addHeader("Access-Control-Allow-Origin", url);
//                response.addHeader("Access-Control-Allow-Credentials", "true");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
