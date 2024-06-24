package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodSeasDAO;
import model.FoodSeasListmodel;

@WebServlet("/SetPlayingConditionsServlet")
public class SetPlayingConditionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetPlayingConditionsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインセッションが切れていたらログイン画面に戻す
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            response.sendRedirect("/B1/login.jsp");
            return;
        }

     // 現在時刻を取得
        Timestamp startTime = new Timestamp(new Date().getTime());

        // 開始時刻をリクエスト属性に設定
        request.setAttribute("startTime", startTime);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/B1/play.jsp");
        dispatcher.forward(request, response);


        FoodSeasDAO fcDao = new FoodSeasDAO();
        FoodSeasListmodel userNum = new FoodSeasListmodel();
        int user_num = userNum.getUser_num();
        List<FoodSeasListmodel> foodSeasRecord = fcDao.select(user_num);

        ArrayList<String> meat = new ArrayList<>();
    	ArrayList<String> vege = new ArrayList<>();
    	ArrayList<String> seas = new ArrayList<>();
    	ArrayList<String> help = new ArrayList<>();

        for (FoodSeasListmodel food : foodSeasRecord) {
        	if ("肉".equals(food.getFood_seas_genre())) {
        		meat.add(food.getFood_seas_name());
        	}
        	else if ("野菜".equals(food.getFood_seas_genre())) {
        		vege.add(food.getFood_seas_name());
        	}
        	else if ("その他".equals(food.getFood_seas_genre())) {
        		seas.add(food.getFood_seas_name());
        	}

            else if ("その他".equals(food.getFood_seas_genre())) {
            	help.add(food.getFood_seas_name());
            }
        }


        // ArrayListからランダムで取り出す
        // 肉
        Random rand = new Random();
        int randomMeat = rand.nextInt(meat.size());
        String selectMeat = meat.get(randomMeat);

        // 野菜
        int randomVege1 = rand.nextInt(vege.size());
        int randomVege2 = rand.nextInt(vege.size());
        while (randomVege1 == randomVege2) {
        	randomVege2 = rand.nextInt(vege.size());
        }
        String selectVege1 = vege.get(randomVege1);
        String selectVege2 = vege.get(randomVege2);

        // 調味料
        int randomSeas = rand.nextInt(seas.size());
        String selectSeas = seas.get(randomSeas);

        int randomHelp = rand.nextInt(help.size());
        String selectHelp = help.get(randomHelp);

        String food_con = selectMeat + "," + selectVege1 + "," + selectVege2 + ",(" + selectSeas + "),(" + selectHelp + ")";

        String seas_con = se



        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request.setCharacterEncoding("UTF-8");
    	// 食材の提示




        // 調味料とお助けの表示も。


        // セッションスコープにfoodSeasNamesを保存












        // 料理ページにフォワードする
     	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/play.jsp");
		dispatcher.forward(request, response);



    }
}
