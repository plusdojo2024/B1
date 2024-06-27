<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html id="hyousyou">
<section >
<head>
<meta charset="UTF-8">
<title>表彰一覧</title>
<link rel="stylesheet" href="/B1/css/cooklist.css">
</head>
<header class="header">
  <div class="logo"></div>
  <button class="hamburger-menu" id="js-hamburger-menu">
    <span class="hamburger-menu__bar"></span>
    <span class="hamburger-menu__bar"></span>
    <span class="hamburger-menu__bar"></span>
  </button>
  <nav class="navigation">
    <ul class="navigation__list">
      <li id="list1" class="navigation__list-item"><a href="#" class="navigation__link">プレイ</a></li>
      <li id="list2" class="navigation__list-item"><a href="#" class="navigation__link">食材一覧</a></li>
      <li id="list3" class="navigation__list-item"><a href="#" class="navigation__link">料理一覧</a></li>
      <li id="list4" class="navigation__list-item"><a href="#" class="navigation__link">スコア</a></li>
    </ul>
  </nav>
</header>
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
<img  class="img-pc"  src  ="/B1/img/${e.cook_img}">
<p>${e.cook_num}.${e.cook_name}</p>
<p>作った日付<br>${e.cook_date}</p>
		</li>
</c:forEach>
</ul>
</div>


</main>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script>

const button = document.querySelector("button");
button.addEventListener("click", toggleDisplay);

function toggleDisplay() {
  const demo = document.querySelector("#demo");
  demo.classList.toggle("hidden");
};
</script>
<script>
$(function () {
	  $('#js-hamburger-menu, .navigation__link').on('click', function () {
	    $('.navigation').slideToggle(500)
	    $('.hamburger-menu').toggleClass('hamburger-menu--open')
	  });
	});
</script>

</section>
<footer>
	<a href="/B1/CookListServlet?cooks=list" class="btn">料理一覧へ</a>
</footer>
</html>
