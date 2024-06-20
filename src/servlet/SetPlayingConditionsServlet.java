package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodSeasDAO;

/**
 * Servlet implementation class SetPlayingConditions
 */
@WebServlet("/SetPlayingConditionsServlet")
public class SetPlayingConditionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPlayingConditionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインセッションが切れていたらログイン画面に戻す
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            response.sendRedirect("/B1/login");
            return;
        }

        // 食材の提示
        FoodSeasDAO fcDao = new FoodSeasDAO();
        try {
            List<String> foodSeasNames = fcDao.getRandomFoodSeasNamesByGenreAndStock();

            // セッションスコープにfoodSeasNamesを保存
            session.setAttribute("foodSeasNames", foodSeasNames);

            request.getRequestDispatcher("/play.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "必要な食材が見つかりませんでした。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}