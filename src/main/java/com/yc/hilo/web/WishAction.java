package com.yc.hilo.web;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.dao.WishDao;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;

@RestController
public class WishAction {
	
	@Resource
	private WishDao wd;
	
	@RequestMapping("queryWish")
	public List<?> queryWish(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return wd.selectWish(user.getUid());
	}
	
	@RequestMapping(path="wish.s" ,params = "addWish")
	public Result addWish(String fid,HttpSession session)  {
		// 获取当前的登录的用户
		User user = (User) session.getAttribute("loginedUser");
		
		wd.addWish(user.getUid(),fid);
		
		return Result.success("收藏成功");
		
	}
	
	@RequestMapping(path="wish.s" ,params = "addCarts")
	public Result addCart(int fid,HttpSession session) {
		// 获取当前的登录的用户
		User user = (User) session.getAttribute("loginedUser");
		
		wd.addCart(user.getUid(),fid);
		
		return Result.success("加购成功!");
		
	}
	
	@RequestMapping(path="wish.s" ,params = "deleteWish")
	public Result deleteCart(int fid,HttpSession session) {
		wd.delectWish(fid);
		return Result.success("删除商品成功!");
		
	}
	
	
	
	
}
