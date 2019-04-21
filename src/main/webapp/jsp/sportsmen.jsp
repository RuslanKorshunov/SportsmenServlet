<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="CustomTags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sportsmen</title>
</head>
<body>
    <c:import url="header.jsp"/>
    <ctg:sportsmenTable value="${sportsmen}"/>
</body>
</html>
