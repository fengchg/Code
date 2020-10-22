package com.maro.common.filter;

import org.jeecgframework.p3.core.utils.common.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossDomainFilter implements Filter {

    @Override
    public void destroy() {
        //System.out.println("过滤器销毁");
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String type=httpRequest.getMethod();
    	String url = httpRequest.getHeader("Origin");
        if (!StringUtils.isEmpty(url)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", url);
        }
//        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Headers",
                "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessToken");

        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        httpResponse.setHeader("Access-Control-Max-Age", "1209600");

        httpResponse.setHeader("Access-Control-Expose-Headers", "accesstoken");

        httpResponse.setHeader("Access-Control-Request-Headers", "accesstoken");

        httpResponse.setHeader("Expires", "-1");

        httpResponse.setHeader("Cache-Control", "no-cache");

        httpResponse.setHeader("pragma", "no-cache");
//        httpRequest.setCharacterEncoding("UTF-8");
        chain.doFilter(httpRequest,httpResponse);
    }

}
