package com.acolyte.servletapi;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet implements Servlet {
    ServletConfig config = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("servlet initialized");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");

        PrintWriter out = res.getWriter();

        out.print("<html><body>");
        out.print("<b>First servlet</b>");
        out.print("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "FirstServlet#getServletInfo";
    }
}
