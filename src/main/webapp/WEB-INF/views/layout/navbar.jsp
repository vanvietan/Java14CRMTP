<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page__header mb-0">
    <div class="container page__container">
        <div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
            <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse" data-target="#navbarsExample03" type="button">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample03">
                <ul class="nav navbar-nav flex">
                    <li class="nav-item">
                        <a class="nav-link active" href="home">
                            Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Project
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">
                                Manage Project
                            </a>
                            <a class="dropdown-item" href="#">
                                Project Create Project
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            User
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="userlist">
                                User List
                            </a>
                            <a class="dropdown-item" href="signup">
                                Create User
                            </a>
                            <a class="dropdown-item" href="role-edit">
                                Role Edit
                            </a> 
                            <a class="dropdown-item" href="user-update">
                                Change Profile User
                            </a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Task</a>
                     <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Task
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="userlist">
                                Task List
                            </a>
                            <a class="dropdown-item" href="task-add">
                                Add Task
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

