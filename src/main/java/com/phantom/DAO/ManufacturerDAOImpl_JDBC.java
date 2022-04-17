package com.phantom.DAO;

import com.phantom.entity.Manufacturer;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ManufacturerDAOImpl_JDBC implements ManufacturerDAO {

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
    public Iterable<Manufacturer> findAll() {
        Set<Manufacturer> manufacturers = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM manufacturer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                final Manufacturer manufacturer = Manufacturer.builder()
                                .id(resultSet.getLong("id"))
                                .name(resultSet.getString("name"))
                                .build();
                manufacturers.add(manufacturer);
            }
            preparedStatement.close();
        } catch (SQLException e) {
        }finally {
            closeConnection(connection);
        }
        return manufacturers;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public Manufacturer findById(Long id) {
        return null;
    }

    @Override
    public void insert(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
