package com.yc.hilo.web;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;
import com.yc.hilo.biz.UserBiz;
import com.yc.hilo.dao.UserDao;
@RestController
public class UserAction {

	@Resource
	private UserDao udao;
	
	@Resource
	private UserBiz ubiz;
	
	@RequestMapping("reg.s")
	public Result reg(User user,String vcode,HttpSession session) throws SQLException {
		try {
			String svcode = (String) session.getAttribute("vcode");
			if(!vcode.equalsIgnoreCase(svcode)) {
				throw new BizException("验证码错误");
			}
			udao.register(user);
			return new Result(1, "注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		} 
	}
	
	
}
