package com.techstore.model.voucher;

import com.techstore.dto.VoucherDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Voucher implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    @NotBlank(message = "Tên không được để trống!")
    private String nameVoucher;
    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "ngày hết hạn không được bỏ trống!")
    private Date expiredDate;
    @Column(columnDefinition = "int")
    @NotNull(message = "Phải nhập số lượng")
    @Min(value = 0, message = "Số lượng phải lớn hơn 0")
    private Double amountVoucher;
    @NotNull(message = "Phải có phần trăm giảm giá")
    @Min(value = 0, message = "phần trăm giảm giá phải lớn hơn 0")
    @Max(value = 100, message = "phần trăm giảm giá phải nhỏ hơn 101")
    private Double percentDiscount;
    @Column(columnDefinition = "bit")
    private boolean isExpired;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Voucher voucher = (Voucher) target;
        if (!voucher.nameVoucher.matches("^(([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸ.,ẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\s\\'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉị.,ọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉ.,ịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]))*$")) {
            errors.rejectValue("nameVoucher", "", "Tên không được chứa kí tự đặc biệt @;,.=+");
        }
    }
}

