package com.acolyte.servletapi.event_listener.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionListenerLogout", value = "/SessionListenerLogout")
public class SessionListenerLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        session.invalidate();

        out.print("<center><h2>You are successfully logged out</h2><br>");
        out.print("<br><a href='event_listener/session/welcome.html'>back to start page</a><br>");
        out.print("<a href='index.html'>back to main page</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
