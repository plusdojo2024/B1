<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Play Page</title>
</head>
<body>
    <h1>調理条件</h1>
   	<c:if test="${empty foodSeasNames}">
		<p>一致するデータはありません。</p>
	</c:if>
	<c:forEach var="e" items="${foodSeasNames}">
		<p>${e.name}</p>
	</c:forEach>





   	<!--   <c:forEach var="name" items="${foodSeasNames}">
        		<li>${e.name}</li>
    </c:forEach>
	-->

    <!-- ここに他のコンテンツや機能を追加 -->

</body>
</html>