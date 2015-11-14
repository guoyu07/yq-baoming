package com.yq.bm.dao;

import com.google.common.base.Strings;
import com.sr178.common.jdbc.bean.IPage;
import com.yq.bm.bo.Baoming;
import com.yq.common.dao.YqBmDaoBase;

public class BaoMingDao extends YqBmDaoBase<Baoming> {

	
	public IPage<Baoming> search(String suser,String sheng,int upvip,int st,int pageIndex,int pageSize){
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
		if(st==0){//看全部
			
		}else if(st==1){//只看删除
			sql = sql + " and status=1";
		}else if(st==2){//只看未删除
			sql = sql + " and status=0";
		}
		sql = sql+" order by id desc";
		return super.getJdbc().getListPage(sql, Baoming.class, null, pageSize, pageIndex);
	}
}
