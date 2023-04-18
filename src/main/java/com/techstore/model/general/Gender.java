package com.techstore.model.general;

import javax.persistence.*;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String nameGender;

    public Gender() {
    }

    public Gender(int id, String nameGender) {
        this.id = id;
        this.nameGender = nameGender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
