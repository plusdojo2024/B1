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

/**
 * Servlet implementation class SetPlayingConditions
 */
@WebServlet("/SetPlayingConditions")
public class SetPlayingConditions extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPlayingConditions() {
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
        List<String> foodSeasNames = fcDao.getRandomFoodSeasNames();

        request.setAttribute("foodSeasNames", foodSeasNames);
        request.getRequestDispatcher("/food_seas_display.jsp").forward(request, response);

        // webブラウザからのリクエスト（国内か海外かランダムか）を受け取り、それに応じて調味料を返す。
		//





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
