package model;

import java.io.Serializable;

public class PastScore implements Serializable{
	private int user_num ;
	private int scores_num ;
	private int tour_num ;
	private int round_num ;
	private int hole_num;
	private String tour_sta;
	private String tour_fin;
	private int cook_num ;
	private int scores ;

	//引数がないコンストラクタ
	public PastScore() {

	}
    //引数があるコンストラクタ
	public PastScore(int user_num ,int scores_num,int tour_num ,int round_num ,int hole_num ,String tour_sta ,String tour_fin ,int cook_num ,int scores ) {
		super();
		this.user_num=user_num;
		this.scores_num=scores_num;
		this.tour_num=tour_num;
		this.round_num=round_num;
		this.hole_num=hole_num;
		this.tour_sta=tour_sta;
		this.tour_fin=tour_fin;
		this.cook_num=cook_num;
		this.scores=scores;
	}
	  // GetterとSetter
	 public int getUser_num() {return user_num;}
	 public void setUser_num(int user_num) {this.user_num = user_num;}

	 public int getScores_num() {return scores_num;}
	 public void setScores_num(int scores_num) {this.scores_num = scores_num;}

	 public int getTour_num() {return tour_num;}
	 public void setTour_num(int tour_num) {this.tour_num = tour_num;}

    public int getRound_num() {return round_num;}
    public void setRound_num(int round_num) {this.round_num = round_num;}

    public int getHole_num() {return hole_num;}
    public void setHole_num(int hole_num) {this.hole_num = hole_num;}

    public String getTour_sta() {return tour_sta;}
    public void setTour_sta(String tour_sta) {this.tour_sta = tour_sta;}

    public String getTour_fin() {return tour_fin;}
    public void setTour_fin(String tour_fin) {this.tour_fin = tour_fin;}

    public int getCook_num() {return cook_num;}
    public void setCook_num(int cook_num) {this.cook_num = cook_num;}

    public int getScores() {return scores;}
    public void setScores(int scores) {this.scores = scores;}
}