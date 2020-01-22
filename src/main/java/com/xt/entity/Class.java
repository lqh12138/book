package com.xt.entity;

public class Class {

    private Integer id;
    private String username;
    private String  descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
