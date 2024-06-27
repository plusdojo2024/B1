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

import dao.FoodSeasListDAO;
import dao.RoundsDAO;
import dao.ToursDAO;
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

		HttpSession session = request.getSession();

		if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/WEB-INF/jsp/login.jsp");
            return;
        }else {

        int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

		// 検索処理を行う
		FoodSeasListDAO fDao = new FoodSeasListDAO();
		//ここを改造しました
		String food_seas_genre = "vege";
		List<FoodSeasListmodel> fslList = fDao.select(food_seas_genre);

		//すべてfood_seas_stockがtrueのもののみとした。
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/WEB-INF/jsp/login.jsp");
            return;

        }else {

        	int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

        	RoundsDAO rDAO = new RoundsDAO();
	        Boolean result1 = rDAO.UpdateTour(user_num, "PLAY_STATUS","調理前");

	        ToursDAO tDAO = new ToursDAO();
	        Boolean result2 = tDAO.ChangeRoundStatus(user_num);

	        if(result1 && result2) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	    		dispatcher.forward(request, response);
	        }



        }


		/*
		//チェックボックスがチェックされているidの一覧を配列に保存
		String[] checkedId = request.getParameterValues("checkbox");



        //チェックボックスにチェックが入っているデータのfood_seas_stockを「false」に変更
		FoodSeasListDAO cbdao = new FoodSeasListDAO();

		cbdao.change(checkedId);

		response.sendRedirect("/B1/FoodSeasListServlet");

		*/


	}



}