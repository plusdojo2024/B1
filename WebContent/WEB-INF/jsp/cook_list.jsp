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
	 		<img id="mw" class="img-pc" src="/B1/img/cook.png">
			<p>${e.cook_num}.${e.cook_name}</p>
	 	</div>
		</c:forEach>
	</div>
<section>

</section >
<dialog id="dmw">

	<div class = "favorite">
		<c:forEach var="e" items="${cardList}">
	 	<div>
	 		<img id="mw" class="img-pc" src="/B1/img/cook.png">
			<p>${e.cook_num}.${e.cook_name}</p>
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


	 	</div>
		</c:forEach>
	</div>
</dialog>
</main>
<script>
const btn = document.getElementById("mw");
btn.addEventListener("click",()=>{
	dmw.showModal();
});
</script>



<footer>
	<a href="/B1/HyousyouServlet" class="btn">表彰一覧へ</a>

</footer>


</body>
</section>
</html>
