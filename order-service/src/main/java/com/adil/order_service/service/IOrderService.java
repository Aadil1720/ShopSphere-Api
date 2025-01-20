package com.adil.order_service.service;

import com.adil.order_service.dto.OrderRequest;
import com.adil.order_service.model.Order;

import java.util.List;

public interface IOrderService {
    void placeOrder(OrderRequest orderRequest);
}
