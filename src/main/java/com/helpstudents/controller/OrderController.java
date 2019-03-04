package com.helpstudents.controller;

import com.helpstudents.domain.OrderDTO;
import com.helpstudents.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder (@Valid @RequestBody OrderDTO orderDTO){
       OrderDTO orderDTO1 = orderService.createOrder(orderDTO);
       return new ResponseEntity<>(orderDTO1,HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        OrderDTO orderDTO = orderService.getOrderById(id);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }


}
