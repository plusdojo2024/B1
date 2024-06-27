package servlet;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import dao.RoundsDAO;
import dao.SeasDAO;
import dao.StatusDAO;
import dao.cooksDAO;
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
        if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/B1/login.jsp");
            return;
        }
        /*
     // 現在時刻を取得
        Timestamp startTime = new Timestamp(new Date().getTime());

        // 開始時刻をリクエスト属性に設定
        request.setAttribute("startTime", startTime);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/B1/play.jsp");
        dispatcher.forward(request, response);

        */

        String course_name = request.getParameter("play");

        if( !course_name.equals("japan") && !course_name.equals("foreign") && !course_name.equals("random")) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/B1/play.jsp");
            dispatcher.forward(request, response);
        }

        int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

        FoodSeasDAO fcDao = new FoodSeasDAO();

        List<FoodSeasListmodel> foodSeasRecord = fcDao.select(user_num);

        ArrayList<String> meat = new ArrayList<>();
    	ArrayList<String> vege = new ArrayList<>();
    	ArrayList<String> seas = new ArrayList<>();
    	ArrayList<String> help = new ArrayList<>();

        for (FoodSeasListmodel food : foodSeasRecord) {
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
            	help.add(food.getFood_seas_name());
            }
        }


        // ArrayListからランダムで取り出す

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

        // 野菜
        int randomVege1 = rand.nextInt(vege.size());
        int randomVege2 = rand.nextInt(vege.size());
        while (randomVege1 == randomVege2) {
        	randomVege2 = rand.nextInt(vege.size());
        }
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

        String region = null;

        String[] PlaySeasList;

        if(course_name.equals("foreign")) {
	        String[] Region = {"日本","中国","韓国","タイ","インド","ヨーロッパ","アメリカ"};
	        rand = new Random();
	        int random = rand.nextInt(6);
	         region = Region[random];

	         course_name="海外コース";

	         PlaySeasList = SeasDAO.getSeasCon(user_num, region);


        }else if(course_name.equals("japan")) {

        	region = "日本";

        	course_name = "国内コース";

        	PlaySeasList = SeasDAO.getSeasCon(user_num, region);

        }else {

        	String[] solt_true = {"塩","味噌","醤油","甜麺醤","オイスターソース","コチュジャン",
        							"コンソメ","塩コショウ","チリソース","マヨネーズ","バーベキューソース","チーズ"};
        	String[] solt_false = {"砂糖","酢","豆板醤","ラー油","唐辛子","クミン",
        							"ガラムマサラ","カレーパウダー","チリパウダー",
        							"トマト缶","香草","ワイン","ナンプラー","ココナッツ"
        							,"マスタード"};

        	course_name = "ランダムコース";
        	region = "地球";

        	int random_solt_true1 = 0;
        	int random_solt_true2 = 0;
        	int random_solt_true3 = 0;
        	int random_solt_false1 = 0;
        	int random_solt_false2 = 0;

        	while(random_solt_true1 == random_solt_true2 ||
        			random_solt_true1 == random_solt_true3 ||
        			random_solt_true2 == random_solt_true3) {

        	rand = new Random();
	        random_solt_true1 = rand.nextInt(solt_true.length);
	        random_solt_true2 = rand.nextInt(solt_true.length);
	        random_solt_true3 = rand.nextInt(solt_true.length);
	        random_solt_false1 = rand.nextInt(solt_false.length);
	        random_solt_false2 = rand.nextInt(solt_false.length);

        	}

        	PlaySeasList = new String[]{solt_true[random_solt_true1],solt_true[random_solt_true2],
        					solt_false[random_solt_false1],solt_false[random_solt_false2],
        					solt_true[random_solt_true3]};
        }

        String seas_con = PlaySeasList[1] + "," + PlaySeasList[2] + ",(" + PlaySeasList[0] + ")";

        int cook_time = 15;
        String cook_time_ = cook_time + "";

        cooksDAO cDAO = new cooksDAO();
        int cook_num = cDAO.insertCook(user_num, food_con, seas_con, cook_time);

        String cook_num_ = cook_num +"";

        RoundsDAO rDAO = new RoundsDAO();
        Boolean result = rDAO.UpdateTour(user_num, "PLAY_STATUS","料理中");

        rDAO = new RoundsDAO();
        result = rDAO.UpdateTour(user_num, "COOK_NUM",cook_num_);



        if(selectSeas == null) {
        	selectSeas = "なし";
        }

        if(selectHelp == null) {
        	selectHelp = "なし";
        }

        for(int n = 0;n < 5;n++) {
        	if(PlaySeasList[n] == null ) {
        		PlaySeasList[n]="なし";
        	}
        }
        StatusDAO sDAO = new StatusDAO();
        String[] Status = sDAO.getStatus(user_num);
        String round_name = null;

        if(Status[4].equals("R1")) {
        	round_name = "ラウンド１";
        }else if(Status[4].equals("R2")) {
        	round_name = "ラウンド２";
        }else if(Status[4].equals("R3")) {
        	round_name = "ラウンド３";
        }else {
        	round_name = "ラウンド開始前";
        }

        String[] play ={	cook_time_,//play[0]調理時間
        					selectMeat,//play[1]肉
        					selectVege1,
        					selectVege2,
        					selectSeas,
        					selectHelp,
        					PlaySeasList[0],//play[6]
        					PlaySeasList[1],
        					PlaySeasList[2],
        					PlaySeasList[3],
        					PlaySeasList[4],
        					course_name,//play[11]
        					region + "っぽい",//
        					round_name + " Ｈ" + Status[3]
        					};

        request.setAttribute("play", play);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/play.jsp");
        dispatcher.forward(request, response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request.setCharacterEncoding("UTF-8");

    	HttpSession session = request.getSession();
        if (session.getAttribute("user_num") == null) {
            response.sendRedirect("/B1/login.jsp");
            return;
        }else {

        		int user_num = Integer.parseInt((String)session.getAttribute("user_num"));

    			request.setCharacterEncoding("UTF-8");


    			Part Image = request.getPart("image");
    			String cook_sta = request.getParameter("cook_sta");

    			LocalDateTime now = LocalDateTime.now();

    			// フォーマットを定義
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    			// フォーマットして文字列に変換
    			String cook_fin = now.format(formatter);;


    			//コンテンツタイプを取得し格納

    			String ImageBase = "C:\\pleiades\\workspace\\B1\\WebContent\\Image\\";
    			String ImageType = Image.getContentType();

    			String SimpleImageType = ImageType.substring(6);

    			StatusDAO sDAO = new StatusDAO();
    			String[] Status = sDAO.getStatus(user_num);

				LocalDateTime nowDate = LocalDateTime.now();

				DateTimeFormatter TimeFormat =DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String cook_date = nowDate.format(TimeFormat);

    			//ファイルの名前を書き込む
    			String image = "U" + Status[0] +"R"+ Status[2] +"H"+ Status[3] + "." + SimpleImageType;

    			//ファイルを書き込む
    			String ImagePass = ImageBase + image;
    			Image.write(ImagePass);

    			cooksDAO cDAO = new cooksDAO();
    			Boolean result = cDAO.updateCook(user_num, "COOK_IMG", image);

    			cDAO = new cooksDAO();
    			result = cDAO.updateCook(user_num, "COOK_STA", cook_sta);

    			cDAO = new cooksDAO();
    			result = cDAO.updateCook(user_num, "COOK_FIN", cook_fin);

    			cDAO = new cooksDAO();
    			result = cDAO.updateCook(user_num, "COOK_DATE", cook_date);

    			RoundsDAO rDAO = new RoundsDAO();
    	        result = rDAO.UpdateTour(user_num, "PLAY_STATUS","仮登録");

    			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    			long minutesDifference = 0;
    			long secondsDifference = 0;

    			try {

    			Date date1 = sdf.parse(cook_sta);
                Time time1 = new Time(date1.getTime());

                Date date2 = sdf.parse(cook_fin);
                Time time2 = new Time(date2.getTime());

                // 時間の差を計算します（ミリ秒単位で差分を取得）


                long timeDifference = Math.abs(time2.getTime() - time1.getTime());

                // 時間差を分と秒に変換します
                minutesDifference = TimeUnit.MILLISECONDS.toMinutes(timeDifference);
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(timeDifference)
                                            - TimeUnit.MINUTES.toSeconds(minutesDifference);
    			}catch (ParseException e) {
    	            e.printStackTrace();
    			}

    			if(result = true ) {

    				String[] cook = {image,minutesDifference + "分" + secondsDifference + "秒"};

    				request.setAttribute("cook",cook);

    				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/temp_regist.jsp");
    		        dispatcher.forward(request, response);
    			}
        }
    	}
















    }
