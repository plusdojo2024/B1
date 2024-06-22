<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材マイ調味料一覧</title>
</head>
<body>
食材調味料の一覧
<ul class="accordion-area">
    <li>
      <section>
        <h3 class="title">肉</h3>
        <div class="box">
            <c:forEach var="e" items="${meatList}" >
				${e.food_seas_num },
				${e.food_seas_name },
				${e.food_seas_genre },
				${e.food_seas_stock },
				<button type="button">在庫の削除</button>
				<hr>
			</c:forEach>
        </div>
      </section>
    </li>

    <li>
      <section>
        <h3 class="title">野菜</h3>
        <div class="box">
        	<form method="post" action="/B1/FoodSeasListServlet" name="form">
         	 <c:forEach var="e" items="${vegeList}" >
         	 	<input type="checkbox" name="checkbox" value="${e.food_seas_num }">
				${e.food_seas_num },
				${e.food_seas_name },
				${e.food_seas_genre },
				${e.food_seas_stock },
				<hr>
			</c:forEach>
			<input type="submit" value="チェックボックスの削除">
			</form>
        </div>
      </section>
    </li>
    <li>
      <section>
        <h3 class="title">お助け</h3>
        <div class="box">
            <c:forEach var="e" items="${helpList}" >
				${e.food_seas_num },
				${e.food_seas_name },
				${e.food_seas_genre },
				${e.food_seas_stock },
				<button type="button" >在庫の削除</button>
				<hr>
			</c:forEach>

        </div>
      </section>
    </li>

        <li>
      <section>
        <h3 class="title">マイ調味料</h3>
        <div class="box">
            <c:forEach var="e" items="${myseList}" >
				${e.food_seas_num },
				${e.food_seas_name },
				${e.food_seas_genre },
				${e.food_seas_stock },
				<button type="button" onclick ="confirmCheck()">在庫の削除</button>
				<input type="checkbox" class="mysestock" value="delete" name="mysedel">
				<hr>
			</c:forEach>
        </div>
      </section>
    </li>
  </ul>
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