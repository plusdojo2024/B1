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

import model.NowTourScore;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 仮のデータとしてscoreListを作成する
    	List<NowTourScore> scoreList = new ArrayList<NowTourScore>();


        // scoreListをリクエスト属性に設定
        request.setAttribute("scoreList", scoreList);

     // 結果ページにフォワードする
     		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
     		dispatcher.forward(request, response);
    }
}