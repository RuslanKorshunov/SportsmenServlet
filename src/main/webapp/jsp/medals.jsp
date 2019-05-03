<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="CustomTags"%>
<html>
<head>
    <title>Medals</title>
</head>
<body>
    <c:import url="header.jsp"/>
    <ctg:medalsTable value="${medals}"/>
    <form action="ControlServlet" method="get">
        <input type="submit" src="images/backward.png" name="button" value="backward"/>
        <input type="text" value="${page}" size="${page}">
        <input type="submit" src="images/forward.png" name="button" value="forward">
        <input type="hidden" name="table" value="medals"/>
        <input type="hidden" name="page" value="${page}">
    </form>
</body>
</html>
