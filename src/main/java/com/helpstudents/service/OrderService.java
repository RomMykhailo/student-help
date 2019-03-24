package com.helpstudents.service;

import com.helpstudents.domain.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder (OrderDTO orderDTO);
    OrderDTO getOrderById (Long id);
    List<OrderDTO> getAllOrdersForCustomerId (Long customerId);

}
