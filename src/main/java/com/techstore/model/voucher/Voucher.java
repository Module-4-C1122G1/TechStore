package com.techstore.model.voucher;

import javax.persistence.*;

@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "int")
    private int amountVoucher;

    public Voucher() {
    }

    public Voucher(int id, int amountVoucher) {
        this.id = id;
        this.amountVoucher = amountVoucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountVoucher() {
        return amountVoucher;
    }

    public void setAmountVoucher(int amountVoucher) {
        this.amountVoucher = amountVoucher;
    }
}
