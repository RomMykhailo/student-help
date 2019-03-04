package com.helpstudents.service;

import com.helpstudents.domain.OrderDTO;

public interface OrderService {

    OrderDTO createOrder (OrderDTO orderDTO);
    OrderDTO getOrderById (Long id);

}
