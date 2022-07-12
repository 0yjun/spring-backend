package com.backspringboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

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
                System.out.println("로그인 필요 requst : "+request.getMethod());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
    private boolean isAxaxRequest(HttpServletRequest req){
        String handler = req.getHeader("AJAX");
        return "true".equals(handler);
    }
}
