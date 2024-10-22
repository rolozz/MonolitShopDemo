package com.java.project.shop.services.impl;

import com.java.project.shop.entities.Deal;
import com.java.project.shop.entities.Product;
import com.java.project.shop.repositories.DealRepository;
import com.java.project.shop.services.DealService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    DealRepository dealRepository;
    RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional
    public Deal makeDeal(Deal deal) throws Exception {
        final Double totalPrice = deal.getOrder()
                .getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        if (Math.abs(deal.getAmount() - totalPrice) < 0.0001) {
            deal.getOrder().setIsPaid(true);
            redisTemplate.opsForValue().set(deal.getOrder().getClient().getUsername(), deal);
            return dealRepository.save(deal);
        } else throw new Exception("не верная сумма");
    }

}
