package com.preeti.servlet;

import java.io.IOException;

import com.preeti.dao.User;
import com.preeti.dao.UserDao;
import com.preeti.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        try {
            if (userDao.addUser(user)) {
                response.sendRedirect("login.jsp?registration=success");
            } else {
                response.sendRedirect("register.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=2");
        }
    }

}
