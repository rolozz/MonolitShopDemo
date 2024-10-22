package com.java.project.shop.services.impl;

import com.java.project.shop.entities.Order;
import com.java.project.shop.repositories.OrderRepository;
import com.java.project.shop.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional
    public Order save(Order order) {
        redisTemplate.opsForValue().set(order.getClient().getUsername(), order);
        return orderRepository.save(order);
    }

}
