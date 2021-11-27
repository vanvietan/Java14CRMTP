<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.backend.java14.crm.util.UrlConst" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
h1 {text-align: center;}
p1 {text-align: left;}

/* TERM & CONDITION POPUP */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.close {
	position: absolute;
	top: 0;
	right: 14px;
	font-size: 20px;
	cursor: pointer;
}

.bg-modal {
	width: 100%;
	heigth: 100%;
	background-color: rgba(0, 0, 0, 0.7);
	position: absolute;
	top: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	display: none;
}

.modal-content {
	background-color: white;
	border-radius: 4px;
	text-align: center;
	padding: 20px;
	position: relative;
}
/* PASSWORD POPUP */

#message {
  display:none;
  background: white;
  color: #000;
  position: relative;
  padding: 20px;
  margin-top: 10px;
}

#message p {
  padding: 10px 35px;
  font-size: 18px;
}


.valid {
  color: green;
}

.valid:before {
  position: relative;
  left: -35px;
  content: "✔";
}


.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "✖";
}
</style>
</head>
<body>
<br>

<h1 class="m-0">Sign up!</h1>

<p style="text-align:center;" class="mb-3">Create an account now!</p>

<div class="container page__container ">
	<!-- Page Content -->
	<div class="card card-form ">
		<div class="row no-gutters ">
			
			<div class="col-lg-12 card-form__body card-body ">
				<form action="<%= request.getContextPath()+UrlConst.USER_ADD %>" method="">
					<div class="was-validated">
						<div class="form-row">
							<label for="validationSample01">Full name</label> 
							<div class="col-12 col-md-12 mb-3 input-group input-group-merge">
								<input type="text" class="form-control" name="name"
									placeholder="Enter your full name" required="" >
								<div class="input-group-prepend">
			                        <div class="input-group-text">
			                            <span class="far fa-user"></span>
			                        </div>
			                    </div>	
								<div class="invalid-feedback">Please provide your full name.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
						</div>
					</div>
					
					<div class="was-validated">
						<div class="form-row">
							<label for="exampleInputEmail1">Your email:</label>
							<div class="col-12 col-md-12 mb-3 input-group input-group-merge">
								<input type="email" class="form-control" name="email"
									placeholder="Enter your email" required="" >
								<div class="input-group-prepend">
			                        <div class="input-group-text">
			                            <span class="far fa-envelope"></span>
			                        </div>
			                    </div>
								<div class="invalid-feedback">Please provide your email.</div>
								<div class="valid-feedback">Looks good!</div>
								<div class="input-group-prepend">
							</div>
						</div>
					</div>

					<div class="was-validated">
						<div class="form-group">
							<label for="exampleInputPassword1">Your password:</label> <input
								type="password" id="psw" class="form-control" name="password"
								placeholder="Enter your password .." required="" 
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
								<div class="invalid-feedback">Please provide your password.</div>
								<div class="valid-feedback">Looks good!</div>
						</div>
					</div>
					
					<div id="message">
					  <h1>Password must contain the following:</h1><br>
					  <p1 id="letter" class="invalid">A <b>lowercase</b> letter</p1><br><br>
					  <p1 id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p1><br><br>
					  <p1 id="number" class="invalid">A <b>number</b></p1><br><br>
					  <p1 id="length" class="invalid">Minimum <b>8 characters</b></p1><br><br>
					</div>
									
					<script>
					var myInput = document.getElementById("psw");
					var letter = document.getElementById("letter");
					var capital = document.getElementById("capital");
					var number = document.getElementById("number");
					var length = document.getElementById("length");
					
					// When the user clicks on the password field, show the message box
					myInput.onfocus = function() {
					  document.getElementById("message").style.display = "block";
					}
					
					// When the user clicks outside of the password field, hide the message box
					myInput.onblur = function() {
					  document.getElementById("message").style.display = "none";
					}
					
					// When the user starts to type something inside the password field
					myInput.onkeyup = function() {
					  // Validate lowercase letters
					  var lowerCaseLetters = /[a-z]/g;
					  if(myInput.value.match(lowerCaseLetters)) {  
					    letter.classList.remove("invalid");
					    letter.classList.add("valid");
					  } else {
					    letter.classList.remove("valid");
					    letter.classList.add("invalid");
					  }
					  
					  // Validate capital letters
					  var upperCaseLetters = /[A-Z]/g;
					  if(myInput.value.match(upperCaseLetters)) {  
					    capital.classList.remove("invalid");
					    capital.classList.add("valid");
					  } else {
					    capital.classList.remove("valid");
					    capital.classList.add("invalid");
					  }
					
					  // Validate numbers
					  var numbers = /[0-9]/g;
					  if(myInput.value.match(numbers)) {  
					    number.classList.remove("invalid");
					    number.classList.add("valid");
					  } else {
					    number.classList.remove("valid");
					    number.classList.add("invalid");
					  }
					  
					  // Validate length
					  if(myInput.value.length >= 8) {
					    length.classList.remove("invalid");
					    length.classList.add("valid");
					  } else {
					    length.classList.remove("valid");
					    length.classList.add("invalid");
					  }
					}
					</script>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Your phone number:</label>
						<input type="number" class="form-control" id="exampleInputPassword1" 
							name="phone" placeholder="Enter your phone number ..">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Your address:</label>
						<input type="text" class="form-control" id="exampleInputEmail1"
						name="address" placeholder="Enter your address ..">
					</div>

					<div class="popup" id="popup"><p style="color:blue;">Terms and conditions</p></div><br><br>
					
					<div class="bg-modal" id="bg-modal">
						<div class="modal-content" id="modal-content">
							<div class="close">x</div>
							<h3><strong class="headings-color">TERM AND CONDITION</strong></h3>
							<p3>Attending class regularly<br>
							<p3>Do your homework<br>
							<p3>Get a job after finishing the course!!!
						</div>
					</div>	
					
					<script>
						document.getElementById("popup").addEventListener("click", function() {
							document.querySelector(".bg-modal").style.display = "flex";
						}); 
						
						document.querySelector(".close").addEventListener("click", function() {
							document.querySelector(".bg-modal").style.display = "none";
						});
					</script>
					
					<div class="form-group">
						<div class="custom-control custom-checkbox">
							<input class="custom-control-input" type="checkbox" value=""
								id="invalidCheck01" required="" > <label
								class="custom-control-label" for="invalidCheck01"> Agree
								to terms and conditions </label>
						</div>
					</div>
				
				</form>			
				
				<button type="submit" value="submit" class="btn btn-primary">Submit</button>		
				
			</div>
		</div>
	</div>
</div>

</body>
</html>