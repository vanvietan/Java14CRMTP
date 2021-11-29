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

@WebServlet(name="userUpdateServlet" , urlPatterns= {
		UrlConst.USER_UPDATE,
		UrlConst.USER_UPDATE_NAME,
		UrlConst.USER_UPDATE_EMAIL,
		UrlConst.USER_UPDATE_PASSWORD,
		UrlConst.USER_UPDATE_PHONE,
		UrlConst.USER_UPDATE_ADDRESS
		
})
public class UserUpdateServlet extends HttpServlet{
	private UserService service;
	private User user;
	private String action;
	private String emailSession;
	
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
		emailSession = (String) req.getSession().getAttribute("email");
		super.service(req, resp);
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.findUser(emailSession);
		req.setAttribute("users", users);
		req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(action) {
		
		/* CHANGE NAME */
		case UrlConst.USER_UPDATE_NAME:
			String changeName = req.getParameter("name");
			service.changeName(changeName , emailSession);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			break;
		/* CHANGE EMAIL */
		case UrlConst.USER_UPDATE_EMAIL:
			String changeEmail = req.getParameter("email");
			service.changeEmail(changeEmail , emailSession);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			break;
		/* CHANGE PASSWORD */
		case UrlConst.USER_UPDATE_PASSWORD:
			String changePassword = req.getParameter("password");
			service.changePassword(changePassword , emailSession);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			break;
		/* CHANGE PHONE */
		case UrlConst.USER_UPDATE_PHONE:
			String changePhone = req.getParameter("phone");
			service.changePhone(changePhone , emailSession);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			break;
		/* CHANGE ADDRESS */
		case UrlConst.USER_UPDATE_ADDRESS:
			String changeAddress = req.getParameter("address");
			service.changeAddress(changeAddress , emailSession);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
			break;
		default:
			break;
		}
	}
}
