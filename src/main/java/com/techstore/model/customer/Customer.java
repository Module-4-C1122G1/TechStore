package com.techstore.model.customer;

import com.techstore.model.account.Account;
import com.techstore.model.general.Gender;
import com.techstore.model.general.InitialDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String nameCustomer;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(columnDefinition = "varchar(100)")
    private String phoneNumber;
    @Column(columnDefinition = "date")
    private Date dateOfBirth;
    @ManyToOne
    private TypeCustomer typeCustomer;
    @ManyToOne
    private Gender gender;
    @OneToOne
    private Account account;
    @Embedded
    private InitialDate initialDate;

    public Customer() {
        initialDate = new InitialDate();
    }

    public Customer(int id, String nameCustomer, String address, String phoneNumber, Date dateOfBirth, TypeCustomer typeCustomer, Gender gender, Account account, InitialDate initialDate) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.typeCustomer = typeCustomer;
        this.gender = gender;
        this.account = account;
        this.initialDate = initialDate;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(InitialDate initialDate) {
        this.initialDate = initialDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
