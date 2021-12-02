package com.acolyte.servletapi.session.loginapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionLoginServlet", value = "/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("session/loginapp/link.html").include(request, response);

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        if (userPassword.equals("admin123")) {
            out.print("<center><h1>Welcome, " + userName + "</h1></center>");

            HttpSession session = request.getSession();
            session.setAttribute("uname", userName);
        } else {
            out.print("<center><h1>Sorry, password is incorrect</h1>");
            out.print("<b>pssss, try admin 123</b>");
            request.getRequestDispatcher("session/loginapp/login.html").include(request, response);
        }
    }
}
