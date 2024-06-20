package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う
		FoodSeasListDAO fDao = new FoodSeasListDAO();
		//ここを改造しました
		String food_seas_genre = "vege";
		List<FoodSeasListmodel> fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("vegeList",fslList);

		 food_seas_genre = "meat";
		 fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("meatList",fslList);

		 food_seas_genre = "help";
		fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("helpList",fslList);

		food_seas_genre = "myse";
		 fslList = fDao.select(food_seas_genre);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("myseList",fslList);

	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_list.jsp");
	dispatcher.forward(request, response);
}
	public void vegedel() {
//        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String[] check = request.getParameterValues("check");
		HttpSession session = request.getSession();
		ArrayList<FoodSeasListmodel> fslList = (ArrayList<FoodSeasListmodel>)session.getAttribute("vegelist");

		if(check != null) {
			for(int j = check.length-1; j >=0; j--) {
				if(check[j] != null) {
					int a = Integer.parseInt(check[j]);
					fslList.remove(a);
				}
			}
		}
				request.setAttribute("vegelist",fslList);
				RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
				rd.forward(request, response);

			}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// TODO Auto-generated method stub
						doGet(request, response);
	}
}



