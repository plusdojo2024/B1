package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cooksDAO;
import model.cooks;


@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
			//response.sendRedirect("/simpleBC/LoginServlet");
			//return;
		//}




		// 検索処理を行う
		cooksDAO bDao = new cooksDAO();
		// ここを改造しました
		int user_num=1;
		List<cooks> cardList = bDao.select(user_num);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);



		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cook_list.jsp");
		dispatcher.forward(request, response);
	}


}

