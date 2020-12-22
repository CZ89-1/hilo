package com.yc.hilo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.hilo.biz.BizException;
import com.yc.hilo.biz.UserBiz;
import com.yc.hilo.po.User;



@Repository
public class UserDao extends BaseDao {

	@Resource
	private UserBiz ubiz;

	public void insert(User user) throws SQLException {
		String sql = "insert into user values(null,?,?,?,?,?,?,1,null,?)";
		jt.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone(),
				user.getSex(), user.getAddr());
	}

	/**
	 * 根据用户名查用户
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public User selectByName(String username) {
		String sql = "select * from user where username=?";
		return jt.query(sql, rs -> {
			return rs.next() ? UserRowMapper.mapRow(rs, -1) : null;
		}, username);
	}

	public User login(String username, String password, String vcode, HttpSession session) throws BizException {
		return ubiz.login(username, password, vcode, session);
	}

	public void register(User user) throws BizException, SQLException {
		ubiz.register(user);
	}

	private RowMapper<User> UserRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUid(rs.getInt("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setSex(rs.getString("sex"));
//			user.setState(rs.getInt("state"));
//			user.setCode(rs.getString("code"));
			user.setAddr(rs.getString("addr"));
			return user;
		}
	};

	public void updatePwdByName(String password, String username) {
		String sql="update user set password=? where username=?";
		jt.update(sql,password,username);
		
	}

}
