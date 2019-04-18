<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <c:import url="date.jsp"/>
    <form action="ControlServlet" method="get">
        <input type="submit" name="button" value="sportsmen">
        <input type="submit" name="button" value="medals">
    </form>
</body>
</html>
