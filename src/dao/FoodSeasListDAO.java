package dao;

/**
 * Servlet implementation class FoodSeasListDAO
 */
//@WebServlet("/FoodSeasListDAO")

//public class FoodSeasListDAO extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FoodSeasListDAO() {
//        super();
//        // TODO Auto-generated constructor stub
// //   }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
////	}
//
////ここから編集
//	public static String[] fsl(String genre) throws SQLException {
//		Connection conn = null;
//		String[] fslList = new String[4];
//
//		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/", "B1", "");
//
//	String sql = "SELECT * FROM food_seas WHERE meat;";
//	PreparedStatement pStmt = conn.prepareStatement(sql);
//
//
//
//	//SQL文を完成させる
//	if (fls.getName() != null) {
//		pStmt.setString(1, "%" + fls.getName() + "%");
	//}
//	else {
//		pStmt.setString(1, "%");
//	}
//	if (fls.getAddress() != null) {
//		pStmt.setString(2, "%" + fls.getAddress() + "%");
//	}
//	else {
