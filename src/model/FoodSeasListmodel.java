//package model;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class FoodSeasListmodel
// */
//@WebServlet("/FoodSeasListmodel")
//public class FoodSeasListmodel extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FoodSeasListmodel() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
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
//	}

////	public class FoodSeasListmodel implements Serializable {
//		private int food_seas_num;			// 食材管理番号
//		private String food_seas_name;		//食材登録名
//		private String food_seas_genre;		// ジャンル
//		private boolean food_seas_stock;	// 役職名
//
//
//	public FoodSeasListmodel(int food_seas_num, String food_seas_name,
//			String food_seas_genre, boolean food_seas_stock) {
//			this.food_seas_num = food_seas_num;
//			this.food_seas_name = food_seas_name;
//			this.food_seas_genre = food_seas_genre;
//			this.food_seas_stock = food_seas_stock ;
//
//		}
//
//		public FoodSeasListmodel() {
//			this.food_seas_num = "food_seas_num";
//			this.food_seas_name = "food_seas_name";
//			this.food_seas_genre = "food_seas_genre";
//			this.food_seas_stock = "food_seas_stock" ;
//		}
//
//		public int getFood_seas_num() {
//			return food_seas_num;
//		}
//
//		public void setFood_seas_num(int food_seas_num) {
//			this.food_seas_num = food_seas_num;
//		}
//
//
//		public String getFood_seas_name() {
//			return food_seas_name;
//		}
//
//		public void setFood_seas_name(String food_seas_name) {
//			this.food_seas_name = food_seas_name;
//		}
//
//
//		public String getFood_seas_genre() {
//			return food_seas_genre;
//		}
//
//		public void setFood_seas_genre(String food_seas_genre) {
//			this.food_seas_genre = food_seas_genre;
//		}
//
//
//
//	}
//
//}
