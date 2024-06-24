<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<section id="hero">
<head>

<meta charset="UTF-8">
<title>料理の一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
</head>
<body>
<main>
	<div class = "favorite">
		<c:forEach var="e" items="${cardList}">
	 	<div>
	 		<img  class="img-pc" id="B${e.cook_num}" src  ="/B1/img/cook.png">

			<p>${e.cook_num}.${e.cook_name}</p>

	 	</div>
		</c:forEach>
	</div>
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



<footer>
	<a href="/B1/HyousyouServlet" class="btn">表彰一覧へ</a>

</footer>


</body>
</section>
</html>
