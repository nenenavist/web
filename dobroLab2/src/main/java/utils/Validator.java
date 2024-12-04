package utils;

import jakarta.servlet.http.HttpServletRequest;
import table.Point;
import table.PointDTO;


public class Validator {

    private static double x;
    private static double y;
    private static double r;

    public static boolean validate(HttpServletRequest request) {
        try {
            if (!parse(request)) {
                throw new Exception();
            }
            if (x<-2.0 || x>2.0) {
                throw new Exception();
            }
            if (y < -5 || y > 5) {
                throw new Exception();
            }
            if (r<1 || r>5) {
                throw new Exception();
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static Point createPoint(PointDTO pointDTO){
        boolean isInside = checkIfInside(pointDTO.getX(), pointDTO.getY(), pointDTO.getR());
        return new Point(pointDTO.getX(), pointDTO.getY(), pointDTO.getR(), isInside);
    }


    private static boolean parse(HttpServletRequest request) {
        String x = request.getParameter("x_value");
        String y = request.getParameter("y_value");
        String yValueInput = request.getParameter("y-text");
        String r = request.getParameter("radius");

        if ((y == null || y.isEmpty()) && (yValueInput != null && !yValueInput.isEmpty())) {
            y = yValueInput;
        }
        try {
            double dx = Double.parseDouble(x.trim());
            double dy = Double.parseDouble(y.trim());
            int dr = Integer.parseInt(r.trim());
            Validator.x = dx;
            Validator.y = dy;
            Validator.r = dr;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkIfInside(Double x, Double y, Double r) {
        if ((x <= 0 && y >= 0 && x>=-r && y<=r) && (x*x + y*y <= r*r)) {
            return true;
        }
        if (x <= 0 && y <= 0 && y >= (-x-r) && x >= -r && y>=-r) {
            return true;
        }
        if ((x >= 0 && x <= r/2) && (y >= 0 && y <= r)) {
            return true;
        }
        return false;
    }


}
