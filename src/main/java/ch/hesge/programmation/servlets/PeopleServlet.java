package ch.hesge.programmation.servlets;

import ch.hesge.programmation.helpers.Variables;
import ch.hesge.programmation.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/people")
public class PeopleServlet extends HttpServlet {

    public List<Person> people;

    public PeopleServlet() {
        this.people = new ArrayList<Person>() {{
            add(new Person("firstName1", "lastName1"));
            add(new Person("firstName2", "lastName2"));
            add(new Person("firstName3", "lastName3"));
        }};
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        this.people.add(new Person(firstName, lastName));
        req.getRequestDispatcher("/people");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", people);
        req.getRequestDispatcher(Variables.folder + "people.jsp").forward(req, resp);
    }
}
