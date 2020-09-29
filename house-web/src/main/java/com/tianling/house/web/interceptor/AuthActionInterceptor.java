package com.tianling.house.web.interceptor;

import com.tianling.house.common.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author tianling
 * @create 2020/9/20
 **/
@Component("AuthActionInterceptor")
public class AuthActionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = UserContext.getUser();
        if (user == null) {
            String target = URLEncoder.encode(request.getRequestURL().toString(), "utf-8");
            String msg = URLEncoder.encode("请先登录", "utf-8");
            if("GET".equalsIgnoreCase(request.getMethod())){
                response.sendRedirect("/accounts/signin?errorMsg="+ msg + "&target="+target);
            }else{
                response.sendRedirect("/accounts/signin?errorMsg=");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
