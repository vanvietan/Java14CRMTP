package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (name="taskServlet", urlPatterns= {
		UrlConst.TASK_DELETE,
		UrlConst.TASK_LIST
})
public class TaskServlet extends HttpServlet {
	private String action;
	private TaskService service;
	private Task task;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
		task = new Task();
		action="";

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (action) {

		/* SHOW LIST task */
		case UrlConst.TASK_LIST:
			List<Task> tasks = service.getTasks();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher(JspConst.TASK_LIST)
				.forward(req, resp);
			break;

		/* ADD task */
		/* case UrlConst.TASK_ADD: */
			
		/* DELETE task*/
		case UrlConst.TASK_DELETE:
			int taskId = Integer.parseInt(req.getParameter("id")) ;
			service.deleteTask(taskId);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_DELETE);
			break;

		default:
			break;
		}
	}


}