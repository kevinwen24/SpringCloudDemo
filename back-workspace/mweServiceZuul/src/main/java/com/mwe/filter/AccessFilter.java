package com.mwe.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		HttpSession session = request.getSession();

		if (null == session.getAttribute("user")) {
			String uri = request.getRequestURI();
			String queryString = request.getQueryString();
			String redirectPage = "/login";
			
			if (StringUtils.isEmpty(queryString)) {
				redirectPage += "?go=" + uri;
			} else {
				redirectPage += "?go=" + uri + "#" + queryString;
			}
			
			if ("/api-b/index".contains(uri) || "POST".equals(request.getMethod())) {
				redirectPage = "/login";
			}
			
			try {
				ctx.setSendZuulResponse(false);
				response.sendRedirect(redirectPage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
