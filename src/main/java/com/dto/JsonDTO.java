package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * json参数实体
 *
 * @author Liukx
 * @create 2017-04-10 10:05
 * @email liukx@elab-plus.com
 **/
public class JsonDTO {

    private String username;
    private String password;
    @JsonProperty("tel")
    private String mobile;
    private Date created;
    private Integer age;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
