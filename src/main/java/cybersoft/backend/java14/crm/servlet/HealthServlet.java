package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.datasource.MySQLConnection;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="healthServlet",urlPatterns= {
		UrlConst.HEALTH,
		UrlConst.DB_CHECK
})
public class HealthServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		switch(path) {
		case UrlConst.HEALTH:
			
			break;
		case UrlConst.DB_CHECK:
			Connection testConnection = MySQLConnection.getConnection();
			if(testConnection != null) {
				resp.getWriter().append("Kết nối đến cơ sở dữ liệu thành công");
			}else {
				resp.getWriter().append("Kết nối đến cơ sở dữ liệu thất bại");
			}
			break;
		default:
			break;
		}
	}
}
