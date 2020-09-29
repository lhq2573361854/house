package com.tianling.house.common.model;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表(Comment)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:30:10
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 311640342076774084L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 评论内容
    */
    private String content;
    /**
    * 房屋id
    */
    private Long houseId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 博客id
    */
    private Long blogId;
    /**
    * 1-房产2-博客
    */
    private String type;
    /**
    * 用户id
    */
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}