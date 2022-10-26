package com.edu.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id //设置StuId为主键
    @GeneratedValue(strategy = GenerationType.AUTO)  //设置递增规则
    private Long StuId;
    private String Name;
    private String Password;
    private Integer Age;
    //学生和爱好为一对多的关系
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    // mappedBy = "student" 形成双向关系，避免生成中间表
    // cascade = CascadeType.ALL 包含所有持久化操作
    // fetch = FetchType.LAZY 表示关系类在被访问时才加载
    // 学生有多个爱好，故采取泛型
    public List<Hobby> HobbyList;

    public List<Hobby> getHobbyList() {
        return HobbyList;
    }

    public void setHobbyList(List<Hobby> HobbyList) {
        this.HobbyList = HobbyList;
    }

    public Long getStuId() {
        return StuId;
    }

    public void setStuId(Long stuId) {
        StuId = stuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
