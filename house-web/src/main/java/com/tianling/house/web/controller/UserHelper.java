package com.tianling.house.web.controller;


import cn.hutool.core.util.ReUtil;
import com.google.common.base.Strings;
import com.tianling.house.common.model.User;
import com.tianling.house.common.result.ResultMsg;

/**
 * @author tianling
 * @create 2020/9/16
 **/
public class UserHelper {

    public static ResultMsg validate(User account){
        if(Strings.isNullOrEmpty(account.getName())){
            return ResultMsg.errorMsg("账号出错");
        }
        if(Strings.isNullOrEmpty(account.getEmail())){
            return ResultMsg.errorMsg("邮箱有误");
        }
        if(Strings.isNullOrEmpty(account.getPasswd())){
            return ResultMsg.errorMsg("密码不能为空");
        }
        if(account.getPasswd().length() < 1){
            return ResultMsg.errorMsg("密码过短");
        }
        return ResultMsg.successMsg("成功");
    }
}
