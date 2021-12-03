package com.acolyte.servletapi.filter.lyfecycle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FilterLifecycleServlet", value = "/FilterLifecycleServlet")
public class FilterLifecycleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;chaset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<center><h2>Welcome to servlet</h2>");
        out.print("<br><a href='index.html'>Back to main page</a><center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
