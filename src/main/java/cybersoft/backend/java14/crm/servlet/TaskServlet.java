package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="taskServlet", urlPatterns= {
		UrlConst.TASK_UPDATE_ASSIGNEE,
		UrlConst.TASK_DELETE,
		UrlConst.TASK_LIST,
		UrlConst.TASK_ADD,
		UrlConst.TASK_SHOW_LIST_USER,
		UrlConst.TASK_LIST_IN_PROJECT
})
public class TaskServlet extends HttpServlet {
	private String action;
	private TaskService service;
	private Task task;
	private int userId, taskId, projectId;
	private String sd, ed;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
		task = new Task();
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
		
		/* ADD task */
		case UrlConst.TASK_ADD:
			projectId = Integer.parseInt(req.getParameter("projectId"));
			req.getRequestDispatcher(JspConst.TASK_ADD)
			.forward(req, resp);
			break;
			
		/* SHOW LIST task */
		case UrlConst.TASK_LIST:
			List<Task> tasks = service.getTasks();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher(JspConst.TASK_LIST)
				.forward(req, resp);
			break;
		
		/* SHOW LIST TASK IN PROJECT */
//		case UrlConst.TASK_LIST_IN_PROJECT:
//			List<Task> task = service.getTaskInProject();
//			req.setAttribute("tasks", task);
//			req.getRequestDispatcher(JspConst.TASK_LIST)
//				.forward(req, resp);
//			break;
		/* UPDATE ASSIGNEE */
		case UrlConst.TASK_UPDATE_ASSIGNEE:
			userId = Integer.parseInt(req.getParameter("userId"));
			taskId = Integer.parseInt(req.getParameter("taskId"));
			service.updateAssignee(userId , taskId);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
			break;
			
		/* DELETE task */
		case UrlConst.TASK_DELETE:
			taskId = Integer.parseInt(req.getParameter("taskId")) ;
			service.deleteTask(taskId);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
			break;
		
		/* SHOW LIST USER */
		case UrlConst.TASK_SHOW_LIST_USER:
			taskId = Integer.parseInt(req.getParameter("taskId"));
			List<User> users = userService.getUsers();
			req.setAttribute("taskId", taskId);
			req.setAttribute("users", users);
			req.getRequestDispatcher(JspConst.TASK_SHOW_LIST_USER)
			.forward(req, resp);
			break;
		
		default:
			break;
		}
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
			task.setAssignee(1);
			task.setStatus(3);
			task.setProject(projectId);
			service.addTask(task);
			resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
		}
	}
}