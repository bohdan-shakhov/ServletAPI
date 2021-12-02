package com.acolyte.servletapi.session.urlrewriting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RewritingServlet2", value = "/RewritingServlet2")
public class RewritingServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uName");

        out.print("<center> <h1>Welcome, " + name + " on second servlet</h1>");
        out.print("<a href='session/urlrewriting/urlrewriting.html'>back to start page</a><br>");
        out.print("<a href='index.html'>back to main page</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
