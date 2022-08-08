package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public class AccountDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addAccountToUser(AccountBean accountBean) {
		
		stmt.update("insert into accounts (accname,accnumber,acctype,accbalance,userid) values(?,?,?,?,?)",accountBean.getAccname(),accountBean.getAccnumber(),accountBean.getAcctype(),accountBean.getAccbalance(),accountBean.getUserId());
	}

	public List<AccountBean> getAccountsByUserId(int userId) {
		
		List<AccountBean> accounts = stmt.query("select distinct(acctype) from accounts where userid = ?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {userId});
		return accounts;
	}

	public List<AccountBean> getaccountsByaccType(String accType,int userId) {
		List<AccountBean> accounts = stmt.query("select * from accounts where acctype = ? and userId = ?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {accType,userId});
		return accounts;
	}
}
//  Query for all accounts by userid :  select * from accounts where userid = ?