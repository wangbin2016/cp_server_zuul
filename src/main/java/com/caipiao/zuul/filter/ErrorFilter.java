package com.caipiao.zuul.filter;


public class ErrorFilter extends BaseFilter{

	@Override
	public Object run() {
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "error";
	}

}
