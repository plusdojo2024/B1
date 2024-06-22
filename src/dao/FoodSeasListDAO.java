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
			String sql = "SELECT * FROM food_seas WHERE food_seas_genre = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, food_seas_genre);
//ここで、SQL文を作って、？１番目に入るのはfood_seas_genreの４つのどれか

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				FoodSeasListmodel record = new FoodSeasListmodel(
//FoodSeasListmodelは、modelファイル内で決めた、６～９行目
				rs.getInt("food_seas_num"),	//1
				rs.getString("food_seas_name"),//もやし
				rs.getString("food_seas_genre"),//vege
				rs.getBoolean("food_seas_stock")//TRUE
						);
				fslList.add(record);
//fslListにrecordの内容を追加していく指示をしてる
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
public boolean delete(int food_seas_num) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

		// SQL文を準備する";
		String sql = "DELETE FROM food_seas WHERE food_seas_num=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setInt(1, food_seas_num);

		// SQL文を実行する
		if (pStmt.executeUpdate() == 1) {
			result = true;
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

	// 結果を返す
	return result;
}
}

