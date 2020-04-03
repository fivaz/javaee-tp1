package ch.hesge.programmation.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/initial2")
public class Initial2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><h1>Test initial 2</h1></body></html>");
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/include");
        dispatcher.include(req, resp);
    }
}
