package com.yq.bm.action;

import java.util.List;

import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.bm.bo.Baoming;
import com.yq.bm.bo.Province;
import com.yq.bm.dao.ProvinceDao;
import com.yq.bm.service.BmService;
import com.yq.common.action.ALDAdminPageActionSupport;
import com.yq.common.exception.ServiceException;

public class BaoMingListAction extends ALDAdminPageActionSupport<Baoming> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String opPass;
	private String suser;
	private int status;
	private List<Province> provinceList;
	private String sheng;
	public String execute(){
		ProvinceDao provinceDao = ServiceCacheFactory.getServiceCache().getService(ProvinceDao.class); 
		provinceList = provinceDao.getProvinceList();
		if(status==0){
			
			return SUCCESS;
		}
		BmService bmService = ServiceCacheFactory.getServiceCache().getService(BmService.class);
		try {
			 super.initPage(bmService.getBmPageList(opPass, suser,sheng, super.getToPage(), 50));
		} catch (ServiceException e) {
			super.setErroCodeNum(e.getCode());
		}
		return SUCCESS;
	}

	
	public String getSheng() {
		return sheng;
	}


	public void setSheng(String sheng) {
		this.sheng = sheng;
	}


	public String getOpPass() {
		return opPass;
	}

	public void setOpPass(String opPass) {
		this.opPass = opPass;
	}

	public String getSuser() {
		return suser;
	}

	public void setSuser(String suser) {
		this.suser = suser;
	}

	public int getStatus() {
		return status;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
