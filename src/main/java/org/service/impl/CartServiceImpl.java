package org.service.impl;

import org.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisService redisService;
    @Override
    public void add(String customerId) {
        redisService.addSortSet("rmd_cart_test123", customerId);
    }

    @Override
    public Set<String> getCart(String customerId) {
        return null;
    }
}
