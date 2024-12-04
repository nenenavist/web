/*package utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import table.Point;


import java.util.ArrayList;
import java.util.List;

public class ContextUpdater {
    public static void updateContext(HttpServletRequest request, Point result){
        ServletContext context = request.getServletContext();
        List<Point> results = (List<Point>) context.getAttribute("results");

        if (results == null) {
            results = new ArrayList<>();
        }

        results.add(result);

        context.setAttribute("results", results);
    }
}*/
