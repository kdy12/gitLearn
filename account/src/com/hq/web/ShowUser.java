package com.hq.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.dao.AddUserDao;

public class ShowUser extends HttpServlet{
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
        List<Map<String, Object>> list =  addUser.showUser();
        request.setAttribute("list", list);
//        response.sendRedirect(path + "/index.jsp");  
        request.getRequestDispatcher("/showUser.jsp").forward(request, response);
        out.flush();  
        out.close();  
    }  
}
