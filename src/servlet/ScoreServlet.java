package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PastDAO;
import model.PastScore;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 検索処理を行う
    	PastDAO pDao = new PastDAO();
    	// ここを改造しました
    	int user_num=1;
    	List<PastScore> pastList = pDao.select(user_num);

    	// 検索結果をリクエストスコープに格納する
    	request.setAttribute("pastList", pastList);

    	// メニューページにフォワードする
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
    	dispatcher.forward(request, response);
    }
}