package com.helpstudents.service;

import com.helpstudents.domain.OrderDTO;
import com.helpstudents.entity.OrderEntity;
import com.helpstudents.repository.OrderRepository;
import com.helpstudents.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ObjectMapperUtils objectMapperUtils;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderDTO.setDateCreate(LocalDateTime.now());
        OrderEntity orderEntity = objectMapperUtils.map(orderDTO, OrderEntity.class);
        orderRepository.save(orderEntity);
        return orderDTO;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        OrderDTO orderDTO = objectMapperUtils.map(orderEntity,OrderDTO.class);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getAllOrdersForCustomerId(Long customerId) {
        List<OrderEntity> orderEntities = orderRepository.findAllByCustomerEntityId(customerId);
        List<OrderDTO> orderDTOS = objectMapperUtils.mapAll(orderEntities,OrderDTO.class);
        return orderDTOS;
    }
}
