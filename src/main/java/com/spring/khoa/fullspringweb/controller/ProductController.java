package com.spring.khoa.fullspringweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.khoa.fullspringweb.model.Product;
import com.spring.khoa.fullspringweb.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;

    // display list of product
    @RequestMapping(method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        model.addAttribute("listProduct", productService.getAllProduct());
        return "index";
    }

    @GetMapping("/showNewProductForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveEmployee(@ModelAttribute("product") Product product) {
        // save product to database
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get product from the service
        Product product = productService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {

        // call delete employee method
        this.productService.deleteProductById(id);
        return "redirect:/";
    }

}
