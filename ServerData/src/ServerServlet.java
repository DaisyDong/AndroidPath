import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import mysql.MysqlConn;


public class ServerServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		this.doPost(request, response); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----post");
		request.setCharacterEncoding("UTF-8");
		String queryName=request.getParameter("queryName");
		String queryNumber = request.getParameter("queryNumber");
		ResultSet set = null;
		StringBuilder list = new StringBuilder();
		 
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn = MysqlConn.getConnection();
		if(conn != null)
		{
			try{
//				conn = MySQLJdbc.getConnection();
//				final String sql = "select * from reportCard;";
//				stmt = conn.prepareStatement(sql); 
//				rs = stmt.executeQuery();
				Statement stmt = conn.createStatement();
				set = stmt.executeQuery("select * from stu where name=\'"+queryName+"\'and number=\'"+queryNumber+"\'");
				while (set.next()) {  
					list.append(set.getString("db"));
					list.append(',');
					list.append(set.getString("system"));
					list.append(',');
					list.append(set.getString("complier"));
					list.append(','); 
					list.append(set.getString("net"));
					}   
				System.out.println(list.toString().split(","));
				out.print(list.toString());
				System.out.println("连接成功！");
				}
				catch(SQLException e){
					e.printStackTrace();
				}
		}
		else
		{
			System.out.println("连接失败！");
		} 
		
		System.out.println(queryName);
		System.out.println(queryNumber);
		/**
		 * 查询业务，数据库查询成绩单，使用学号和姓名，如果有该人则返回其成绩，如若没有则返回无此人
		 * 使用response 写回调用方查询结果
		 */ 
	}
 
}
