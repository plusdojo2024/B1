package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class DefinitiveRegistration
 */
@WebServlet("/DefinitiveRegistration")
public class DefinitiveRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefinitiveRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	// もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
	if (session.getAttribute("id") == null) {
		response.sendRedirect("/B1/login.java");
		return;
	}

	// 登録ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
	if (session.getAttribute("id") == null) {
		response.sendRedirect("/B1/login.java");
		return;
	}

	// リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String cook_time = request.getParameter("cook_time");
	String cook_com = request.getParameter("cook_com");

	// ↑とってきたやつ（cook_timeとcook_com）を表示したい

	// 登録処理を行う
	BcDAO bDao = new BcDAO();
	if (bDao.insert(new Bc(0, cook_time, cook_com))) {	// 登録成功
		request.setAttribute("result",
		new Result("登録成功！", "レコードを登録しました。", "/B1/Current.java"));  //←登録したやつを現在のスコアで表示させたい
	}
	else {												// 登録失敗
		request.setAttribute("result",
		new Result("登録失敗！", "レコードを登録できませんでした。", "/B1/Current.java"));
	}
	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_regist.jsp");
	dispatcher.forward(request, response);

}
