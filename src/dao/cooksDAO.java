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
	public List<cooks> select(int cook_num) {
		Connection conn = null;
		List<cooks> cardList = new ArrayList<cooks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/DB/B1", "B1", "");

			// SQL文を準備する
			String sql = "SELECT * FROM cooks WHERE cook_num =? ORDER BY cook_num ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, cook_num);



			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				cooks record = new cooks(
				rs.getInt("cook_num"),
				rs.getInt("cook_date"),
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
				rs.getString("cook_com")
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
}
