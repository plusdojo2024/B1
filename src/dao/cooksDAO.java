package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// ここから
public class cooksDAO {

	public static boolean getCooksTicket(String cook_time,String cook_com) {

		//DBアクセス権
		Connection conn = null;

		boolean loginResult = false;
		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/DB/B1","B1","");

			//SQL準備
			String StatusCheckSQL = "SELECT *  FROM COOKS WHERE cook_time LIKE ? AND cook_com";

			PreparedStatement EmbedSQL = conn.prepareStatement(StatusCheckSQL);
			EmbedSQL.setString(1, cook_time);
			EmbedSQL.setString(2, cook_com);

			ResultSet result = EmbedSQL.executeQuery();

			result.next();
			if(result.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}


		}

		catch	(Exception e){
			e.printStackTrace();
			loginResult = false;
		}

		finally{

			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		};

		return loginResult;
	};
};
