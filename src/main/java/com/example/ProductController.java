package com.example;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class);
    private final List<Product> products = new ArrayList<>();

    @GetMapping("/products")
    public List<Product> getProducts() {
        logger.info("Fetching product list");
        return products;
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody @Valid Product product) {
        if (StringUtils.isBlank(product.getName())) {
            logger.warn("Attempted to add product with blank name");
            return "Product name cannot be blank";
        }
        products.add(product);
        logger.info("Product added successfully: " + product.getName());
        return "Product added successfully!";
    }

    @GetMapping("/product-names")
    public List<String> getProductNames() {
        logger.info("Fetching product names");
        return products.stream()
                .map(Product::getName) // Extract product names
                .collect(Collectors.toList());
    }
}
