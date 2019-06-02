package org.icode.msp.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by sheriff on 2018/11/20.
 */
@Data
public class User {
    private String account;
    private String password;
    private String nickname;
    private String headPortrait;
    private Integer sex;
    private String email;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer level;
    private Integer state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastLoginTime;
    private String remark;
    private Integer count;

    public User(){}

    public User(String account, String password, String nickname, String headPortrait, Integer sex, String email, String tel, Date createTime, Integer level, Integer state, Date lastLoginTime, String remark, Integer count) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.headPortrait = headPortrait;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
        this.createTime = createTime;
        this.level = level;
        this.state = state;
        this.lastLoginTime = lastLoginTime;
        this.remark = remark;
        this.count = count;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", createTime=" + createTime +
                ", level=" + level +
                ", state=" + state +
                ", lastLoginTime=" + lastLoginTime +
                ", remark='" + remark + '\'' +
                ", count=" + count +
                '}';
    }
}
