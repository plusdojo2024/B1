package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.cooksDAO;

/**
 * Servlet implementation class SaveTemporaryRegistration
 */
@WebServlet("/SaveTemporaryRegistrationServlet")
public class SaveTemporaryRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTemporaryRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインセッションが切れていたらログイン画面に戻す
		HttpSession session = request.getSession();
        if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/WEB-INF/jsp/login.jsp");
            return;
        }


		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
        if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/WEB-INF/jsp/login.jsp");
            return;
        }

		int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

    	String cook_comment = request.getParameter("cook_comment");

    	cooksDAO cDAO = new cooksDAO();
		Boolean result = cDAO.updateCook(user_num, "COOK_COM", cook_comment);

		if(result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		    dispatcher.forward(request, response);
		}
	}
	}


