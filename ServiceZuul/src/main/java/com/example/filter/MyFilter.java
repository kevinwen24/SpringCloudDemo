package com.example.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = ctx.getResponse();
        String uri = request.getRequestURI().toString();
        String accessToken = request.getParameter("token");
		log.info(String.format("%s  >>> %s", request.getMethod(), uri));
		String[] uriArray = uri.split("[/]");
		String firstIndex = uriArray[2];
		System.out.println("firstIndex="+firstIndex);
		System.out.println("user="+session.getAttribute("user"));
		if (uri != null && (firstIndex.endsWith("css") || firstIndex.endsWith("js") || firstIndex.endsWith("image") ||  firstIndex.endsWith("login"))) {
			log.info("ok");
	        return null;
		}
		if (session.getAttribute("user") == null) {
			log.warn("token is empty!");
			//ctx.setSendZuulResponse(false); // 过滤该请求，不对其进行路由  
            //ctx.setResponseStatusCode(401); // 返回错误码  
            //response.sendRedirect("/login");
            // ctx.setResponseBody("{\"result\":\"username is not correct!\"}");
            try {
				response.sendRedirect("/api-b/login");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            /*try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
            	
            }*/

            return null;
        }
        log.info("ok");
        return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行该过滤器，此处为true，说明需要过滤  
		return true;
	}

	@Override
	public int filterOrder() {
		// 优先级为0，数字越大，优先级越低  
		return 0;
	}
	
	/**
	 * 返回一个字符串代表过滤器的类型
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * 
	 * */
	@Override
	public String filterType() {
		return "pre";
	}

}
