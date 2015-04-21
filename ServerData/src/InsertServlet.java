import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import mysql.MysqlConn;


public class InsertServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----post---insert");
		//http://localhost:8080/ServerData/servlet/InsertServlet?Info={%22Sname%22:%22jack%22,%22Number%22:%221124%22,%22DataBase%22:%2289%22,%22Complier%22:%2290%22,%22System%22:%2291%22,%22Net%22:%2293%22}
		request.setCharacterEncoding("UTF-8"); 
		String info = request.getParameter("Info");
		System.out.println(info);
		JSONObject object = new JSONObject().fromObject(info);
		String sname = object.getString("Sname");
		String number = object.getString("Number");
		String db = object.getString("DataBase");
		String complier = object.getString("Complier");
		String system = object.getString("System");
		String net = object.getString("Net");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String list = new String();
		
		Connection conn = MysqlConn.getConnection();
		if(conn != null)
		{
			try{ 
				String sqlString = "insert into stu values(\"" + sname +"\",\"" + number + "\",\"" + 
						db + "\",\"" + system + "\",\"" + complier + "\",\"" + net + "\")";
				Statement stmt = conn.createStatement(); 
				System.out.println(sqlString);
				int a = stmt.executeUpdate(sqlString);  
				list = "success";
				out.print(list);
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
		 
		System.out.println(list);
		/**
		 * 查询业务，数据库查询成绩单，使用学号和姓名，如果有该人则返回其成绩，如若没有则返回无此人
		 * 使用response 写回调用方查询结果
		 */ 
	}

}
