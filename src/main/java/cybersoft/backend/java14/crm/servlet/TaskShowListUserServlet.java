package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.service.UserService;
import cybersoft.backend.java14.crm.util.JspConst;
import cybersoft.backend.java14.crm.util.UrlConst;
@WebServlet(name="updateAssigneeServlet", urlPatterns = {
			UrlConst.TASK_SHOW_LIST_USER
	})
public class TaskShowListUserServlet extends HttpServlet {
	private UserService userService;
	private TaskService taskService;
	private int taskId, userId;
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserService();
		taskService = new TaskService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		taskId = Integer.parseInt(req.getParameter("taskId"));
		List<User> users = userService.getUsers();
		req.setAttribute("taskId", taskId);
		req.setAttribute("users", users);
		req.getRequestDispatcher(JspConst.TASK_SHOW_LIST_USER)
		.forward(req, resp);
	}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
//		
//		userId = Integer.parseInt(req.getParameter("userId"));
//		taskId = Integer.parseInt(req.getParameter("taskId"));
//		taskService.updateAssignee(userId , taskId);
//		resp.sendRedirect(req.getContextPath() + UrlConst.TASK_UPDATE_ASSIGNEE);
//	}
}
