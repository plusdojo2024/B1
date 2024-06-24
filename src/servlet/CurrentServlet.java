package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDAO;
import model.NowTourScore;

@WebServlet("/CurrentServlet")
public class CurrentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 検索処理を行う
    	ScoreDAO sDao = new ScoreDAO();
    	// ここを改造しました
    	int scores_num=1;
    	List<NowTourScore> scoreList = sDao.select(scores_num);

    	// 検索結果をリクエストスコープに格納する
    	request.setAttribute("scoreList", scoreList);

    	// メニューページにフォワードする
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/today_scores.jsp");
    	dispatcher.forward(request, response);
    }
}
