package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {		//Add

		stmt.update(
				"insert into users (firstname,lastname,email,password,gender,usertype,active) values(?,?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getGender(),
				user.getUserType(), user.getActive());
	}

	public UserBean getUserByEmail(String email) {		//Duplicate Email

		List<UserBean> users = null;
		try {
			users = stmt.query("select * from users where email = ?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
		} catch (Exception e) {
			System.out.println("User Not Present!");
		}

		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public UserBean authenticateUser(LoginBean loginBean) {		//Validate	
		UserBean user = null;
		try {
		user = stmt.queryForObject("select * from users where email = ? and password = ?",
				new BeanPropertyRowMapper<>(UserBean.class),
				new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		}catch(Exception e) {
			System.out.println("No user Found");
		}
		return user;
	}

	public List<UserBean> getAllUsers() {		//List

		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public void deleteUser(int userId) {		//Delete

		stmt.update("delete from users where userid = ?", userId);
	}
	
	public UserBean getUserByUserId(int userId) {		//Detail of Update User
		UserBean user = stmt.queryForObject("select * from users where userid = ?",new BeanPropertyRowMapper<UserBean>(UserBean.class),new Object[] {userId});
		return user;
	}

	public void updateUser(UserBean user) {		//Update

		stmt.update("update users set firstname = ?,lastname = ?,email = ?,gender = ? where userid = ?",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getGender(), user.getUserId());
	}

	

}
