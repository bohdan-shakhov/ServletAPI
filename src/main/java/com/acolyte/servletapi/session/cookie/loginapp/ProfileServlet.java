package com.acolyte.servletapi.session.cookie.loginapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatcher = request.getRequestDispatcher("session/cookie/loginapp/link.html");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String name = cookies[0].getValue();
            if (!name.equals("") || name != null) {
                out.print("<center><h1>Welcome to profile</h1>");
                out.print("Welcome, <b>" + name + "</b><br>");
                dispatcher.include(request, response);
            }
        } else {
            out.print("<center><h1 styles='color: red'>Please login first</h1>");
            dispatcher.include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
