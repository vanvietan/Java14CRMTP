package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;

@WebServlet(name="taskShowListServlet" , urlPatterns={
//		UrlConst.TASK_LIST
})
public class TaskListServlet extends HttpServlet {
	private TaskService service;
	private Task task;
	private int taskId;
	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
		task = new Task();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> tasks = service.getTasks();
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher(JspConst.TASK_LIST)
			.forward(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		taskId = Integer.parseInt(req.getParameter("taskId"));
//		if (req.getParameter("Assign") != null) {
//			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_SHOW_LIST_USER);
//		} else if (req.getParameter("Delete") != null) {
//			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
//		}
//	}
}


