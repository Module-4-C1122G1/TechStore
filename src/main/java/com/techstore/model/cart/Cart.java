package com.techstore.model.cart;

import com.techstore.model.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {

    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (product.getId() == entry.getKey().getId()) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> item = selectItemInCart(product);
            products.put(item.getKey(), item.getValue() + 1);
        }
    }

    public Integer countTotalProductQuantity() {
        Integer productsQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productsQuantity += entry.getValue();
        }
        return productsQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Double countTotalPayment() {
        Double payment = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += Long.parseLong(entry.getKey().getPrice()) * entry.getValue();
        }
        return payment;
    }
}
