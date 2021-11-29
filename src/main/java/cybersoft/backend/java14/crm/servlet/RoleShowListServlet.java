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

@WebServlet(name="roleShowListServlet" , urlPatterns={
		UrlConst.ROLE_EDIT
})
public class RoleShowListServlet extends HttpServlet{
	private UserService service;

	private User user;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		user = new User();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getUsers();
		req.setAttribute("users", users);
		req.getRequestDispatcher(JspConst.ROLE_EDIT).forward(req, resp);
	}
}
