package com.phantom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manufacturer {
    private Long id;
    private String name;
    private Set<Product> products;

    public boolean addProduct(Product product){
        if (products == null){
            products = new HashSet<>();
        }
        return products.add(product);
    }
}
