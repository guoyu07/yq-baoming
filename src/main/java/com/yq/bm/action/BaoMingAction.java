package com.yq.bm.action;

import java.util.Date;
import java.util.List;

import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.bm.bo.Baoming;
import com.yq.bm.bo.Province;
import com.yq.bm.dao.BaoMingDao;
import com.yq.bm.dao.ProvinceDao;
import com.yq.bm.service.BmService;
import com.yq.common.action.ALDAdminActionSupport;
import com.yq.common.exception.ServiceException;

public class BaoMingAction extends ALDAdminActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String name;
	private int sex;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String clothSize;
	private String shoesSize;
	private String orderName;
	private String phone;
	private String qq;
	private String idCard;
	private List<Province> provinceList;
	
	private int status;
	
	public String execute(){
		if(status==0){
			ProvinceDao provinceDao = ServiceCacheFactory.getServiceCache().getService(ProvinceDao.class); 
			provinceList = provinceDao.getProvinceList();
			return SUCCESS;
		}
		
		BmService bmService = ServiceCacheFactory.getServiceCache().getService(BmService.class); 
		try {
			bmService.addBaoMing(name, sex, provinceName, cityName, areaName, clothSize, shoesSize, orderName, phone, qq, idCard,userName);
		} catch (ServiceException e) {
			super.setErroCodeNum(e.getCode());
			return SUCCESS;
		}
		super.setErroCodeNum(2000);
		return SUCCESS;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
