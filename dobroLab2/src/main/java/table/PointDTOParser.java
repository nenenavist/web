package table;

import jakarta.servlet.http.HttpServletRequest;


public class PointDTOParser {
    public static PointDTO parse(HttpServletRequest request){
        String xValue = request.getParameter("x_value");
        String yValue = request.getParameter("y_value");
        String radius = request.getParameter("radius");
        return PointDTO.of(xValue,yValue,radius);
    }
}
