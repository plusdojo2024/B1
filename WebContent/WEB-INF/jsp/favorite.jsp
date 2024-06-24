<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html id="hyousyou">
<section >
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<main>

	<div class = "favor">

		<button class="example1" type="button" >早</button>
		<button class="example2" type="button">旨</button>
		<button class="example3" type="button">努</button>

</div>
<div id= "demo">
<ul class="scroll_content">
	<c:forEach var="e" items="${cardList}">
		<li>
<img  class="img-pc"  src  ="/B1/img/cook.png">
<p>${e.cook_num}.${e.cook_name}</p>
<p>作った日付<br>${e.cook_date}</p>
		</li>
</c:forEach>
<<<<<<< HEAD
</ul>
</div>


</main>

<script>

const button = document.querySelector("button");
button.addEventListener("click", toggleDisplay);

function toggleDisplay() {
  const demo = document.querySelector("#demo");
  demo.classList.toggle("hidden");
};
</script>

</section>
<footer>
	<a href="/B1/FavoriteServlet" class="btn">料理一覧へ</a>
</footer>
=======
お気に入り一覧
</body>
>>>>>>> 673d0f3004db7507e0e173e19827a662453de0ff
</html>