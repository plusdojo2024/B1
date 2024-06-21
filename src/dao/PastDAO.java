package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PastScore;

public class PastDAO {
    public List<PastScore> select(int user_num) {
        Connection conn = null;
        List<PastScore> pastList = new ArrayList<>();

        try {
            // データベースドライバをロード
            Class.forName("org.h2.Driver");

            // データベースに接続
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

            // SQL文を準備
            String sql = "SELECT * FROM past_scores WHERE USER_NUM = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // パラメータを設定
            pStmt.setInt(1,user_num);

            // SQLクエリを実行し、結果を取得
            ResultSet rs = pStmt.executeQuery();

            // 結果セットからデータを取得してpastListに格納
            while (rs.next()) {
                PastScore record = new PastScore(
                	rs.getInt("user_num"),
                	rs.getInt("scores_num"),
                	rs.getInt("tour_num"),
                    rs.getInt("round_num"),
                    rs.getInt("hole_num"),
                    rs.getString("tour_sta"),
                    rs.getString("tour_fin"),
                    rs.getInt("cook_num"),
                    rs.getInt("scores")
                );
                pastList.add(record);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            pastList = null;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            pastList = null;
        }
        finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    pastList = null;
                }
            }
        }

        // 結果を返す
        return pastList;
    }
}