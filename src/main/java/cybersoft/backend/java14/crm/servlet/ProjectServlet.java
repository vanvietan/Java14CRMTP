package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.service.ProjectService;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="taskServlet", urlPatterns= {
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_LIST,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT
})
public class ProjectServlet extends HttpServlet {
	private String action;
	private ProjectService service;
	private Project project;;
	private int userId, projectId;
	private String sd, ed, email;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
		project = new Project();
		userService = new UserService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (action) {
		/* SHOW PROJECT */
		case UrlConst.PROJECT:
			req.getRequestDispatcher(JspConst.PROJECT)
			.forward(req, resp);
			break;
			
		/* ADD task */
		case UrlConst.PROJECT_ADD:
			req.getRequestDispatcher(JspConst.PROJECT_ADD)
			.forward(req, resp);
			break;
			
		/* SHOW LIST task */
		case UrlConst.PROJECT_LIST:
			List<Project> projects = service.getProjects();
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspConst.PROJECT_LIST)
				.forward(req, resp);
			break;

		/* DELETE task */
		case UrlConst.PROJECT_DELETE:
			projectId = Integer.parseInt(req.getParameter("projectId")) ;
			service.deleteProject(projectId);
			resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_LIST);
			break;

		
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("create" != null) {
			email = (String) req.getSession().getAttribute("email");
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
			project.setStatus(3);
			service.addProject(project);
			resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_LIST);
		}
	}
}