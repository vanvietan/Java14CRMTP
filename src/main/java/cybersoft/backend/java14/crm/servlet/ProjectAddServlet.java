package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.service.ProjectService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet (name = "projectAddServlet", urlPatterns = {
		UrlConst.PROJECT_ADD
})
public class ProjectAddServlet extends HttpServlet{
		private ProjectService service;
		private Project project;
		private String sd,ed;
		 
		@Override
		public void init() throws ServletException {		
		super.init();
		service = new ProjectService();
		project = new Project();
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				if("create" != null) {
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
					
					service.addProject(project);
					resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
				}
		}
}
