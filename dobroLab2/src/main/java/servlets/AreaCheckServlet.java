package servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import table.Point;
import table.PointDTOParser;
import utils.ResultBean;
import utils.Validator;

import java.io.IOException;
public class AreaCheckServlet extends HttpServlet {

    @Inject
    private ResultBean resultBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Point result = Validator.createPoint(PointDTOParser.parse(request));
            resultBean.addPoint(result);
            request.setAttribute("currentResult", result);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

}