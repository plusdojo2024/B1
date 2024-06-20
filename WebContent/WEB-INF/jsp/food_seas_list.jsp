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
				在庫
				<input type="checkbox" class="meatstock" value="delete" name="meatdel">
				<hr>
			</c:forEach>
			<button type="button">在庫の削除</button>
        </div>
      </section>
    </li>

    <li>
      <section>
        <h3 class="title">野菜</h3>
        <div class="box">
         	 <c:forEach var="e" items="${vegeList}" >
				${e.food_seas_num },
				${e.food_seas_name },
				${e.food_seas_genre },
				${e.food_seas_stock }
				在庫
				<form action="vegedel" method="get">
				<% for(int i = 0; i < vegeList.size(); i++) { %>
				<%out.print(i+1); %>
				<%= vegeList.get(i).getName()%>
				<input type="checkbox" name="check" value="<%=i%>"><br>

				<% } %>
				<input type="submit" value="在庫の削除">
				</form>

				<hr>
			</c:forEach>
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
				${e.food_seas_stock }
				<input type="checkbox" class="helpstock" value="delete" name="helpdel">
				<hr>
			</c:forEach>
			<button type="button" >在庫の削除</button>
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
				${e.food_seas_stock }
				<input type="checkbox" class="mysestock" value="delete" name="mysedel">

				<hr>
			</c:forEach>
        <button type="button" onclick ="confirmCheck()">在庫の削除</button>
        </div>

      </section>
    </li>
</ul>

</body>
</html>