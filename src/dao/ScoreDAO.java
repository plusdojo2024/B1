package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.score;

public class ScoreDAO{

<<<<<<< HEAD
	public static List<NowTourScore> select(NowTourScore score) {
=======
	public static List<score> select(int scores_num) {
>>>>>>> 640fa20bebea0e13c76d5e32dbb5de24549b4522
		Connection conn = null;
		List<score> cardList = new ArrayList<score>();

		try {
			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/DB/B1","B1","");
			// SQL文を準備する
			String sql = "SELECT * FROM scores WHERE scores_num LIKE ? ORDER BY scores_num ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

<<<<<<< HEAD
			// 結果表をコレクションにコピーする
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
				try {conn.close();}
				catch (SQLException e) {
					e.printStackTrace();
					scoreList = null;
				}
			}
		}
		// 結果を返す
		return scoreList;
=======


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							score record = new score(
							rs.getInt("scores_num"),
							rs.getInt("par"),
							rs.getInt("time_scores"),
							rs.getInt("food_scores"),
							rs.getInt("seas_scores"),
							rs.getInt("cook_scores"),
							rs.getInt("taste_scores"),
							rs.getInt("total_score")
									);
									cardList.add(record);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						cardList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								cardList = null;
							}
						}
					}

					// 結果を返す
					return cardList;
>>>>>>> 640fa20bebea0e13c76d5e32dbb5de24549b4522
	}
}