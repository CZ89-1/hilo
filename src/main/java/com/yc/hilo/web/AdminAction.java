package com.yc.hilo.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.biz.AdminBiz;
import com.yc.hilo.biz.BizException;
import com.yc.hilo.dao.AdminDao;
import com.yc.hilo.po.Admin;
import com.yc.hilo.po.Result;
import com.yc.hilo.po.User;

@RestController
public class AdminAction {
	
	@Resource
	private AdminDao ad;
	
	@Resource
	private AdminBiz ab;
	
	@RequestMapping("sendVcodeAd")
	public String sendVcode(String aname,HttpSession session) {
		String vcode=ab.sendVcode(aname);
		session.setAttribute("vcode", vcode);
		return "验证码邮件发送成功!";
	}
	@RequestMapping("resetPwdAd")
	public String resetPwd(String aname,String vcode,String password,HttpSession session) {
		ab.resetPwd(aname,vcode,password, (String) session.getAttribute("vcode"));
	    return "重置密码成功";
	}
	
	@RequestMapping("loginAd")
	public Result login(String aname,String password,String vcode,HttpSession session) throws IOException, EncodeException {
		Admin admin;
		try {
			admin = ad.login(aname,password,vcode,session);
			//session.setAttribute("loginedUser", admin);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return  new Result(0, e.getMessage());
		}
		
	}

}
