package com.hq.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.dao.AddUserDao;
import com.hq.dto.Accounts;

public class CostMany extends HttpServlet{
	 public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	        this.doPost(request, response);  
	    }  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	    	String path = request.getContextPath();  
	    	request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html; charset=utf-8");  
	        PrintWriter out = response.getWriter();  
	        String userIds = request.getParameter("userIds");  
	        String costMan = request.getParameter("costMan");  
	        String costMany = request.getParameter("costMany");
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String str = format.format(new Date());
	        String[] strArray = userIds.split(",");
	        int num=strArray.length;
	        DecimalFormat    df   = new DecimalFormat("######0.00");
	        String costMoney=df.format(Double.parseDouble(costMany)/num)+"";
	        for(int i=0;i<strArray.length;i++){
	        	String accountId = Long.toString(System.currentTimeMillis());
	        	List<Object> params = new ArrayList<Object>();  
	 	        params.add(accountId);  
	 	        params.add(strArray[i]);  
	 	        params.add(str); 
	 	        params.add(costMoney); 
	 	        if(strArray[i].equals(costMan)){
		 	        params.add(costMany); 
	 	        }else{
	 	        	params.add("0");
	 	        }
	 	        AddUserDao addUser=new AddUserDao();
	 	        Map<String, Object> map=addUser.findAccount(strArray[i]);
	 	        double lastBlance=0;
		 	        if(map.size()>0){
		 	        	lastBlance = Double.parseDouble((String) map.get("BALANCE"));
		 	        }
		 	    String balance="";
	 	        if(strArray[i].equals(costMan)){
	 	        	balance = df.format(lastBlance+Double.parseDouble(costMany)-Double.parseDouble(costMoney))+"";
	 	        }else{
	 	    	    balance = df.format(lastBlance-Double.parseDouble(costMoney))+"";
	 	        }
	 	        params.add(lastBlance);
	 	        params.add(balance);
	 	        boolean flag = addUser.addAccounts(params);  
	        }
	        
	        out.flush();  
	        out.close();  
	    }  
	 
	}


