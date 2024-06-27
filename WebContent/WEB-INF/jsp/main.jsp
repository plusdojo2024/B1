<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/main.css" rel="stylesheet" type="text/css">
<title>ＴＯＰ</title>
</head>
<body>

<div class="container">

    <!-- プレイボタン -->
    <div class="playButton">
        <a href="/B1/StatusCheckServlet?page=Play">
            <img src="/B1/img/golf_ball.png" class="img">
        </a>
    </div>

    <!-- 本登録ボタン -->
    <div class="registButton">
        <a href="/B1/StatusCheckServlet?page=Regist" class="ahref">
            <div class="SelectBlockName">
                <h1>本登録</h1>
            </div>
        </a>
    </div>

    <!-- 残りの3つのボタン -->
    <div class="buttonRow">
        <div class="SelectBlock">
            <a href="/B1/StatusCheckServlet?page=Cooks" class="ahref">
                <div class="SelectBlockName">
                    <h1>料理の一覧</h1>
                </div>
            </a>
        </div>
        <div class="SelectBlock">
            <a href="/B1/StatusCheckServlet?page=Foods" class="ahref">
                <div class="SelectBlockName">
                    <h1>食材の登録</h1>
                </div>
            </a>
        </div>
        <div class="SelectBlock">
            <a href="/B1/StatusCheckServlet?page=Score" class="ahref">
                <div class="SelectBlockName">
                    <h1>スコア記録</h1>
                </div>
            </a>
        </div>
    </div>

    <dialog>
        <div>${Message[0]}</div>
        <div>${Message[1]}</div>
        <button>ＯＫ</button>
    </dialog>
    <script>
        window.addEventListener("load", (event) => {
            const MessageDialog = document.getElementById("");
        });
    </script>

</div>

</body>
</html>