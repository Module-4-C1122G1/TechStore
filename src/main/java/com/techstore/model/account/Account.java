package com.techstore.model.account;

import com.techstore.model.customer.Customer;
import com.techstore.model.employee.Employee;
import com.techstore.model.general.InitialDate;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Tên tài khoản không được để trống")
    @Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", message = "Tên tài khoản bắt buộc là email")
    @Column(columnDefinition = "varchar(100)", unique = true)
    private String userName;
    @Pattern(regexp = "[a-zA-Z0-9]{6,}", message = "Mật khẩu bắt buộc 6 kí tự trở lên")
    @Column(length = 128, nullable = false)
    private String password;
    @Embedded
    private InitialDate initialDate;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Employee employee;

    public Account() {
        initialDate = new InitialDate();
    }

    public Account(int id, String userName, String password, InitialDate initialDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.initialDate = initialDate;
    }

    public Account(int id, String userName, String password, InitialDate initialDate, Customer customer, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.initialDate = initialDate;
        this.customer = customer;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(InitialDate initialDate) {
        this.initialDate = initialDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
