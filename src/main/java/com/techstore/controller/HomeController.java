package com.techstore.controller;

import com.techstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IProductService productService;

    @GetMapping({"", "/product"})
    public ModelAndView showHomePage(@RequestParam(defaultValue = "1") int categories, @RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        pageable = PageRequest.of(page, 12);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("pageCurrent", page);
        modelAndView.addObject("productList", productService.findAllProductById(categories, pageable));
        return modelAndView;
    }

    @GetMapping("/product/manufacturer/{id}")
    public ModelAndView showProductListByManufacturer(@PathVariable int id, @RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        pageable = PageRequest.of(page, 12);
        modelAndView.addObject("manufacturer", id);
        modelAndView.addObject("pageCurrent", page);
        modelAndView.addObject("productList", productService.findProductsByManufacturerId(id, pageable));
        return modelAndView;
    }
}
