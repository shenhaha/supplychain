package com.luer.weixin.bean;

import java.util.Date;

public class User {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String appid;

    private String city;

    private String country;

    private String headimgurl;

    private String mobile;

    private String name;

    private String nickname;

    private String openid;

    private String province;

    private String remark;

    private String sex;

    private String subscribe;

    private String subscribeScene;

    private String subscribeTime;

    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid ;//== null ? null : appid.trim()
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city ;//== null ? null : city.trim()
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country ;//== null ? null : country.trim()
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl ;//== null ? null : headimgurl.trim()
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile ;//== null ? null : mobile.trim()
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ;//== null ? null : name.trim()
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid ;//== null ? null : openid.trim()
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province ;//== null ? null : province.trim()
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark ;//== null ? null : remark.trim()
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex ;//== null ? null : sex.trim()
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe ;//== null ? null : subscribe.trim()
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene ;//== null ? null : subscribeScene.trim()
    }

    public String getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(String subscribeTime) {
        this.subscribeTime = subscribeTime ;//== null ? null : subscribeTime.trim()
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag ;//== null ? null : tag.trim()
    }
}