package com.edu.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private Long CourseId;
    private String Name;
    private Integer Credit;
    public Long getCourseId() {
        return CourseId;
    }

    public void setCourseId(Long courseId) {
        CourseId = courseId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCredit() {
        return Credit;
    }

    public void setCredit(Integer credit) {
        Credit = credit;
    }
}
