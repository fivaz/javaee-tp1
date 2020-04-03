package ch.hesge.programmation.servlets;

import ch.hesge.programmation.helpers.Variables;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email.equals("1") & password.equals("1")) {
            req.getRequestDispatcher(Variables.folder + "home.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect("/web_war_exploded/login");
        }
    }
}
