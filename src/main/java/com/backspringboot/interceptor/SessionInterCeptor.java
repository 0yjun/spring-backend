package com.backspringboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterCeptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("인터셉터 적용");
        try {
            if (request.getSession().getAttribute("memVo") == null) {
                if (isAxaxRequest(request)) {
                    response.sendError(600);
                    return false;
                }
                System.out.println("로그인 필요 requst : "+request.getRequestURL());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //response.sendError(500, "로그인 필요");
        //return false;
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("post handler");
    }
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
    private boolean isAxaxRequest(HttpServletRequest req){
        String handler = req.getHeader("AJAX");
        return "true".equals(handler);
    }

}
