package dao;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.FoodSeasRegistmodel;

public class FoodSeasRegistDAO{
	public boolean insert(FoodSeasRegistmodel Fsl) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO food_seas VALUES (NULL, ?, ?,1)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (Fsl.getName() != null && !Fsl.getName().equals("")) {
				pStmt.setString(1, Fsl.getName());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (Fsl.getGenre() != null && !Fsl.getGenre().equals("")) {
			pStmt.setString(2, Fsl.getGenre());
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
				}
				catch (ClassNotFoundException e) {}
					e.printStackTrace();

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
	}
	// 結果を返す
			return result;
}
