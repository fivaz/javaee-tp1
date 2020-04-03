package ch.hesge.programmation.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(urlPatterns = "/param")
public class ParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><table border=2>");
        for (String param : parameterMap.keySet()) {
            writer.println("<tr><td>" + param + "</td><td>" + Arrays.toString(parameterMap.get(param)) + "</td></tr>");
        }
        writer.println("</table></body></html>");
    }
}
