<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Admin Page</title>
</head>
<body>
	<h1> Admin Page</h1>
	<h2>Role Show List</h1>
	<table class="table mt-5">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Address</th>
              <th>Role</th>
              <th>Role Change</th>
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
	              <td>${user.role.description}</td>
	              <td>
	        		<button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> Change Here <span class="caret"></span> </button>
                      <div class="dropdown-menu">
                          <a class="dropdown-item" href="<%= request.getContextPath()+ UrlConst.ROLE_EDIT_ADMIN %>?email=${user.email}">Administrator</a>
                          <a class="dropdown-item" href="<%= request.getContextPath()+ UrlConst.ROLE_EDIT_MANAGER %>?email=${user.email}">Manager</a>
                          <a class="dropdown-item" href="<%= request.getContextPath()+ UrlConst.ROLE_EDIT_USER %>?email=${user.email}">User</a>
                      </div>
	              </td>
	              <td><a class="btn btn-sm btn-danger" href="<%= request.getContextPath() + UrlConst.USER_DELETE%>?email=${user.email}">Remove</a></td>
	            </tr>
          	</c:forEach>
          </tbody>
       </table>
</body>
</html>