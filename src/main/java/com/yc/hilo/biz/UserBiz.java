package com.yc.hilo.biz;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.po.User;
import com.yc.hilo.util.Utils;
import com.yc.hilo.dao.UserDao;

@Service
public class UserBiz {
	@Resource
	private UserDao udao;
	
	public void register(User user) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(user.getUsername(), "用户名不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getName(), "姓名不能为空");
		// 同名验证
		User dbuser = udao.selectByName(user.getUsername());
		if(dbuser != null ) {
			throw new BizException("该用户名已经被注册");
		}
		
		try {
			udao.insert(user);
		} catch (SQLException e) {
			throw new BizException("注册失败，请联系管理员",e);
		}
	}
}
