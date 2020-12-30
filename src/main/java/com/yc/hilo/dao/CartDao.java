package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.hilo.dao.BaseDao;
import com.yc.hilo.po.Cart;


@Repository
public class CartDao extends BaseDao {
	public List<?> queryCart(Integer uid) throws SQLException {
		String sql = "select fruit.*,cart.* from cart,fruit " + 
	  "where cart.fid=fruit.fid and cart.uid=?";
		List<?> list = null;
		
		System.out.println("list==" + list);
		return list;
	}

	public void addCart(Integer uid,int fid, int count) throws SQLException {
		

		String sql = "update cart set count=count+? where uid=? and fid=?";
		if (jt.update(sql, count, uid, fid) == 0) {
			sql = "insert into cart values(null,?,?,?)";
			jt.update(sql, uid, fid, count);
		}
	}

	public void deleteCart(String fid) {
		String sql = "delete from cart where fid=?";

		jt.update(sql, fid);

	}

	public void clearCart(Integer iUid) throws SQLException {
		String sql = "delete from cart where uid = ?";
		jt.update(sql, iUid);
	}

	public void insert(int uid, int fid, int count) {
		jt.update("insert into cart values(null,?,?,?)", uid, fid, count);
	}

	public List<Map<String,Object>> selectCart(Integer uid) {
		return jt.queryForList("select * from cart a"
				+ " left join user b on a.uid=b.uid"
				+ " left join fruit c on a.fid=c.fid"
				+ " where a.uid=?", uid);
	}
	public Double selectTotalByUid(Integer uid) {
		String sql = "SELECT SUM(count*f.fprice) FROM cart a JOIN fruit f WHERE a.fid=f.fid AND uid=?";
		return jt.queryForObject(sql, Double.class, uid);
	}

	/**
	 * 根据用户id 删除购物车
	 */
	public void deleteByUid(Integer uid) {
		jt.update("delete from cart where uid=?",uid);
	}

	@SuppressWarnings("unused")
	private RowMapper<Cart> cartRowMapper = new RowMapper<Cart>() {

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setCcid(rs.getInt("ccid"));
			cart.setUid(rs.getInt("uid"));
			cart.setFid(rs.getInt("fid"));
			cart.setCount(rs.getInt("count"));
			return cart;
		}
	};

	public int getCartCount() {
		String sql="select count(ccid) from cart";
		return jt.queryForObject(sql,Integer.class);
	}

}
