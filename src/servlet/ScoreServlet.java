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
   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // リクエストパラメータを取得する
            request.setCharacterEncoding("UTF-8");
            int user_num = Integer.parseInt(request.getParameter("user_num"));
        	int tour_num = Integer.parseInt(request.getParameter("tour_num"));
        	int round_num = Integer.parseInt(request.getParameter("round_num"));
        	int scores_num = Integer.parseInt(request.getParameter("scores_num"));
        	int hole_num = Integer.parseInt(request.getParameter("hole_num"));
        	int tour_sta = Integer.parseInt(request.getParameter("tour_sta"));
        	int tour_fin = Integer.parseInt(request.getParameter("tour_fin"));
        	int cook_num = Integer.parseInt(request.getParameter("cook_num"));
        	int scores = Integer.parseInt(request.getParameter("scores"));


            // 検索処理を行う
            List<PastScore> pastList = PastDAO.select(new PastScore(user_num,tour_num,round_num,scores_num,hole_num,tour_sta,tour_fin,cook_num,scores));

            // 検索結果をリクエストスコープに格納する
            request.setAttribute("pastList", pastList);

            // 結果ページにフォワードする
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            // 数値変換エラーが発生した場合の処理
            e.printStackTrace(); // エラーをコンソールに出力
            // または、適切なエラーページにリダイレクトするなどの処理を行う
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "数値の形式が正しくありません");
        }
    }*/
