package model;

import java.io.Serializable;

public class FoodSeasRegistmodel implements Serializable{
	private String name; //食材名
	private String genre; //ジャンル

	public FoodSeasRegistmodel(String name, String genre) {
		this.name = name;
		this.genre = genre;
	}

	public FoodSeasRegistmodel(){
		this.name = "";
		this.genre = "";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String Genre) {
		this.genre = genre;
	}
}