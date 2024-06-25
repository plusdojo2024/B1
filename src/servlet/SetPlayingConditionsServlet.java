package servlet;

import java.io.IOException;
<<<<<<< HEAD
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
=======
import java.util.ArrayList;
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.FoodSeasDAO;
<<<<<<< HEAD
=======
import dao.RoundsDAO;
import dao.SeasDAO;
import dao.StatusDAO;
import dao.cooksDAO;
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
import model.FoodSeasListmodel;

@WebServlet("/SetPlayingConditionsServlet")
@MultipartConfig
public class SetPlayingConditionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetPlayingConditionsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインセッションが切れていたらログイン画面に戻す
        HttpSession session = request.getSession();
<<<<<<< HEAD
        if (session.getAttribute("id") == null) {
=======
        if (session.getAttribute("id") != null) {
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
            response.sendRedirect("/B1/login.jsp");
            return;
        }
        /*
     // 現在時刻を取得
        Timestamp startTime = new Timestamp(new Date().getTime());

<<<<<<< HEAD
     // 現在時刻を取得
        Timestamp startTime = new Timestamp(new Date().getTime());

=======
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
        // 開始時刻をリクエスト属性に設定
        request.setAttribute("startTime", startTime);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/B1/play.jsp");
        dispatcher.forward(request, response);

<<<<<<< HEAD

        FoodSeasDAO fcDao = new FoodSeasDAO();
        FoodSeasListmodel userNum = new FoodSeasListmodel();
        int user_num = userNum.getUser_num();
=======
        */


        FoodSeasDAO fcDao = new FoodSeasDAO();
        int user_num = 1;
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
        List<FoodSeasListmodel> foodSeasRecord = fcDao.select(user_num);

        ArrayList<String> meat = new ArrayList<>();
    	ArrayList<String> vege = new ArrayList<>();
    	ArrayList<String> seas = new ArrayList<>();
    	ArrayList<String> help = new ArrayList<>();

        for (FoodSeasListmodel food : foodSeasRecord) {
<<<<<<< HEAD
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
=======
        	if ("meat".equals(food.getFood_seas_genre())) {
        		meat.add(food.getFood_seas_name());
        	}
        	else if ("vege".equals(food.getFood_seas_genre())) {
        		vege.add(food.getFood_seas_name());
        	}
        	else if ("seas".equals(food.getFood_seas_genre())) {
        		seas.add(food.getFood_seas_name());
        	}

            else if ("help".equals(food.getFood_seas_genre())) {
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
            	help.add(food.getFood_seas_name());
            }
        }


        // ArrayListからランダムで取り出す
<<<<<<< HEAD
        // 肉
        Random rand = new Random();
        int randomMeat = rand.nextInt(meat.size());
        String selectMeat = meat.get(randomMeat);
=======

        // 肉
        Random rand = new Random();
        String food_con = null;
        String selectMeat = null;
        String selectVege1 = null;
        String selectVege2 = null;
        String selectSeas = null;
        String selectHelp = null;


        if(meat.size() != 0 && vege.size() != 0) {
        int randomMeat = rand.nextInt(meat.size());
        selectMeat = meat.get(randomMeat);
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff

        // 野菜
        int randomVege1 = rand.nextInt(vege.size());
        int randomVege2 = rand.nextInt(vege.size());
        while (randomVege1 == randomVege2) {
        	randomVege2 = rand.nextInt(vege.size());
        }
<<<<<<< HEAD
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
=======
        selectVege1 = vege.get(randomVege1);
        selectVege2 = vege.get(randomVege2);

        food_con = selectMeat + "," + selectVege1 + "," + selectVege2 ;

        }

        // 調味料
        if(seas.size() != 0) {
        int randomSeas = rand.nextInt(seas.size());
        selectSeas = seas.get(randomSeas);
        food_con += ",(" + selectSeas + ")";
        }

        //お助け
        if(help.size() != 0) {
        int randomHelp = rand.nextInt(help.size());
        selectHelp = help.get(randomHelp);
        food_con += (",(" + selectHelp + ")" );
        }

        String region ="日本";

        String[] PlaySeasList = SeasDAO.getSeasCon(user_num, region);

        String seas_con = PlaySeasList[1] + "," + PlaySeasList[2] + ",(" + PlaySeasList[0] + ")";

        int cook_time = 15;
        String cook_time_ = cook_time + "";

        cooksDAO cDAO = new cooksDAO();
        int cook_num = cDAO.insertCook(user_num, food_con, seas_con, cook_time);

        String cook_num_ = cook_num +"";

        RoundsDAO rDAO = new RoundsDAO();
        Boolean result = rDAO.UpdateTour(user_num, "COOK_NUM",cook_num_);

        if(selectSeas == null) {
        	selectSeas = "なし";
        }

        if(selectHelp == null) {
        	selectHelp = "なし";
        }

        String[] play ={cook_time_,selectMeat,selectVege1,selectVege2,selectSeas,selectHelp,
        		PlaySeasList[0],PlaySeasList[1],PlaySeasList[2],PlaySeasList[3],PlaySeasList[4],};


        request.setAttribute("play", play);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
        dispatcher.forward(request, response);
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
    	// 食材の提示



=======
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff

    	// リクエストパラメータを取得する
    			request.setCharacterEncoding("UTF-8");


    			Part Image = request.getPart("image");

    			//コンテンツタイプを取得し格納

    			String ImageBase = "C:\\pleiades\\workspace\\B1\\WebContent\\Image\\";
    			String ImageType = Image.getContentType();

    			String SimpleImageType = ImageType.substring(6);

    			int user_num = 1;

    			StatusDAO sDAO = new StatusDAO();
    			String[] Status = sDAO.getStatus(user_num);



    			//ファイルの名前を書き込む
    			String image = "U" + Status[0] +"R"+ Status[2] +"H"+ Status[3] + "." + SimpleImageType;



    			//ファイルを書き込む
    			String ImagePass = ImageBase + image;
    			Image.write(ImagePass);

    			cooksDAO cDAO = new cooksDAO();
    			Boolean result = cDAO.updateCook(user_num, "COOK_IMG", image);

    			if(result = true) {
    				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    		        dispatcher.forward(request, response);
    			}











<<<<<<< HEAD
        // セッションスコープにfoodSeasNamesを保存











=======
>>>>>>> 9cffd653ae3e729b93da0c41beeda38e6193e8ff




    }
}
