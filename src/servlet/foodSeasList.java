package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class foodSeasList
 */
@WebServlet("/foodSeasList")
public class foodSeasList extends HttpServlet {
	private static final long serialVersionUID = 1L;


//＋が押されたらデータベースからデータを取得する
	//リクエストパラメータを取得する
	//request.setCharacterEncoding("UTF-8");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foodSeasList() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	//食材調味料一覧にフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food_seas_list.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}


//	FslDAO fDAO = bew BcDAO();
//	List<Fls> fslList = fDAO.select(new Fls(genre))


	}




}
