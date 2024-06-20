package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String scores_num = request.getParameter("scores_num");
		String par = request.getParameter("par");
		String time_scores = request.getParameter("time_scores");
		String food_scores = request.getParameter("food_scores");
		String seas_scores = request.getParameter("seas_scores");
		String cook_scores = request.getParameter("cook_scores");
		String taste_scores = request.getParameter("taste_scores");
		String total_score = request.getParameter("total_score");

        // 結果ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
        dispatcher.forward(request, response);
    }
}