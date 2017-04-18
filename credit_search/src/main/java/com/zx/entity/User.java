package com.zx.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by credittone on 2017/4/17.
 */
@Entity
@Table(name="user_info")
public class User {
    @Id
    private String uname;
    private String pwd;
    private Double money; //余额
    private String ctime; //注册时间

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    public Double getMoney() {
        return money;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User() {
        super();
    }

    public User(String uname, String pwd, Double money, String ctime) {
        this.uname = uname;
        this.pwd = pwd;
        this.money = money;
        this.ctime = ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCtime() {
        return ctime;
    }
}
