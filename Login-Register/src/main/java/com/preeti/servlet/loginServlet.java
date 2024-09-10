package com.preeti.servlet;

import java.io.IOException;

import com.preeti.dao.UserDao;
import com.preeti.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDao.isValidUser(username, password)) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        } 
        else 
        {
            response.sendRedirect("login.jsp?error=1");
            System.out.println("Error A gya");
        }
    }
}
