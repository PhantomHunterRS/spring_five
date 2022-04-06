package com.phantom.DAO;

import com.phantom.entity.Manufacturer;
import com.phantom.entity.Product;

import java.util.Iterator;

public interface ProductDAO {
    Iterator<Product> fildAll();
    Product findById(Long id);
    void insert(Product product);
    void update(Product product);
    void deleteById(Long id);
}
