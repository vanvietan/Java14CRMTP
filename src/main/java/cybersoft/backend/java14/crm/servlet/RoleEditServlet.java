package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="roleEditServlet" , urlPatterns= {
		UrlConst.ROLE_EDIT_ADMIN,
		UrlConst.ROLE_EDIT_MANAGER,
		UrlConst.ROLE_EDIT_USER
})
public class RoleEditServlet extends HttpServlet{
	private UserService service;	
	private String action;
	private String email;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		action ="";
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		email = req.getParameter("email");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (action) {
		
		case UrlConst.ROLE_EDIT_ADMIN:
			service.changeToAdmin(email);
			resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_EDIT);
			break;
		case UrlConst.ROLE_EDIT_MANAGER:
			service.changeToManager(email);
			resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_EDIT);
			break;
		case UrlConst.ROLE_EDIT_USER:
			service.changeToUser(email);
			resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_EDIT);
			break;
		default:
			break;
		}
	}
}
