package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.hilo.po.Fruit;

@Repository
public class FruitsDao extends BaseDao{
   public List<Fruit> SelectFruits() {
	   String sql="select * from fruit";
	   return jt.query(sql,FruitRowMapper);
       
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
			f.setCid(rs.getInt("cid"));
			return f;
		}
	};

	public List<Fruit> queryFruitByCid(int cid) {
		String sql="select *from fruit where cid=? limit 0,12";
		return jt.query(sql, FruitRowMapper,cid);
	}
}
