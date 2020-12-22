package com.yc.hilo.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.hilo.dao.CartDao;
import com.yc.hilo.dao.OrdersDao;
import com.yc.hilo.po.Orders;
import com.yc.hilo.util.Utils;



@Service
public class OrdersBiz {

	@Resource
	private CartDao cdao;
	
	@Resource
	private OrdersDao odao;
	
	@Transactional
	public void pay(Orders orders) throws BizException{

		// 验证输入值
		Utils.checkNull(orders.getAddr(), "请填写收货地址");
		Utils.checkNull(orders.getPhone(), "请填写收货人电话");
		Utils.checkNull(orders.getName(), "请填写收货人姓名");
		
		// 计算总金额
		Double total = cdao.selectTotalByUid(orders.getUid());
		orders.setTotal(total);
//		orders.setState(0);
		
		// 写入数据库
		// 订单主表  orders
		int oid = odao.insertOrders(orders);
		// 订单明细 orderitem
		orders.setOid(oid);
		odao.insertItems(orders);
		// 清空购物车 cart ==> uid
		cdao.deleteByUid(orders.getUid());

	}

}
