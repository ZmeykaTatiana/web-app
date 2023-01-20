package org.example.filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LogFilter extends HttpFilter {
    private static final String PRINT_PATTERN="%s: %s [%s] {%s} %s %s %s";
    @Override
    public void init() throws ServletException {
        System.out.println("init logfilter");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq= req;
        String path=httpReq.getServletPath();
        String URI=httpReq.getRequestURI();
        String URL=httpReq.getRequestURL().toString();
       String session=httpReq.getSession().getId();
        System.out.println(String.format(PRINT_PATTERN, new Date().toString(),"INFO",Thread.currentThread().getName(),session,path,URI,URL));
    chain.doFilter(req,res);
    }

    @Override
    public void destroy() {
        System.out.println("destroy logfilter");
    }
}
