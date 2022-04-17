package com.phantom;

import com.phantom.DAO.*;
import com.phantom.config.DbConfig;
import com.phantom.config.HibernateConfig;
import com.phantom.entity.Manufacturer;
import com.phantom.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);
//        ManufacturerDAO manufacturerDAO = new ManufacturerDAOImpl_JDBC();
        ManufacturerDAO manufacturerDAO = context.getBean(ManufacturerDAO.class);
//        System.out.println(manufacturerDAO.findNameById(2L));
//        for (Manufacturer manufacturer : manufacturerDAO.findAll()) {
//            System.out.println(manufacturer);
//
//        }
        System.out.println(manufacturerDAO.findById(3l));

//        ProductDAO products = new ProductDAOImpl();
//        for (Product product : products.findAll()) {
//            System.out.println(product);
//        }
//        ProductDAO products = context.getBean(ProductDAO.class);
//                for (Product product : products.findAll()) {
//            System.out.println(product);
//        }

    }
}
