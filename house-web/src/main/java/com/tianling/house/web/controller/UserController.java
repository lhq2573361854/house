package com.tianling.house.web.controller;


import cn.hutool.core.util.StrUtil;
import com.tianling.house.biz.service.AgencyService;
import com.tianling.house.biz.service.UserService;
import com.tianling.house.common.constants.CommonConstants;
import com.tianling.house.common.model.Agency;
import com.tianling.house.common.model.User;
import com.tianling.house.common.result.ResultMsg;
import com.tianling.house.common.utils.HashUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2020-09-16 20:32:02
 */
@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    /**
     * agencyService 代理服务
     */
    @Resource
    private AgencyService agencyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    /**注册提交：1 注册校验 2发送邮件 3 失败重定向
     * 注册页获取： 根据account对象为依据 判断是否获取请求
     * @param account 账号信息
     * @param modelMap 返回的页面的信息
     * @return
     */
    @RequestMapping("/accounts/register")
    public String accountRegister(User account, @RequestParam(value = "avatarFile",required = false) List<MultipartFile> files, ModelMap modelMap){
        if(account == null || StrUtil.isBlank(account.getName())){
            modelMap.put("agencyList",  agencyService.queryAllAgency());
            return "/user/accounts/register";
        }
        ResultMsg validate = UserHelper.validate(account);
        if(validate.isSuccess() && userService.addAccount(account,files)){
            modelMap.put("email",account.getEmail());
            return "/user/accounts/registerSubmit";
        }
        return "redirect:/user/accounts/register?"+validate.asUrlParams();
    }

    /**
     *激活注册的账户
     * @param key
     * @return
     */
    @RequestMapping("accounts/verify")
    public String verify(String key) {
        boolean result = userService.enable(key);
        if (result) {
            return "redirect:/index?" + ResultMsg.successMsg("激活成功").asUrlParams();
        } else {
            return "redirect:/accounts/register?" + ResultMsg.errorMsg("激活失败,请确认链接是否过期");
        }
    }

    /**
     * 用户登录请求
     * @param request
     * @return
     */
    @RequestMapping("accounts/signin")
    public String signIn(HttpServletRequest request) {
       String username =  request.getParameter("username");
       String password =  request.getParameter("password");
       String target =  request.getParameter("target");
       if (username == null || password == null){
           request.setAttribute("target",target);
           return "user/accounts/signin";
       }
       User user = userService.auth(username,password);
       if(user == null ){
           return "redirect:/accounts/signin?"+"target="+ target + "&username" + username + "&"+ResultMsg.errorMsg("用户名密码错误");
       }else{
           HttpSession session = request.getSession();
           session.setAttribute(CommonConstants.USER_ATTRIBUTE,user);
           session.setAttribute(CommonConstants.PLAN_USER_ATTRIBUTE,user);
           return StringUtils.isBlank(target) ? "redirect:/index" : "redirect:"+ target;
       }
    }

    /**
     * 提供页面信息
     * 更新用户信息
     * @param updateUser
     * @param map
     * @return
     */
    @RequestMapping("/accounts/profile")
    public String profile(HttpServletRequest request,User updateUser,ModelMap map){
        if (updateUser.getEmail() == null) {
            return "/user/accounts/profile";
        }
        User update = userService.updateByEmail(updateUser,updateUser.getEmail());
        request.getSession().setAttribute(CommonConstants.USER_ATTRIBUTE,update);
        return "redirect:/accounts/profile?"+ResultMsg.successMsg("更新成功").asUrlParams();
    }

    /**
     *  修改密码通过email
     * @param email
     * @param password
     * @param newPassword
     * @param confirmPassword
     * @param map
     * @return
     */
    @RequestMapping("/accounts/changePassword")
    public String changePassword(String email,String password,String newPassword,String confirmPassword,ModelMap map){
        User user = userService.auth(email, password);
        if( user == null || !confirmPassword.equalsIgnoreCase(newPassword)){
            return "redirect:/accounts/profile?"+ResultMsg.errorMsg("密码错误").asUrlParams();
        }
        User updateUser = new User();
        updateUser.setPasswd(HashUtils.encryPassword(newPassword));
        userService.updateByEmail(updateUser,email);
        return "redirect:/accounts/profile?"+ResultMsg.successMsg("更新成功").asUrlParams();
    }

}