<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Header -->
<div id="header" class="mdk-header bg-light js-mdk-header m-0" data-fixed data-effects="waterfall">
    <div class="mdk-header__content">
        <div class="navbar navbar-expand-sm navbar-main navbar-light bg-light pr-0" id="navbar" data-primary>
            <div class="container">
                <!-- Navbar toggler -->

                <button class="navbar-toggler navbar-toggler-right d-block d-md-none" type="button" data-toggle="sidebar">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Navbar Brand -->
                <a href="dashboard.html" class="navbar-brand">
                    <img class="navbar-brand-icon" src="assets/images/logo.png" height="50" alt="Cybersoft" />
                </a>

                <span class="mr-3"></span>

                <form class="search-form d-none d-xl-flex flex mr-3" action="fixed-index.html">
                    <button class="btn" type="submit">
                        <i class="material-icons">search</i>
                    </button>
                    <input type="text" class="form-control" placeholder="Search" />
                </form>

                <ul class="nav navbar-nav ml-auto d-none d-md-flex border-left">
                    <li class="nav-item dropdown">
                        <a href="#notifications_menu" class="nav-link dropdown-toggle" data-toggle="dropdown" data-caret="false">
                            <i class="material-icons nav-icon navbar-notifications-indicator">
                                notifications_none
                            </i>
                        </a>
                        <div id="notifications_menu" class="dropdown-menu dropdown-menu-right navbar-notifications-menu">
                            <div class="dropdown-item d-flex align-items-center py-2">
                                <span class="flex navbar-notifications-menu__title m-0">
                                    Notifications
                                </span>
                                <a href="javascript:void(0)" class="text-muted">
                                    <small>Clear all</small>
                                </a>
                            </div>
                            <div class="navbar-notifications-menu__content" data-perfect-scrollbar>
                                <div class="py-2">
                                    
                                    
                                    
                                </div>
                            </div>
                            <a href="javascript:void(0);" class="dropdown-item text-center navbar-notifications-menu__footer">
                                View All
                            </a>
                        </div>
                    </li>
                </ul>

                
                 <ul class="nav navbar-nav d-none d-sm-flex border-left navbar-border navbar-height align-items-center" >
					<div class="button-list d-flex flex-wrap" >	
	                	<a href="log-in">
	                		<button type="button" class="btn btn-primary btn-rounded" style="height:40px; width:73px"> Log in </button>
	                	</a>
	                	<a href="log-out">
	                		<button type="button" class="btn btn-primary btn-rounded" style="height:40px; width:73px"> Logout </button>
	                	</a>
	            	</div>
                </ul>
                
            </div>
        </div>
    </div>
</div>

<!-- // END Header -->