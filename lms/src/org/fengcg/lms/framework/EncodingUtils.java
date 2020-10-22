/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * className:org.fengxl.lms.framewok.EncodingUtils.java
 * author:·ë³É¹û
 * date:2013-2-25
 * description:
 */
public class EncodingUtils implements Filter{
	private String charset;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest requst, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		requst.setCharacterEncoding(charset);
		chain.doFilter(requst, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("charset");
	}

}
