package com.acolyte.servletapi.session.hiddenfield;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiddenServlet2", value = "/HiddenServlet2")
public class HiddenServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uName");

        out.print("<center>Welcome, <b>" + name + "</b> to anotehr servlet<br>");
        out.print("<a href='session/hiddenfield/hidden.html'>Back to start page</a><br>");
        out.print("<a href='index.html'>Back to main page</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
