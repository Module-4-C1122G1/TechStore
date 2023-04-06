package com.techstore.model.customer;

import javax.persistence.*;

@Entity
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String nameTypeCustomer;

    public TypeCustomer() {
    }

    public TypeCustomer(int id, String nameTypeCustomer) {
        this.id = id;
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }
}
