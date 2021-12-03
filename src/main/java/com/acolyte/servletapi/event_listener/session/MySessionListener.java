package com.acolyte.servletapi.event_listener.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class MySessionListener implements HttpSessionListener {
    ServletContext context = null;
    static int total = 0;
    static int current = 0;

    public MySessionListener() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        /* Session is created. */
        total++;
        current++;

        context = event.getSession().getServletContext();
        context.setAttribute("totalusers", total);
        context.setAttribute("currentusers", current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        /* Session is destroyed. */
        current--;
        context.setAttribute("currentusers", current);
    }

}
