package com.tianling.house.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋表(House)实体类
 *
 * @author tianling
 * @since 2020-09-16 20:24:40
 */
public class House implements Serializable {
    private static final long serialVersionUID = 754367736411447839L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 房产名称
    */
    private String name;
    /**
    * 1-销售2-出租
    */
    private Object type;
    /**
    * 单位元,价格
    */
    private Integer price;
    /**
    * 房屋图片
    */
    private String images;
    /**
    * 面积
    */
    private Integer area;
    /**
    * 卧室的数量
    */
    private Integer beds;
    /**
    * 卫生间的数量
    */
    private Integer baths;
    /**
    * 评分
    */
    private Object rathing;
    /**
    * 房产描述
    */
    private String remarks;
    /**
    * 房产属性
    */
    private String properties;
    /**
    * 户型图
    */
    private String floorPlan;
    /**
    * 标签
    */
    private String tags;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 小区id
    */
    private Integer communityId;
    /**
    * 房产地址
    */
    private String address;
    /**
    * 1-上架2-下架
    */
    private Object state;


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

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Object getRathing() {
        return rathing;
    }

    public void setRathing(Object rathing) {
        this.rathing = rathing;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getFloorPlan() {
        return floorPlan;
    }

    public void setFloorPlan(String floorPlan) {
        this.floorPlan = floorPlan;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

}