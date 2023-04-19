package com.techstore.model.voucher;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    private String nameVoucher;
    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiredDate;
    @Column(columnDefinition = "int")
    private Double amountVoucher;

    private Double percentDiscount;
    @Column(columnDefinition = "bit")
    private boolean isExpired = true;
    @ManyToOne
    private TypeVoucher typeVoucher;

    public Voucher() {
    }

    public Voucher(Integer id, String nameVoucher, Date expiredDate, Double amountVoucher,
                   Double percentDiscount, boolean isExpired, TypeVoucher typeVoucher) {
        this.id = id;
        this.nameVoucher = nameVoucher;
        this.expiredDate = expiredDate;
        this.amountVoucher = amountVoucher;
        this.percentDiscount = percentDiscount;
        this.isExpired = isExpired;
        this.typeVoucher = typeVoucher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameVoucher() {
        return nameVoucher;
    }

    public void setNameVoucher(String nameVoucher) {
        this.nameVoucher = nameVoucher;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Double getAmountVoucher() {
        return amountVoucher;
    }

    public void setAmountVoucher(Double amountVoucher) {
        this.amountVoucher = amountVoucher;
    }

    public Double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public TypeVoucher getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(TypeVoucher typeVoucher) {
        this.typeVoucher = typeVoucher;
    }
}

