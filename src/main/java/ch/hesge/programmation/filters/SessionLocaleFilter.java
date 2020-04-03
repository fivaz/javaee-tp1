package ch.hesge.programmation.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getParameter("lang") != null)
            req.getSession().setAttribute("lang", req.getParameter("lang"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {

    }
}
