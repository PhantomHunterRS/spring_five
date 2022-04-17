package com.phantom.DAO;

import com.phantom.entity.Manufacturer;
import com.phantom.entity.Product;

import java.sql.*;
import java.util.HashSet;

import java.util.Set;



public class ProductDAOImpl implements ProductDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "geek","geek");
    }
    private void closeConnection(Connection connection){
        if (connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Iterable<Product> findAll() {
        Set<Product> products = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .build();

                products.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
        }finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
