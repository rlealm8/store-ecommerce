package com.ecommerce.store.controller;

import com.ecommerce.store.dto.CartRequest;
import com.ecommerce.store.model.Cart;
import com.ecommerce.store.service.ICartService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/cart")
public class CartController {

    private static final String CONSTANT_CART_ID = "/{cartId}";

    @Autowired
    ICartService iCartService;

    @GetMapping(CONSTANT_CART_ID)
    @SneakyThrows
    public ResponseEntity<Cart> find(@PathVariable Long cartId) {
        return ResponseEntity.status(HttpStatus.OK).body(iCartService.find(cartId));
    }

    @PostMapping()
    @SneakyThrows
    public ResponseEntity<Cart> save(@RequestBody CartRequest cartRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(iCartService.save(cartRequest.toDomain()));
    }

    @PutMapping()
    @SneakyThrows
    public ResponseEntity<Cart> update(@RequestBody CartRequest cartRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(iCartService.save(cartRequest.toDomain()));
    }

    @DeleteMapping(CONSTANT_CART_ID)
    @SneakyThrows
    public void delete(@PathVariable Long cartId) {
        iCartService.delete(cartId);
    }

}
