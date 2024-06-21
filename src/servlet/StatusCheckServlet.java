package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StatusDAO;

/**
 * Servlet implementation class StatesCheck
 */
@WebServlet("/StatusCheckServlet")
public class StatusCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

		if (session.getAttribute("user_num") == null) {
			response.sendRedirect("/B1/LoginServlet");
			return;

		}else {
		//ログイン成功時の処理

			//セッションスコープ内のuser_numを取り出す
			int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

			//サーブレットについたタグを読み取る
			String page = request.getParameter("page");
			if( page.equals("Cooks") || page.equals("Foods")) {
			//料理一覧と食材一覧はプレイステータス関係なし

				if( page.equals("Cooks")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("ShowDishList");
					dispatcher.forward(request,response);
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher("FoodSeasListServlet");
					dispatcher.forward(request,response);
				}

			}else if( page.equals("Play") || page.equals("Regist") ) {
				//プレイは調理前のみ、本登録は仮登録済みのみ

				String[] Status = StatusDAO.getStatus(user_num);

				if(Status != null) {

					if( page.equals("Play")) {
						//プレイ選択時
						if(Status[5].equals("調理前")) {

							RequestDispatcher dispatcher = request.getRequestDispatcher("WorldTourPlayServlet");
							dispatcher.forward(request,response);

						}else {
							// エラーメッセージをリクエストスコープに格納する
							String[] ErrorMessage = {"プレイだめ","だめ"};
							request.setAttribute("ErrorMessage",ErrorMessage );

							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
							dispatcher.forward(request,response);
						}

					}else {
						//本登録選択時
						if(Status[5] .equals("仮登録")) {
							RequestDispatcher dispatcher = request.getRequestDispatcher("DefinitiveRegistrationServlet");
							dispatcher.forward(request,response);
						}else {
							// エラーメッセージをリクエストスコープに格納する
							String[] ErrorMessage = {"本登録だめ","だめ"};
							request.setAttribute("ErrorMessage",ErrorMessage );

							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
							dispatcher.forward(request,response);
						}
					}

			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request,response);
			};

		}else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request,response);

		}
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
