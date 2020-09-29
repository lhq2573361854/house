package com.tianling.house.web.interceptor;

import com.google.common.base.Joiner;
import com.tianling.house.common.constants.CommonConstants;
import com.tianling.house.common.model.Comment;
import com.tianling.house.common.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author tianling
 * @create 2020/9/20
 **/
@Component("AuthInterceptor")
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(StringUtils.startsWith("/static",requestURI) || StringUtils.startsWith("/error",requestURI))
            return true;
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute(CommonConstants.USER_ATTRIBUTE);
        if (user != null) {
            UserContext.setUser(user);
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k,v)->{
            request.setAttribute(k, Joiner.on(",").join(v));
        });
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
    }
}
