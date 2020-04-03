package ch.hesge.programmation.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/home")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long antes = System.currentTimeMillis();

        //executa a ação
        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de execução " + (depois - antes));
    }

    @Override
    public void destroy() {

    }
}
