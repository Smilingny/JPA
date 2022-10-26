package com.edu.Entity;

import javax.persistence.*;

@Entity
public class Hobby {
    @Id // 设置HobbyId为主键
    @GeneratedValue(strategy = GenerationType.AUTO)  // 设置主键自增规则
    private Long HobbyId;
    private String Name;
    //爱 好与学生是多对一的关系
    @ManyToOne(cascade = CascadeType.ALL)
    // 设置外键
    @JoinColumn(name = "StuId")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getHobbyId() {
        return HobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        HobbyId = hobbyId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
