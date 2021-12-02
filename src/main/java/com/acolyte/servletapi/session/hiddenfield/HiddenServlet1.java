package com.acolyte.servletapi.session.hiddenfield;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiddenServlet1", value = "/HiddenServlet1")
public class HiddenServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");

        out.print("<center><h1>Hello " + name + "</h1>");
        out.print("<form action='/ServletAPI_war_exploded/HiddenServlet2'>");
        out.print("<input type='hidden' name='uName' value='" + name + "'><br>");
        out.print("<input type='submit' value='go'><br></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
