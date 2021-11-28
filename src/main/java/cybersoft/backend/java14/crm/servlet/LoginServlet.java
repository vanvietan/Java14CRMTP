package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="loginServlet" , urlPatterns= {
		
		UrlConst.AUTH_LOGIN
		})
public class LoginServlet extends HttpServlet{
	private UserService service;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean isSuccess = service.loginUser(email, password);
		if(isSuccess) {
			req.getSession().setAttribute("isAuthenticated", true);
			req.getSession().setAttribute("email", email);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_UPDATE);
		}else {
			resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
		}
	}
}
