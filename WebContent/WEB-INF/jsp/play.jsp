<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>プレイ画面（条件提示＆料理中画面）</h1>

	<ul>
        <c:forEach var="name" items="${sessionScope.foodSeasNames}">
            <li>${name}</li>
        </c:forEach>
    </ul>
</body>
</html>