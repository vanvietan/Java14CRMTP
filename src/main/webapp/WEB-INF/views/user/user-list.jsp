<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<h1>User List</h1>
	<table class="table mt-5">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Address</th>
              <th>Role</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="user" items="${users}" >
          		<tr>
	              <td>${user.id}</td>
	              <td>${user.name}</td>
	              <td>${user.email}</td>
	              <td>${user.phone}</td>
	              <td>${user.address}</td>
	              <td>${role.name}</td>
	              <td><a class="btn btn-sm btn-danger" href="<%= request.getContextPath() + UrlConst.USER_DELETE%>?email=${user.email}">Remove</a></td>
	            </tr>
          	</c:forEach>
          </tbody>
       </table>
</body>
</html>