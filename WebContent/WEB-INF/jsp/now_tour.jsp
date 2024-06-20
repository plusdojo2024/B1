<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参加中のツアー</title>
</head>
<body>
参加中のツアー
<form method="get" action="ScoreServlet">
<c:forEach var="e" items="${scoreList}">
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