package com.example.jedis.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String name;
    private Long salary;

    public User(String id, String name, Long l) {
        this.id= id;
        this.name= name;
        this.salary=l;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}