package com.acolyte.servletapi.loadonstartuptest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet1", value = "/Servlet1", loadOnStartup = 1)
public class Servlet1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet1#init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
