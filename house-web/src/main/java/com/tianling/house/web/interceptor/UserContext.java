package com.tianling.house.web.interceptor;

import com.tianling.house.common.model.User;

/**
 * @author tianling
 * @create 2020/9/20
 **/
public class UserContext {
    private static ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    public static void setUser(User user){
        USER_HOLDER.set(user);
    }

    public static void remove(){
        USER_HOLDER.remove();
    }

    public static User getUser(){
        return  USER_HOLDER.get();
    }

}
