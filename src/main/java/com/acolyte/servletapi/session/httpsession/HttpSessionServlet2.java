package com.acolyte.servletapi.session.httpsession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HttpSessionServlet2", value = "/HttpSessionServlet2")
public class HttpSessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("uname");

        out.print("<center> <h1>Welcome, " + name + " on second servlet</h1>");
        out.print("<a href='session/httpsession/httpsession.html'>back to start page</a><br>");
        out.print("<a href='index.html'>back to main page</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
