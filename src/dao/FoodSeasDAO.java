package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodSeasDAO {
    static {
        try {
            // データベースドライバの読み込み
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("H2ドライバの読み込みに失敗しました", e);
        }
    }

    public List<String> getRandomFoodSeasNamesByGenreAndStock() {
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
    }
}

