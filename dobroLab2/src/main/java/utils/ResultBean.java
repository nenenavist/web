package utils;

import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.Data;
import table.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Named("resultBean")
@Singleton
public class ResultBean implements Serializable {
    private List<Point> points;

    public ResultBean() {
        this.points = new ArrayList<>();
    }

    public synchronized void addPoint(Point point) {
        points.add(point);
    }
}
