package com.anik_wq.SpringWebApp.service;

import com.anik_wq.SpringWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Mobile", 10000),
            new Product(102, "Camera", 50000),
            new Product(103, "Laptop", 100000)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductsById (int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(1, "No Item", 0));
    }

    public void addProduct (Product prod) {
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        products.stream().forEach(p -> {
            if (p.getProdId() == prod.getProdId()) {
                p.setProdName(prod.getProdName());
                p.setPrice(prod.getPrice());
            }
        });
    }

    public void deleteProductById(int prodId) {
        products = products.stream()
                .filter(p -> p.getProdId() != prodId)
                .collect(Collectors.toCollection(ArrayList::new))

        ;
    }

}
