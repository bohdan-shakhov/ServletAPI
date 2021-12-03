package com.acolyte.servletapi.event_listener.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ContextFetchDataServlet", value = "/ContextFetchDataServlet")
public class ContextFetchDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ServletContext context = getServletContext();
            connection = (Connection) context.getAttribute("connection");

            statement = connection.prepareStatement("SELECT * FROM employee");

            resultSet = statement.executeQuery();
            out.print("<center>");
            while (resultSet.next()) {
                out.print("<br>"+resultSet.getInt(1)+" "+resultSet.getString(2));
            }
            out.print("<br><a href='event_listener/context/welcome.html'>back to start page</a><br>");
            out.print("<a href='index.html'>back to main page</a></center>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
