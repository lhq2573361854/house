package com.tianling.house.common.model;

import java.io.Serializable;

/**
 * 经纪人表(Agency)实体类
 *
 * @author tianling
 * @since 2020-09-15 12:02:57
 */
public class Agency implements Serializable {
    private static final long serialVersionUID = 893872728825004249L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 经纪机构名称
    */
    private String name;
    /**
    * 地址
    */
    private String phone;
    /**
    * 手机号
    */
    private String address;
    /**
    * 电子邮箱
    */
    private String email;
    /**
    * 描述
    */
    private String aboutUs;
    /**
    * 电脑
    */
    private String mobile;
    /**
    * 网站
    */
    private String webSite;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

}