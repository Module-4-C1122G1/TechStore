package com.techstore.model.customer;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(columnDefinition = "varchar(255)")
    private String nameCustomer;
    @NotBlank
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @NotBlank
    @Column(columnDefinition = "varchar(100)")
    private String phoneNumber;
    @NotNull
    @Column(columnDefinition = "date")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private Date dateOfBirth    ;
    @ManyToOne
    @JoinColumn(name = "type_id")
    @NotNull
    private TypeCustomer typeCustomer;

    public Customer() {
    }

    public Customer(int id, String nameCustomer, String address, String phoneNumber, Date dateOfBirth, TypeCustomer typeCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.typeCustomer = typeCustomer;
    }

    public Customer(String nameCustomer, String address, String phoneNumber, Date dateOfBirth, TypeCustomer typeCustomer) {
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.typeCustomer = typeCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
