package com.ecommerce.store.service;

import com.ecommerce.store.model.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);

    Product find(Long id);

    List<Product> findList(List<Long> ids);
    
    void delete(Long id);
    
}
