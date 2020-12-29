package com.yc.hilo.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.po.Result;



@RestController
public class LogoutAction {
	
	@RequestMapping("out.s")
	public Result logout(HttpSession session) throws IOException {
		Object loginedUser = session.getAttribute("loginedUser");
		if(loginedUser == null) {
			return new Result(0,"你还未登录");
		}
		session.removeAttribute("loginedUser");
		return new Result(1,"成功退出");
	}

}