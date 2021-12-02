package com.acolyte.servletapi.session.loginapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionProfileServlet", value = "/SessionProfileServlet")
public class SessionProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("session/loginapp/link.html").include(request, response);

        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("uname");

            out.print("<center>Hello, <b>" + name + "</b>. Welcome to Profile</center>");
        } else {
            out.print("<center><h2>Please login first!!!</h2><center>");
            request.getRequestDispatcher("session/loginapp/login.html").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
