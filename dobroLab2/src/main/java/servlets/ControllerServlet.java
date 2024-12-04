package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.Validator;


import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (Validator.validate(request)) {
                request.getRequestDispatcher("AreaCheckServlet").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().println("<h3>400 Bad Request</h3>");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<h3>400 Bad Request</h3>");
        }
    }

}