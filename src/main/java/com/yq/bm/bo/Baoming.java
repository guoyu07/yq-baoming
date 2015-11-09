package com.yq.bm.bo;

import java.util.Date;
   /**
    * baoming 实体类
    */ 


public class Baoming{
	private Integer id;
	private String name;
	private int sex;
	private String sheng;
	private String shi;
	private String qu;
	private String clothSize;
	private String shoesSize;
	private String orderName;
	private String phone;
	private String qq;
	private String idCard;
	private Date time;
	private String userName;
	private Integer upvip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getClothSize() {
		return clothSize;
	}
	public void setClothSize(String clothSize) {
		this.clothSize = clothSize;
	}
	public String getShoesSize() {
		return shoesSize;
	}
	public void setShoesSize(String shoesSize) {
		this.shoesSize = shoesSize;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public Baoming(String name, int sex, String sheng, String shi, String qu, String clothSize, String shoesSize,
			String orderName, String phone, String qq, String idCard, Date time, String userName,int upvip) {
		super();
		this.name = name;
		this.sex = sex;
		this.sheng = sheng;
		this.shi = shi;
		this.qu = qu;
		this.clothSize = clothSize;
		this.shoesSize = shoesSize;
		this.orderName = orderName;
		this.phone = phone;
		this.qq = qq;
		this.idCard = idCard;
		this.time = time;
		this.userName = userName;
		this.upvip = upvip;
	}
	public Baoming() {
		super();
	}
	public Integer getUpvip() {
		return upvip;
	}
	public void setUpvip(Integer upvip) {
		this.upvip = upvip;
	}
	
}

