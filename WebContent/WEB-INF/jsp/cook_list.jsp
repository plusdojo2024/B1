<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html id="hero">
<section >
<head>

<meta charset="UTF-8">
<title>料理の一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
</head>
<header class="header">
  <div class="logo"><img src="/B1/img/logo.png"></div>
  <button class="hamburger-menu" id="js-hamburger-menu">
    <span class="hamburger-menu__bar"></span>
    <span class="hamburger-menu__bar"></span>
    <span class="hamburger-menu__bar"></span>
  </button>
  <nav class="navigation">
    <ul class="navigation__list">
      <li class="navigation__list-item"><a href="#" class="navigation__link">プレイ</a></li>
      <li class="navigation__list-item"><a href="#" class="navigation__link">食材一覧</a></li>
      <li class="navigation__list-item"><a href="#" class="navigation__link">料理一覧</a></li>
      <li class="navigation__list-item"><a href="#" class="navigation__link">スコア</a></li>
    </ul>
  </nav>
</header>

<body>
<main>
	<div class = "favorite">
		<c:forEach var="e" items="${cardList}">
	 	<div>
	 		<img  class="img-pc" id="B${e.cook_num}" src  ="/B1/img/${e.cook_img}">

			<p>${e.cook_num}.${e.cook_name}</p>

	 	</div>
		</c:forEach>
	</div>


	<c:forEach var="e" items="${cardList}">
<dialog id="D${e.cook_num}">
<div class ="dia">
<img class="cp" src="/B1/img/${e.cook_img}">
<p>${e.cook_num}.${e.cook_name}</p>
調理時間&ensp;${e.cook_time}分<br>
開始時間&ensp;${e.cook_sta}<br>
終了時間&ensp;${e.cook_fin}<br>
条件の食材&ensp;${e.food_con}<br>
使った食材&ensp;${e.food_used}<br>
調味料の条件&ensp;${e.seas_con}<br>
使った調味料&ensp;${e.seas_used}<br>
調理の満足度&ensp;${e.cook_satis}<br>
味の満足度&ensp;${e.aji_satis}<br>
お気に入り(D=旨い)(E=努力)(F=早い)&ensp;${e.cook_fav}<br>
コメント&ensp;${e.cook_com}<br>
</div>
</c:forEach>
</dialog>

</main>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script>
<c:forEach var="e" items="${cardList}">
const Button${e.cook_num}= document.getElementById("B${e.cook_num}");
Button${e.cook_num}.addEventListener("click",()=>{
	D${e.cook_num}.showModal();
});
</c:forEach>
$(function () {
	  $('#js-hamburger-menu, .navigation__link').on('click', function () {
	    $('.navigation').slideToggle(500)
	    $('.hamburger-menu').toggleClass('hamburger-menu--open')
	  });
	});
</script>



<footer>
	<a href="/B1/HyousyouServlet" class="btn">表彰一覧へ</a>

</footer>


</body>
</section>
</html>
