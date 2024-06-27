package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.cooks;

public class cooksDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<cooks> select(int user_num) {
		Connection conn = null;
		List<cooks> cardList = new ArrayList<cooks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する
			String sql = "SELECT * FROM COOKS WHERE USER_NUM = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, user_num);



			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				cooks record = new cooks(
				rs.getInt("cook_num"),
				rs.getString("cook_date"),
				rs.getString("cook_img"),
				rs.getString("cook_name"),
				rs.getString("cook_time"),
				rs.getString("cook_sta"),
				rs.getString("cook_fin"),
				rs.getString("food_con"),
				rs.getString("food_used"),
				rs.getString("seas_con"),
				rs.getString("seas_used"),
				rs.getString("cook_satis"),
				rs.getString("aji_satis"),
				rs.getString("cook_fav"),
				rs.getString("cook_com"),
				rs.getInt("user_num")
						);
						cardList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

<<<<<<< HEAD
	public static int insertCook(int user_num, String food_con, String seas_con, int cook_time) {
=======
	public int insertCook(int user_num, String food_con, String seas_con, int cook_time) {
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
		Connection conn = null;
		int cook_num = 0;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する
			// 条件食材の登録
			String sql = "INSERT INTO COOKS(COOK_TIME, FOOD_CON, SEAS_CON, USER_NUM) "
					+ "VALUES (?, ?, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, cook_time);
			pStmt.setString(2, food_con);
			pStmt.setString(3, seas_con);
			pStmt.setInt(4, user_num);

			if(pStmt.executeUpdate() == 1) {
				try {
					sql = "SELECT cook_num "
							+ "FROM COOKS "
							+ "WHERE user_num = ? "
							+ "ORDER BY cook_num desc limit 1";
					pStmt = conn.prepareStatement(sql);

					pStmt.setInt(1, user_num);

					ResultSet Result = pStmt.executeQuery();
					Result.next();
					cook_num = Result.getInt("cook_num");
				}
				catch(Exception e){
					e.printStackTrace();
					}
				finally {
					if(conn != null) {
						try {
							conn.close();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return cook_num;
	}

<<<<<<< HEAD
	public static boolean updateCook(int user_num, String column_name, String value) {
=======
	public boolean updateCook(int user_num, String column_name, String value) {
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
		int cook_num = 0;
		boolean result = false;
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			String sql = "SELECT cook_num "
					+ "FROM COOKS "
					+ "WHERE user_num = ? "
					+ "ORDER BY cook_num desc limit 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, user_num);

			ResultSet Result = pStmt.executeQuery();
			Result.next();
			cook_num = Result.getInt("cook_num");

			try {


				String UpdateCookSQL = null;

				switch(column_name) {

				case "COOK_DATE":
				case "COOK_IMG":
				case "COOK_NAME":
				case "COOK_STA":
				case "COOK_FIN":
				case "FOOD_USED":
				case "SEAS_USED":
				case "COOK_SATIS":
				case "AJI_SATIS":
				case "COOK_FAV":
				case "COOK_COM":

				UpdateCookSQL =
				"UPDATE cooks SET " + column_name +" = ? "
				+ "WHERE COOK_NUM = ?";
				break;
				}

				pStmt = conn.prepareStatement(UpdateCookSQL);
				pStmt.setString(1, value);
				pStmt.setInt(2, cook_num);


				if(pStmt.executeUpdate() == 1) {
					result = true;
				}else {
					result = false;
				}

			}catch(Exception e){
				e.printStackTrace();
				result = false;
				}

			finally {
				if(conn != null) {
					try {
						conn.close();
					}
					catch(Exception e) {
						e.printStackTrace();
						result = false;
					}
				}
			}

		}
		catch(Exception e){
			e.printStackTrace();
			}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


}
