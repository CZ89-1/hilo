package com.yc.hilo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.biz.OrdersBiz;
import com.yc.hilo.dao.OrdersDao;
import com.yc.hilo.po.Orders;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;



@RestController
public class OrdersAction {
	
	@Resource
	private OrdersBiz obiz;
	

	@Resource
	private OrdersDao odao;
	

	@RequestMapping("order.s")
	public Result pay(Orders orders, HttpSession session ,String addr,String phone,String name) {

		try {
			User user = (User) session.getAttribute("loginedUser");
			orders.setUid(user.getUid());
			orders.setName(name);
			orders.setPhone(phone);
			orders.setAddr(addr);
			obiz.pay(orders);
			return Result.success("下单成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	@RequestMapping("queryOlist")
	public List<?> queryCart(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return odao.selectOrders(user.getUid());
		
	}
	
	@RequestMapping(path="order.s" ,params = "sureOrder")
	public Result sureOrder(int oid,HttpSession session) {
		odao.sureOrder(oid);
		return Result.success("确认收货成功!");
		
	}
	
	@RequestMapping(path="order.s" ,params = "queryOrdersState")
	public List<?>queryOrderstate(int state,HttpSession session){
		return odao.queryOrderstate(state);
	}
	

}
