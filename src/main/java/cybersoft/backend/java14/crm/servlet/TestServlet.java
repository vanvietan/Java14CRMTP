package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="signupServlet", urlPatterns= {
		UrlConst.TEST
		})
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.SIGNUP)
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("submit" != null) {
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_ADD);
		}
	}
}