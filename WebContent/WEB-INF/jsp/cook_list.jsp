<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>料理の一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
<p>料理の一覧</p>
</head>
<body>
<c:forEach var="e" items="${cardList}">
<img id="mw" class="img-pc" src="/B1/img/cook.png">
${e.cook_num}
${e.cook_name}<br>

<dialog id="dmw">
text
</dialog>
</c:forEach>
<script>
const btn = document.getElementById("mw");
btn.addEventListener("click",()=>{
	dmw.showModal();
});
</script>

<!--<c:forEach var="e" items="${cardList}">
<img class="img-pc" src="/B1/img/cook.png"><br>
${e.cook_num}
${e.cook_name}<br>
${e.cook_time}<br>
${e.cook_sta}<br>
${e.cook_fin}<br>
${e.food_con}<br>
${e.food_used}<br>
${e.seas_con}<br>
${e.seas_used}<br>
${e.cook_satis}<br>
${e.aji_satis}<br>
${e.cook_fav}<br>
${e.cook_com}<br>

</c:forEach>-->

</body>
</html>