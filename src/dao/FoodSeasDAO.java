package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FoodSeasListmodel;

public class FoodSeasDAO {
	public List<String> getRandomFoodSeasNamesByGenreAndStock(int user_num) {
		Connection conn = null;
		List<String> foodSeasNames = new ArrayList<>();
        int foodBoxNum = 0;
        try {
        	Class.forName("org.h2.Driver");
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
                	FoodSeasListmodel fslModel = new FoodSeasListmodel(
                		rs.food_seas_num  = rs.getInt("food_seas_num"),
                		rs.food_seas_name = rs.getString("food_seas_name"),
                		rs.food_seas_genre = rs.getString("food_seas_genre")
                		rs.food_seas_stock = rs.getBoolean("food_seas_stock")
                		rs.
                		rs.
                			)

                	int food_seas_num  = rs.getInt("food_seas_num");
                	String food_seas_name = rs.getString("food_seas_name");
                	String food_seas_genre = rs.getString("food_seas_genre");
                	Boolean food_seas_stock = rs.getBoolean("food_seas_stock");
                	int food_box_nu = rs.getInt("food_box_num");
                	int user_num = rs.getInt("user_num");
                	 // foodseas型の配列に格納？わからない。iki
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foodSeasNames;
    }

}