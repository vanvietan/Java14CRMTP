package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="addTaskServlet", urlPatterns= {
		UrlConst.TASK_ADD
})
public class TaskCreateServlet extends HttpServlet {
	private TaskService service;
	private Task task;
	private String sd, ed;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
		task = new Task();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.TASK_ADD)
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("create" != null) {
			task.setName(req.getParameter("name"));
			task.setDescription(req.getParameter("description"));
			sd = req.getParameter("start_date").replace("-","");
			ed = req.getParameter("end_date").replace("-","");
			
			LocalDate start_date = LocalDate.parse(sd, DateTimeFormatter.BASIC_ISO_DATE);
			LocalDate end_date = LocalDate.parse(ed, DateTimeFormatter.BASIC_ISO_DATE);
				
			java.sql.Date sqlsd = Date.valueOf(start_date);
			java.sql.Date sqled = Date.valueOf(end_date);
				
			task.setStart_date(sqlsd);
			task.setEnd_date(sqled);
 
			service.addTask(task);
			resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
		}
	}
}
