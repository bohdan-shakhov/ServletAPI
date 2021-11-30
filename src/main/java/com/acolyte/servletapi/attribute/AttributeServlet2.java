package com.acolyte.servletapi.attribute;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AttributeServlet2", value = "/AttributeServlet2")
public class AttributeServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String servlet1 = (String) context.getAttribute("1-servlet");

        out.print("<center><h2>Welcome to second servlet</h2>");
        out.print("You were redirected from: " + servlet1 + "</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
