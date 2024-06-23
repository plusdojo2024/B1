package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StatusDAO{
	public static String[] getStatus(int user_num) {
		//DBアクセス権
		Connection conn = null;
		//ステータス配列を定義
		String[] Status = {"user_num", "tour_num" ,"round_num" , "hole_num" ,"round_status","play_status"};
		try {
			//データベース読み込み
			Class.forName("org.h2.Driver");
			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");
			//SQL準備
			String StatusCheckSQL =
					"SELECT USER_ROUND.tour_num,ROUNDS.round_num,ROUNDS.hole_num,USER_ROUND.round_status,ROUNDS.PLAY_status"
					+ " FROM ("
					+ "    SELECT round_status AS round_status,tour_num AS tour_num, round_st AS round_num FROM tours WHERE user_num = ? "
					+ "    UNION ALL"
					+ "    SELECT round_status AS round_status  ,tour_num AS tour_num, round_nd AS round_num FROM tours WHERE user_num = ? "
					+ "    UNION ALL"
					+ "    SELECT round_status AS round_status ,tour_num AS tour_num, round_th AS round_num FROM tours WHERE user_num = ? "
					+ ") AS USER_ROUND"
					+ " INNER JOIN ROUNDS ON USER_ROUND.round_num = ROUNDS.round_num"
					+ " ORDER BY tour_num DESC,round_num DESC,hole_num DESC LIMIT 1;";
			PreparedStatement EmbedSQL = conn.prepareStatement(StatusCheckSQL);
			EmbedSQL.setInt(1, user_num);
			EmbedSQL.setInt(2, user_num);
			EmbedSQL.setInt(3, user_num);
			ResultSet result = EmbedSQL.executeQuery();

			while(result.next()) {

				Status[0] = user_num +"";
				Status[1] = result.getString("tour_num");
				Status[2] = result.getString("round_num");
				Status[3] = result.getString("hole_num");
				Status[4] = result.getString("round_status");
				Status[5] = result.getString("play_status");
			};
		}
		catch	(Exception e){
			e.printStackTrace();
			Status = null;
		}
		finally{
			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					Status = null;
				}
			}
		};
		return Status;
	};
};