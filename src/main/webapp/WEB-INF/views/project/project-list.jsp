<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project List</title>
</head>
<body>
<h1 style="text-align:center;"> Create New Project!</h1>
		<table class="table mt-5">
	          <thead>
	            <tr>
	              <th style="width: 50px;">ID</th>
	              <th style="width: 100px;">Name</th>
	              <th style="width: 870px;">Description</th>
	              <th>Start Date</th>
	              <th>End Date</th>
	              <th>Created By User</th>
	              <th>Status</th>
	              <th>Create Task</th>
	              <th>Delete Project</th>
	            </tr>
	          </thead>
	          <tbody>
	          	<c:forEach var="project" items="${projects}">
	          		<tr>
		              <td>${project.id}</td>
		              <td><a href="<%=request.getContextPath()+UrlConst.PROJECT%>">${project.name}</a></td>
		              <td>${project.description}</td>
		              <td>${project.start_date}</td>
		              <td>${project.end_date}</td>
		              <td>${project.create_user}</td>
		              <td>${project.status}</td>
		              <td><a class="btn btn-sm btn-danger" href="<%=request.getContextPath()+UrlConst.TASK_ADD%>?projectId=${project.id}">Add Task</a></td>
		              <td><a class="btn btn-sm btn-danger" href="<%=request.getContextPath()+UrlConst.PROJECT_DELETE%>?projectId=${project.id}">Delete Project</a></td>
		            </tr>
	          	</c:forEach>
	          </tbody>
		</table>
</body>
</html> 