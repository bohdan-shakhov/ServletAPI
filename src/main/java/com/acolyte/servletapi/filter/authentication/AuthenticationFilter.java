package com.acolyte.servletapi.filter.authentication;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/AdminServlet")
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userpassword = request.getParameter("userpassword");

        if (userpassword.equals("admin")) {
            chain.doFilter(request, response);
        } else {


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("filter/authentication/welcome.html");
            requestDispatcher.include(request, response);

            out.print("<center><h1>Sorry, password is incorrect</h1>");
        }

    }
}
