package com.nile.pojo;

import java.util.Date;

public class Author {
    private Integer id;

    private String name;

    private String profile;

    private Date createTime;

    private Date updateTime;

    public Author(Integer id, String name, String profile, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Author() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
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
}