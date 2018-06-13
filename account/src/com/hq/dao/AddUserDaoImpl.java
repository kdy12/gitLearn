package com.hq.dao;

import java.util.List;
import java.util.Map;

import com.hq.dto.Accounts;

public interface AddUserDaoImpl {
	//添加用户
	 public boolean addUser(List<Object> params); 
	 //查询账单
	 public List<Map<String, Object>>  findAll(); 
	 //查询用户
	 public List<Map<String, Object>>  showUser(); 
	//添加消费账单
	public boolean addCostMany(List<Object> params); 
	//查询单条账单 
	public Map<String, Object> findAccount(String userId);
	//添加账单
	public boolean addAccounts(List<Object> params); 
	//根据用户id查询个人账单
	public List<Map<String, Object>> showAccounts(List<Object> params); 
}
