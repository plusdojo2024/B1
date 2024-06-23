package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;







public class ToursDAO{

	public static boolean AddRound1_AddTour(int user_num) {

		//DBアクセス権
		Connection conn = null;

		boolean result = false;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			//
			String AddRoundSQL =
				"INSERT INTO rounds "
				+ "( hole_num , play_status ,user_num) "
				+ "VALUES  ( 1 , '食材不足', ? ); ";

			PreparedStatement EmbedSQL = conn.prepareStatement(AddRoundSQL);
			EmbedSQL.setInt(1, user_num);

			if(EmbedSQL.executeUpdate() == 1) {

				try {

					//ROUNDSテーブルから最新のラウンド番号を取得

					AddRoundSQL =
					"SELECT ROUND_NUM FROM ROUNDS "
					+ "WHERE USER_NUM = ? "
					+ "ORDER BY ROUND_NUM DESC "
					+ "LIMIT 1 ;";

					EmbedSQL = conn.prepareStatement(AddRoundSQL);
					EmbedSQL.setInt(1, user_num);

					ResultSet RoundNumResult = EmbedSQL.executeQuery();

					//ラウンド番号を取得

					RoundNumResult.next();
					int round_num = RoundNumResult.getInt("ROUND_NUM");

					if(round_num != 0) {

						LocalDateTime nowDate = LocalDateTime.now();

						DateTimeFormatter TimeFormat =DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String tour_sta = nowDate.format(TimeFormat);

						//そのラウンド番号でツアー番号を作成

						try {

							String AddTourSQL =
									"INSERT INTO tours "
									+ "(user_num , tour_sta , round_st , round_status) "
									+ "VALUES  ( ? ,? , ? ,'RN');";

							EmbedSQL = conn.prepareStatement(AddTourSQL);
							EmbedSQL.setInt(1, user_num);
							EmbedSQL.setString(2, tour_sta);
							EmbedSQL.setInt(3, round_num);

							if(EmbedSQL.executeUpdate() == 1) {
								result = true;
							}else {
								result = false;
							}

						}
						catch(Exception e){

							e.printStackTrace();
							result = false;
						}
					}
				}
				catch(Exception e){

					e.printStackTrace();
					result = false;
				}

				finally{

					if(conn != null) {
						try {
							conn.close();
						}
						catch(Exception e) {
							e.printStackTrace();
							result = false;
						}
					}
				}
				return result;
			}

		}catch(Exception e){

			e.printStackTrace();
			result = false;;

		}finally{

			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					result = false;
				}
			}
		}
		return result;
	}


	public static boolean ChangeRoundStatus(int user_num) {

		//DBアクセス権
		Connection conn = null;

		boolean result = false;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
			"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			try {

				String RoundCheckSQL =
				"SELECT TOUR_NUM,ROUND_ST,ROUND_ND,ROUND_TH "
				+"FROM TOURS WHERE USER_NUM = ? ORDER BY tour_num DESC LIMIT 1";

				PreparedStatement EmbedSQL = conn.prepareStatement(RoundCheckSQL);
				EmbedSQL.setInt(1, user_num);

				ResultSet Round123NumResult = EmbedSQL.executeQuery();

				Round123NumResult.next();
				int Tour_num = Round123NumResult.getInt("tour_num");
				String Round2_num = Round123NumResult.getString("round_nd");
				String Round3_num = Round123NumResult.getString("round_th");

				String UpdateRoundStatusSQL = null;

				if(Round2_num == null) {
					//現在R1
					UpdateRoundStatusSQL =
					"UPDATE tours SET ROUND_STATUS = 'R1' "
					+ "WHERE TOUR_NUM= ? ;";

				}else if(Round3_num == null){
					//現在R2
					UpdateRoundStatusSQL =
					"UPDATE tours SET ROUND_STATUS = 'R2' "
					+ "WHERE TOUR_NUM= ? ;";

				}else {

					UpdateRoundStatusSQL =
					"UPDATE tours SET ROUND_STATUS = 'R3' "
					+ "WHERE TOUR_NUM= ? ;";

				}

				 EmbedSQL = conn.prepareStatement(UpdateRoundStatusSQL);
				 EmbedSQL.setInt(1, Tour_num);


				if(EmbedSQL.executeUpdate() == 1) {
					result = true;
				}else {
					result = false;
				}

				}
				catch(Exception e){
					e.printStackTrace();
					result = false;
				}
				finally{

				if(conn != null) {
					try {
						conn.close();
					}
					catch(Exception e) {
						e.printStackTrace();
						result = false;
					}
				}
			};
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		finally{

			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					result = false;
				}
		}
		}
	return result;
	}

}

