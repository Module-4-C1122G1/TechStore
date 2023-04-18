package com.techstore.model.voucher;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class TypeVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    private String typeVoucher;

    public TypeVoucher() {
    }

    public TypeVoucher(Integer id, String typeVoucher) {
        this.id = id;
        this.typeVoucher = typeVoucher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }
}
