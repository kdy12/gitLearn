package com.hq.dao;

import java.util.List;
import java.util.Map;

import com.hq.dto.Accounts;

public interface AddUserDaoImpl {
	//����û�
	 public boolean addUser(List<Object> params); 
	 //��ѯ�˵�
	 public List<Map<String, Object>>  findAll(); 
	 //��ѯ�û�
	 public List<Map<String, Object>>  showUser(); 
	//��������˵�
	public boolean addCostMany(List<Object> params); 
	//��ѯ�����˵� 
	public Map<String, Object> findAccount(String userId);
	//����˵�
	public boolean addAccounts(List<Object> params); 
	//�����û�id��ѯ�����˵�
	public List<Map<String, Object>> showAccounts(List<Object> params); 
}
