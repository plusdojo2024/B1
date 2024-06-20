package model;

import java.io.Serializable;

public class NowTourScore implements Serializable {
	private int scores_num ; /* スコア管理番号 */
	private int par  ; /* パー数 */
	private int time_scores ;  /* 調理時間スコア */
	private int food_scores ; /* 食材スコア */
	private int seas_scores;/* 調味料スコア */
	private int cook_scores;  /* 調理満足度 */
	private int taste_scores;   /* 味満足度 */
	private int total_score ;   /* 	今回のスコア */

	//引数がないコンストラクタ
	public NowTourScore() {

	}
    //引数があるコンストラクタ
	public NowTourScore( int scores_num ,int par,int time_scores,int food_scores,int seas_scores,
					int cook_scores,int taste_scores,int total_score ) {
		super();
		this.scores_num=scores_num;
		this.par=par;
		this.time_scores=time_scores;
		this.food_scores=food_scores;
		this.seas_scores=seas_scores;
		this.cook_scores=cook_scores;
		this.taste_scores=taste_scores;
		this.total_score=total_score;
	}


	public int getScores_num() {
		return scores_num;
	}
	public void setScores_num(int scores_num) {
		this.scores_num = scores_num;
	}
	public int getPar() {
		return par;
	}
	public void setPar(int par) {
		this.par = par;
	}
	public int getTime_scores() {
		return time_scores;
	}
	public void setTime_scores(int time_scores) {
		this.time_scores = time_scores;
	}
	public int getFood_scores() {
		return food_scores;
	}
	public void setFood_scores(int food_scores) {
		this.food_scores = food_scores;
	}
	public int getSeas_scores() {
		return seas_scores;
	}
	public void setSeas_scores(int seas_scores) {
		this.seas_scores = seas_scores;
	}
	public int getCook_scores() {
		return cook_scores;
	}
	public void setCook_scores(int cook_scores) {
		this.cook_scores = cook_scores;
	}
	public int getTaste_scores() {
		return taste_scores;
	}
	public void setTaste_scores(int taste_scores) {
		this.taste_scores = taste_scores;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
}