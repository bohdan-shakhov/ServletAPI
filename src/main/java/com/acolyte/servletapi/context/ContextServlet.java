package com.acolyte.servletapi.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ContextServlet", value = "/ContextServlet")
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();

        Enumeration<String> parameterNames = context.getInitParameterNames();
        String name = "";

        while (parameterNames.hasMoreElements()) {
            name = parameterNames.nextElement();
            out.print("<br><b>Parametr name: </b>" + name);
            out.print(" <b>value: </b>" + context.getInitParameter(name));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
