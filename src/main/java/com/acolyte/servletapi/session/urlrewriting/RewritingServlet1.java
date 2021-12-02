package com.acolyte.servletapi.session.urlrewriting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RewritingServlet1", value = "/RewritingServlet1")
public class RewritingServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");

        out.print("<center> <h1>Welcome, " + name + " on first servlet</h1>");
        out.print("<a href='RewritingServlet2?uName=" + name + "'>go to next servlet</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
