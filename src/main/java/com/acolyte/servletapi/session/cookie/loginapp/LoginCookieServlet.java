package com.acolyte.servletapi.session.cookie.loginapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginCookieServlet", value = "/LoginCookieServlet")
public class LoginCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatcher = request.getRequestDispatcher("session/cookie/loginapp/link.html");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (password.equals("admin123")) {
            out.print("<center><h1>You are successfully logged in</h1>");
            out.print("Welcome <b>" + name + "</b></center>");

            Cookie cookie = new Cookie("name", name);
            response.addCookie(cookie);
            dispatcher.include(request, response);
        } else {
            out.print("<center><h1>Sorry, password is incorrect</h1>");
            out.print("psss, try <b>admin123</b></center>");
            request.getRequestDispatcher("session/cookie/loginapp/login.html").include(request, response);
        }

        out.close();
    }
}
