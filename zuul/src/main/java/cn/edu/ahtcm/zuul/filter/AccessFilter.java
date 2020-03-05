package cn.edu.ahtcm.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器类型 前置还是后置
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 指定在过滤器链中的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        // 该过滤器顺序要大于5，才能得到serviceId
        return FilterConstants.DEBUG_FILTER_ORDER + 5;
    }

    /**
     * 是否执行过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        if("user-feign-service".equals(serviceId)){
            log.info("user-feign-service request");
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getParameter("token") == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("please login");
            ctx.setResponseStatusCode(HttpStatus.OK.value());
        }
        // zuul过滤器返回的数据为以后的设计使用
        // 目前该返回值没有被使用
        return null;
    }
}
