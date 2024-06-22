package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodSeasDAO {
	public List<String> getRandomFoodSeasNamesByGenreAndStock(int user_num) {
		Connection conn = null;
		List<String> foodSeasNames = new ArrayList<>();
        int foodBoxNum = 0;

        try {
<<<<<<< HEAD
        	Class.forName("org.h2.Driver");
=======
            // データベースドライバの読み込み
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("H2ドライバの読み込みに失敗しました", e);
        }
    }
    public List<String> getRandomFoodSeasNamesByGenreAndStock(int user_num) {
        List<String> foodSeasNames = new ArrayList<>();
        String sqlMeat = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = 'meat' AND food_seas_stock = TRUE ORDER BY RANDOM() LIMIT 1";
        String sqlVegetable = "SELECT food_seas_name FROM food_seas WHERE food_seas_genre = 'vege' AND food_seas_stock = TRUE ORDER BY RANDOM() LIMIT 2";
        try (
>>>>>>> cf96dc07c26f7d8d7d49c299092d0859b7560e0b
            // データベースに接続
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");
            String foodBox = "SELECT food_box_num FROM FOOD_SEAS WHERE user_num = ? ORDER BY food_box_num desc limit 1";
            PreparedStatement pStmt = conn.prepareStatement(foodBox);
            pStmt.setInt(1, user_num);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
            	foodBoxNum = rs.getInt("food_box_num");
            }
            if (foodBoxNum !=0) {
            	foodBox = "SELECT * FROM FOOD_SEAS WHERE food_box_num = ? ORDER BY food_seas_genre desc";
                pStmt = conn.prepareStatement(foodBox);
                pStmt.setInt(1, foodBoxNum);

                rs = pStmt.executeQuery();

                while (rs.next()) {
                	 = rs.getInt("food_seas_num");
                	 = rs.getString("food_seas_name");
                	 = rs.getString("food_seas_genre");
                	 = rs.getBoolean("food_seas_stock");
                	 = rs.getInt("food_box_num");
                	 = rs.getInt("user_num");
                	 // foodseas型の配列に格納？わからない。iki
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodSeasNames;
    }

}