<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <c:import url="header.jsp"/>
    <form action="ControlServlet" method="get">
        <c:set var="page" value="1" scope="request"/>
    </form>
</body>
</html>
