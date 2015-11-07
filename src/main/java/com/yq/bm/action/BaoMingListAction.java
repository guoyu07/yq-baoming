package com.yq.bm.action;

import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.bm.bo.Baoming;
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
	public String execute(){
		if(status==0){
			return SUCCESS;
		}
		BmService bmService = ServiceCacheFactory.getServiceCache().getService(BmService.class);
		try {
			 super.initPage(bmService.getBmPageList(opPass, suser, super.getToPage(), 50));
		} catch (ServiceException e) {
			super.setErroCodeNum(e.getCode());
		}
		return SUCCESS;
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

	public void setStatus(int status) {
		this.status = status;
	}
}
