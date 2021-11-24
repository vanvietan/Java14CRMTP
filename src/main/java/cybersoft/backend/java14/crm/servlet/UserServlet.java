package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="userServlet", urlPatterns= {
		UrlConst.USER_DASHBOARD,
		UrlConst.USER_ADD,
		UrlConst.USER_DELETE,
		UrlConst.USER_UPDATE
})
public class UserServlet extends HttpServlet{
	private UserService service;
	private String action;
	private User user;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		user = new User();
		action="";
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch (action) {
		
		/* SHOW LIST USER */
		case UrlConst.USER_DASHBOARD:
			List<User> users = service.getUsers();
			req.setAttribute("users", users);
			req.getRequestDispatcher(JspConst.USER_DASHBOARD)
				.forward(req, resp);
			break;
			
		/* ADD USER */	
		case UrlConst.USER_ADD:
			
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setPhone(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
				
			service.addUser(user);
			resp.sendRedirect(req.getContextPath() + UrlConst.SIGNUP);
			break;	
		
		/* DELETE USER*/
		case UrlConst.USER_DELETE:
			int deleteUser = Integer.parseInt(req.getParameter("id")) ;
			service.deleteUser(deleteUser);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_DELETE);
			break;
			
		default:
			break;
		}
	}
	
	
}
