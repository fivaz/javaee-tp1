package ch.hesge.programmation.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {
    private Properties supportedLanguages;

    public SessionLocaleFilter() {
        supportedLanguages = new Properties();
        supportedLanguages.put("en", Locale.ENGLISH);
        supportedLanguages.put("fr", Locale.FRENCH);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        //check query param language
        if (req.getParameter("lang") != null)
            req.getSession().setAttribute("lang", req.getParameter("lang"));
            //check session language
        else if (req.getSession().getAttribute("lang") == null) {
            //use system language
            Enumeration<Locale> locales = req.getLocales();
            while (locales.hasMoreElements()) {
                Locale locale = locales.nextElement();
                if (supportedLanguages.contains(locale)) {
                    System.out.println(locale);
                    req.getSession().setAttribute("lang", locale.toString());
                    break;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {

    }
}
