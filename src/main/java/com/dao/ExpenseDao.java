package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.ExpenseBean;

@Repository
public class ExpenseDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addExpense(ExpenseBean expBean, int balance) {
		stmt.update("insert into expenses (expname,explocation,expcat,expsubcat,accid,expamount,date,time,userid) values(?,?,?,?,?,?,?,?,?)",expBean.getExpName(),expBean.getExpLocation(),expBean.getExpCat(),expBean.getExpSubCat(),expBean.getAccId(),expBean.getExpAmount(),expBean.getDate(),expBean.getTime(),expBean.getUserId());
		stmt.update("update accounts set accbalance = ? where acctype = ? and userid = ?",balance,expBean.getAccType(),expBean.getUserId());
	}

	public AccountBean getBalance(int userId, int accId) {
		AccountBean account =  stmt.queryForObject("select * from accounts where userid = ? and accid = ?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {userId,accId});	
		return account;
	}

	public List<ExpenseBean> getExpensesByUserId(Integer userId) {
		List<ExpenseBean> expenses = stmt.query("select * from expenses e join category c on e.expcat = c.catid join subcategory s on s.subcatid = e.expsubcat join accounts a on e.accid = a.accid where e.userid = ?",new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {userId});
		return expenses;
	}
}
