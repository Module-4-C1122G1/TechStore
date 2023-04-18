package com.techstore.model.employee;

import com.techstore.model.account.Account;
import com.techstore.model.general.Gender;
import com.techstore.model.general.InitialDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String nameEmployee;
    @Column(columnDefinition = "varchar(100)")
    private String phoneNumber;
    @Column(columnDefinition = "date")
    private Date dateOfBirth;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @ManyToOne
    private Position position;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Gender gender;
    @OneToOne
    private Account account;
    @Embedded
    private InitialDate initialDate;

    public Employee() {
        initialDate = new InitialDate();
    }

    public Employee(int id, String nameEmployee, String phoneNumber, Date dateOfBirth, String address, Position position, Department department, Gender gender, Account account, InitialDate initialDate) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.position = position;
        this.department = department;
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

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
