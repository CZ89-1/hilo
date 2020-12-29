package com.yc.hilo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class WishDao extends BaseDao{
	
	public List<Map<String,Object>> selectWish(Integer uid) {
		return jt.queryForList("select * from wish a"
				+ " left join user b on a.uid=b.uid"
				+ " left join fruit c on a.fid=c.fid"
				+ " where a.uid=?", uid);
	}
	
	public void delectWish(int fid) {
		String sql="delete from wish where fid=?";
		jt.update(sql,fid);
	}
	
    public void addWish(Integer uid,String fid) {
			String sql = "insert into wish values(null,?,?,1)";
			jt.update(sql, uid, fid);
		}
	

   public void addCart(Integer uid,int fid) {
	       String sql = "insert into cart values(null,?,?,1)";
	       jt.update(sql, uid, fid);
  }
  }

    
	
	

