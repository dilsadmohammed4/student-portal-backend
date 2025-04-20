package com.student.portal.entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String email;
    @Column(unique = true)
    private String RollNo;
    private String mil;
    private String english;
    private String physics;
    private String chemistry;
    private String biology;
    private String mathematics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getMil() {
        return mil;
    }

    public void setMil(String mil) {
        this.mil = mil;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public String getMathematics() {
        return mathematics;
    }

    public void setMathematics(String mathematics) {
        this.mathematics = mathematics;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", RollNo='" + RollNo + '\'' +
                ", mil='" + mil + '\'' +
                ", english='" + english + '\'' +
                ", physics='" + physics + '\'' +
                ", chemistry='" + chemistry + '\'' +
                ", biology='" + biology + '\'' +
                ", mathematics='" + mathematics + '\'' +
                '}';
    }
}
