package com.adil.product_service.mapper;

import com.adil.product_service.dto.ProductRequest;
import com.adil.product_service.dto.ProductResponse;
import com.adil.product_service.model.Product;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class ProductMapper {

    // Convert ProductRequestDTO to Product
    public Product productRequestDTOToProduct(ProductRequest productRequest) {
        return new Product(
                null,  // MongoDB will auto-generate the ID
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice()
        );

    }
    // Convert Product to ProductResponseDTO
    public ProductResponse productToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    // Convert ProductResponseDTO to Product
    public Product productResponseDTOToProduct(ProductResponse productResponse) {
        return new Product(
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getId(),
                productResponse.getPrice()
        );
    }
}
