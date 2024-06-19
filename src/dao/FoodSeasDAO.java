package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodSeasDAO {
	public List<String> getRandomFoodSeasNames() {
        List<String> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
        	//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/DB/B1","B1","food_seas");

            // 肉の1つをランダムに取得
            String sqlMeat = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = '肉' ORDER BY RAND() LIMIT 1";
            ps = conn.prepareStatement(sqlMeat);
            rs = ps.executeQuery();
            if (rs.next()) {
                result.add(rs.getString("food_seas_name"));
            }

            // リソースをクローズして再利用
            rs.close();
            ps.close();

            // 野菜の2つをランダムに取得
            String sqlVeg = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = '野菜' ORDER BY RAND() LIMIT 2";
            ps = conn.prepareStatement(sqlVeg);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("food_seas_name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // リソースのクローズ
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }

        return result;
    }
}
