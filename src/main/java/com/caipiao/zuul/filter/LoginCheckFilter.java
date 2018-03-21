package com.caipiao.zuul.filter;


import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class LoginCheckFilter extends ZuulFilter{
	
	protected RequestContext context;
	protected HttpServletRequest request;
	
	public LoginCheckFilter() {
		context = RequestContext.getCurrentContext();
		request = context.getRequest();
	}
	
	@Override
	public Object run() {
		context = RequestContext.getCurrentContext();
		request = context.getRequest();
		String token = request.getParameter("token");
		if(token == null) {
			context.setSendZuulResponse(false);
			context.setResponseBody("");
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		context = RequestContext.getCurrentContext();
		request = context.getRequest();
		String uri = request.getRequestURI();
		Map<String,String[]> map = request.getParameterMap();
		System.out.println(map.size());
		for(Map.Entry<String, String[]>  key : map.entrySet()) {
			System.out.println(key +"   value:"+Arrays.toString(key.getValue()));
		}
		if(uri.indexOf("\\/user\\/") > -1) {
			return true;
		}
		return false;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
