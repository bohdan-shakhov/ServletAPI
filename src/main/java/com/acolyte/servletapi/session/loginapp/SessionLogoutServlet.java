package com.acolyte.servletapi.session.loginapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionLogoutServlet", value = "/SessionLogoutServlet")
public class SessionLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("session/loginapp/link.html").include(request, response);

        HttpSession session = request.getSession();
        session.invalidate();

        out.print("<center><h3>You are successfully logged out!</h3></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
