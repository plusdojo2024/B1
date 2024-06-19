<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
            <li>${sessionScope.name}</li>
        </c:forEach>
    </ul>

    <!-- ここに他のコンテンツや機能を追加 -->

</body>
</html>