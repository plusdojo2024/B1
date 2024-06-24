package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
ツアー番号は変更なし、ラウンドを作成しツアーテーブルと紐づける
Boolean)RoundsDAO.AddRoundUpdateTour(user_num,R2もしくはR3,tour_num)
ツアー番号ラウンド番号変更なし、既にあるラウンド番号で次のホールを作成
Boolean)RoundsDAO.AddHole(user_num ,round_num ,hole_num)
  */

public class RoundsDAO{

	public  static Boolean AddRoundUpdateTour(int user_num,String now_round,int tour_num) {

		Boolean result = false;

		//DBアクセス権
		Connection conn = null;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			String AddRoundSQL =
					"INSERT INTO rounds ( hole_num , play_status , user_num) "
					+ "VALUES  ('1' , '食材不足', ? );" ;

			PreparedStatement EmbedSQL = conn.prepareStatement(AddRoundSQL);
			EmbedSQL.setInt(1, user_num);

			if(EmbedSQL.executeUpdate() == 1) {

				try {

				String RoundNumSearchSQL =
				"SELECT ROUND_NUM FROM ROUNDS "
				+ "WHERE USER_NUM = ? "
				+ "ORDER BY ROUND_NUM DESC "
				+ "LIMIT 1 ;";

				EmbedSQL = conn.prepareStatement(RoundNumSearchSQL);
				EmbedSQL.setInt(1, user_num);

				ResultSet RoundNumResult = EmbedSQL.executeQuery();

				RoundNumResult.next();

				//ラウンド番号を取得
				int round_num = RoundNumResult.getInt("round_num");

					try {

						String IncertRoundSQL = null;

						if(now_round.equals("R1") ) {

							IncertRoundSQL =
							"UPDATE tours "
							+ "SET ROUND_ND= ? ,ROUND_STATUS='RN' "
							+ "WHERE TOUR_NUM= ? ;";

						}else if(now_round.equals("R2") ) {

							IncertRoundSQL =
							"UPDATE tours "
							+ "SET ROUND_TH= ?  ,ROUND_STATUS='RN' "
							+ "WHERE TOUR_NUM= ? ;";

						}else {

							result = false;

						}

							EmbedSQL = conn.prepareStatement(IncertRoundSQL);
							EmbedSQL.setInt(1, round_num);
							EmbedSQL.setInt(2, tour_num);

							if(EmbedSQL.executeUpdate() == 1) {
								result = true;
							}else {
								result = false;
							}
					}
					finally {
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

		return result;
	};

	public static Boolean AddHole(int user_num , int round_num , int hole_num) {

		Boolean result = false;

		//DBアクセス権
		Connection conn = null;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			String AddRoundSQL =
					"INSERT INTO rounds (round_num , hole_num , play_status , user_num) "
					+ "VALUES  ( ? , ? , '調理前', ? );" ;

			PreparedStatement EmbedSQL = conn.prepareStatement(AddRoundSQL);
			EmbedSQL.setInt(1, round_num);
			EmbedSQL.setInt(2, hole_num + 1);
			EmbedSQL.setInt(3, user_num);

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

		finally {
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

	public static Boolean UpdateTour(int user_num , String culum_name ,String Value ) {

		Boolean result = false;

		//DBアクセス権
		Connection conn = null;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			String RoundNumSearchSQL =
					"SELECT ROUND_NUM , HOLE_NUM FROM ROUNDS "
					+ "WHERE USER_NUM = ? "
					+ "ORDER BY ROUND_NUM DESC, HOLE_NUM DESC "
					+ "LIMIT 1 ;";

			PreparedStatement EmbedSQL = conn.prepareStatement(RoundNumSearchSQL);
			EmbedSQL.setInt(1, user_num);

			ResultSet RoundNumResult = EmbedSQL.executeQuery();

			RoundNumResult.next();

			//ラウンド番号を取得
			int round_num = RoundNumResult.getInt("round_num");
			int hole_num = RoundNumResult.getInt("hole_num");

			try {

				String UpdateRoundSQL = null;

				switch(culum_name) {

				case "FOOD_SEAS_NUM":
				case "SEAS_NUM":
				case "COOK_NUM":
				case "SCORES_NUM":
				case "COURCE_NAME":
				UpdateRoundSQL =
				"UPDATE rounds SET " + culum_name +" = ? "
				+ "WHERE ROUND_NUM = ? AND HOLE_NUM = ?";
				break;
				}

				EmbedSQL = conn.prepareStatement(UpdateRoundSQL);
				EmbedSQL.setString(1, Value);
				EmbedSQL.setInt(2, round_num);
				EmbedSQL.setInt(3, hole_num);

				if(EmbedSQL.executeUpdate() == 1) {
					result = true;
				}else {
					result = false;
				}

			}catch(Exception e){
				e.printStackTrace();
				result = false;
				}

			finally {
				if(conn != null) {
					try {
						conn.close();
					}
					catch(Exception e) {
						e.printStackTrace();
						result = false;
					}
			}



		}}
		catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		finally {
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


