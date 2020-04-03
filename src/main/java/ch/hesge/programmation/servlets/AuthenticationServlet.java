package ch.hesge.programmation.servlets;

import ch.hesge.programmation.helpers.Variables;
import ch.hesge.programmation.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class AuthenticationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("auth").equals(new User("stefane@user.com", "12345")))
            fowardToHome(req, resp);
        else
            redirectToLogin(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(email, password);
        if (user.equals(new User("stefane@user.com", "12345"))) {
            HttpSession session = req.getSession();
            session.setAttribute("auth", user);
            fowardToHome(req, resp);
        } else
            redirectToLogin(resp);
    }

    private void fowardToHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Variables.folder + "MainPage.jsp")
                .forward(req, resp);
    }

    private void redirectToLogin(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/web_war_exploded/login");
    }
}
