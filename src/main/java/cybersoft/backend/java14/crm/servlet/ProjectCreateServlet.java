package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.service.ProjectService;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="addProjectServlet", urlPatterns= {
		UrlConst.PROJECT_ADD
})
public class ProjectCreateServlet extends HttpServlet {
	private ProjectService service;
	private UserService userService;
	private Project project;
	private String sd, ed;
	private int userId;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
		project = new Project();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.PROJECT_ADD)
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("create" != null) {
			String email= (String)req.getSession().getAttribute("email");
			userId = userService.getUserIdByEmail(email);
			
			project.setName(req.getParameter("name"));
			project.setDescription(req.getParameter("description"));
			sd = req.getParameter("start_date").replace("-","");
			ed = req.getParameter("end_date").replace("-","");
			
			LocalDate start_date = LocalDate.parse(sd, DateTimeFormatter.BASIC_ISO_DATE);
			LocalDate end_date = LocalDate.parse(ed, DateTimeFormatter.BASIC_ISO_DATE);
				
			java.sql.Date sqlsd = Date.valueOf(start_date);
			java.sql.Date sqled = Date.valueOf(end_date);
				
			project.setStart_date(sqlsd);
			project.setEnd_date(sqled);
			project.setCreate_user(userId);
			
			service.addProject(project);
			resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
		}
	}
}
