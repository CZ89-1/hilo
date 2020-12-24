package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.yc.hilo.po.Fruit;

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
}
