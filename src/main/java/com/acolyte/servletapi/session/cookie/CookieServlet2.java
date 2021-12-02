package com.acolyte.servletapi.session.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        out.print("<center>Hello <b>" + cookies[0].getValue() + "</b> from another servlet<br>");
        out.print("<a href='index.html'>Back to start page</a></center>");

        out.close();
    }
}
