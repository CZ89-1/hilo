package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.yc.hilo.po.Fruit;
import com.yc.hilo.po.Result;

@Repository
public class FruitsDao extends BaseDao{
   public List<Fruit> SelectFruitsNew() {
	   String sql="SELECT * FROM fruit ORDER BY fdate DESC LIMIT 0,8";
	   return jt.query(sql,FruitRowMapper);
       
   }
   public List<Fruit> SelectFruitsGuanggao() {
	   String sql="SELECT * FROM fruit WHERE guanggao=1 LIMIT 0,1";
	   return jt.query(sql,FruitRowMapper);
       
   }
   public List<Fruit> SelectFruitsTuijian() {
	   String sql="SELECT * FROM fruit WHERE (fnprice-fprice)/fprice LIMIT 0,1";
	   return jt.query(sql,FruitRowMapper);
       
   }
   
   
   public List<Fruit> SelectFruitsPopular() {
	   String sql="SELECT * FROM fruit WHERE hot=1 LIMIT 0,6";
	   return jt.query(sql,FruitRowMapper);
       
   }
   
   public Fruit queryFruitById(int fid) {
		String sql = "select * from fruit where fid=?";
		return jt.query(sql, rs->{
			return rs.next() ? FruitRowMapper.mapRow(rs, -1) : null;
		}, fid);
		
	}
   
   
   
   private RowMapper<Fruit> FruitRowMapper = new RowMapper<Fruit>() {

		@Override
		public Fruit mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fruit f = new Fruit();
			f.setFid(rs.getInt("fid"));
			f.setFdesc(rs.getString("fdesc"));
			f.setfImage(rs.getString("f_image"));
			f.setFname(rs.getString("fname"));
			f.setFprice(rs.getDouble("fprice"));
			f.setFnprice(rs.getDouble("fnprice"));
			f.setGuanggao(rs.getInt("guanggao"));
			f.setFdate(rs.getDate("fdate"));
			return f;
		}
	};

	public List<Fruit> queryFruitByCid(int cid, int pageNum, int pageSize) {
		String sql="select * from fruit where cid=?";
		if(pageNum==1) {
			sql += " limit 0,?";
			return jt.query(sql,FruitRowMapper,cid,pageSize);
		}else {
			sql += " limit ?,?";
			return jt.query(sql,FruitRowMapper,cid,pageSize*(pageNum-1),pageSize);
		}
		
	}
	
	
//	public List<Fruit> queryFruitByFname(String fname) {
//		String sql="select * from fruit where fname like ?";
//		return jt.query(sql,FruitRowMapper,fname);
//	}
	public int getFruitsTotalNum() {
			String sql = "select count(fid) from fruit";
			return jt.queryForObject(sql,Integer.class);
		}
	public List<Fruit> queryFruit (int pageNum, int pageSize) {
		String sql="select * from fruit";
		if(pageNum==1) {
			sql += " limit 0,?";
			return jt.query(sql,FruitRowMapper,pageSize);
		}else {
			sql += " limit ?,?";
			return jt.query(sql,FruitRowMapper,pageSize*(pageNum-1),pageSize);
		}
	}
	
	}
	
	
	


