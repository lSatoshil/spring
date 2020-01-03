package com.satoshi.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");

        if (accessToken == null){
            logger.error("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            return "access token is empty";
        }
        logger.error("access token is ok");
        return null;
    }
}