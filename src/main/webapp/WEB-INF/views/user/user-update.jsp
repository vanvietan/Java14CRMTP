<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<%@ page import="cybersoft.backend.java14.crm.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update</title>
</head>
<body>	
	<h2> Login to change your profile !!!</h2>
	<br>
	<h2>Welcome <%=session.getAttribute("email") %></h2>
	<div class="col-lg-8 card-form__body card-body">
        <table class="table mt-5">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Password</th>
              <th>Phone</th>
              <th>Address</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="user" items="${users}">
          		<tr>
	              <td>${user.id}</td>
	              <td>${user.name}</td>
	              <td>${user.email}</td>
	              <td>${user.password}</td>
	              <td>${user.phone}</td>
	              <td>${user.address}</td>
	            </tr>
          	</c:forEach>
          </tbody>
       </table>
       	<div class="container-fluid">
       		<form action="<%= request.getContextPath()+ UrlConst.USER_UPDATE_NAME %>" method="post">
       			<input type="text" name="name">
       			<button type="submit">Change Name</button>
       		</form>
       		<br>
       		<form action="<%= request.getContextPath()+ UrlConst.USER_UPDATE_EMAIL %>" method="post">
       			<input type="text" name="email">
       			<button type="submit">Change Email</button>
       		</form>
       		<br>
       		<form action="<%= request.getContextPath()+ UrlConst.USER_UPDATE_PASSWORD %>" method="post">
       			<input type="text" name="password">
       			<button type="submit">Change Password</button>
       		</form>
       		<br>
       		<form action="<%= request.getContextPath()+ UrlConst.USER_UPDATE_PHONE %>" method="post">
       			<input type="text" name="phone">
       			<button type="submit">Change Phone</button>
       		</form>
       		<br>
       		<form action="<%= request.getContextPath()+ UrlConst.USER_UPDATE_ADDRESS %>" method="post">
       			<input type="text" name="address">
       			<button type="submit">Change Address</button>
       		</form>
       		
       	</div>
     </div>
</body>
</html>