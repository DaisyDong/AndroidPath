package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class MysqlConn {
	private static final String  drivers = "com.mysql.jdbc.Driver";
	private static final String username ="root";
	private static final String password ="ymzmdx";
	private static final String url = "jdbc:mysql://localhost:3306/SCT"; //�������ݿ�
	
	public static Connection getConnection(){
		 try
		   {
			 Class.forName(drivers);  
			 return DriverManager.getConnection(url, username, password);
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace(); 
			   return null;
		   }
		}
//		
//		public static void main(String[] args)
//		{ 
//			Connection conn = MysqlConn.getConnection();
//			if(conn != null)
//			{
//				try{
//					Statement stmt = conn.createStatement();
//					stmt.executeQuery("select * from stu where ")
//					System.out.println("���ӳɹ���");
//					}
//					catch(SQLException e){
//						e.printStackTrace();
//					}
//			}
//			else
//			{
//				System.out.println("����ʧ�ܣ�");
//			}
//		}
} 
