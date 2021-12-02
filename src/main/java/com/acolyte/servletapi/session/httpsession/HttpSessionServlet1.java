package com.acolyte.servletapi.session.httpsession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HttpSessionServlet1", value = "/HttpSessionServlet1")
public class HttpSessionServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        out.print("<center> <h1>Welcome, " + userName + " on first servlet</h1>");
        out.print("<a href='HttpSessionServlet2'>go to next servlet</a></center>");


        HttpSession session = request.getSession();
        session.setAttribute("uname", userName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
