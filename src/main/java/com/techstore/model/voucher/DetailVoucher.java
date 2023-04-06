package com.techstore.model.voucher;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DetailVoucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    private Voucher voucher;
    @Column(columnDefinition = "varchar(255)")
    private String nameVoucher;
    @Column(columnDefinition = "date")
    private Date expiredDate;
    private int percentDiscount;
    @Column(columnDefinition = "tinyint")
    private int isExpired;
    @ManyToOne
    private TypeVoucher typeVoucher;
    public DetailVoucher() {
    }

    public DetailVoucher(Voucher voucher, String nameVoucher, Date expiredDate, int percentDiscount, int isExpired, TypeVoucher typeVoucher) {
        this.voucher = voucher;
        this.nameVoucher = nameVoucher;
        this.expiredDate = expiredDate;
        this.percentDiscount = percentDiscount;
        this.isExpired = isExpired;
        this.typeVoucher = typeVoucher;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
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

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(int isExpired) {
        this.isExpired = isExpired;
    }

    public TypeVoucher getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(TypeVoucher typeVoucher) {
        this.typeVoucher = typeVoucher;
    }
}
