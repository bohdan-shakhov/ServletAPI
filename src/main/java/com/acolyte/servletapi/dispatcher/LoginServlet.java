package com.acolyte.servletapi.dispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        if (userName.equals("user")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
            dispatcher.forward(request, response);
        } else {
            out.print("<h3 style=\"color: red\">Sorry user name is incorrect!</h3>");
            out.print("<a href='dispatcher.html'>Back to login form</a>");
        }
    }
}
