package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NowTourScore;

public class ScoreDAO {
    public List<NowTourScore> select(int scores_num) {
        Connection conn = null;
        List<NowTourScore> scoreList = new ArrayList<>();

        try {
            // データベースドライバをロード
            Class.forName("org.h2.Driver");

            // データベースに接続
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

            // SQL文を準備
            String sql = "SELECT * FROM scores WHERE SCORES_NUM = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // パラメータを設定
            pStmt.setInt(1,scores_num);

            // SQLクエリを実行し、結果を取得
            ResultSet rs = pStmt.executeQuery();

            // 結果セットからデータを取得してpastListに格納
            while (rs.next()) {
                NowTourScore record = new NowTourScore(
                	rs.getInt("scores_num"),
                	rs.getInt("par"),
                    rs.getInt("time_scores"),
                    rs.getInt("food_scores"),
                    rs.getInt("seas_scores"),
                    rs.getInt("cook_scores"),
                    rs.getInt("taste_scores"),
                    rs.getInt("total_score")
                );
                scoreList.add(record);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            scoreList = null;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            scoreList = null;
        }
        finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    scoreList = null;
                }
            }
        }

        // 結果を返す
        return scoreList;
    }
}