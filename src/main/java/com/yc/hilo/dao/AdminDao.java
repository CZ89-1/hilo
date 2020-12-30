package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.hilo.biz.AdminBiz;
import com.yc.hilo.biz.BizException;
import com.yc.hilo.po.Admin;
import com.yc.hilo.po.User;


@Repository
public class AdminDao extends BaseDao{
	
	@Resource
	private AdminBiz ab;
	
	public Admin selectByName(String aname) {
		String sql = "select * from admin where aname=?";
		return jt.query(sql, rs->{
			return rs.next() ? AdminRowMapper.mapRow(rs, -1) : null;
		}, aname);
	}
	
	public void updatePwdByName(String password, String aname) {
		String sql="update admin set password=? where aname=?";
		jt.update(sql,password,aname);
		
	}
	
	public Admin login(String aname, String password, String vcode, HttpSession session) throws BizException {
		return ab.login(aname, password, vcode, session);
	}
	
	private RowMapper<Admin> AdminRowMapper = new RowMapper<Admin>() {

		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin=new Admin();
			admin.setAid(rs.getInt("aid"));
			admin.setAname(rs.getString("aname"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			return admin;
		}
	};

}
