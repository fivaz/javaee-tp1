package ch.hesge.programmation.servlets;

import ch.hesge.programmation.models.BDD;
import ch.hesge.programmation.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/people")
public class PeopleServlet extends HttpServlet {

    //    private static String view = "/peopleJSP.jsp";
    //    private static String view = "/peopleJSTL.jsp";
    private static String view = "/peopleJSTLLangSession.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BDD bdd = new BDD();
        List<Person> people = bdd.getPeople();

        req.setAttribute("people", people);
        req.getRequestDispatcher(view).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Person person = new Person(firstName, lastName, new Date());

        BDD bdd = new BDD();
        List<Person> people = bdd.getPeople();
        people.add(person);

        req.setAttribute("people", people);
        req.getRequestDispatcher(view).forward(req, resp);
    }
}
