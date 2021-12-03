package cybersoft.backend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.backend.java14.crm.service.TaskService;
import cybersoft.backend.java14.crm.util.UrlConst;
@WebServlet (name="deleteTaskServlet", urlPatterns= {
//		UrlConst.TASK_DELETE
})
public class TaskDeleteServlet extends HttpServlet {
	private TaskService service;
	private int taskId;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		taskId = Integer.parseInt(req.getParameter("taskId")) ;
		service.deleteTask(taskId);
		resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
	}
}
