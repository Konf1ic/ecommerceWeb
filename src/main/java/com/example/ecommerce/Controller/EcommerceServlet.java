package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Ecommerce;
import com.example.ecommerce.Service.EcommerceDAO;
import com.example.ecommerce.Service.EcommerceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EcommerceServlet", value = "/ecommerce")
public class EcommerceServlet extends HttpServlet {
    private EcommerceService ecommerceService;

    @Override
    public void init() {
        ecommerceService = new EcommerceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showSearchForm(req, resp);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("staff", ecommerceService.findEcommerceById(id));
        req.getRequestDispatcher("update/updateAccountStaff.jsp").forward(req,resp);

    }

    private void UpdateAccount_Staff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        int phone_number = Integer.parseInt(req.getParameter("phone_number"));
        String address = req.getParameter("address");
        Ecommerce book = new Ecommerce(id,name,password,email,age,phone_number,address);
        ecommerceService.UpDateAccount_staff(book);
        req.getRequestDispatcher("update/updateAccountStaff.jsp").forward(req,resp);
    }

    private void showSearchForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("searchAccount/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case  "search":
                    searchAccount(req,resp);
                    break;
                case "registerBuyer":
                    insertAccount_buyer(req, resp);
                    break;
                case "registerStaff":
                    insertAccount_staff(req,resp);
                    break;
                case "edit":
                    UpdateAccount_Staff(req,resp);

                    break;
                case "registerSupplier":
                    insertAccount_supplier(req,resp);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String username = req.getParameter("username");
        List<Ecommerce>list = ecommerceService.searchAccount(username);

        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchAccount/search.jsp");
        dispatcher.forward(req,resp);
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
    private  void insertAccount_supplier(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        int phone_number = Integer.parseInt(req.getParameter("phone_number"));
        String address = req.getParameter("address");
        Ecommerce ecommerce = new Ecommerce(username,password,email,age,phone_number,address);
        ecommerceService.insertAccount_supplier(ecommerce);
        req.getRequestDispatcher("register/registerSupplier.jsp").forward(req,resp);

    }
}
