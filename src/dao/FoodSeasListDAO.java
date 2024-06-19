package dao;


//ここから編集
	public static String[] fsl(String genre) {
//DBアクセス権
	Connection conn = null;
	String[] fslList = new String[4];

	try {
//データベース読み込み
	Class.forName("org.h2.Driver");
//データベースに接続
	conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/", "B1", "");

//SQL準備
	String sql = "SELECT * FROM food_seas WHERE meat;";
	PreparedStatement pStmt = conn.prepareStatement(sql);

//SQL文を実行し、結果表を記録する
//結果表をコレクションにコピーする
//データベースの切断
//結果を返す