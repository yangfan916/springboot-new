package com.yf.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {

    private Integer id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "日期不能为空")
    private Date date;

    public User(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
