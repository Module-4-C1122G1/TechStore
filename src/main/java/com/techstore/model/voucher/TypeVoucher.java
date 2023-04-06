package com.techstore.model.voucher;

import javax.persistence.*;

@Entity
public class TypeVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255)")
    private String typeVoucher;

    public TypeVoucher() {
    }

    public TypeVoucher(int id, String typeVoucher) {
        this.id = id;
        this.typeVoucher = typeVoucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }
}
