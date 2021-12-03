package com.acolyte.servletapi.event_listener.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionListenerServlet", value = "/SessionListenerServlet")
public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        out.print("<center>Welcome, <b>" + userName + "</b>");

        HttpSession session = request.getSession();
        session.setAttribute("username", userName);

        ServletContext servletContext = getServletContext();
        int totalusers = (Integer) servletContext.getAttribute("totalusers");
        int currentusers = (Integer) servletContext.getAttribute("currentusers");
        out.print("<br>Current users: <b>" + currentusers + "</b>");
        out.print("<br>Total users: <b>" + totalusers + "</b>");

        out.print("<br><a href='event_listener/session/welcome.html'>back to start page</a> | ");
        out.print("<a href='index.html'>back to main page</a> | ");
        out.print("<a href='/ServletAPI_war_exploded/SessionListenerLogout'>logout</a></center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
