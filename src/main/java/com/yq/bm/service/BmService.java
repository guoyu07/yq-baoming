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
		idCard = idCard.trim();
		//检查身份证号码是否合格
		String result = IDCardUtils.IDCardValidate(idCard.toLowerCase());
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
	
	//st 0全部   1只看删除  2 只看未删除
	public IPage<Baoming> getBmPageList(String opPass,String suser,String sheng,int upvip,int st,int pageIndex,int pageSize){
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
		return baoMingDao.search(suser, sheng, upvip, st,pageIndex, pageSize);
	}
	
	/**
	 * 获取单个
	 * @param id
	 * @return
	 */
	public Baoming get(int id){
		return baoMingDao.get(new SqlParamBean("id", id));
	}
	/**
	 * 更新
	 * @param id
	 * @param name
	 * @param sex
	 * @param sheng
	 * @param shi
	 * @param qu
	 * @param clothSize
	 * @param shoesSize
	 * @param orderName
	 * @param phone
	 * @param qq
	 * @param idCard
	 * @param userName
	 * @param upvip
	 * @return
	 */
	public boolean update(int id,String name, int sex, String sheng, String shi, String qu, String clothSize, String shoesSize,String orderName, String phone, String qq, String idCard, String userName, int upvip,String editName) {
		// 检查身份证号码是否合格
		idCard = idCard.trim();
		String result = IDCardUtils.IDCardValidate(idCard.toLowerCase());
		if (!Strings.isNullOrEmpty(result)) {
			throw new ServiceException(1, result);
		}
		Baoming bm = baoMingDao.get(new SqlParamBean("id", id));
		if(!idCard.equals(bm.getIdCard())){
			Baoming baomingTemp = baoMingDao.get(new SqlParamBean("id_card", idCard));
			if (baomingTemp != null) {
				throw new ServiceException(2, "身份证号码已提交");
			}
		}
		baoMingDao.delete(new SqlParamBean("id", id));
		Baoming baoming = new Baoming(name, sex, sheng, shi, qu, clothSize, shoesSize, orderName, phone, qq, idCard,
				bm.getTime(), userName, upvip);
		baoming.setEditName(editName);
		baoming.setEditTime(new Date());
		baoming.setId(id);
		return baoMingDao.add(baoming);
	}
	
	/**
	 * 更新状态
	 * @param id
	 * @return
	 */
	public boolean delete(int id,int st,String deleteName,String recoverName){
		Baoming bm = baoMingDao.get(new SqlParamBean("id", id));
		if(bm==null){
			return false;
		}
		baoMingDao.delete(new SqlParamBean("id", id));
		bm.setStatus(st);
		if(st==0){
			bm.setRecoverName(recoverName);
		}
		if(st==1){
			bm.setDeleteName(deleteName);
		}
		bm.setEditTime(new Date());
		return baoMingDao.add(bm);
	}
	
}
