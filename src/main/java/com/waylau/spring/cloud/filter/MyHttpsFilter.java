package com.waylau.spring.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**通过此过滤器可以做权限安全认证操作*/
@Component
public class MyHttpsFilter extends ZuulFilter  {
	private static Logger log = LoggerFactory.getLogger(MyHttpsFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		
		String requestURL = request.getRequestURL().toString();
		String apiName = request.getParameter("apiName");
		String data = request.getParameter("data");
 
		log.info("ok");
		return null;
	}

	@Override
	public String filterType() {
		// return "pre";
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_FORWARD_FILTER_ORDER;
	}

}
