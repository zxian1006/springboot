package com.zx.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * Created by Credittone on 2017/4/10.
 */
@Entity
@NamedQuery(name="Person.withNameAndAddressNamedQuery",query="select p from Person p where p.name=?1 and address=?2")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person(){
        super();
    }

    public Person(Long id, String name, Integer age , String address){
        super();
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
