package com.phantom.DAO;

import com.phantom.entity.Manufacturer;


public interface ManufacturerDAO {
    Iterable<Manufacturer> findAll();
    String findNameById(Long id);
    Manufacturer findById(Long id);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
