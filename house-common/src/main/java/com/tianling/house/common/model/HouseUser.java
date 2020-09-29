package com.tianling.house.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 房产用户表(HouseUser)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:40
 */
public class HouseUser implements Serializable {
    private static final long serialVersionUID = 137731351879197382L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 房屋id

    */
    private Long houseId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 1-售卖2-收藏
    */
    private Object type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

}