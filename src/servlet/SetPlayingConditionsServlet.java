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

import dao.FoodSeasDAO;
import model.FoodSeasListmodel;


@WebServlet("/SetPlayingConditionsServlet")
public class SetPlayingConditionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetPlayingConditionsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインセッションが切れていたらログイン画面に戻す
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            response.sendRedirect("/B1/login");
            return;
        }

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request.setCharacterEncoding("UTF-8");
    	// 食材の提示
        FoodSeasDAO fcDao = new FoodSeasDAO();
        FoodSeasListmodel userNum = new FoodSeasListmodel();
        int user_num = userNum.getUser_num();
        List<FoodSeasListmodel> foodSeasRecord = fcDao.select(user_num);

        // 調味料とお助けの表示も。


        // セッションスコープにfoodSeasNamesを保存
        HttpSession session = request.getSession();
        session.setAttribute("foodSeasNames", foodSeasRecord);

        // 料理ページにフォワードする
     	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/play.jsp");
		dispatcher.forward(request, response);



    }
}
