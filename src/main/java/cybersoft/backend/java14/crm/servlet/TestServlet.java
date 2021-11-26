package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.util.JspConst;

@WebServlet(name="testServlet" , urlPatterns= {
		"/test"
})
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req, resp);
	}
}
