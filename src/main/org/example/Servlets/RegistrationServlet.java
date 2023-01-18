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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("registration.html");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String password1=req.getParameter("password1");
        RequestDispatcher rd=req.getRequestDispatcher("registration.html");
        resp.setContentType("text/html");

        if(!password.equals(password1)){
            resp.getWriter().println("Passwords are not equal");
            rd.include(req,resp);
            return;
        }

        UserDAO userDAO=new UserDAO();
        User user1=userDAO.getByEmail(email);
        if(user1!=null){
            resp.getWriter().println("User already exist");
            rd.include(req,resp);
            return;

        }

        User newUser=new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        userDAO.insert(newUser);
        resp.getWriter().println("Thank you for your registration"+ newUser.getName());



    }
}
