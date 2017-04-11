package com.model;

import java.util.Date;

public class TGirl {
     // 
     // 表字段 : t_girl.id
    private Integer id;

     // 
     // 表字段 : t_girl.girl_name
    private String girl_name;

     // 
     // 表字段 : t_girl.age
    private Integer age;

     // 
     // 表字段 : t_girl.status
    private Integer status;

     // 
     // 表字段 : t_girl.created
    private Date created;

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.girl_name
     *
     * @mbg.generated
     */
    public String getGirl_name() {
        return girl_name;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.girl_name
     *
     * @mbg.generated
     */
    public void setGirl_name(String girl_name) {
        this.girl_name = girl_name == null ? null : girl_name.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.created
     *
     * @mbg.generated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  t_girl.created
     *
     * @mbg.generated
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}