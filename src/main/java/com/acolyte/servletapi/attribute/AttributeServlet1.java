package com.acolyte.servletapi.attribute;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AttributeServlet1", value = "/AttributeServlet1")
public class AttributeServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        context.setAttribute("1-servlet", "AttributeServlet1");

        out.print("<center><h2>Welcome to first servlet</h2>");
        out.print("<a href=\"AttributeServlet2\">go to second servlet</center>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
