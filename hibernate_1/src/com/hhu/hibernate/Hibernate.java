package com.hhu.hibernate;

import java.util.Date;

/**
 * Created by WeiguoLiu on 2018/3/1.
 */
public class Hibernate {
    private Integer id;
    private String name;
    private String version;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Hibernate(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public Hibernate() {

    }

    @Override
    public String toString() {
        return "Hibernate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", date=" + date +
                '}';
    }
}
