package com.tianling.house.common.model;

import java.io.Serializable;

/**
 * 小区(Community)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:40
 */
public class Community implements Serializable {
    private static final long serialVersionUID = 660453845608279475L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 城市编码
    */
    private String cityCode;
    /**
    * 城市名称
    */
    private String cityName;
    /**
    * 小区名称
    */
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}