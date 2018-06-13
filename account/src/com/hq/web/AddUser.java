package com.hq.web;



import java.io.IOException;  
import java.io.PrintWriter;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.Date;
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.hq.dao.AddUserDao;
  

  
public class AddUser  extends HttpServlet {  
	
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
        String userId = Long.toString(System.currentTimeMillis());
        String name = request.getParameter("name");  
        String passWord = request.getParameter("passWord");  
        String tel = request.getParameter("tel");  
        List<Object> params = new ArrayList<Object>();  
        params.add(userId);  
        params.add(name);  
        params.add(passWord);  
        params.add(tel); 
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(new Date());
        params.add(str);  
        AddUserDao addUser=new AddUserDao();
        boolean flag = addUser.addUser(params);  
        if(flag){  
            out.println("×¢²á³É¹¦");  
            response.sendRedirect(path + "/index.jsp");  
        }else{  
            out.println("×¢²áÊ§°Ü");  
        }  
        out.flush();  
        out.close();  
    }  
 
}
