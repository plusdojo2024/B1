package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodSeasDAO;
import dao.HontourokuDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/DefinitiveRegistrationServlet")
public class DefinitiveRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// user_num取得する
		int user_num =1;

		// リクエストパラメータを取得する
		//request.setCharacterEncoding("UTF-8");
		//String cook_time = request.getParameter("cook_time");
		//String cook_com = request.getParameter("cook_com");

		// 検索処理を行う
			 HontourokuDAO hDao = new HontourokuDAO();
				String[] cooks = hDao.select(user_num);

			 FoodSeasDAO fDAO = new FoodSeasDAO();
			    List<String> foodSeasNames = fDAO.getRandomFoodSeasNamesByGenreAndStock(new String());
                //String[] food = hDao.choose(user_num);

		// 検索結果をリクエストスコープに格納する
			request.setAttribute("cooks", cooks);
			request.setAttribute("foodSeasNames", foodSeasNames);
			//request.setAttribute("food", food);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_regist.jsp");
		dispatcher.forward(request, response);

		/* 登録処理を行う
		HontourokuDAO hDao = new HontourokuDAO();
		if (hDao.insert(new Hontouroku(0, complete, used, taste, cook, favorite
						))) {	// 登録成功
		request.setAttribute("result",
		new Result("登録成功！", "レコードを登録しました。", "/B1/DefinitiveRegistrationServlet"));
		}
		else {												// 登録失敗
		request.setAttribute("result",
		new Result("登録失敗！", "レコードを登録できませんでした。", "/B1/DefinitiveRegistrationServlet"));
		      }

		// 結果ページにフォワードする
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_regist.jsp");
		dispatcher.forward(request, response);*/
	}
}

