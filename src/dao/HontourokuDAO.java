package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HontourokuDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public String[] select(int user_num) {
		Connection conn = null;
		String[] cooks = {"", ""};
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");
			// SELECT文を準備する
			String sql = "SELECT cook_time,cook_com FROM cooks WHERE user_num = ? ORDER BY cook_num DESC LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_num);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				cooks[0] = rs.getString("cook_time");
				cooks[1] = rs.getString("cook_com");
				};
		}
		catch (SQLException e) {
			e.printStackTrace();
			cooks = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cooks = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cooks = null;
				}
			}
		}
		// 結果を返す
		return cooks;
	}
}