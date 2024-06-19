<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Play Page</title>
</head>
<body>
    <h1>調理条件</h1>

    <ul>
     	<c:forEach var="name" items="${sessionScope.foodSeasNames}">
        		<li>${name}</li>
        </c:forEach>
    </ul>

    <!-- ここに他のコンテンツや機能を追加 -->

</body>
</html>