package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodSeasDAO;

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

        // 食材の提示
        FoodSeasDAO fcDao = new FoodSeasDAO();
        List<String> foodSeasNames = fcDao.getRandomFoodSeasNamesByGenreAndStock();

        // 調味料とお助けの表示も。



        // セッションスコープにfoodSeasNamesを保存
        session.setAttribute("foodSeasNames", foodSeasNames);

        // play.jspにフォワード
        request.getRequestDispatcher("/play.jsp").forward(request, response);

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
