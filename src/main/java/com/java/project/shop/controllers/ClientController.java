package com.java.project.shop.controllers;

import com.java.project.shop.entities.Deal;
import com.java.project.shop.entities.Order;
import com.java.project.shop.services.DealService;
import com.java.project.shop.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ClientController {

    OrderService orderService;
    DealService dealService;

    @PostMapping("client/create")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.save(order));
    }

    @PostMapping("client/deal")
    public ResponseEntity<Deal> saveDeal(@RequestBody Deal deal) throws Exception {
        return ResponseEntity.ok(dealService.makeDeal(deal));
    }

}
