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
		UrlConst.USER_LIST,
		UrlConst.USER_ADD,
		UrlConst.USER_DELETE,
		
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
		case UrlConst.USER_LIST:
			List<User> users = service.getUsers();
			req.setAttribute("users", users);
			req.getRequestDispatcher(JspConst.USER_LIST)
				.forward(req, resp);
			break;

		/* DELETE USER*/
		case UrlConst.USER_DELETE:
			String removeEmail = req.getParameter("email") ;
			service.removeUser(removeEmail);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_LIST);
			break;
			
		
			
			
		/* LOGIN */
		case UrlConst.AUTH_LOGIN:
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			boolean isSuccess = service.loginUser(email, password);
			if(isSuccess == true) {
				resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			}else {
				resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			}
			
		case UrlConst.USER_ADD:
			User user = new User();
			user.setAddress(req.getParameter("address"));
			user.setName(req.getParameter("name"));
			user.setPassword(req.getParameter("password"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			service.addUser(user);
			resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
			break;

		default:
			break;
		}
	}
	
	
}
