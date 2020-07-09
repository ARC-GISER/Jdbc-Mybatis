package org.service;

import java.util.Set;

public interface CartService {

    /**
     * @param customerId void
     * @Description: 添加购物车
     * @author lc
     */
    public void add(String customerId);

    /**
     * @param customerId
     * @return Set<String>
     * @Description: 获取购物车数据
     * @author lc
     */
    public Set<String> getCart(String customerId);

}
