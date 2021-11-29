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
	
	<div class="card card-form">
                    <div class="row no-gutters">
                        <div class="col-lg-8 card-form__body border-left">
                            <div class="table-responsive border-bottom" data-toggle="lists" data-lists-values='["js-lists-values-employee-name"]'>

                                <div class="search-form search-form--light m-3">
                                    <input type="text" class="form-control search" placeholder="Search">
                                    <button class="btn" type="button"><i class="material-icons">search</i></button>
                                </div>

                                <table class="table mb-12 thead-border-top-0">
                                    <thead>
                                        <tr>
                                              <th>ID</th>
								              <th>Name</th>
								              <th>Email</th>
								              <th>Phone</th>
								              <th>Address</th>
								              <th>#</th>
                                        </tr>
                                    </thead>
                                    <tbody class="list" id="staff02">
										<c:forEach var="user" class="js-lists-values-employee-name" items="${users}">
							          		<tr>
								              <td>${user.id}</td>
								              <td>${user.name}</td>
								              <td>${user.email}</td>
								              <td>${user.phone}</td>
								              <td>${user.address}</td>
								              <td><a class="btn btn-sm btn-danger" href="<%= request.getContextPath() + UrlConst.USER_DELETE%>?email=${user.email}">Remove</a></td>
								            </tr>
							          	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
</body>
</html>