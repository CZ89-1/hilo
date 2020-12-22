package com.yc.hilo.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.hilo.util.VerifyCodeUtils;

@RestController
public class VerifyCodeAction  {

	@RequestMapping("verifyCode.s")
	public String getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String vcode = VerifyCodeUtils.outputImage(response);
		session.setAttribute("vcode", vcode);
		return vcode;
	}
}



