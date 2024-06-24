package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cooksDAO;


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



		int user_num = 1;
		String column_name ="COOK_IMG";
		String value ="test.jpeg";
		// int cook_time = 15;

		boolean result = cooksDAO.updateCook(user_num, column_name, value);




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

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = request.getParameter("jsp");
//

		String pass = "/WEB-INF/jsp/" + jsp +".jsp";
//
		String servlet = request.getParameter("servlet");

//		String pass="";

		if(jsp.length() != 0) {
		pass = "/WEB-INF/jsp/" + jsp +".jsp";
		}else {
		pass =   servlet ;
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
		dispatcher.forward(request,response);
	}

}

