package com.phantom.DAO;

import com.phantom.entity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


//@Component(value = "springJDBC")
@RequiredArgsConstructor
public class ManufacturerDAOImpl_SpringJDBC implements ManufacturerDAO {

    private final DataSource dataSource;

    @Override
    public Iterable<Manufacturer> findAll() {
        Set<Manufacturer> manufacturers = new HashSet<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
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
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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