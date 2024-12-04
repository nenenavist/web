package table;

public class PointDTO {
    private double x;
    private double y;
    private double r;

    public PointDTO(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static PointDTO of(String xValueStr, String yValueStr, String radiusStr){
        PointDTO pointDTO = new PointDTO(Double.parseDouble(xValueStr),Double.parseDouble(yValueStr),Double.parseDouble(radiusStr));
        return pointDTO;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

}
