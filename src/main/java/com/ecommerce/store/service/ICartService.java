package com.ecommerce.store.service;

import com.ecommerce.store.model.Cart;


public interface ICartService {

    Cart save(Cart cart);

    Cart find(Long cartId);

    void delete(Long cartId);

    void deleteAll();

}
