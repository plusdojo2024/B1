package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Past_scoresDAO
 */
@WebServlet("/Past_scoresDAO")
public class Past_scoresDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Past_scoresDAO() {
    	public List<Scores> select(Scores card) {
    		Connection conn = null;
    		List<Scores> cardList = new ArrayList<Scores>();

    		try {
    			// JDScoresドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdScores:h2:file:C:/pleiades/workspace/data/B1", "sa", "");

    			// SQL文を準備する
    			String sql = "SELECT * FROM Scores WHERE scores_num=?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);
    			// SQL文を完成させる
    			if (card.getName() != null) {pStmt.setString(1, "%" + card.getScores_num() + "%");}
    			else {pStmt.setString(1, "%");}



    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				Scores record = new Scores(
    				rs.getInt("scores_num"),
    				rs.getString("par"),
    				rs.getString("time_scores"),
    				rs.getString("food_scores"),
    				rs.getString("seas_scores"),
    				rs.getString("cook_scores"),
    				rs.getString("taste_scores"),
    				rs.getString("total_score")
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
    				try {conn.close();}
    				catch (SQLException e) {
    					e.printStackTrace();
    					cardList = null;
    				}
    			}
    		}

    		// 結果を返す
    		return cardList;
    	}

    	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
    	public boolean insert(Scores card) {
    		Connection conn = null;
    		boolean result = false;

    		try {
    			// JDScoresドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdScores:h2:file:C:/pleiades/workspace/data/B1", "sa", "");

    			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
    			String sql = "INSERT INTO Scores VALUES (NULL,?, ?, ?, ?, ?, ?, ?)";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			if (card.getPar() != null && !card.getPar().equals("")) {
    				pStmt.setString(1, card.getPar());
    			}
    			else {pStmt.setString(1, "（未設定）");}
    			if (card.getTime_scores() != null && !card.getTime_scores().equals("")) {
    				pStmt.setString(2, card.getTime_scores());
    			}
    			else {pStmt.setString(2, "（未設定）");}
    			if (card.getFood_scores() != null && !card.getFood_scores().equals("")) {
    				pStmt.setString(3, card.getFood_scores());
    			}
    			else {pStmt.setString(3, "（未設定）");}
    			if (card.getSeas_scores() != null && !card.getSeas_scores().equals("")) {
    				pStmt.setString(4, card.getSeas_scores());
    			}
    			else {pStmt.setString(4, "（未設定）");}
    			if (card.getCook_scores() != null && !card.getCook_scores().equals("")) {
    				pStmt.setString(5, card.getCook_scores());
    			}
    			else {pStmt.setString(5, "（未設定）");}
    			if (card.getTaste_scores() != null && !card.getTaste_scores().equals("")) {
    				pStmt.setString(6, card.getTaste_scores());
    			}
    			else {pStmt.setString(6, "（未設定）");}
    			if (card.getTotal_score() != null && !card.getTotal_score().equals("")) {
    				pStmt.setString(7, card.getTotal_score());
    			}

    			// SQL文を実行する
    			if (pStmt.executeUpdate() == 1) {result = true;}
    		}
    		catch (SQLException e) {e.printStackTrace();}
    		catch (ClassNotFoundException e) {e.printStackTrace();}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {conn.close();}
    				catch (SQLException e) {e.printStackTrace();}
    			}
    		}

    		// 結果を返す
    		return result;
    	}

    	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
    	public boolean update(Scores card) {
    		Connection conn = null;
    		boolean result = false;

    		try {
    			// JDScoresドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdScores:h2:file:C:/pleiades/workspace/data/B1", "sa", "");

    			// SQL文を準備する
    			String sql = "UPDATE Scores SET par=?, time_scores=?, food_scores=?, seas_scores=?, cook_scores=?, taste_scores=?, total_score=?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			if (card.getPar() != null && !card.getPar().equals("")) {
    				pStmt.setString(1, card.getPar());
    			}
    			else {pStmt.setString(1, "（未設定）");}
    			if (card.getTime_scores() != null && !card.getTime_scores().equals("")) {
    				pStmt.setString(2, card.getTime_scores());
    			}
    			else {pStmt.setString(2, "（未設定）");}
    			if (card.getFood_scores() != null && !card.getFood_scores().equals("")) {
    				pStmt.setString(3, card.getFood_scores());
    			}
    			else {pStmt.setString(3, "（未設定）");}
    			if (card.getSeas_scores() != null && !card.getSeas_scores().equals("")) {
    				pStmt.setString(4, card.getSeas_scores());
    			}
    			else {pStmt.setString(4, "（未設定）");}
    			if (card.getCook_scores() != null && !card.getCook_scores().equals("")) {
    				pStmt.setString(5, card.getCook_scores());
    			}
    			else {pStmt.setString(5, "（未設定）");}
    			if (card.getTaste_scores() != null && !card.getTaste_scores().equals("")) {
    				pStmt.setString(6, card.getTaste_scores());
    			}
    			else {pStmt.setString(6, "（未設定）");}
    			if (card.getTotal_score() != null && !card.getTotal_score().equals("")) {
    				pStmt.setString(7, card.getTotal_score());
    			}
    			pStmt.setInt(8, card.getScores_num());

    			// SQL文を実行する
    			if (pStmt.executeUpdate() == 1) {result = true;}
    		}
    		catch (SQLException e) {e.printStackTrace();}
    		catch (ClassNotFoundException e) {e.printStackTrace();}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {conn.close();}
    				catch (SQLException e) {e.printStackTrace();}
    			}
    		}

    		// 結果を返す
    		return result;
    	}

    	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
    	public boolean delete(int scores_num) {
    		Connection conn = null;
    		boolean result = false;

    		try {
    			// JDScoresドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdScores:h2:file:C:/pleiades/workspace/data/B1", "sa", "");

    			// SQL文を準備する
    			String sql = "DELETE FROM Scores WHERE scores_num=?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			pStmt.setInt(1, scores_num);

    			// SQL文を実行する
    			if (pStmt.executeUpdate() == 1) {result = true;}
    		}
    		catch (SQLException e) {e.printStackTrace();}
    		catch (ClassNotFoundException e) {e.printStackTrace();}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {conn.close();}
    				catch (SQLException e) {e.printStackTrace();}
    			}
    		}

    		// 結果を返す
    		return result;
    	}

    }

