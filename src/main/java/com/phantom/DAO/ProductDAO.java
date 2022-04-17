package com.phantom.DAO;

import com.phantom.entity.Product;


public interface ProductDAO {
    Iterable<Product> findAll();
    Product findById(Long id);
    void insert(Product product);
    void update(Product product);
    void deleteById(Long id);
}
