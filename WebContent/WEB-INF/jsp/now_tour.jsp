<%@ page language="java" contentType="text/html; charset=UTF-8"　pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参加中のツアー</title>
</head>
<body>
参加中のツアー
<<<<<<< HEAD
<form method="get" action="ScoreServlet">
<c:forEach var="e" items="${scoreList}">
=======
<c:forEach var="e" items="${cardList}">
>>>>>>> 640fa20bebea0e13c76d5e32dbb5de24549b4522
${e.scores_num}<br>
${e.par}<br>
${e.time_scores}<br>
${e.food_scores}<br>
${e.seas_scores}<br>
${e.cook_scores}<br>
${e.taste_scores}<br>
${e.total_score}<br>
</c:forEach>
</form>
</body>
</html>