package com.techstore.dto;

import com.techstore.model.voucher.TypeVoucher;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UpdateVoucherDTO implements Validator {

    private Integer id;
    @NotBlank(message = "Tên không được để trống!")
    private String nameVoucher;
    @NotBlank(message = "ngày hết hạn không được bỏ trống!")
    private String expiredDate;
    @NotNull(message = "Phải nhập số lượng")
    @Min(value = 0, message = "Số lượng phải lớn hơn 0")
    private Double amountVoucher;
    @NotNull(message = "Phải có phần trăm giảm giá")
    @Min(value = 0, message = "phần trăm giảm giá phải lớn hơn 0")
    @Max(value = 100, message = "phần trăm giảm giá phải nhỏ hơn 101")
    private Double percentDiscount;
    private Boolean isExpired;
    private TypeVoucher typeVoucher;

    public UpdateVoucherDTO() {
    }

    public UpdateVoucherDTO(Integer id, String nameVoucher, String expiredDate,
                            Double amountVoucher, Double percentDiscount, Boolean isExpired,
                            TypeVoucher typeVoucher) {
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

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
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

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
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
        UpdateVoucherDTO updateVoucherDTO = (UpdateVoucherDTO) target;
        if (!updateVoucherDTO.nameVoucher.matches("^(([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸ.,ẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\s\\'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉị.,ọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉ.,ịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]))*$")) {
            errors.rejectValue("nameVoucher", "", "Tên không được chứa kí tự đặc biệt @;,.=+");
        }
        if (!updateVoucherDTO.expiredDate.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$\n")) {
            int total = Period.between(LocalDate.parse(updateVoucherDTO.getExpiredDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()).getDays();
            if (total > 0) {
                errors.rejectValue("expiredDate", "", "ngày hết hạn phải lớn hơn ngày hiện tại!!!!!!!");
            }
        }
    }
}
