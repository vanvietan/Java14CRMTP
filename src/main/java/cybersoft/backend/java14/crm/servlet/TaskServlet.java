package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="taskServlet", urlPatterns= {
		UrlConst.TASK_UPDATE_ASSIGNEE,
		UrlConst.TASK_DELETE,
		UrlConst.TASK_LIST
})
public class TaskServlet extends HttpServlet {
	private String action;
	private TaskService service;
	private Task task;
	private int userId, taskId;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
		task = new Task();
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

		/* UPDATE ASSIGNEE */
		case UrlConst.TASK_UPDATE_ASSIGNEE:
			userId = Integer.parseInt(req.getParameter("userId"));
			taskId = Integer.parseInt(req.getParameter("taskId"));
			service.updateAssignee(userId , taskId);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
			break;
			
		/* DELETE task*/
		case UrlConst.TASK_DELETE:
			taskId = Integer.parseInt(req.getParameter("taskId")) ;
			service.deleteTask(taskId);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
			break;

		default:
			break;
		}
	}
}