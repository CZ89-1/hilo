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
		String sql = "insert into orders values(null,?,now(),?,?,?,?,?)";
		KeyHolder kh = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"oid"});
				ps.setObject(1, orders.getTotal());
//				ps.setObject(2, orders.getState());
				ps.setObject(3, orders.getAddr());
				ps.setObject(4, orders.getPhone());
				ps.setObject(5, orders.getUid());
				ps.setObject(6, orders.getName());
				return ps;
			}
			
		}, kh);
		return kh.getKey().intValue();
		/*jt.update(sql,
				orders.getTotal(),
				orders.getState(),
				orders.getAddr(),
				orders.getPhone(),
				orders.getUid(),
				orders.getName());*/
	}
	
	/**
	 * 新增订单明细
	 * @param orders
	 */
	public void insertItems(Orders orders) {
		String sql = "INSERT INTO orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.count,\n" +
				"	a.count * b.shop_price,\n" +
				"	a.pid,\n" +
				"	?\n" +
				"FROM\n" +
				"	cart a\n" +
				"JOIN product b ON a.pid = b.pid\n" +
				"WHERE\n" +
				"	a.uid = ?";
		jt.update(sql, orders.getOid(), orders.getUid());
	}

	public List<Map<String,Object>> selectOrders(Integer uid) {
		return jt.queryForList("select * from orders a "
				+ "left join orderitem b on a.oid=b.oid"
				+ " left join product c on b.pid=c.pid "
				+ "where a.uid=?", uid);
	}
	
	

}
