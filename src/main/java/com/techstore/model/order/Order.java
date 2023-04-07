package com.techstore.model.order;

import com.techstore.model.customer.Customer;
import com.techstore.model.employee.Employee;
import com.techstore.model.general.InitialDate;
import com.techstore.model.product.Product;
import com.techstore.model.voucher.Voucher;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "date")
    private Date dateOrder;
    @Column(columnDefinition = "int")
    private int amountOrder;
    @Column(columnDefinition = "varchar(255)")
    private String destination;
    @Column(columnDefinition = "tinyint")
    private int statusOrder;
    @ManyToMany
    private List<Product> products;
    @OneToOne
    private Employee employee;
    @OneToOne
    private Customer customer;
    @ManyToMany
    private List<Voucher> voucher;
    @Embedded
    private InitialDate initialDate;

    public Order() {
        initialDate = new InitialDate();
    }

    public Order(int id, Date dateOrder, int amountOrder, String destination, int statusOrder, List<Product> products, Employee employee, Customer customer, List<Voucher> voucher, InitialDate initialDate) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.amountOrder = amountOrder;
        this.destination = destination;
        this.statusOrder = statusOrder;
        this.products = products;
        this.employee = employee;
        this.customer = customer;
        this.voucher = voucher;
        this.initialDate = initialDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(int amountOrder) {
        this.amountOrder = amountOrder;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Voucher> getVoucher() {
        return voucher;
    }

    public void setVoucher(List<Voucher> voucher) {
        this.voucher = voucher;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(InitialDate initialDate) {
        this.initialDate = initialDate;
    }
}
