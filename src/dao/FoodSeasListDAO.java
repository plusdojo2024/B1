package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FoodSeasListmodel;

public class FoodSeasListDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<FoodSeasListmodel> select(String food_seas_genre) {
		Connection conn = null;
		List<FoodSeasListmodel> fslList = new ArrayList<FoodSeasListmodel>();
//ここでしてること
//modelで作った物にDBの内容を入れてくる
// fslList = new ArrayList<FoodSeasListmodel>の()内のものを、List<FoodSeasListmodel>型の、fslリストに代入する！
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する
			String sql = "SELECT * FROM food_seas WHERE food_seas_genre = ? AND food_seas_stock = true;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, food_seas_genre);
//ここで、SQL文を作って、？１番目に入るのはfood_seas_genreの４つのどれか

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				FoodSeasListmodel record = new FoodSeasListmodel(
				rs.getInt("food_seas_num"),	//1
				rs.getString("food_seas_name"),//もやし
				rs.getString("food_seas_genre"),//vege
				rs.getBoolean("food_seas_stock"),//TRUE
				rs.getInt ("food_box_num"),
				rs. getInt ("user_num")
						);
				fslList.add(record);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			fslList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			fslList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					fslList = null;
				}
			}
		}
		// 結果を返す
		return fslList;
	}

//データを削除する
	//すべてのデータを取得するメソッド
		public List<FoodSeasListmodel> selectAll() {
			Connection conn = null;
			List<FoodSeasListmodel> fslList = new ArrayList<FoodSeasListmodel>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

				// SQL文を準備する
				String sql = "SELECT * FROM food_seas";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					FoodSeasListmodel record = new FoodSeasListmodel(
					rs.getInt("food_seas_num"),	//1
					rs.getString("food_seas_name"),//もやし
					rs.getString("food_seas_genre"),//vege
					rs.getBoolean("food_seas_stock"),//TRUE
					rs.getInt ("food_box_num"),
					rs. getInt ("user_num")
							);
					fslList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				fslList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				fslList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						fslList = null;
					}
				}
			}
			// 結果を返す
			return fslList;
		}

//チェックが入っているIDの一覧から該当データを削除

		public boolean delete(String[] checkedId) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

				// SQL文を準備する
				String sql = "DELETE FROM food_seas WHERE food_seas_num = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//チェックの入っているデータを削除
				for(String idS :checkedId) {
					int id = Integer.parseInt(idS);

					//SQL文に入力
					pStmt.setInt(1,id);

					// SQL文を実行し、結果を取得する
					if(pStmt.executeUpdate()== 1) {
						result = true;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = false;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						result = false;
					}
				}
			}

			// 結果を返す
			return result;
		}

		//引数で渡されたfood_seas_numの配列を元に合致するデータのfood_seas_stockを
		//FALSEに変更する
		public boolean change(String[] checkedId) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

				// SQL文を準備する
				String sql = "UPDATE food_seas SET food_seas_stock = false WHERE food_seas_num = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//チェックの入っているデータを削除
				for(String idS :checkedId) {
					int id = Integer.parseInt(idS);

					//SQL文に入力
					pStmt.setInt(1,id);

					// SQL文を実行し、結果を取得する
					if(pStmt.executeUpdate()== 1) {
						result = true;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = false;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						result = false;
					}
				}
			}

			// 結果を返す
			return result;
		}
}