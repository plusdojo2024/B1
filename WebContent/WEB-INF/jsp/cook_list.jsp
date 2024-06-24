<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>料理の一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
</head>
<body>
<section id="hero">
<ul>
<<<<<<< HEAD

<c:forEach var="e" items="${cardList}">
 <img id="mw" class="img-pc" src="/B1/img/cook.png"><br>
<p>${e.cook_num}</p>
<p>${e.cook_name}</p>
</c:forEach>
</ul>
</section>
=======
	<c:forEach var="e" items="${cardList}">
 		<img id="mw" class="img-pc" src="/B1/img/cook.png"><br>
			<p>${e.cook_num}</p><br>
			<p>${e.cook_name}</p>
	</c:forEach>

</ul>

<main>
	<div class = "favorite">
		<c:forEach var="e" items="${cardList}">
	 	<div>
	 		<img id="mw" class="img-pc" src="/B1/img/cook.png">
			<p>${e.cook_num}.${e.cook_name}</p>
	 	</div>
		</c:forEach>
	</div>
<<<<<<< HEAD
	<c:forEach var="e" items="${cardList}">
<dialog class="dia" id="D${e.cook_num}">

<img class="img-pc" src="/B1/img/cook.png">
<p>${e.cook_num}.${e.cook_name}</p>
作った日付&ensp;${e.cook_date}<br>
調理時間&ensp;${e.cook_time}分<br>
開始時間&ensp;${e.cook_sta}<br>
終了時間&ensp;${e.cook_fin}<br>
提示された食材&ensp;${e.food_con}<br>
使用した食材&ensp;${e.food_used}<br>
提示された調味料&ensp;${e.seas_con}<br>
使用した調味料&ensp;${e.seas_used}<br>
調理満足度&ensp;${e.cook_satis}<br>
味満足度&ensp;${e.aji_satis}<br>
お気に入り(D=旨い)(E=努力)(F=早い)&ensp;${e.cook_fav}<br>
コメント&ensp;${e.cook_com}<br>
</c:forEach>
</dialog>
</main>
<script>
<c:forEach var="e" items="${cardList}">
const Button${e.cook_num}= document.getElementById("B${e.cook_num}");
Button${e.cook_num}.addEventListener("click",()=>{
	D${e.cook_num}.showModal();
}
);
</c:forEach>
</script>
=======
</main>
>>>>>>> 6024936d52bc4a3d136c8cec11c0f5c237c8245f

<!--  ${e.cook_time}<br>
${e.cook_sta}<br>
${e.cook_fin}<br>
${e.food_con}<br>
${e.food_used}<br>
${e.seas_con}<br>
${e.seas_used}<br>
${e.cook_satis}<br>
${e.aji_satis}<br>
${e.cook_fav}<br>
${e.cook_com}<br>-->
>>>>>>> 673d0f3004db7507e0e173e19827a662453de0ff



</body>
</html>