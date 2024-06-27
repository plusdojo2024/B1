package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HontourokuDAO;
import dao.RoundsDAO;

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

		HttpSession session = request.getSession();

		int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

		if (session.getAttribute("user_num") == null) {
			response.sendRedirect("/WEB-INF/jsp/login.jsp");
			return;

		}else {

			// リクエストパラメータを取得する
			//request.setCharacterEncoding("UTF-8");
			//String cook_time = request.getParameter("cook_time");
			//String cook_com = request.getParameter("cook_com");

			// 検索処理を行う
				 HontourokuDAO hDao = new HontourokuDAO();
					String[] cooks = hDao.select(user_num);

			// 検索結果をリクエストスコープに格納する
				request.setAttribute("cooks", cooks);



			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_regist.jsp");
			dispatcher.forward(request, response);


		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();


        if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/WEB-INF/jsp/login.jsp");
            return;

        }else {

        	int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

        	RoundsDAO rDAO = new RoundsDAO();
        	Boolean result = rDAO.UpdateTour(user_num , "PLAY_STATUS" ,"本登録" );

        	RequestDispatcher dispatcher = request.getRequestDispatcher("StatusCheckPartServlet");
			dispatcher.forward(request, response);


        }
    }
}

