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

	 /*壱岐さんのFoodSeasDAOを貼り付けました使った食材と使い切ったものを表示できるようにしたい
	public List<String> getRandomFoodSeasNamesByGenreAndStock(int user_num) {
        List<String> foodSeasNames = new ArrayList<>();
        String sqlMeat = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = 'meat' AND food_seas_stock = TRUE ORDER BY RANDOM() LIMIT 1";
        String sqlVegetable = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = 'vege' AND food_seas_stock = TRUE ORDER BY RANDOM() LIMIT 2";
        try (
            // データベースに接続
            Connection conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");
            PreparedStatement pstmtMeat = conn.prepareStatement(sqlMeat);
            PreparedStatement pstmtVegetable = conn.prepareStatement(sqlVegetable)) {
            // 肉の食材を1つ取得
            try (ResultSet rsMeat = pstmtMeat.executeQuery()) {
                if (rsMeat.next()) {
                    foodSeasNames.add(rsMeat.getString("food_seas_name"));
                }
            }
            // 野菜の食材を2つ取得
            try (ResultSet rsVegetable = pstmtVegetable.executeQuery()) {
                while (rsVegetable.next()) {
                    foodSeasNames.add(rsVegetable.getString("food_seas_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodSeasNames;
	}*/



	/*public String[] choose(int user_num) {
		Connection conn = null;
		String[] food = {""};
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");
			// SELECT文を準備する
			String sql = "SELECT food_box_num FROM food_seas WHERE user_num = ? ORDER BY food_box_num DESC LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(foodBox);
			pStmt.setInt(1, user_num);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				food[0] = rs.getString("food_seas_name");
					};
		}
		catch (SQLException e) {
			e.printStackTrace();
			food = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			food = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					food = null;
				}
			}
		}
		// 結果を返す
		return food;
	}*/


     //引数cardで指定されたレコードを登録し、成功したらtrueを返す
  /*  public boolean insert(int user_num) {
	    Connection conn = null;
	    boolean result = false;

	    try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");
		// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
		String sql = "INSERT INTO Hontouroku VALUES (NULL, ?, ?, ?, ?, ?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (user_num.getComplete() != null && !user_num.getComplete().equals("")) {
			pStmt.setString(1, user_num.getComplete());
		}
		else {
			pStmt.setString(1, "（未設定）");
		}
		if (user_num.getUsed() != null && !user_num.getUsed().equals("")) {
			pStmt.setString(2, user_num.getDepartment());
		}
		else {
			pStmt.setString(2, "（未設定）");
		}
		if (user_num.getTaste() != null && !user_num.getTaste().equals("")) {
			pStmt.setString(3, user_num.getTaste());
		}
		else {
			pStmt.setString(3, "（未設定）");
		}
		if (user_num.getCook() != null && !user_num.getCook().equals("")) {
			pStmt.setString(4, user_num.getCook());
		}
		else {
			pStmt.setString(4, "（未設定）");
		}
		if (user_num.getFavorite() != null && !user_num.getFavorite().equals("")) {
			pStmt.setString(5, user_num.getFavorite());
		}
		else {
			pStmt.setString(5, "（未設定）");
		}
	} */
}