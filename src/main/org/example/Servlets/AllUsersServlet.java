package org.example.Servlets;

import org.example.DAO.impl.UserDAO;
import org.example.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/usering")
public class AllUsersServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd= req.getRequestDispatcher("jsp/user01.jsp");
        rd.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> user=new UserDAO().getAll();

        RequestDispatcher rd= req.getRequestDispatcher("jsp/user01.jsp");
        rd.forward(req,resp);
    }
}
