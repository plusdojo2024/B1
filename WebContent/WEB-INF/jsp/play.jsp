<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>調理中画面｜献立ゴルフ</title>

   <style>
        /* @media (max-width: 400px) {
        body {
            max-width: 383px;
        }
        } */

        main {
        width: 350px;
        padding: 0;
        }

        /* ゴルフテーマのデザイン追加 */
        body {


        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #e0f7fa; /* ゴルフコースのような爽やかな青緑色 */
        border: 2px solid #2e7d32; /* ゴルフコースのグリーンのような色 */
        max-width: 350px;
        margin: auto;
        }

        header {
        background-color: #2e7d32; /* ゴルフコースのグリーンのような色 */
        color: white;
        text-align: center;
        padding: 0.5em 0;
        }

        h1 {
        text-align: center;
        margin: 0;
        font-family: 'Georgia', serif; /* クラシックな雰囲気のフォント */
        background-color: #4CAF50;
        color: white;
        padding: 5px;
        border-radius: 5px;
        font-size: 1.5em;
        }

        ul {
        padding: 0;
        margin: 0;
        }

        .ul1, .ul2, .ul3 {
        display: flex; /* 横並びにする */
        justify-content: space-between; /* 均等に配置 */
        background-color: #f1f8e9; /* ゴルフコースのフェアウェイのような色 */
        border: 1px solid #8bc34a; /* グリーンとフェアウェイの境界色 */
        border-radius: 5px;
        padding: 5px;
        list-style: none; /* デフォルトのリストスタイルを削除 */
        margin-bottom: 5px;
        }

        .ul1 li, .ul2 li, .ul3 li {
        flex: 1; /* 各項目を等間隔に配置 */
        margin: 0 3px; /* 各項目の間に少し間隔を空ける */
        text-align: center;
        background-color: #c8e6c9; /* ゴルフボールのような色 */
        border-radius: 5px;
        padding: 5px;
        font-size: 0.9em;
        }

        .leftTime {
        padding-left: 15px;
        font-size: 1em;
        }

        #timer {
        width: 230px;
        height: 70px;
        font-size: 1.5em;
        text-align: center;
        background-color: #fff9c4; /* ゴルフ場の砂のような色 */
        border: 2px solid #fbc02d;
        border-radius: 5px;
        margin-bottom: 5px;
        }

        .pause {
        width: 70px
        }
        .freeSeas {
            display: flex; /* 横並びにする */
            justify-content: space-between; /* 均等に配置 */
            background-color: #f1f8e9; /* ゴルフコースのフェアウェイのような色 */
            border: 1px solid #8bc34a; /* グリーンとフェアウェイの境界色 */
            border-radius: 5px;
            padding: 5px;
            list-style: none; /* デフォルトのリストスタイルを削除 */
            margin-bottom: 5px;
            width: 100px;
        }

  .button {
  background: white;
  width: 350px;
  height: 650px;
  font-size: 40px;
  border-radius: 5px;
  font-weight: 900;
  position: relative;
  font-family: serif;
}

#img{
	test-align:center;
	width: 80%;
}

.modal {
  display: none;
  position: fixed;
  z-index: 1;
  height: 650px;
  width: 350px;
  overflow: auto;
  background-color: rgba(255, 255, 255, 1);
}

.modal-content {
  background-color: #FFFFFF;
  width: 350px;
  height: 650px;
  animation-name: modalopen;
  animation-duration: 1s;
}

.modalClose:hover {
  cursor: pointer;
}
    </style>

