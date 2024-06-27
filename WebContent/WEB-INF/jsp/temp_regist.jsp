<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仮登録</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #e0f7fa; /* ゴルフコースのような爽やかな青緑色 */
        max-width: 383px;
        margin: auto;
        border: 2px solid #2e7d32; /* ゴルフコースのグリーンのような色 */
    }

    header {
        background-color: #2e7d32; /* ゴルフコースのグリーンのような色 */
        color: white;
        text-align: center;
        padding: 1em 0;
    }

    main {
        padding: 1em;
        background-color: white;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 350px;
    }

    h1 {
        margin: 0;
        font-family: 'Georgia', serif; /* クラシックな雰囲気のフォント */
    }

    .tour-info, .comment-section, .character-section {
        margin-bottom: 1em;
    }

    .tour-info img {
        max-width: 100%;
        height: auto;
    }

    .tour-info span {
        display: block;
        margin-top: 0.5em;
        font-size: 1.2em;
    }

    .comment-section label {
        display: block;
        margin-bottom: 0.5em;
        font-size: 1em;
    }

    .comment-section textarea {
        width: 100%;
        height: 100px;
        padding: 0.5em;
        font-size: 1em;
        border: 1px solid #4caf50; /* ゴルフボールのような白と緑 */
    }

    .comment-section input[type="submit"] {
        margin-top: 1em;
        padding: 0.5em 1em;
        font-size: 1em;
        background-color: #4caf50; /* ゴルフコースのフェアウェイのような色 */
        color: white;
        border: none;
        cursor: pointer;
    }

    .comment-section input[type="submit"]:hover {
        background-color: #45a049;
    }

    .proceed {
        text-align: center;
        font-size: 1.2em;
        margin-top: 2em;
    }

    .proceed a {
        color: #2e7d32; /* ゴルフコースのグリーンのような色 */
        text-decoration: none;
    }

    .proceed a:hover {
        text-decoration: underline;
    }

    @media (max-width: 400px) {
        body {
            max-width: 383px;
        }
    }
</style>
</head>
<body>
<header>
    <h1>完成!!</h1>
</header>
<main>
    <div class="tour-info">
        参加中のツアー
        <img src="/B1/Image/${cook[0]}" alt="画像" id="Image">
        <span>調理時間${cook[1]}<br></span>
    </div>
    <section class="comment-section">
        <form action="/B1/SaveTemporaryRegistrationServlet" method="post">
            <label for="inputText">コメント</label>
            <textarea id="inputText" name="cook_comment"></textarea>
            <input type="submit">
        </form>
    </section>
    <section class="character-section">
        <!-- キャラ画像 -->
    </section>
    <div class="proceed">
        <a href="#">本登録に進む</a>
    </div>
</main>
</body>
</html>