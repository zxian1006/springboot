package com.zx.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Credittone on 2017/4/11.
 */
@Entity
@Table(name="hunan_json")
public class Company {
    @Id
    @GeneratedValue
    private Integer id;
    private String company_name; //公司名
    private String code; //注册号
    private String body;

    public void setCode(String code) {
        this.code = code;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
