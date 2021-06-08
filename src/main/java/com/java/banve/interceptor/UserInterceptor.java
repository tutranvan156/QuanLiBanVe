package com.java.banve.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class UserInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        logger.info("PreHandle");
//        logger.info("Request ",  request.toString());
//        logger.info("Respond ", response.toString());
//        logger.info("Object ", handler.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
//        logger.info("PostHandle");
//        logger.info("Request ",  request.toString());
//        logger.info("Respond ", response.toString());
//        logger.info("Object ", handler.toString());
//        logger.info("ModeAndView ", modelAndView.toString());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
//        logger.info("UserInterceptor - afterHandle");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

    }

}
