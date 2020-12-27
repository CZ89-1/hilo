package com.yc.hilo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yc.hilo.po.Orders;



@Repository
public class OrdersDao extends BaseDao{
	/**
	 * 新增订单主表
	 * @param orders
	 * @return 
	 */
	
	public int insertOrders(Orders orders) {
		String sql = "insert into orders values(null,?,?,now(),?,?,?,0)";
		KeyHolder kh = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"oid"});
				ps.setObject(1, orders.getTotal());
//				ps.setObject(2, orders.getState());
				ps.setObject(2, orders.getAddr());
				ps.setObject(3, orders.getPhone());
				ps.setObject(4, orders.getUid());
				ps.setObject(5, orders.getName());
				return ps;
			}
			
		}, kh);
		return kh.getKey().intValue();
		
	}
	
	/**
	 * 新增订单明细
	 * @param orders
	 */
	public void insertItems(Orders orders) {
		String sql = "INSERT INTO orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.count * b.fprice,\n" +
				"	a.count,\n" +
				"	a.fid,\n" +
				"	?\n" +
				"FROM\n" +
				"	cart a\n" +
				"JOIN fruit b ON a.fid = b.fid\n" +
				"WHERE\n" +
				"	a.uid = ?";
		jt.update(sql, orders.getOid(), orders.getUid());
	}

	public List<Map<String,Object>> selectOrders(Integer uid) {
		return jt.queryForList("select * from orders a "
				+ "left join orderitem b on a.oid=b.oid"
				+ " left join fruit c on b.fid=c.fid "
				+ "where a.uid=?", uid);
	}
	
	public void sureOrder(int oid) {
		String sql="update orders set state=3 where oid=?";
		jt.update(sql,oid);
	}
	
	public List<Map<String,Object>> queryOrderstate(int state) {
		String sql="SELECT * from orders a JOIN orderitem b JOIN fruit c WHERE a.oid=b.oid AND b.fid=c.fid and state=?";
		return jt.queryForList(sql,state);
	}
	
	
	

}
