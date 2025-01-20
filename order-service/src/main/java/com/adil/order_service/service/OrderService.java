package com.adil.order_service.service;

import com.adil.order_service.dto.OrderLineItemsDto;
import com.adil.order_service.dto.OrderRequest;
import com.adil.order_service.model.Order;
import com.adil.order_service.model.OrderLineItems;
import com.adil.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

  private final OrderRepository orderRepository;


    @Override
    public void placeOrder(OrderRequest orderRequest) {
       Order order=new Order();
       order.setOrderNumber(UUID.randomUUID().toString());
        // Check if the orderLineItemsDtoList is null or empty
        List<OrderLineItems> orderLineItemsList = (orderRequest.getOrderLineItemsDtoList() != null)
                ? orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList()
                : new ArrayList<>();
        order.setOrderLineItemsList(orderLineItemsList);
     orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems=new OrderLineItems();
    orderLineItems.setPrice(orderLineItems.getPrice());
    orderLineItems.setQuantity(orderLineItems.getQuantity());
    orderLineItems.setSkuCode(orderLineItems.getSkuCode());
    return orderLineItems;
    }
}
