package com.ecommerce.store.dto;

import com.ecommerce.store.model.Cart;
import com.ecommerce.store.model.ItemProduct;
import com.ecommerce.store.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CartRequest {

    Long id;

    @JsonProperty("items")
    List<ItemProductRequest> itemProductRequests;

    public Cart toDomain(){
        return Cart.builder()
                .id(id)
                .itemProducts(itemProductRequests.stream().map(item ->
                        ItemProduct.builder()
                                .id(item.getId())
                                .producto(Product.builder().id(item.getProductId()).build())
                                .quantity(item.getQuantity())
                                .build()).collect(Collectors.toList()))
                .build();
    }
}
