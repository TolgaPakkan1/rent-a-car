package com.example.RentACar.controller;

import com.example.RentACar.dto.OrderRequest;
import com.example.RentACar.model.Order;
import com.example.RentACar.repository.OrderRepository;
import com.example.RentACar.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> doOrder(@RequestBody OrderRequest orderRequest){

        Order savedOrder = orderService.doOrder(orderRequest.getUserId(),
                                                orderRequest.getCarId(),
                                                orderRequest.getRentDay(),
                                                orderRequest.getDeliveryDay());
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

    }
}
