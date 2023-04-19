package com.techstore.model.customer;

import javax.persistence.*;

@Entity
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;
    @Column(columnDefinition = "varchar(255)")
    private String nameTypeCustomer;

    public TypeCustomer() {
    }

    public TypeCustomer(int typeID, String nameTypeCustomer) {
        this.typeID = typeID;
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }
}
