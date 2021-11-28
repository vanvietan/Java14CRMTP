package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="userManagamentServlet" , urlPatterns= {
		UrlConst.USER_MANAGEMENT,
		UrlConst.USER_MANAGEMENT_ROLE_EDIT
})
public class UserManagementServlet extends HttpServlet{
	private UserService service;
	private String action;
	private User user;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		action="";
		user = new User();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath(); 
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(action) {
		case UrlConst.USER_MANAGEMENT_ROLE_EDIT:
			break;
		
		default: 
			break;
		}
	}
}
