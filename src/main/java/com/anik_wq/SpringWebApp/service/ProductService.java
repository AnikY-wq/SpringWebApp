package com.anik_wq.SpringWebApp.service;

import com.anik_wq.SpringWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101, "iPhone", 50000),
            new Product(102, "DSLR Camera", 70000),
            new Product(103, "Shire Mic", 10000)
            );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductsById (int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(1, "No Item", 0));
    }


}
