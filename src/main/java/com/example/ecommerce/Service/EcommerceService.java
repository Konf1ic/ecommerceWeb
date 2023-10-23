package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Ecommerce;

import java.sql.SQLException;
import java.util.List;

public interface EcommerceService {
    public void insertAccount_buyer(Ecommerce ecommerce);
    public void insertAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
    public void insertAccount_supplier(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;

      List<Ecommerce> searchAccount(String name) throws SQLException, ClassNotFoundException;
}
