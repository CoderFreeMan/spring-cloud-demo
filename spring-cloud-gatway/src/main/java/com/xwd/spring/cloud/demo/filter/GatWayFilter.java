//package com.xwd.spring.cloud.demo.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.xwd.spring.cloud.demo.constant.GatWayConstant;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * GatWayFilter
// *
// * @author: Kang
// * @time: 2018年04月02日 8:48
// */
//@Component
//public class GatWayFilter extends ZuulFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(GatWayFilter.class);
//
//    private RequestContext requestContext;
//
//    private HttpServletRequest request;
//
//    private HttpServletResponse response;
//
//    /**
//     * 前置过滤器
//     *
//     * @return
//     */
//    @Override
//    public String filterType() {
//        return GatWayConstant.FILTER_PRE;
//    }
//
//    /**
//     * 当前拦截器优先级
//     *
//     * @return
//     */
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    /**
//     * 是否执行该过滤器，true代表需要过滤
//     *
//     * @return
//     */
//    @Override
//    public boolean shouldFilter() {
//        return GatWayConstant.TRUE;
//    }
//
//    /**
//     * filter all request
//     *
//     * @return
//     */
//    @Override
//    public Object run() {
//
//        initRequestParams();
//
//        logger.info("request method type[{}] and request url[{}]", request.getMethod(), request.getRequestURL());
//        try {
//            if (!checkParams()) {
//                setResponseParams(GatWayConstant.RESPONSE_STATUS_CODE, GatWayConstant.FALSE);
//                return null;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * init request params
//     */
//    private void initRequestParams() {
//        requestContext = RequestContext.getCurrentContext();
//        request = requestContext.getRequest();
//        response = requestContext.getResponse();
//    }
//
//    /**
//     * set response data
//     *
//     * @param code
//     * @param zuulResponse
//     */
//    private void setResponseParams(Integer code, boolean zuulResponse) {
//        requestContext.setResponseStatusCode(code);
//        requestContext.setSendZuulResponse(zuulResponse);
//    }
//
//    /**
//     * check request params
//     *
//     * @return
//     * @throws IOException
//     */
//    private boolean checkParams() throws IOException {
//        String token = request.getParameter(GatWayConstant.TOKEN);
//        if (StringUtils.isEmpty(token)) {
//            response.getWriter().write("request must be have token");
//            return GatWayConstant.FALSE;
//        }
//        return GatWayConstant.TRUE;
//    }
//}
