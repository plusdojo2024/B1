package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;

public class SeasDAO {
	public static String () {
		Connection conn = null;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B1/B1", "B1", "");

			// SQL文を準備する
			String sql = "";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, user_num);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
=======
public class SeasDAO{
	public static String[] getSeasCon(int user_num,String region) {
		//DBアクセス権
		Connection conn = null;
		//ステータス配列を定義

		String[][] SeasSet;
		SeasSet = new String[5][4];

		String[] PlaySeasList;
		PlaySeasList = new String[5];

		try {
			//データベース読み込み
			Class.forName("org.h2.Driver");
			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:/pleiades/workspace/B1/B1","B1","");
			//SQL準備
			String SeasSetCheckSQL =
					"SELECT seas_column_name,seas_name,SOLTY FROM COOKS_SEAS WHERE REGION = ? ORDER BY RAND();";
			PreparedStatement EmbedSQL = conn.prepareStatement(SeasSetCheckSQL);
			EmbedSQL.setString(1, region);

			ResultSet result = EmbedSQL.executeQuery();

			int i = 0;

			while(result.next()) {
				SeasSet[i][0] = result.getString("seas_column_name");
				SeasSet[i][1] = result.getString("seas_name");
				SeasSet[i][2] = result.getString("SOLTY");
				i = i + 1;
			};


			try {

					String SQL = null;

				for(int k = 0; k < 5 ; k++) {

					SQL = "SELECT " + SeasSet[k][0] + " FROM SEAS WHERE USER_NUM = ? ORDER BY SEAS_NUM LIMIT 1 ";

					EmbedSQL = conn.prepareStatement(SQL);
					EmbedSQL.setInt(1, user_num);

					result = EmbedSQL.executeQuery();

					result.next();
					SeasSet[k][3] = result.getString(SeasSet[k][0]);
				}

				int count_free = 0;
				int count_con 	= 0;
				int count_ban 	= 0;

				for(int x=0 ; x<5 ; x++) {

					if(SeasSet[x][3].equals("TRUE") && SeasSet[x][2].equals("TRUE") && count_free < 1) {

						//塩味あり在庫ありをFREEに
						PlaySeasList[count_free] = SeasSet[x][1];
						count_free = count_free + 1;

					}else if( !SeasSet[x][3].equals("TRUE") && SeasSet[x][2].equals("TRUE") && count_ban < 1) {

						//塩味あり在庫なしを禁止に
						PlaySeasList[4 - count_ban] = SeasSet[x][1];
						count_ban = count_ban + 1;

					}else if(SeasSet[x][3].equals("TRUE") && SeasSet[x][2].equals("TRUE") && count_ban < 1) {

						//塩味あり在庫ありを禁止に
						PlaySeasList[4 - count_ban] = SeasSet[x][1];
						count_ban = count_ban + 1;

					}else if(count_ban < 2){
						//塩味なし１を禁止、塩味ありを１禁止
						PlaySeasList[4 - count_ban] = SeasSet[x][1];
						count_ban = count_ban + 1;

					}else{

						//在庫ありを条件に2つ選ぶ
						PlaySeasList[count_free + count_con ] = SeasSet[x][1];
						count_con = count_con + 1;

					}
				}

				/*	PlaySeasList
				 * 0:FREE	塩味あり
				 * 1:必須
				 * 2:必須
				 * 3:禁止	塩味あり
				 * 4:禁止
				 * */

			}catch(Exception e){

				e.printStackTrace();;
			}

		}
		catch	(Exception e){
			e.printStackTrace();
			SeasSet = null;
		}
		finally{
			if(conn != null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					SeasSet = null;
				}
			}
		};
		return PlaySeasList;
	};
};
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
