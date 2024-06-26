package model;

import java.io.Serializable;

public class FoodSeasListmodel implements Serializable {
	private int food_seas_num;			/*食材管理番号*/
	private String food_seas_name ;		/* 食材名 */
	private String food_seas_genre ;	/* 食材のジャンル */
	private boolean food_seas_stock;	/* 在庫の有無 */
	private int food_box_num;
	private int user_num;

//ここまででやってること
//FoodSeasListmodelクラスを作成して、中身を決める
//私の場合はこの4つ


	//引数がないコンストラクタ


	public FoodSeasListmodel() {
	}
    //引数があるコンストラクタ
	public FoodSeasListmodel( int food_seas_num ,String food_seas_name, String food_seas_genre, boolean food_seas_stock
			,int food_box_num, int user_num) {
		super();
		this.food_seas_num = food_seas_num;
		this.food_seas_name = food_seas_name;
		this.food_seas_genre = food_seas_genre;
		this.food_seas_stock = food_seas_stock;
		this.food_box_num = food_box_num;
		this.user_num = user_num;

	}
//ここまででしてること
//コンストラクタは実体かするときに使うやつ
//ここに入るのはmodel

	public int getFood_seas_num() {
		return food_seas_num;
	}
	public void setFood_seas_num(int food_seas_num) {
		this.food_seas_num = food_seas_num;
	}

	public String getFood_seas_name() {
		return food_seas_name;
	}
	public void setFood_seas_name(String food_seas_name) {
		this.food_seas_name = food_seas_name;
	}


	public String getFood_seas_genre() {
		return food_seas_genre;
	}
	public void setFood_seas_genre(String food_seas_genre) {
		this.food_seas_genre = food_seas_genre;
	}


	public boolean getFood_seas_stock() {
		return food_seas_stock;
	}
	public void setFood_seas_stock(boolean food_seas_stock) {
		this.food_seas_stock = food_seas_stock;
	}

	public int getFood_box_num() {
		return food_box_num;
	}
	public void setFood_box_num(int food_box_num) {
		this.food_box_num = food_box_num;
	}

	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

}
