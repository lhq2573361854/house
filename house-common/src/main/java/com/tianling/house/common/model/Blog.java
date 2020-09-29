package com.tianling.house.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客表
(Blog)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:35
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = -30115135680527678L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 标签
    */
    private String tags;
    /**
    * 内容
    */
    private String content;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 标题
    */
    private String titile;
    /**
    * 分类
    */
    private Integer cat;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

}