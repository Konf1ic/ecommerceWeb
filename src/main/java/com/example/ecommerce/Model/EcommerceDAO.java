package com.example.ecommerce.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EcommerceDAO implements EcommerceService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/Ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "18092004";

    public EcommerceDAO() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    private static final String INSERT_account_buyer_SQL = "INSERT INTO account_buyer (username, password, email, age, phone_number, address) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String INSERT_account_staff_SQL = "INSERT INTO account_staff (username, password, email, name, age,phone_number,address) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_account_supplier_SQL = "INSERT INTO account_supplier (username, password, email, age,account_buyer,address) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from ";

    @Override
    public void insertAccount_buyer(Ecommerce ecommerce) {
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_account_buyer_SQL);
            preparedStatement.setString(1, ecommerce.getUsername());
            preparedStatement.setString(2,ecommerce.getPassword());
            preparedStatement.setString(3,ecommerce.getEmail());
            preparedStatement.setInt(4,ecommerce.getAge());
            preparedStatement.setInt(5,ecommerce.getPhone_number());
            preparedStatement.setString(6,ecommerce.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insertAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException {
        Connection connection =getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_account_staff_SQL);
        preparedStatement.setString(1, ecommerce.getUsername());
        preparedStatement.setString(2,ecommerce.getPassword());
        preparedStatement.setString(3,ecommerce.getEmail());
        preparedStatement.setString(4,ecommerce.getName());
        preparedStatement.setInt(5,ecommerce.getAge());
        preparedStatement.setInt(6,ecommerce.getPhone_number());
        preparedStatement.setString(7,ecommerce.getAddress());
        preparedStatement.executeUpdate();


    }

    @Override
    public void insertAccount_supplier(Ecommerce ecommerce) {

    }
}
