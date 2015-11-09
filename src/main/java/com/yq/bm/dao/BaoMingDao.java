package com.yq.bm.dao;

import com.google.common.base.Strings;
import com.sr178.common.jdbc.bean.IPage;
import com.yq.bm.bo.Baoming;
import com.yq.common.dao.YqBmDaoBase;

public class BaoMingDao extends YqBmDaoBase<Baoming> {

	
	public IPage<Baoming> search(String suser,String sheng,int upvip,int pageIndex,int pageSize){
		String sql = "select * from "+super.getTable()+" where 1=1";
		if(upvip!=0){
			sql = sql +" and upvip="+upvip;
		}
		if(!Strings.isNullOrEmpty(sheng)){
			sql = sql +" and sheng='"+sheng+"'";
		}
		if(!Strings.isNullOrEmpty(suser)){
			sql = sql +" and (name='"+suser+"'"+" or id_card='"+suser+"'"+" or order_name='"+suser+"'"+" or user_name='"+suser+"'"+")";
		}
		return super.getJdbc().getListPage(sql, Baoming.class, null, pageSize, pageIndex);
	}
}
