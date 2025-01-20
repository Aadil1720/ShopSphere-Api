package com.adil.product_service.service;

import com.adil.product_service.dto.ProductRequest;
import com.adil.product_service.dto.ProductResponse;
import com.adil.product_service.exceptions.AlreadyExistExceptions;
import com.adil.product_service.mapper.ProductMapper;
import com.adil.product_service.model.Product;
import com.adil.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductMapper mapper;
    private final ProductRepository productRepository;


    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Optional<Product> existingProduct = productRepository.findByName(request
                .getName());
        if (existingProduct.isPresent()) {
            log.error("Product with name {} already exists", request.getName());
            throw new AlreadyExistExceptions("Product with the same name already exists");
        }

        Product product = mapper.productRequestDTOToProduct(request);

        Product savedProduct = productRepository.save(product);
        log.info("Product with id {} is saved", savedProduct.getId());

        return mapper.productToProductResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
       return  productRepository.findAll().stream()
                .map(mapper::productToProductResponse)
                 .collect(Collectors.toList());
    }

}
