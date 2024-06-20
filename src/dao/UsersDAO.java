package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class UsersDAO{

	public static boolean getLoginTicket(String user_name,String user_pass) {

		//DBアクセス権
		Connection conn = null;

		boolean loginResult = false;

		try {

			//データベース読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");

			//SQL準備
			String StatusCheckSQL = "SELECT COUNT(*) FROM USERS "
				+ "WHERE user_name=? AND user_pass=?;";

			PreparedStatement EmbedSQL = conn.prepareStatement(StatusCheckSQL);
			EmbedSQL.setString(1, user_name);
			EmbedSQL.setString(2, user_pass);

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
