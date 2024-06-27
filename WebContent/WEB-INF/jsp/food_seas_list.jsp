<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材マイ調味料一覧</title>
<style>
.mv{
 display: flex;
    padding: 5px;
    border: 1px solid #999;
    background: #daf0f2;
}
.box{
/*コレ*/margin: 10px;
    border: 1px solid #999;
    padding: 0 10px;
    background: #FFF;
}


.hm{
  display: flex;
    padding: 10px;
    border: 1px solid #999;
    background: #daf0f2;
}

<!--button {
  color: #090909;
  padding: 0.7em 1.7em;
  font-size: 18px;
  border-radius: 0.5em;
  background: #e8e8e8;
  cursor: pointer;
  border: 1px solid #e8e8e8;
  transition: all 0.3s;
  box-shadow: 6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff;
}

</style>
</head>
<body>
<body>
	<h2>食材調味料の一覧</h2>
	<button type="button" onclick="location.href='/B1/StatusCheckPartServlet?page=foodRegist'">食材登録</button>
			<form method="post" action="/B1/FoodSeasListServlet" name="form">
				<div class="mv"><section>
					<h3 class="title">肉</h3>
					<div class="box">
						<c:forEach var="e" items="${meatList}">
							<input type="checkbox" name="checkbox"
								value="${e.food_seas_num }">
				${e.food_seas_num }
				${e.food_seas_name }
							<hr>
						</c:forEach>
					</div>
				</section>

				<section>
					<h3 class="title">野菜</h3>
					<div class="box">

						<c:forEach var="e" items="${vegeList}">
							<input type="checkbox" name="checkbox"
								value="${e.food_seas_num }">
				${e.food_seas_num }
				${e.food_seas_name }
				<hr>
						</c:forEach>
					</div>
				</section></div>

				<div class="hm"><section>
					<h3 class="title">お助け</h3>
					<div class="box">
						<c:forEach var="e" items="${helpList}">
							<input type="checkbox" name="checkbox"
								value="${e.food_seas_num }">
				${e.food_seas_num }
				${e.food_seas_name }
							<hr>
						</c:forEach>
					</div>
				</section>

				<section>
					<h3 class="title">マイ調味料</h3>
					<div class="box">
						<c:forEach var="e" items="${myseList}">
				${e.food_seas_num }
				${e.food_seas_name }
				<button type="button" onclick="confirmCheck()">在庫の削除</button>
							<input type="checkbox" class="mysestock" value="delete"
								name="mysedel">
							<hr>
						</c:forEach>
					</div>
				</section></div>
				<input type="submit" value="在庫の削除">
			</form>
	<script>
  //チェックされてるかの判定をする
  //判断した結果をどこかに入れる？
  function confirmCheck() {
      const meatdel = document.querySelector("#meatdel")

  function confirmCheck() {
      const vegetdel = document.querySelector("#vegetdel")

  function confirmCheck() {
     const helpdel = document.querySelector("#helpdel")

  function confirmCheck() {
      const mysedel = document.querySelector("#mysedel")
  </script>


</body>
</html>