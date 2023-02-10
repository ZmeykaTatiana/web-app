package org.example.DAO.impl;

import org.example.DAO.AbstractDAO;
import org.example.Model.Office;
import org.example.Utils.BDUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OfficesDAO extends AbstractDAO<Office> {

    @Override
    public boolean insert(Office office) {
        return false;
    }

    @Override
    public boolean update(Office office) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Office office) {
        return false;
    }

    @Override
    public Office getById(int id) {

        String sql = "SELECT * FROM user_db.offices WHERE id_office = ?";
        Office office = null;

        try (Connection connection = BDUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                office = new Office();
                office.setId_office(resultSet.getInt("id_office"));
                office.setName(resultSet.getString("name"));
                office.setLocation(resultSet.getString("location"));
                office.setPhone(resultSet.getString("phone"));
                office.setFax(resultSet.getString("fax"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return office;
    }

    @Override
    public Set<Office> getAll() {
        String sql = "SELECT * FROM user_db.offices ORDER BY id_office";
        Set<Office> officesList = new HashSet<>();

        try (Connection connection = BDUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Office office = new Office();
                office.setId_office(Integer.parseInt(resultSet.getString("id_office")));
                office.setName(resultSet.getString("name"));
                office.setLocation(resultSet.getString("location"));
                office.setPhone(resultSet.getString("phone"));
                office.setFax(resultSet.getString("fax"));
                officesList.add(office);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return officesList;
    }


    }


