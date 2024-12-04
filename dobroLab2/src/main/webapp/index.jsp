<%@ page import="table.Point" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.TableCreatorBean" %>
<%@ page import="utils.ResultBean" %>
<%@ page import="jakarta.enterprise.inject.spi.CDI" %>
<%@ page import="utils.TableCreatorBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Lab2</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="click.js"></script>
</head>
<body>

<header>
    <h1 class="header">Var 986 | Smirnova Polina Ruslanovna | P3225</h1>
</header>

<div class="main-container">
    <div class="content">
        <h2>Checking for a point hit</h2>
        <form id="coords_form" name="coords_form" action="ControllerServlet" method="GET" accept-charset="UTF-8" onsubmit="return validateForm();">
            <input type="hidden" id="image_click" name="image_click" value="false">
            <label>Coordinate X:</label>
            <div>
                <input type="checkbox" name="x[]" class="x-button" id="x-2" onclick="setX(-2)">-2</input>
                <input type="checkbox" name="x[]" class="x-button" id="x-1.5" onclick="setX(-1.5)">-1.5</input>
                <input type="checkbox" name="x[]" class="x-button" id="x-1" onclick="setX(-1)">-1</input>
                <input type="checkbox" name="x[]" class="x-button" id="x-0.5" onclick="setX(-0.5)">-0.5</input>
                <input type="checkbox" name="x[]" class="x-button" id="x0" onclick="setX(0)">0</input>
                <input type="checkbox" name="x[]" class="x-button" id="x0.5" onclick="setX(0.5)">0.5</input>
                <input type="checkbox" name="x[]" class="x-button" id="x1" onclick="setX(1)">1</input>
                <input type="checkbox" name="x[]" class="x-button" id="x1.5" onclick="setX(1.5)">1.5</input>
                <input type="checkbox" name="x[]" class="x-button" id="x2" onclick="setX(2)">2</input>
            </div>
            <input type="hidden" id="x_value" name="x_value">
            <input type="hidden" id="y_value" name="y_value">

            <br>

            <label for="y_value_input">Coordinate Y (from -3 to 3):</label>
            <input type="text" id="y_value_input" name="y_value_input" >
            <br>

            <label>Variable R:</label>
            <div>
                <button type="button" class="radius-button" id="r1" onclick="setR(1)">1</button>
                <button type="button" class="radius-button" id="r2" onclick="setR(2)">2</button>
                <button type="button" class="radius-button" id="r3" onclick="setR(3)">3</button>
                <button type="button" class="radius-button" id="r4" onclick="setR(4)">4</button>
                <button type="button" class="radius-button" id="r5" onclick="setR(5)">5</button>
            </div>
            <input type="hidden" id="radius_hidden" name="radius">
            <br>

            <input type="submit" value="RIP">
        </form>


        <h3>Area graph</h3>
        <p>Click on the image to select the coordinates</p>
        <div class="graph-container">
            <canvas id="graphCanvas" width="500" height="500" onclick="handleClick(event);"></canvas>
            <%
                ResultBean resultBean = CDI.current().select(ResultBean.class).get();
                if (resultBean != null) {
                    List<Point> points = resultBean.getPoints();
                    if (points != null && !points.isEmpty()) {
                        double graphWidth = 500;
                        double graphHeight = 500;
                        double offsetX = graphWidth / 2;
                        double offsetY = graphHeight / 2;
                        double rad = points.get(points.size() - 1).getRadius();

                        for (Point point : points) {
                            double px = offsetX + point.getX() / point.getRadius() * 200 / rad * point.getRadius() - 5;
                            double py = offsetY - point.getY() / point.getRadius() * 200 / rad * point.getRadius() - 5;

                            if (px < 0) px = 0;
                            if (px > graphWidth) px = graphWidth;
                            if (py < 0) py = 0;
                            if (py > graphHeight) py = graphHeight;

                            String color = point.isInside() ? "green" : "red";
            %>
            <div class="dot" style="left:<%= px %>px; top:<%= py %>px; background-color:<%= color %>;"></div>
            <%
                    }
                }
                }
            %>
        </div>



        <h3>RESULTS</h3>
        <%
            TableCreatorBean tableCreatorBean = CDI.current().select(TableCreatorBean.class).get();
            if (tableCreatorBean != null) {
                tableCreatorBean.create(out);
            } else {
                out.println("<p>Table is empty</p>");
            }
        %>
    </div>
</div>

<script src="graph.js"></script>

</body>
</html>