package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource; // データソースを保持する変数

    @Override
    public void init() throws ServletException {
        super.init();
        // データソースを初期化するコード（コンテキストから取得する例）
        dataSource = (DataSource) getServletContext().getAttribute("dataSource");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // リクエストパラメータを取得する
            request.setCharacterEncoding("UTF-8");
            String scores_num = request.getParameter("scores_num");
            String par = request.getParameter("par");
            String time_scores = request.getParameter("time_scores");
            String food_scores = request.getParameter("food_scores");
            String seas_scores = request.getParameter("seas_scores");
            String cook_scores = request.getParameter("cook_scores");
            String taste_scores = request.getParameter("taste_scores");
            String total_scores = request.getParameter("total_scores");

            // データベースに接続
            conn = dataSource.getConnection();

            // SQL文の準備
            String sql = "INSERT INTO scores_table (scores_num, par, time_scores, food_scores, seas_scores, cook_scores, taste_scores, total_scores) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, scores_num);
            stmt.setString(2, par);
            stmt.setString(3, time_scores);
            stmt.setString(4, food_scores);
            stmt.setString(5, seas_scores);
            stmt.setString(6, cook_scores);
            stmt.setString(7, taste_scores);
            stmt.setString(8, total_scores);

            // SQLを実行
            stmt.executeUpdate();

            // 結果ページにフォワードする
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/now_tour.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("DB操作でエラーが発生しました", e);
        } finally {
            // リソースの解放
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException("リソースの解放でエラーが発生しました", e);
            }
        }
    }
}