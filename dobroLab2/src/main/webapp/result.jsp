<%@ page import="table.Point" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Point hit results</title>
    <link rel="stylesheet" type="text/css" href="resultStyle.css">
</head>
<body>

<div class="container">
    <h2>RESULTS</h2>

    <%
        Point currentResult = (Point) request.getAttribute("currentResult");
        if (currentResult != null) {
    %>
    <table>
        <tr>
            <th>Parametr</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>X</td>
            <td><%= currentResult.getX() %></td>
        </tr>
        <tr>
            <td>Y</td>
            <td><%= currentResult.getY() %></td>
        </tr>
        <tr>
            <td>R</td>
            <td><%= currentResult.getRadius() %></td>
        </tr>
        <tr>
            <td>Result</td>
            <td><%= currentResult.isInside() ? "Hit" : "Fail" %></td>
        </tr>
    </table>
    <%
    } else {
    %>
    <p>There are no results to display :c</p>
    <%
        }
    %>

    <a href="index.jsp">Return</a>
</div>

</body>
</html>