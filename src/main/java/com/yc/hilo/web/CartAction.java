package com.yc.hilo.web;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.dao.CartDao;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;



@RestController
public class CartAction {

	@Resource
	private CartDao cdao;
	
	@RequestMapping(path="cart.s" ,params = "deleteCart")
	public Result deleteCart(String fid,HttpSession session) {
		cdao.deleteCart(fid);
		return Result.success("删除商品成功!");
		
	}
	@RequestMapping("clearCart")
	public Result clearCart(HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("loginedUser");
		cdao.clearCart(user.getUid());
		return Result.success("清空购物车成功!");
		
	}
	
	/**
	 * 添加购物车
	 * @param pid 商品id
	 * @param count 商品数量
	 * @param session 会话对象
	 * @return
	 */
	@RequestMapping("addCart")
	public Result addCart(int fid, int count, HttpSession session) {
		// 获取当前的登录的用户
		User user = (User) session.getAttribute("loginedUser");
		// 添加购物车记录, 注意:这里没有判断,是否有添加过商品,请自行移植
		cdao.insert(user.getUid(),fid,count);
		// 返回结果
		return Result.success("添加购物车成功!");
	}
	
	/**
	 * 查询购物车
	 * @param session
	 * @return
	 */
	@RequestMapping("queryCart")
	public List<?> queryCart(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return cdao.selectCart(user.getUid());
	}
	
	@RequestMapping("queryCartCount")
	public int getCartCount() {
		return cdao.getCartCount();
	}
	
}
