package com.techstore.controller.product;

import com.techstore.model.product.Product;
import com.techstore.service.ICategoriesService.ICategoriesService;
import com.techstore.service.IProductService.IManufacturerService;
import com.techstore.service.IProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("")
    public ModelAndView showProductList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String name, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("product/listProduct");
        pageable = PageRequest.of(page, 10, Sort.by("initialDate","nameProduct"));
        modelAndView.addObject("productList", productService.findAllByName(name, pageable));
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= productService.findAllByName(name, pageable).getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        modelAndView.addObject("pageNumberList", pageNumberList);
        modelAndView.addObject("pageCurrent", page);
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
    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdateProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("product/createProduct");
        modelAndView.addObject("product", productService.findById(id));
        modelAndView.addObject("categories", categoriesService.findAll());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        return modelAndView;
    }
}
