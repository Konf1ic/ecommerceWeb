package com.example.ecommerce.Model;

import java.sql.SQLException;

public interface EcommerceService {
    public void insertAccount_buyer(Ecommerce ecommerce);
    public void insertAccount_staff(Ecommerce ecommerce) throws SQLException, ClassNotFoundException;
    public void insertAccount_supplier(Ecommerce ecommerce);


}
