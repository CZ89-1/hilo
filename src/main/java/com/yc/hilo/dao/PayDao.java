package com.yc.hilo.dao;

import org.springframework.stereotype.Repository;



@Repository
public class PayDao extends BaseDao{
	
	public void queryOid(int oid) {
		String sql="update orders set state=1 where oid=?";
		jt.update(sql,oid);
	}
}
