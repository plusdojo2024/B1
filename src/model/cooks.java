package model;

import java.io.Serializable;

public class cooks implements Serializable {
	private int cook_num ; /* 番号 */
	private int cook_date  ; /* 日付 */
	private char cook_img ;  /* 画像 */
	private String cook_name ; /* 料理名 */
	private String cook_time;/* 調理時間 */
	private String  cook_sta;  /* 開始時間 */
	private String  cook_fin;   /* 終了時間 */
	private String  food_con ;   /* 	食材条件 */
	private String food_used;   /* 使用した食材 */
	private String seas_con ;   /* 調味料条件 */
	private String seas_used;   /* 使用した調味料*/
	private String cook_satis;   /* 調理の満足度 */
	private String  aji_satis ;   /* 味の満足度 */
	private String cook_fav;   /* お気に入り */
	private String cook_com; /* コメント */




	public int getCook_num() {
		return cook_num;
	}
	public void setCook_num(int cook_num) {
		this.cook_num = cook_num;
	}
	public int getCook_date() {
		return cook_date;
	}
	public void setCook_date(int cook_date) {
		this.cook_date = cook_date;
	}
	public char getCook_img() {
		return cook_img;
	}
	public void setCook_img(char cook_img) {
		this.cook_img = cook_img;
	}
	public String getCook_name() {
		return cook_name;
	}
	public void setCook_name(String cook_name) {
		this.cook_name = cook_name;
	}
	public String getCook_time() {
		return cook_time;
	}
	public void setCook_time(String cook_time) {
		this.cook_time = cook_time;
	}
	public String getCook_sta() {
		return cook_sta;
	}
	public void setCook_sta(String cook_sta) {
		this.cook_sta = cook_sta;
	}
	public String getCook_fin() {
		return cook_fin;
	}
	public void setCook_fin(String cook_fin) {
		this.cook_fin = cook_fin;
	}
	public String getFood_con() {
		return food_con;
	}
	public void setFood_con(String food_con) {
		this.food_con = food_con;
	}
	public String getFood_used() {
		return food_used;
	}
	public void setFood_used(String food_used) {
		this.food_used = food_used;
	}
	public String getSeas_con() {
		return seas_con;
	}
	public void setSeas_con(String seas_con) {
		this.seas_con = seas_con;
	}
	public String getSeas_used() {
		return seas_used;
	}
	public void setSeas_used(String seas_used) {
		this.seas_used = seas_used;
	}
	public String getCook_satis() {
		return cook_satis;
	}
	public void setCook_satis(String cook_satis) {
		this.cook_satis = cook_satis;
	}
	public String getAji_satis() {
		return aji_satis;
	}
	public void setAji_satis(String aji_satis) {
		this.aji_satis = aji_satis;
	}
	public String getCook_fav() {
		return cook_fav;
	}
	public void setCook_fav(String cook_fav) {
		this.cook_fav = cook_fav;
	}
	public String getCook_com() {
		return cook_com;
	}
	public void setCook_com(String cook_com) {
		this.cook_com = cook_com;
	}

