package dao;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.FoodSeasRegistmodel;

public class FoodSeasRegistDAO{
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(FoodSeasRegistmodel fsr) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			//ここに追加した物を入れるよ
			String sql = "INSERT INTO food_seas VALUES (NULL, ?, ?,true)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (fsr.getFood_seas_name() != null && !fsr.getFood_seas_name().equals("")) {
				pStmt.setString(1, fsr.getFood_seas_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			if (fsr.getFood_seas_genre() != null && !fsr.getFood_seas_genre().equals("")) {
				pStmt.setString(2, fsr.getFood_seas_genre());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			fsr = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			fsr = null;
}
		 finally{
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