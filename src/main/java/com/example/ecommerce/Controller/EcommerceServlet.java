package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Ecommerce;
import com.example.ecommerce.Model.EcommerceDAO;
import com.example.ecommerce.Model.EcommerceService;
import com.sun.tools.javac.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EcommerceServlet", value = "/ecommerce")
public class EcommerceServlet extends HttpServlet {
    private EcommerceService ecommerceService;

    @Override
    public void init() {
        ecommerceService = new EcommerceDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "registerBuyer":
                insertAccount_buyer(req, resp);
                break;
            case "registerStaff":
                System.out.println("ok");
                try {
                    insertAccount_staff(req, resp);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }


    }

    private void insertAccount_staff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int phone_number = Integer.parseInt(req.getParameter("phone_number"));
        String address = req.getParameter("address");

        Ecommerce ecommerce = new Ecommerce(username, password, email, name, age, phone_number, address);
        ecommerceService.insertAccount_staff(ecommerce);
        req.getRequestDispatcher("register/registerStaff.jsp").forward(req,resp);

    }

    private void insertAccount_buyer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        int phone_number = Integer.parseInt(req.getParameter("phone_number"));
        String address = req.getParameter("address");

        Ecommerce ecommerce = new Ecommerce(username, password, email, age, phone_number, address);
        ecommerceService.insertAccount_buyer(ecommerce);
        req.getRequestDispatcher("register/registerBuyer.jsp").forward(req, resp);
    }
}
