package com.techstore.model.categories;

import javax.persistence.*;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String nameCategories;

    public Categories() {
    }

    public Categories(int id, String nameCategories) {
        this.id = id;
        this.nameCategories = nameCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }
}
