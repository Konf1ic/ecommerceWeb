package com.example.ecommerce.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EcommerceDAO {

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

    private static final String INSERT_account_buyer_SQL = "INSERT INTO account_buyer (username, password, email, age,account_buyer,address) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String INSERT_account_staff_SQL = "INSERT INTO account_staff (username, password, email, name, age,account_buyer,address) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_account_supplier_SQL = "INSERT INTO account_supplier (username, password, email, age,account_buyer,address) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from Product";

}
