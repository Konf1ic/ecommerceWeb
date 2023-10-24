package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Ecommerce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcommerceDAO implements EcommerceService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1";

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
    private static final String INSERT_account_supplier_SQL = "INSERT INTO account_supplier (username, password, email, age,phone_number,address) VALUES (?, ?, ?, ?, ?, ?);";
     private static final String UPDATE_USERS_account_staff_SQL ="update account_staff set username = ?, password = ? , email = ?, age= ?, phone_number = ?,address = ? where id = ?";
    private static final String SELECT_ALL = "select * from ";

    @Override
    public void insertAccount_buyer(Ecommerce ecommerce) {
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_account_buyer_SQL);
            preparedStatement.setString(1, ecommerce.getUsername());
            preparedStatement.setString(2, ecommerce.getPassword());
            preparedStatement.setString(3, ecommerce.getEmail());
            preparedStatement.setInt(4, ecommerce.getAge());
            preparedStatement.setInt(5, ecommerce.getPhone_number());
            preparedStatement.setString(6, ecommerce.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insertAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_account_staff_SQL);
        preparedStatement.setString(1, ecommerce.getUsername());
        preparedStatement.setString(2, ecommerce.getPassword());
        preparedStatement.setString(3, ecommerce.getEmail());
        preparedStatement.setString(4, ecommerce.getName());
        preparedStatement.setInt(5, ecommerce.getAge());
        preparedStatement.setInt(6, ecommerce.getPhone_number());
        preparedStatement.setString(7, ecommerce.getAddress());
        preparedStatement.executeUpdate();


    }

    @Override
    public void insertAccount_supplier(Ecommerce ecommerce) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_account_supplier_SQL);
            preparedStatement.setString(1, ecommerce.getUsername());
            preparedStatement.setString(2, ecommerce.getPassword());
            preparedStatement.setString(3, ecommerce.getEmail());
            preparedStatement.setInt(4, ecommerce.getAge());
            preparedStatement.setInt(5, ecommerce.getPhone_number());
            preparedStatement.setString(6, ecommerce.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException {


        List<Ecommerce> list = new ArrayList<>();

        String query1 = "select * from account_buyer where username like ?";
        PreparedStatement preparedStatement1 = getConnection().prepareStatement(query1);
        preparedStatement1.setString(1, "%" + name + "%");

        ResultSet resultSet1 = preparedStatement1.executeQuery();
        while (resultSet1.next()) {
            int id = resultSet1.getInt("id");
            String username = resultSet1.getString("username");
            String password = resultSet1.getString("password");
            String email = resultSet1.getString("email");
            int age = resultSet1.getInt("age");
            int phone_number = resultSet1.getInt("phone_number");
            String address = resultSet1.getString("address");

            list.add(new Ecommerce(id, username, password, email, age, phone_number, address));
        }

        String query2 = "select * from account_staff where username like ?";
        PreparedStatement preparedStatement2 = getConnection().prepareStatement(query2);
        preparedStatement2.setString(1, "%" + name + "%");

        ResultSet resultSet2 = preparedStatement2.executeQuery();
        while (resultSet2.next()) {
            int id = resultSet2.getInt("id");
            String username = resultSet2.getString("username");
            String password = resultSet2.getString("password");
            String email = resultSet2.getString("email");
            int age = resultSet2.getInt("age");
            int phone_number = resultSet2.getInt("phone_number");
            String address = resultSet2.getString("address");
            list.add(new Ecommerce(id, username, password, email, age, phone_number, address));
        }

        String query3 = "select * from account_supplier where username like ?";
        PreparedStatement preparedStatement3 = getConnection().prepareStatement(query3);
        preparedStatement3.setString(1, "%" + name + "%");

        ResultSet resultSet3 = preparedStatement3.executeQuery();
        while (resultSet3.next()) {
            int id = resultSet3.getInt("id");
            String username = resultSet3.getString("username");
            String password = resultSet3.getString("password");
            String email = resultSet3.getString("email");
            int age = resultSet3.getInt("age");
            int phone_number = resultSet3.getInt("phone_number");
            String address = resultSet3.getString("address");
            list.add(new Ecommerce(id, username, password, email, age, phone_number, address));
        }
        return list;
    }

    @Override
    public boolean UpDateAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_account_staff_SQL);
        preparedStatement.setString(1,ecommerce.getUsername());
        preparedStatement.setString(2,ecommerce.getPassword());
        preparedStatement.setString(3,ecommerce.getEmail());
        preparedStatement.setInt(4,ecommerce.getAge());
        preparedStatement.setInt(5,ecommerce.getPhone_number());
        preparedStatement.setString(6,ecommerce.getAddress());
        preparedStatement.setInt(7,ecommerce.getId());
        rowUpdated = preparedStatement.executeUpdate()>0;
        return rowUpdated;
    }

    @Override
    public Ecommerce findEcommerceById(int editId) throws SQLException, ClassNotFoundException {
        String query = "select * from account_staff where id = ?";
        PreparedStatement preparedStatement3 = getConnection().prepareStatement(query);
        preparedStatement3.setInt(1, editId);

        Ecommerce ecommerce = null;

        ResultSet resultSet3 = preparedStatement3.executeQuery();
        while (resultSet3.next()) {
            int id = resultSet3.getInt("id");
            String username = resultSet3.getString("username");
            String password = resultSet3.getString("password");
            String email = resultSet3.getString("email");
            int age = resultSet3.getInt("age");
            int phone_number = resultSet3.getInt("phone_number");
            String address = resultSet3.getString("address");
            ecommerce = new Ecommerce(id, username, password, email, age, phone_number, address);

        }

        return ecommerce;
    }
}