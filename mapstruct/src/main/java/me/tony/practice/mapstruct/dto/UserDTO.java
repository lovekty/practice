package me.tony.practice.mapstruct.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tony.zhuby
 * @date 2018/1/9
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 515213730491770145L;
    private String userCode;
    private String name;
    private Integer gender;
    private Integer age;
    private Date insertTime;
    private Date updateTime;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
