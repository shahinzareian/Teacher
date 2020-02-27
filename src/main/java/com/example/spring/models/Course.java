package com.example.spring.models;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ManyToOne
    Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
