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
          <p>肉一覧</p>
            <c:forEach var="e" items="${meatList}" >

				${e.food_seas_num },${e.food_seas_name },${e.food_seas_genre },	${e.food_seas_stock }
				<hr>
			</c:forEach>

        </div>
      </section>
    </li>
    <li>
      <section>
        <h3 class="title">野菜</h3>
        <div class="box">
          <p>野菜一覧</p>
         	 <c:forEach var="e" items="${vegeList}" >

				${e.food_seas_num },${e.food_seas_name },${e.food_seas_genre },	${e.food_seas_stock }
				<hr>
			</c:forEach>



        </div>
      </section>
    </li>
    <li>
      <section>
        <h3 class="title">お助け</h3>
        <div class="box">
          <p>お助け一覧</p>
            <c:forEach var="e" items="${helpList}" >

				${e.food_seas_num },${e.food_seas_name },${e.food_seas_genre },	${e.food_seas_stock }
				<hr>
			</c:forEach>
        </div>
      </section>

    </li>
  </ul>

</body>
</html>