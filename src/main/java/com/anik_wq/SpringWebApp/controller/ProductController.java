package com.anik_wq.SpringWebApp.controller;

import com.anik_wq.SpringWebApp.model.Product;
import com.anik_wq.SpringWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductsById(prodId);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
        return "Product added into Products List";
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
        return "Products list updated";
    }

    @DeleteMapping("/products/{prodId}")
    public String deleteProductById(@PathVariable int prodId) {
        service.deleteProductById(prodId);
        return "Product " + prodId + " removed from the list.";
    }
}
