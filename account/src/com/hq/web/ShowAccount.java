package com.hq.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.dao.AddUserDao;

public class ShowAccount extends HttpServlet{
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
	        AddUserDao addUser=new AddUserDao();
	        String userId = request.getParameter("userId");  
	        List<Object> params = new ArrayList<Object>();  
	        params.add(userId);  
	        List<Map<String, Object>> list =  addUser.showAccounts(params);
	        request.setAttribute("list", list);
	        request.getRequestDispatcher("/showAccount.jsp").forward(request, response);
	        out.flush();  
	        out.close();  
	    }  
}
