package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoundsDAO;
import dao.StatusDAO;
import dao.ToursDAO;

/**
 * Servlet implementation class StatusCheckPart
 */
@WebServlet("/StatusCheckPartServlet")
public class StatusCheckPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusCheckPartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 絶対いらないTODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/

		HttpSession session = request.getSession();

		int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

		if (session.getAttribute("user_num") == null) {
			response.sendRedirect("/B1/LoginServlet");
			return;

		}else {

			String page = request.getParameter("page");

			//ＤＢの参照のみ
			if(page.equals("play")||page.equals("foodRegsit") ) {

				//ＤＢからステータス取得
				StatusDAO sDAO = new StatusDAO();
				String[] Status = sDAO.getStatus(user_num);

				//プレイ⇒コース選択　調理前のみ通す
				if(page.equals("play")) {

					if(Status[5].equals("調理前")) {

						//条件をセットするサーブレットへ
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("SetPlayingConditionsServlet");
						dispatcher.forward(request,response);

					}else if(Status[5].equals("中断")){

						////条件をセットして調理画面へ
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("SetPlayingConditionsServlet");
						dispatcher.forward(request,response);

					}else if(Status[5].equals("料理中")) {

						//ペナルティセット
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("SetPlayingConditionsServlet");
						dispatcher.forward(request,response);

					}else {

						//mainへ戻す
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
						dispatcher.forward(request,response);
					}

				}else {

					//食材一覧⇒食材登録　ＲＮのみ通す
					if(Status[4].equals("RN")) {

						//通す
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("DefinitiveRegistrationServlet");
						dispatcher.forward(request,response);

					}else {
						//通さない
						RequestDispatcher dispatcher
						= request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
						dispatcher.forward(request,response);
					}
				}
			}

			if(page.equals("DefinitiveRegistration")) {

				/*	本登録後の処理
				 *	①ステータスチェック
				 *	②条件分岐
				 *	・R3のH6
				 *		⇒	新ツアー作成
				 *			(ツアーテーブル更新)
				 *	・R1,2のH6
				 *		⇒	新ラウンド作成
				 *			(ラウンドテーブル更新)
				 *	・それ以外
				 *		⇒	新ホール追加
				 *			(ラウンドテーブル更新)
				 *	③各条件ごとにテーブルの行追加を行う
				 *		⇒ツアーテーブルの更新とラウンドテーブル更新の２種
				 *
				 */

				//ＤＢからステータス取得
				StatusDAO sDAO = new StatusDAO();
				String[] Status = sDAO.getStatus(user_num);

				if(Status[5].equals("食材不足")) {

					Boolean result = null;

					if(Status[4].equals("R3") && Status[3].equals("6")) {
						//ツアー終了を宣言
						LocalDateTime nowDate = LocalDateTime.now();

						DateTimeFormatter TimeFormat =DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String tour_fin = nowDate.format(TimeFormat);

						RoundsDAO rDAO = new RoundsDAO();
						result = rDAO.UpdateTour(user_num , "TOUR_FIN" ,tour_fin ) ;

						//R3のH6 ⇒ツアーテーブル挿入 ToursDAO.AddTour()
						ToursDAO tDAO = new ToursDAO();
						result = tDAO.AddRound1_AddTour(user_num);

					}else if((Status[4].equals("R1")||Status[4].equals("R2")) && Status[3].equals("6")) {
						//R1,2のH6 ⇒ ラウンドテーブル挿入 RoundsDAO.AddRound()

						int tour_num = Integer.parseInt(Status[1]);
						RoundsDAO rDAO = new RoundsDAO();
						result = rDAO.AddRoundUpdateTour(user_num , Status[4] ,tour_num );

					}else {
						int round_num = Integer.parseInt(Status[2]);
						int hole_num = Integer.parseInt(Status[3]);
						RoundsDAO rDAO = new RoundsDAO();
						result = rDAO.AddHole(user_num ,round_num ,hole_num);
						//ラウンドテーブル挿入 RoundsDAO.AddHole()
					}

					if(result == true) {

						sDAO = new StatusDAO();
						Status = sDAO.getStatus(user_num);

						session = request.getSession();
						request.setAttribute("Status",Status );

						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
						dispatcher.forward(request,response);
					}

				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request,response);
				}

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
