package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.fsl;

public class FoodSeasListDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<fsl> select(String food_seas_genre) {
		Connection conn = null;
		List<fsl> fslList = new ArrayList<fsl>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/DB/B1", "B1", "");

			// SQL文を準備する
			String sql = "SELECT * FROM food_seas WHERE ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				fsl record = new fsl(
				rs.getInt("food_seas_num"),
				rs.getString("food_seas_name"),
				rs.getString("food_seas_genre"),
				rs.getBoolean("food_seas_stock")
						);
						fslList.add(record);
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
		return fslList;
	}
}
