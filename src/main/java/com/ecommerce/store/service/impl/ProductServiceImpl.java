package com.ecommerce.store.service.impl;

import com.ecommerce.store.model.Product;
import com.ecommerce.store.repository.ProductRepository;
import com.ecommerce.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product find(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findList(List<Long> ids) {
        return (List<Product>) productRepository.findAllById(ids);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
