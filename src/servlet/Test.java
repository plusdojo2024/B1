package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		/*
		int user_num = 18;
		String region = "日本";

		String[] PlaySeasList = SeasDAO.getSeasCon(user_num,region);
		request.setAttribute("PlaySeasList",PlaySeasList );

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request,response);
		*/

		/*
		String user_num = "1";

		HttpSession session = request.getSession();
		session.setAttribute("user_num", user_num);

		RequestDispatcher dispatcher = request.getRequestDispatcher("StatusCheckPartServlet?page=DefinitiveRegistration");
		dispatcher.forward(request,response);
		*/
		/*
		int user_num = 1;
		FoodSeasDAO fsDAO = new FoodSeasDAO();
		List<FoodSeasListmodel> FoodSeasList = fsDAO.select(user_num);



		request.setAttribute("FS",FoodSeasList );
		*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request,response);

		/**/


		/*単体テスト
		int user_num = 1;
		int round_num = 21;
		int hole_num = 2;

		Boolean result = RoundsDAO.AddHole(user_num,round_num,hole_num);
		*/

		/*単体テスト
		int user_num = 1;
		Boolean result = ToursDAO.AddRound1_AddTour(user_num);
		*/

		/*
		int user_num = 1;

		Boolean result = RoundsDAO.UpdateTour(user_num , "FOOD_SEAS_NUM" ,"3" ) ;
		*/
		/*
		String[] Status = StatusDAO.getStatus(user_num);

		String now_round = Status[4];
		int tour_num = Integer.parseInt(Status[1]);

		Boolean result = RoundsDAO.AddRoundUpdateTour(user_num,now_round,tour_num);
		*/
		/*
		result = ToursDAO.ChangeRoundStatus(user_num);


		String[] Status = StatusDAO.getStatus(user_num);
		request.setAttribute("Status",Status );

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request,response);
		*/


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

