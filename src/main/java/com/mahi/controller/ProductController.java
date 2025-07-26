package com.mahi.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahi.binding.Product;

@Controller
public class ProductController {

    @GetMapping("/")
    public String loadForm(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/product")
    public String handleSubmitBtn(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index"; // re-show form with validation messages
        }

        System.out.println(product);
        model.addAttribute("msg", "Product Saved Successfully");
        model.addAttribute("product", new Product()); // reset the form
        return "index";
    }
}
