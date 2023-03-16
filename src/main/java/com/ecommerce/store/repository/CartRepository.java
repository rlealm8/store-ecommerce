package com.ecommerce.store.repository;

import com.ecommerce.store.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
