package table;

public class Point {
    private double x;
    private double y;
    private double radius;
    private boolean isInside;


    public Point(double x, double y, double radius, boolean isInside) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isInside = isInside;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isInside() {
        return isInside;
    }
}
