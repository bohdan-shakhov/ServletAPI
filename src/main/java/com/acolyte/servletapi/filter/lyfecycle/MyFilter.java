package com.acolyte.servletapi.filter.lyfecycle;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter", urlPatterns = "/FilterLifecycleServlet")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<center><h2>filter is invoked before</h2>");

        chain.doFilter(request, response);

        out.print("<h2>filter is invoked after</h2></center>");
    }
}
