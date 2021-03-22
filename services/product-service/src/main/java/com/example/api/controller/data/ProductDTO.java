package com.example.api.controller.data;

import com.example.api.model.Product;
import lombok.*;

import java.util.Objects;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productId;
    private String productName;

    public Product toProduct(){
        return toProduct(this);
    }

    public static Product toProduct(ProductDTO productDTO){
        if(Objects.isNull(productDTO)){
            return null;
        }
        return Product.builder()
            .productId(productDTO.getProductId())
            .productName(productDTO.getProductName())
            .build();
    }

    public static ProductDTO of(Product product){
        if(Objects.isNull(product)){
            return null;
        }
        return new ProductDTO(product.getProductId(), product.getProductName());
    }
}
