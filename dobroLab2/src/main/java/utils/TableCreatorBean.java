package utils;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.servlet.jsp.JspWriter;
import lombok.Data;
import table.Point;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
@Data
@Singleton
@Named("tableCreator")
public class TableCreatorBean implements Serializable {
    @Inject
    private ResultBean resultBean;

    public TableCreatorBean(){
    }
    public void create(JspWriter out) throws IOException {
        List<Point> results = resultBean.getPoints();
        if (results.isEmpty()) {
            out.println("<p>There are no results to display :c</p>");
            return;
        }
        out.println("<table>");
        out.println("<tr><th>X</th><th>Y</th><th>Radius</th><th>Result</th></tr>");

        for (Point result : results) {
            out.println("<tr>");
            out.println("<td>" + result.getX() + "</td>");
            out.println("<td>" + result.getY() + "</td>");
            out.println("<td>" + result.getRadius() + "</td>");
            out.println("<td>" + (result.isInside() ? "Hit" : "Fail") + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }
}
