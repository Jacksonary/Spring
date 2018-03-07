package com.hhu.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by WeiguoLiu on 2018/3/5.
 */
@Entity
@Table(name = "hibernate", schema = "db_studentinfo", catalog = "")
public class HibernateEntity {
    private int id;
    private String name;
    private String version;



    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "VERSION", nullable = true, length = 255)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "HibernateEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HibernateEntity that = (HibernateEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, version);
    }
}
