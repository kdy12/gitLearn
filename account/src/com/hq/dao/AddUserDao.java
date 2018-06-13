package com.hq.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hq.dto.Accounts;
import com.hq.util.JdbcUtils;

public class AddUserDao implements AddUserDaoImpl{
	
	 private JdbcUtils jdbcUtils = null;  
	    public AddUserDao() {  
	        // TODO Auto-generated constructor stub  
	        jdbcUtils = new JdbcUtils();  
	    }  
	
	@Override
	public boolean addUser(List<Object> params) {
		boolean flag = false;  
        jdbcUtils.getConnection();  
        String sql = "insert into users(userId,name, passWord, tel,createTime) values (?,?,?,?,?)";  
        try{  
            flag = jdbcUtils.updateByPreparedStatement(sql, params);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            jdbcUtils.releaseConn();  
        }  
          
        return flag;  
	}

	@Override
	public List<Map<String, Object>> findAll() {
		jdbcUtils.getConnection();  
//        String sql = "select * from users u right join accounts a on u.userid=a.userid";  
        String sql = "select * from users u , accounts a where u.userid=a.userid and a.costTime = (select max(costTime) from accounts where userid=a.userid) order by cast(balance AS int)";  
		List<Map<String, Object>> list=null;
		try {
			list = jdbcUtils.findModeResult(sql, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public List<Map<String, Object>> showUser() {
		jdbcUtils.getConnection(); 
		String sql = "select * from users ";  
		List<Map<String, Object>> list=null;
		try {
			list = jdbcUtils.findModeResult(sql, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public boolean addCostMany(List<Object> params) {
		boolean flag = false;  
        jdbcUtils.getConnection();  
        String sql = "insert into accounts(accountId,name, passWord, tel,createTime) values (?,?,?,?,?)";  
        try{  
            flag = jdbcUtils.updateByPreparedStatement(sql, params);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            jdbcUtils.releaseConn();  
        }  
          
        return flag;  
	}

	@Override
	public Map<String, Object> findAccount(String userId) {
		jdbcUtils.getConnection();
		String sql = "select * from accounts where costtime=(select  max(costtime)  from accounts where userid=?) and userId=? ";  
		List<Object> params = new ArrayList<Object>();  
		params.add(userId);  
		params.add(userId);  
		Map<String, Object> map=null;
		try {  
			map = jdbcUtils.findSimpleResult(sql, params);  
		} catch (Exception e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
		return map;
	}

	@Override
	public boolean addAccounts(List<Object> params) {
		boolean flag = false;  
        jdbcUtils.getConnection();  
        String sql = "insert into accounts(accountId,userId, costtime, costmoney,saveMoney,lastBalance,balance) values (?,?,?,?,?,?,?)";  
        try{  
            flag = jdbcUtils.updateByPreparedStatement(sql, params);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            jdbcUtils.releaseConn();  
        }  
        return flag;  
	}

	@Override
	public List<Map<String, Object>> showAccounts(List<Object> params) {
		jdbcUtils.getConnection();  
		String sql = "select * from users u , accounts a where u.userid=a.userid and a.userId=? order by costtime";  
		List<Map<String, Object>> list=null;
		try {
			list = jdbcUtils.findModeResult(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
}
