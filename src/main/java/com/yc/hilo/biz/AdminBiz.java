package com.yc.hilo.biz;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.hilo.dao.AdminDao;
import com.yc.hilo.po.Admin;
import com.yc.hilo.po.User;
import com.yc.hilo.util.Utils;

@Service
public class AdminBiz {
   
  @Resource
  private AdminDao ad;
  
  @Resource
  private MailBiz mbiz;
  
  public String sendVcode(String aname) {
		Admin admin = ad.selectByName(aname);
		// 生成随机验证码
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(admin.getEmail(), "密码重置验证码","请使用"+vcode+"验证码来重置密码");
		return vcode;
	}
	public String resetPwd(String aname,String vcode,
			String password,String sessionVcode) {
		System.out.println(vcode);
		System.out.println(aname);
		System.out.println(password);
		if(vcode.equalsIgnoreCase(sessionVcode)) {
			ad.updatePwdByName(password,aname);
			return "密码重置成功!";
		}else {
			return "验证码错误!";
		}
	}
	public Admin login(String aname,String password,String vcode,HttpSession session) throws BizException {
		// 字段验证
		Utils.checkNull(aname, "请输入用户名");
		Utils.checkNull(password, "请输入密码");
		
		Admin admin = new Admin();
		admin = ad.selectByName(aname);
		if(admin == null) {
			throw new BizException("请检查用户名是否正确");
		}
	
		if( !admin.getPassword().equals(password)  ) {
			throw new BizException("密码错误");
		}
		@SuppressWarnings("null")
		String svcode = (String) session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(svcode)) {
			throw new BizException("验证码错误");
		}
		return admin;
	}
}
