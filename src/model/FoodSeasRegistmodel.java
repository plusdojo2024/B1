package model;

import java.io.Serializable;

public class FoodSeasRegistmodel implements Serializable{
	private int food_seas_num;
	private String food_seas_name;
	private String food_seas_genre;
	private boolean food_seas_stock;
//	private int food_box_num;
//	private int user_num;

	public FoodSeasRegistmodel(int food_seas_num,String food_seas_name,String food_seas_genre,
			boolean food_seas_stock) {
		this.food_seas_num = food_seas_num;
		this.food_seas_name = food_seas_name;
		this.food_seas_genre = food_seas_genre;
		this.food_seas_stock =  food_seas_stock;
//		this.food_box_num = food_box_num;
//		this.user_num = user_num;
	}

	public FoodSeasRegistmodel() {
		this.food_seas_num = 0;
		this.food_seas_name = "";
		this.food_seas_genre = "";
		this.food_seas_stock =  true;
//		this.food_box_num = 0;
//		this.user_num = 0;
	}

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

	public void setFood_seas_stock(String food_seas_stock) {
		this.food_seas_stock = true;
	}

//	public int getFood_box_num() {
//		return food_box_num;
//	}
//
//	public void setFood_box_num(int food_box_num) {
//		this.food_box_num = food_box_num;
//	}
//
//	public int getUser_num() {
//		return user_num;
//	}
//
//	public void setUser_num(int user_num) {
//		this.user_num = user_num;
//	}

	public boolean insert(FoodSeasRegistmodel foodSeasRegistmodel) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}