</head>
<body>
	<div id="StartModal" class="modal">
        <div class="modal-content">

            <button class="modalClose button"><img id="img" src  ="/B1/img/cook.png"><br>画面をタップして<br>START!!!</button>
        </div>
    	</div>

    <h1>調理画面</h1>
    <div class="playHead">
        <ul class="ul1">
            <li class="li1"><span>${play[11]}</span><br></li>     <!-- コース -->
            <li class="li1"><span>${play[12]}</span><br></li>     <!-- 国名 -->
            <li class="li1"><span>${play[13]}<br>${play[14]}<br></span></li>     <!-- ホール数 -->
        </ul>
    </div>

    <main>

        <div class="condition">

            <ul class="ul2">
                <li><div id="timer">残り時間<br><span id="countdown"></span></div></li>
                <li><div class="pause">一時停止</div></li>
            </ul>
            <section><!-- 肉と野菜 -->
                <div class="hTitle">必須食材</div>
                <div>
                    <div class="essentialItems">
                        <ul class="ul3">
                            <li><span>${play[1]}</span></li><!-- 肉 -->
                            <li><span>${play[2]}</span></li><!-- 野菜1 -->
                            <li><span>${play[3]}</span></li><!-- 野菜2 -->
                        </ul>
                    </div>
                </div>
            </section>
            <section><!-- 調味料 -->
                <div>
                    <div class="hTitle">FREE調味料</div>
                    <ul class="ul2">
                        <li><span>${play[6]}</span></li>
                    </ul>
                </div>
                <div>
                    <div class="hTitle">制限付き調味料</div>
                    <ul class="ul2">
                        <li><span>${play[7]}</span></li>
                        <li><span>${play[8]}</span></li>
                    </ul>
                </div>
                <div>
                    <div class="hTitle">禁止調味料</div>
                    <ul class="ul2">
                        <li><span>${play[9]}</span></li>
                        <li><span>${play[10]}</span></li>
                    </ul>
                </div>
            </section>
            <section><!-- お助け -->
                <div class="hTitle">お助け食材・調味料</div>
                <ul class="ul2">
                    <li><span>${play[4]}</span></li>
                    <li><span>${play[5]}</span></li>
                </ul>
            </section>
        </div>
    </main>
    <br>
    <br>

    <form method="post" action="/B1/SetPlayingConditionsServlet" enctype="multipart/form-data" id="cook">
        <input type="file" name="image" accept="image/*" class="required" required>
                    <input type="hidden" id="cook_sta" name="cook_sta">
        <input type="submit" name="regist" value="完成！" id="submit"><br>
    </form>

    <div id="StartModal" class="modal">
  		<div class="modal-content">
    	<button class="modalClose button">始める</button>
  		</div>
	</div>

    <script>
    const modal = document.getElementById('StartModal');

    window.onload = function(){
      modal.style.display = 'block';
    }

    const buttonClose = document.getElementsByClassName('modalClose')[0];

    // 始めるがクリックされた時
    buttonClose.addEventListener('click', modalClose);
    function modalClose() {

      modal.style.display = 'none';

      var duration = 1000 * 60 * 15; // 15分をミリ秒で表したもの
      startCountdown(duration)

      let now = new Date();
      let hours = now.getHours().toString().padStart(2, '0');
      let minutes = now.getMinutes().toString().padStart(2, '0');
      let seconds = now.getSeconds().toString().padStart(2, '0');

      let timeString = hours + ':' + minutes + ':' + seconds;

      document.getElementById('cook_sta').value = timeString;
    }

    // モーダルコンテンツ以外がクリックされた時
    addEventListener('click', outsideClose);
    function outsideClose(e) {
      if (e.target == modal) {
        modal.style.display = 'none';
      }
    }

    // カウントダウン関数
    function startCountdown(duration) {
    var timer = duration;
    setInterval(function () {
  	  var milliseconds = timer % 1000; // ミリ秒部分を取得
  	    milliseconds = Math.floor(milliseconds / 10); // ミリ秒の末尾の1桁を削除
      var seconds = Math.floor((timer / 1000) % 60);
      var minutes = Math.floor((timer / 1000 / 60) % 60);

      // ミリ秒を3桁で表示するためのフォーマット
      var formattedMilliseconds = ('00' + milliseconds).slice(-2);

      // idが"countdown"の要素にカウントダウンタイマーを表示
      document.getElementById('countdown').textContent = minutes + "分 " + seconds + "." + formattedMilliseconds + "秒 ";

      	timer = timer - 10;

      if (timer < 0) {
      	document.getElementById('countdown').textContent = "??分 ??.??秒";
      }

    }, 10);
  }
    </script>
</body>
</html>