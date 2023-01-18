package org.example.Servlets;

import org.example.DAO.impl.UserDAO;
import org.example.Model.User;
import org.example.Utils.Constanc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.Utils.Constanc.EMAIL;
import static org.example.Utils.Constanc.PASSWORD;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // PrintWriter pw = resp.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        final String password = req.getParameter("password");
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("login.html");

        User user = new UserDAO().getByEmail(email.trim());
        System.out.println(user);
        if (user == null) {
            resp.getWriter().println("<b>User does not exist. Please <a href='registration'> Reg</a></b>");
            rd.include(req, resp);
        } else if (password.equals(user.getPassword())) {
            resp.getWriter().println("welcome,"+user.getName());
            rd.include(req, resp);
        } else {
            resp.getWriter().println("<b>Bad credentials</b>");
            rd.include(req, resp);
        }

    }
}



