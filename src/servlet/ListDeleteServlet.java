package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.javac.util.List;

import dao.FoodSeasListDAO;
import model.FoodSeasListmodel;
/**
 * Servlet implementation class ListDeleteServlet
 */
@WebServlet("/ListDeleteServlet")
public class ListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//一覧結果を取得
		FoodSeasListDAO fDao = new FoodSeasListDAO();
		List<FoodSeasListmodel> fslList = fDao.selectAll();

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("delList", fslList);

		// 一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//チェックボックスがチェックされているidの一覧を配列に保存
		String[] checkedId = request.getParameterValues("checkbox");

		//チェックボックスにチェックが入っているデータを削除
		FoodSeasListDAO fDao = new FoodSeasListDAO();

		fDao.delete(checkedId);

		response.sendRedirect("/B1/FoodSeasListServlet");
	}
}
