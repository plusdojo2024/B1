package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.LoginUser;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");

		if(user_name.length() == 0) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request,response);
		}else {

		UsersDAO myDAO  = new UsersDAO();

		String Check_user_num = myDAO.getLoginTicket(user_name,user_pass);

		if(Check_user_num != null){

			int user_num = Integer.parseInt(Check_user_num);

			HttpSession session = request.getSession();
			session.setAttribute("user_num", new LoginUser(user_num));

			RequestDispatcher dispatcher = request.getRequestDispatcher("StatusCheck");
			dispatcher.forward(request,response);
		}else {

			String[] Message = {"ログイン失敗","やり直してね！！"};

			//リクエストスコープに格納する
			request.setAttribute("Message", Message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request,response);

		};
		};
	};

};
