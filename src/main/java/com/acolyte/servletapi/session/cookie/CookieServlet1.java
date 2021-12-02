package com.acolyte.servletapi.session.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieServlet1")
public class CookieServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        out.print("<center>Welcome <b>" + userName + "</b>!!!");

        Cookie cookie = new Cookie("uname", userName);
        response.addCookie(cookie);

        out.print("<form action='CookieServlet2'>");
        out.print("<input type='submit' value='go to next servlet'>");
        out.print("</form></center>");

        out.close();
    }
}
