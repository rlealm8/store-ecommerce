package com.ecommerce.store.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ItemProductRequest {

    private Long id;

    private Integer quantity;

    private Long productId;
}
