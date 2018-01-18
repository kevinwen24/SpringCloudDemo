package com.mwe.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		/*RequestContext ctx = RequestContext.getCurrentContext();  
        return (boolean) ctx.get("isSuccess");*/
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", "zhangsan");
		//这句话导致session不一致
		//ctx.addZuulRequestHeader("Cookie", "SESSION=" + session.getId());
		System.err.println(session.getAttribute("user"));
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
