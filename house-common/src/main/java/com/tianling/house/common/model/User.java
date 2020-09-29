package com.tianling.house.common.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:40
 */
public class User implements Serializable {
    private static final long serialVersionUID = -91516197664286927L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 手机
    */
    private String phone;
    /**
    * 邮件
    */
    private String email;
    /**
    * 自我介绍
    */
    private String aboutme;
    /**
    * 通过md5加密
    */
    private String passwd;
    /**
    * 头像图片
    */
    private String avatar;
    /**
    * 1-普通用户2-经纪人
    */
    private Object type;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 1-启用2-停用
    */
    private Object enable;
    /**
    * 所属经济机构
    */
    private Integer agencyId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object getEnable() {
        return enable;
    }

    public void setEnable(Object enable) {
        this.enable = enable;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

}