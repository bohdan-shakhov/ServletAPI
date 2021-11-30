package com.acolyte.servletapi.config;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ConfigServlet", value = "/ConfigServlet")
public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();

        String name = "";
        while (parameterNames.hasMoreElements()) {
            name = parameterNames.nextElement();
            out.print("<br><b>Parametr name: </b>" + name);
            out.print(" <b>value: </b>" + servletConfig.getInitParameter(name));
        }

        if (out != null) {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
