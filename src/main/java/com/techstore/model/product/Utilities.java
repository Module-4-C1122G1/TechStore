package com.techstore.model.product;

import javax.persistence.*;

@Entity
public class Utilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String nameUtilities;

    public Utilities() {
    }

    public Utilities(int id, String nameUtilities) {
        this.id = id;
        this.nameUtilities = nameUtilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUtilities() {
        return nameUtilities;
    }

    public void setNameUtilities(String nameUtilities) {
        this.nameUtilities = nameUtilities;
    }
}
