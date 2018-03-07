package com.hhu.hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by WeiguoLiu on 2018/3/1.
 */
@Entity
@Table(name = "t_grade", schema = "db_studentinfo", catalog = "")
public class TGradeEntity {
    private int id;
    private String gradeName;
    private String gradeDesc;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gradeName")
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Basic
    @Column(name = "gradeDesc")
    public String getGradeDesc() {
        return gradeDesc;
    }

    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TGradeEntity that = (TGradeEntity) o;
        return id == that.id &&
                Objects.equals(gradeName, that.gradeName) &&
                Objects.equals(gradeDesc, that.gradeDesc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gradeName, gradeDesc);
    }
}
