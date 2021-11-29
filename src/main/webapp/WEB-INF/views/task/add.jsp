<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
h4 {text-align: center;}
</style>
</head>
<body>
<br>

<h4> Create New Task!</h4>

<p style="text-align:center;" class="mb-3">Work work work!</p>
<form method="post" >
<div class="container page__container ">
	<!-- Page Content -->
	<div class="card card-form ">
		<div class="row no-gutters ">
			
			<div class="col-lg-12 card-form__body card-body ">
				
					<div class="was-validated">
						<div class="form-row">
							<label for="validationSample01">Task name</label> 
							<div class="col-12 col-md-12 mb-3 input-group input-group-merge">
								<input type="text" class="form-control" name="name"
									placeholder="Enter task name" required="" >
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Description:</label>
						<input type="text" class="form-control" id="exampleInputPassword1" 
							name="description" >
					</div>
					
					<div class="row mb-12 align-items-center" >
					<label for="datepicker"></label>
						<div class="col-lg-6">
	                        <div class="card">
	                            <div class="card-header card-header-large bg-white">
	                                <h4 class="card-header__title">Task Start Date</h4>
	                            </div>
	                            <div class="card-body">
	                                <label class="text-label" for="flatpickrSample01">Date</label>
	                                <input id="datepicker" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today" name="start_date">
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="col-lg-6">
	                        <div class="card">
	                            <div class="card-header card-header-large bg-white">
	                                <h4 class="card-header__title">Task End Date</h4>
	                            </div>
	                            <div class="card-body">
	                                <label class="text-label" for="flatpickrSample01">Date</label>
	                                <input id="datepicker" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today" name="end_date">
	                            </div>
	                        </div>
	                    </div>
                    </div>
					
				
				
				<button type="submit" value="create" class="btn btn-primary">Create</button>	
				
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>