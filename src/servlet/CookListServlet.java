package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.cooksDAO;
import model.cooks;


@WebServlet("/CookListServlet")
public class CookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

		if (session.getAttribute("user_num") == null) {

			response.sendRedirect("/WEB-INF/jsp/login.jsp");
			return;

		}else {
		//ログイン成功時の処理


		String cooks = request.getParameter("cooks");


		int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

		if(cooks.equals("favorite")) {
		// 検索処理を行う
		cooksDAO bDao = new cooksDAO();
		// ここを改造しました
		List<cooks> cardList = bDao.select(user_num);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);


		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite.jsp");
		dispatcher.forward(request, response);
		return;
		}else if(cooks.equals("list")) {

		cooksDAO bDao = new cooksDAO();
		// ここを改造しました
		List<cooks> cardList = bDao.select(user_num);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cook_list.jsp");
		dispatcher.forward(request, response);
		return;
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cook_list.jsp");
			dispatcher.forward(request, response);
			return;
		}
		}
	}


}

