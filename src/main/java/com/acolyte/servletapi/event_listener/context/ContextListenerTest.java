package com.acolyte.servletapi.event_listener.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class ContextListenerTest implements ServletContextListener {

    public ContextListenerTest() {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

}
