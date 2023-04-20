package com.techstore.controller.product;

import com.techstore.model.product.Product;
import com.techstore.service.ICategoriesService.ICategoriesService;
import com.techstore.service.IProductService.IManufacturerService;
import com.techstore.service.IProductService.IProductService;
import com.techstore.service.IUploadFileService.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoriesService categoriesService;
    @Autowired
    private IManufacturerService manufacturerService;
    @Autowired
    private IUploadFileService uploadFileService;

    @GetMapping("")
    public ModelAndView showProductList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String search, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("product/listProduct");
        pageable = PageRequest.of(page, 10, Sort.by("initialDate", "id"));
        Page<Product> products = productService.findAllByName(search, pageable);
        if (products.getTotalElements() == 0) {
            modelAndView.addObject("emptyList", "Không có sản phẩm \'"+search+"\' nào được tìm thấy");
            modelAndView.addObject("searchValue", search);
        } else {
            modelAndView.addObject("productList", products);
            List<Integer> pageNumberList = new ArrayList<>();
            for (int i = 1; i <= productService.findAllByName(search, pageable).getTotalPages(); i++) {
                pageNumberList.add(i);
            }
            modelAndView.addObject("pageNumberList", pageNumberList);
            modelAndView.addObject("pageCurrent", page);
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateProduct() {
        ModelAndView modelAndView = new ModelAndView("product/createProduct");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categoriesService.findAll());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        return modelAndView;
    }

    @PostMapping("/create/save")
    public ModelAndView saveNewProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, @RequestParam(value = "file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors() || file.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("product/createProduct");
            modelAndView.addObject("product", product);
            modelAndView.addObject("categories", categoriesService.findAll());
            modelAndView.addObject("manufacturers", manufacturerService.findAll());
            if (file.isEmpty()) {
                modelAndView.addObject("fileEmpty", "Không được để trống trường này");
            }
            modelAndView.addObject("messageError", "Thêm mới sản phẩm thất bại.");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("product/createProduct");
        uploadFileService.uploadFile(file);
        product.setImage("/images/" + file.getOriginalFilename());
        productService.save(product);
        modelAndView.addObject("categories", categoriesService.findAll());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        modelAndView.addObject("messageSuccess", "Thêm mới "+product.getNameProduct()+" thành công.");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdateProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("product/updateProduct");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoriesService.findAll());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        modelAndView.addObject("categoryOfProduct", categoriesService.findCategoriesById(product.getCategories().getId()));
        modelAndView.addObject("manufacturerOfProduct", manufacturerService.findManufacturerById(product.getManufacturer().getId()));
        return modelAndView;
    }

    @PostMapping("/update/{id}/save")
    public ModelAndView saveProductUpdated(@Valid @ModelAttribute Product product, BindingResult bindingResult, @RequestParam(value = "file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors() || file.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("product/updateProduct");
            modelAndView.addObject("product", product);
            modelAndView.addObject("categories", categoriesService.findAll());
            modelAndView.addObject("manufacturers", manufacturerService.findAll());
            modelAndView.addObject("categoryOfProduct", categoriesService.findCategoriesById(product.getCategories().getId()));
            modelAndView.addObject("manufacturerOfProduct", manufacturerService.findManufacturerById(product.getManufacturer().getId()));
            if (file.isEmpty()) {
                modelAndView.addObject("fileEmpty", "Không được để trống trường này");
            }
            modelAndView.addObject("messageError", "Chỉnh sửa "+product.getNameProduct()+" thất bại.");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("product/updateProduct");
        uploadFileService.uploadFile(file);
        product.setImage("/images/" + file.getOriginalFilename());
        productService.save(product);
        modelAndView.addObject("categories", categoriesService.findAll());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        modelAndView.addObject("categoryOfProduct", categoriesService.findCategoriesById(product.getCategories().getId()));
        modelAndView.addObject("manufacturerOfProduct", manufacturerService.findManufacturerById(product.getManufacturer().getId()));
        modelAndView.addObject("messageSuccess", "Chỉnh sửa "+product.getNameProduct()+" thành công.");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.remove(id);
        return "redirect:/admin/product";
    }
}
