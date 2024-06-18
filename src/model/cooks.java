package model;

import java.io.Serializable;

public class cooks implements Serializable {
	private int cook_num ; /* 番号 */
	private String cook_date  ; /* 日付 */
	private String cook_img;  /* 画像 */
	private String cook_name ; /* 料理名 */
	private String cook_time;/* 調理時間 */
	private String  cook_sta;  /* 開始時間 */
	private String  cook_fin;   /* 終了時間 */
	private String ;   /* 終了時間 */
	private String cook_fin;   /* 終了時間 */
	private String cook_fin;   /* 終了時間 */
	private String cook_fin;   /* 終了時間 */
	private String cook_fin;   /* 終了時間 */


	//引数がないコンストラクタ
	public Bc() {

	}
    //引数があるコンストラクタ
	public Bc(int number, String company, String name, String address, String phone, String email, String remarks) {
		super();
		this.number = number;
		this.company = company;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}