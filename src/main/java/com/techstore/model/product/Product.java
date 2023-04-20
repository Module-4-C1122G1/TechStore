package com.techstore.model.product;

import com.techstore.model.categories.Categories;
import com.techstore.model.general.InitialDate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không được để trống trường này")
    @Column(columnDefinition = "varchar(255)")
    private String nameProduct;
    @Column(columnDefinition = "text")
    private String image;
    @NotNull(message = "Không được để trống trường ngày")
    @Min(value = 1000, message = "Bắt buộc lớn hơn 1000 (vnd)")
    @Column(columnDefinition = "double")
    private Double price;
    @NotBlank(message = "Không được để trống trường ngày")
    @Column(columnDefinition = "varchar(255)")
    private String screenTechnology;
    @NotBlank(message = "Không được để trống trường ngày")
    @Column(columnDefinition = "varchar(255)")
    private String operatingSystem;
    @NotBlank(message = "Không được để trống trường ngày")
    @Column(columnDefinition = "varchar(255)")
    private String chip;

    @Column(columnDefinition = "double")
    private Double cpu_speed;
    @Min(value = 2, message = "Ram phải lớn hơn hoặc bằng 2GB")
    @Column(columnDefinition = "int")
    private Integer ram;
    @Min(value = 8, message = "Dung lượng phải lớn hơn hoặc bằng 8GB")
    @Column(columnDefinition = "int")
    private Integer capacity;
    @Min(value = 1, message = "Dung lượng pin phải lớn hơn 0")
    @Column(columnDefinition = "int")
    private Integer pin;
    @NotBlank(message = "Không được để trống trường này")
    @Column(columnDefinition = "varchar(255)")
    private String material;
    @Min(value = 0, message = "Khối lượng phải lớn hơn 0")
    @NotNull(message = "Không được để trống trường này")
    @Column(columnDefinition = "double")
    private Double weight;
    @Min(value = 1, message = "Kích thước phải lớn hơn 1")
    @NotNull(message = "Không được để trống trường này")
    @Column(columnDefinition = "double")
    private Double size;
    @Column(columnDefinition = "mediumtext")
    private String description;
    @NotBlank(message = "Không thể để trống trường này")
    @Column(columnDefinition = "date")
    private String timePublic;
    @ManyToOne(targetEntity = Manufacturer.class)
    private Manufacturer manufacturer;
    @ManyToMany
    private List<Utilities> utilities;
    @ManyToOne(targetEntity = Categories.class)
    private Categories categories;
    @Embedded
    private InitialDate initialDate;

    public Product() {
        initialDate = new InitialDate();
    }

    public Product(int id, String nameProduct, String image, Double price, String screenTechnology, String operatingSystem, String chip, Double cpu_speed, Integer ram, Integer capacity, Integer pin, String material, Double weight, Double size, String description, String timePublic, Manufacturer manufacturer, List<Utilities> utilities, Categories categories, InitialDate initialDate) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.image = image;
        this.price = price;
        this.screenTechnology = screenTechnology;
        this.operatingSystem = operatingSystem;
        this.chip = chip;
        this.cpu_speed = cpu_speed;
        this.ram = ram;
        this.capacity = capacity;
        this.pin = pin;
        this.material = material;
        this.weight = weight;
        this.size = size;
        this.description = description;
        this.timePublic = timePublic;
        this.manufacturer = manufacturer;
        this.utilities = utilities;
        this.categories = categories;
        this.initialDate = initialDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public Double getCpu_speed() {
        return cpu_speed;
    }

    public void setCpu_speed(Double cpu_speed) {
        this.cpu_speed = cpu_speed;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimePublic() {
        return timePublic;
    }

    public void setTimePublic(String timePublic) {
        this.timePublic = timePublic;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<Utilities> getUtilities() {
        return utilities;
    }

    public void setUtilities(List<Utilities> utilities) {
        this.utilities = utilities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public String getPrice2() {
        return new DecimalFormat("#").format(price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(InitialDate initialDate) {
        this.initialDate = initialDate;
    }
}
