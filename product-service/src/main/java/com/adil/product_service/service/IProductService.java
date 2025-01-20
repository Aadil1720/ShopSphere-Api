package com.adil.product_service.service;

import com.adil.product_service.dto.ProductRequest;
import com.adil.product_service.dto.ProductResponse;
import java.util.List;

public interface IProductService {
 ProductResponse createProduct(ProductRequest request);
 List<ProductResponse> getAllProducts();
}
