<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <%
        // Achhi , aau nua create hebani
        HttpSession currentSession = request.getSession(false);

        // Bapa re tk check kalu username and Session achhi na nai
        if (currentSession == null || currentSession.getAttribute("username") == null) 
        {
            response.sendRedirect("login.jsp");
        } 
        else 
        {
            String username = (String) currentSession.getAttribute("username");
    %>
    
            <h1>Welcome, <%= username %>!</h1>
            
    <%
        }
    %>
</body>
</html>
