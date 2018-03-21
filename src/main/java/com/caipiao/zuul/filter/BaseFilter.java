package com.caipiao.zuul.filter;


import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public abstract class BaseFilter extends ZuulFilter{

	protected RequestContext context;
	protected HttpServletRequest request;
	
	public BaseFilter() {
		context = RequestContext.getCurrentContext();
		request = context.getRequest();
	}
}
