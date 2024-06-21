package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BcDAO;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class foodSeasList
 */
@WebServlet("/FoodSeasRegistServlet")
public class FoodSeasRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_regist.jsp");
		dispatcher.forward(request, response);

		// 登録処理を行う
				BcDAO bDao = new BcDAO();
				if (bDao.insert(new Bc(0, name, address))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
				}
				else {												// 登録失敗
					request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}

	}

		}

