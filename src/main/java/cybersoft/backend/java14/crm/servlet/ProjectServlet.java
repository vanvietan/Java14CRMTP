package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.service.ProjectService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;


@WebServlet (name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_LIST,
		UrlConst.PROJECT_DELETE,
		
})
public class ProjectServlet extends HttpServlet {
		private String action;
		private ProjectService service;
		private Project project;
		
		@Override
		public void init() throws ServletException {
			super.init();
			service = new ProjectService();
			project = new Project();
			action = "";
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			switch(action) {
			
			/* Show project List*/
			case UrlConst.PROJECT_LIST:
				List<Project> projects = service.getProjects();
				req.setAttribute("projects", projects);
				req.getRequestDispatcher(JspConst.PROJECT_LIST).forward(req, resp);
				break;
			
			
			/* ADD project */
			/* case UrlConst.TASK_ADD: */
			
			//DELETE project 
			
			case UrlConst.PROJECT_DELETE:
				int projectId = Integer.parseInt(req.getParameter("id"));
				service.deleteProject(projectId);
				resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DELETE);
				break;
					
					
			default:
				 break;
				
		}
		
	}	
		
		
}
