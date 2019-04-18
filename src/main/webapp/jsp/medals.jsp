<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="CustomTags"%>
<html>
<head>
    <title>Medal</title>
</head>
<body>
    <c:import url="header.jsp"/>
    <ctg:table value="${medals}"/>
</body>
</html>
