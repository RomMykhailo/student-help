package com.helpstudents.controller;

import com.helpstudents.domain.OrderDTO;
import com.helpstudents.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @PostMapping("/add")
    public ResponseEntity<?> addOrder (@Valid @RequestBody OrderDTO orderDTO){
       OrderDTO orderDTO1 = orderService.createOrder(orderDTO);
       return new ResponseEntity<>(orderDTO1,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER, ROLE_ADMIN, ROLE_WORKER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        OrderDTO orderDTO = orderService.getOrderById(id);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    @GetMapping("/getAllforcustomer/{id}")
    public ResponseEntity<?> getAllOrdersForCustomerId(@PathVariable Long customerId){
        List<OrderDTO> orderDTOS = orderService.getAllOrdersForCustomerId(customerId);
        return new ResponseEntity<>(orderDTOS,HttpStatus.OK);
    }


}
