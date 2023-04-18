package com.techstore.model.order;

import com.techstore.model.product.Product;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
    private int amountProduct;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int amountProduct) {
        this.order = order;
        this.product = product;
        this.amountProduct = amountProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }
}
