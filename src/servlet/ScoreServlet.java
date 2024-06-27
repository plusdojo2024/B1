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

import dao.PastDAO;
import model.PastScore;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();

    	if (session.getAttribute("user_num") == null) {
			response.sendRedirect("/WEB-INF/jsp/login.jsp");
			return;

		}else {

			//ログイン成功時の処理
			//セッションスコープ内のuser_numを取り出す
			int user_num = Integer.parseInt((String)session.getAttribute("user_num"));


			String score = request.getParameter("score");


			if(score.equals("current")) {

	    	// 検索処理を行う
	    	PastDAO pDao = new PastDAO();

	    	// ここを改造しました
	    	List<PastScore> pastList = pDao.select(user_num);

	    	// 検索結果をリクエストスコープに格納する
	    	request.setAttribute("pastList", pastList);

	    	// メニューページにフォワードする
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
	    	dispatcher.forward(request, response);
			}else if(score.equals("past")) {
				// 検索処理を行う
		    	PastDAO pDao = new PastDAO();

		    	// ここを改造しました
		    	List<PastScore> pastList = pDao.select(user_num);

		    	// 検索結果をリクエストスコープに格納する
		    	request.setAttribute("pastList", pastList);

		    	// メニューページにフォワードする
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/past_score.jsp");
		    	dispatcher.forward(request, response);
			}
		}
}}