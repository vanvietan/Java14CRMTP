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
	<h1>Task List</h1>
	<table class="table mt-5">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Description</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>Project</th>
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
	              <td>${project.name}</td>
	            </tr>
          	</c:forEach>
          </tbody>
       </table>
</body>
</html> 