package cybersoft.backend.java14.crm.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import cybersoft.backend.java14.crm.util.DbConst;
/*
 * Mục đích: Kết nối đến database tên crm_app
 * Người tạo: VietAn 
 */
public class MySQLConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DbConst.MYSQL_URL,DbConst.USERNAME,DbConst.PASSWORD);
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver MySQL Connector J.");
			e.printStackTrace();
		}
		return null;
	}
}
