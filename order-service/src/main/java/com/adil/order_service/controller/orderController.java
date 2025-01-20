package com.adil.order_service.controller;

import com.adil.order_service.dto.OrderRequest;
import com.adil.order_service.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class orderController {

    private final IOrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String  placeOrder(@RequestBody OrderRequest orderRequest){
         orderService.placeOrder(orderRequest);
        return "order placed successfully.";
    }

}
