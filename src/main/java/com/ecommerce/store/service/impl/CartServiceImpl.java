package com.ecommerce.store.service.impl;

import com.ecommerce.store.model.Cart;
import com.ecommerce.store.repository.CartRepository;
import com.ecommerce.store.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CartServiceImpl implements ICartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        log.info("Save cart {}", cart);
        return cartRepository.save(cart);
    }

    @Override
    public Cart find(Long cartId) {
        log.info("Find cart id {}", cartId);
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public void delete(Long cartId) {
        log.info("Delete cart id {}", cartId);
        cartRepository.deleteById(cartId);
    }

    @Override
    public void deleteAll() {
        log.info("Delete all cart");
        cartRepository.deleteAll();
    }

}
