package com.model;

import java.util.Date;

public class TTest {
     // 
     // 表字段 : t_test.id
    private Integer id;

     // 
     // 表字段 : t_test.username
    private String username;

     // 
     // 表字段 : t_test.name
    private String name;

     // 
     // 表字段 : t_test.sex
    private String sex;

     // 
     // 表字段 : t_test.status
    private String status;

     // 
     // 表字段 : t_test.time
    private Date time;

     // 
     // 表字段 : t_test.created
    private Date created;

     // 
     // 表字段 : t_test.test_id
    private String test_id;

     // 
     // 表字段 : t_test.love_name
    private String love_name;

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.created
     *
     * @mbg.generated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.created
     *
     * @mbg.generated
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.test_id
     *
     * @mbg.generated
     */
    public String getTest_id() {
        return test_id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.test_id
     *
     * @mbg.generated
     */
    public void setTest_id(String test_id) {
        this.test_id = test_id == null ? null : test_id.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.love_name
     *
     * @mbg.generated
     */
    public String getLove_name() {
        return love_name;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_test.love_name
     *
     * @mbg.generated
     */
    public void setLove_name(String love_name) {
        this.love_name = love_name == null ? null : love_name.trim();
    }
}