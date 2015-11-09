package com.yq.bm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.sr178.common.jdbc.bean.IPage;
import com.sr178.common.jdbc.bean.SqlParamBean;
import com.yq.bm.bo.Baoming;
import com.yq.bm.dao.BaoMingDao;
import com.yq.common.exception.ServiceException;
import com.yq.common.utils.IDCardUtils;

public class BmService {
    @Autowired
	private BaoMingDao baoMingDao;
	
	
	public void addBaoMing(String name, int sex, String sheng, String shi, String qu, String clothSize, String shoesSize,
			String orderName, String phone, String qq, String idCard,  String userName,int upvip){
		
		//检查身份证号码是否合格
		String result = IDCardUtils.IDCardValidate(idCard);
		if(!Strings.isNullOrEmpty(result)){
			throw new ServiceException(1, result);
		}
		Baoming baomingTemp = baoMingDao.get(new SqlParamBean("id_card", idCard));
		if(baomingTemp!=null){
			throw new ServiceException(2, "身份证号码已提交");
		}
		Baoming baoming = new Baoming(name, sex, sheng, shi, qu, clothSize, shoesSize, orderName, phone, qq, idCard, new Date(), userName,upvip);
		baoMingDao.add(baoming);
	}
	
	
	public IPage<Baoming> getBmPageList(String opPass,String suser,String sheng,int upvip,int pageIndex,int pageSize){
		if(Strings.isNullOrEmpty(opPass)||!opPass.equals("nhbm2016")){
			throw new ServiceException(1, "操作密码不正确");
		}
//		if(Strings.isNullOrEmpty(suser)){
//			if(Strings.isNullOrEmpty(sheng)){
//				return baoMingDao.getPageList(pageIndex, pageSize, "order by id desc");
//			}else{
//				return baoMingDao.getPageList(pageIndex, pageSize, "order by id desc",new SqlParamBean("sheng", sheng));
//			}
//		}else{
//			if(Strings.isNullOrEmpty(sheng)){
//				return baoMingDao.getPageList(pageIndex, pageSize, "order by id desc",new SqlParamBean("user_name", suser),new SqlParamBean("or","order_name", suser),new SqlParamBean("or","id_card", suser),new SqlParamBean("or","name", suser));
//			}else{
//				return baoMingDao.getPageList(pageIndex, pageSize, "order by id desc",new SqlParamBean("sheng", sheng),new SqlParamBean("and","user_name", suser),new SqlParamBean("or","order_name", suser),new SqlParamBean("or","id_card", suser),new SqlParamBean("or","name", suser));
//			}
//		}
		return baoMingDao.search(suser, sheng, upvip, pageIndex, pageSize);
	}
	
	
}
