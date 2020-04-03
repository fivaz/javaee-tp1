package ch.hesge.programmation.servlets;

import ch.hesge.programmation.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Person person = new Person(firstName, lastName);
        req.setAttribute("person", person);

        String folder = "/WEB-INF/";
        String view = "paramHTML.jsp";
        switch (req.getPathInfo()) {
            case "/xml":
                view = "paramXML.jsp";
                break;
            case "/json":
                view = "paramJSON.jsp";
                break;
        }

        req.getServletContext()
                .getRequestDispatcher(folder + view)
                .forward(req, res);
    }
}