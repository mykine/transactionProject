package com.demo.mykine.springtxjpa.domain.entity.User;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_users")
public class TUsers {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * age
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 名字
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_dt")
    private Date createDt;

    /**
     * 更新时间
     */
    @Column(name = "update_dt")
    private Date updateDt;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取age
     *
     * @return age - age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置age
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return create_dt - 创建时间
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * 设置创建时间
     *
     * @param createDt 创建时间
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * 获取更新时间
     *
     * @return update_dt - 更新时间
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * 设置更新时间
     *
     * @param updateDt 更新时间
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}