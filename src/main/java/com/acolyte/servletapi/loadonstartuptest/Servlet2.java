package com.acolyte.servletapi.loadonstartuptest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet2", value = "/Servlet2", loadOnStartup = 0)
public class Servlet2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet2#init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
