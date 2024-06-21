package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodSeasListDAO;
import model.FoodSeasListmodel;

/**
 * Servlet implementation class foodSeasList
 */
@WebServlet("/FoodSeasListServlet")
public class FoodSeasListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 検索処理を行う
		FoodSeasListDAO fDao = new FoodSeasListDAO();
		//ここを改造しました
		String food_seas_genre = "vege";
		List<FoodSeasListmodel> fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("vegeList", fslList);

		food_seas_genre = "meat";
		fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("meatList", fslList);

		food_seas_genre = "help";
		fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("helpList", fslList);

		food_seas_genre = "myse";
		fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("myseList", fslList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		////各食材ごとに削除ボタンを作成する
		//		FoodSeasListDAO fDao = new FoodSeasListDAO();
		//		if(request.getParameter("submit").equals("削除")) {
		//			request.setAttribute("result",
		//			new Result("削除成功！", "レコードを削除しました。", "/B1//FoodSeasListServlet"));
		//		}
		//		else {						// 削除失敗
		//			request.setAttribute("result",
		//			new Result("削除失敗！", "レコードを削除できませんでした。", "/B1//FoodSeasListServlet"));
		//			}

		////チェックボックスがチェックされたら削除する
		//	// 更新または削除を行う
		//	FoodSeasListDAO fDao = new FoodSeasListDAO();
		//	if (request.getParameter("meatdel").equals("在庫の削除")){
		//		if(meatdel.checked) {
		//
		//		}
		//	}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_list.jsp");
		dispatcher.forward(request, response);

	}

}
