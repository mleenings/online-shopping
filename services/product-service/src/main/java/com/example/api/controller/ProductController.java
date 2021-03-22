package com.example.api.controller;

import com.example.api.controller.data.ProductDTO;
import com.example.api.model.Product;
import com.example.api.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO request) {
        log.debug("POST /products");
        log.debug("request: {}", request);
        return productResponse(service.saveProduct(request.toProduct()));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        log.debug("GET /products");
        return productResponse(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        log.debug("GET /products/{}", id);
        return productResponse(service.getProductById(id));
    }

    private static ResponseEntity<ProductDTO> productResponse(Optional<Product> product) {
        return product.map(p -> ResponseEntity.ok(Objects.requireNonNull(ProductDTO.of(p)))).orElseGet(() -> ResponseEntity.ok(new ProductDTO()));
    }

    private static ResponseEntity<ProductDTO> productResponse(final Product product){
        return ResponseEntity.ok(Objects.requireNonNull(ProductDTO.of(product)));
    }

    private static ResponseEntity<List<ProductDTO>> productResponse(final List<Product> products){
        if(CollectionUtils.isEmpty(products)){
            return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(products.stream()
                    .map(ProductDTO::of)
                    .collect(Collectors.toList()));
        }
    }
}
