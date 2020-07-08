package com.springcloud.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;  //是否启用过滤器
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = requestContext.getRequest();
        //获取请求参数access-token
        String token = request.getParameter("access-token");
        //拦截
        if(StringUtils.isBlank(token)){ //token==null || token.trim().isEmpty()  判断效率低，庸俗
            requestContext.setSendZuulResponse(false);//表示拦截
            requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value()); //返回403
        }

        return null;
    }
}
