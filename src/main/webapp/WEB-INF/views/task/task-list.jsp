<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
</head>
<body>
<h1 style="text-align:center;"> Create New Task!</h1>
		<table class="table mt-5">
	          <thead>
	            <tr>
	              <th style="width: 50px;">ID</th>
	              <th style="width: 100px;">Name</th>
	              <th style="width: 870px;">Description</th>
	              <th>Start Date</th>
	              <th>End Date</th>
	              <th>Project</th>
	              <th>Assignee Id</th>
	              <th>Status</th>
	              <th>Assign</th>
	              <th>Delete</th>
	            </tr>
	          </thead>
	          <tbody>
	          	<c:forEach var="task" items="${tasks}">
	          		<tr>
		              <td>${task.id}</td>
		              <td>${task.name}</td>
		              <td>${task.description}</td>
		              <td>${task.start_date}</td>
		              <td>${task.end_date}</td>
		              <td>${task.project}</td>
		              <td>${task.assignee}</td>
		              <td>${task.status}</td>
		              <!-- <td><input value="Assign" class="btn btn-sm btn-primary" type="submit"></td>
		              <td><input value="Delete" class="btn btn-sm btn-danger" type="submit"></td> -->
		              <td><a class="btn btn-sm btn-primary" href="<%=request.getContextPath()+UrlConst.TASK_SHOW_LIST_USER%>?taskId=${task.id}">Assign An Employee</a></td>
		              <td><a class="btn btn-sm btn-danger" href="<%=request.getContextPath()+UrlConst.TASK_DELETE%>?taskId=${task.id}">Delete Task</a></td>
		            </tr>
	          	</c:forEach>
	          </tbody>
		</table>
</body>
</html> 