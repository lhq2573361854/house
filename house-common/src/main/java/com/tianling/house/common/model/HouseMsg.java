package com.tianling.house.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋信息表(HouseMsg)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:40
 */
public class HouseMsg implements Serializable {
    private static final long serialVersionUID = 541469085597150459L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 消息
    */
    private String msg;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 经纪人id
    */
    private Long agentId;
    /**
    * 房子id
    */
    private Long houseId;
    /**
    * 用户名称
    */
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}