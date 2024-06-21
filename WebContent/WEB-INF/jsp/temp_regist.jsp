<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仮登録</title>
</head>
<body>
<header>
    <p>完成!!</p>
</header>
<main>
    <section>
        <span>調理時間</span>
        <!-- <div> DBの値を用いて調理時間を表示 EL式?? </div> -->
    </section>

    <section>
        <form action="jsp" method="post">
            <label for="inputText">コメント</label>
            <input type="text" id="inputText" name="inputText" required>
            <input type="submit" value="">
        </form>
    </section>
    <section>
        <!-- キャラ画像 -->
    </section>

    <div>
        本登録に進む
    </div>

</main>


</body>
</html>