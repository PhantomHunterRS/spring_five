package com.phantom.DAO;

import com.phantom.entity.Manufacturer;

import java.util.Iterator;

public interface ManufacturerDAO {
    Iterator<Manufacturer> fildAll();
    Manufacturer findById(Long id);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
