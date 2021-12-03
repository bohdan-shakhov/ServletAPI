package com.acolyte.servletapi.event_listener.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListenerTest implements ServletContextListener {

    public static final String URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String FULL_URL = URL +
            "?user=" + USER +
            "&password=" + PASSWORD;

    public ContextListenerTest() {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(FULL_URL);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ServletContext context = event.getServletContext();
        context.setAttribute("connection", connection);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

}
