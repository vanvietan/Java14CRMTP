<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<form>
					<div class="was-validated">
						<div class="form-row">
							<label for="validationSample01">Full name</label> 
							<div class="col-12 col-md-12 mb-3 input-group input-group-merge">
								<input type="text" class="form-control" id="validationSample01"
									placeholder="First name" required="">
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
								<input type="text" class="form-control" id="validationSample01"
									placeholder="First name" required="">
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
								type="password" id="psw" class="form-control" id="exampleInputPassword1"
								placeholder="Enter your password .." required="" 
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
								<div class="invalid-feedback">Please provide your email.</div>
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
<!--		CITY STATE OPTION 					
					<div class="was-validated">
						<div class="form-row">
							<div class="col-12 col-md-12 mb-3">
								<label for="validationSample01">Full name</label> <input
									type="text" class="form-control" id="validationSample01"
									placeholder="First name" required="">
								<div class="invalid-feedback">Please provide your full name.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
						</div>
						
					</div>
										
					<div class="form-group">
						<div class="form-row">
							<div class="col-12 col-md-12 mb-3">
								<label for="validationSample03">City</label> <input type="text"
									class="form-control" id="validationSample03" placeholder="City"
									required="">
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="form-row">
							<div class="col-12 col-md-12 mb-3">
								<label for="validationSample04">State</label> <input type="text"
									class="form-control" id="validationSample04"
									placeholder="State" required="">
							</div>
						</div>
					</div> -->
					
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
										
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

<!--		SCROLL DOWN OPTION
	<div class="card card-form">
		<div class="row no-gutters">
			<div class="col-lg-4 card-body">
				<p>
					<strong class="headings-color">Select</strong>
				</p>
				<p class="text-muted">
					Customizable select box with support for searching, tagging, remote
					data sets, infinite scrolling, and many other highly used options
					powered by Select2. Please read the <a href="https://select2.org/"
						target="_blank">official plugin documentation</a> for a full list
					of options.
				</p>
			</div>
			<div class="col-lg-8 card-form__body card-body">
				<div class="form-group">
					<label for="select01">Basic</label> <select id="select01"
						data-toggle="select" class="form-control">
						<option selected="">My first option</option>
						<option>Another option</option>
						<option>Third option is here</option>
					</select>
				</div>
				<div class="form-group">
					<label for="select02">Avatars</label> <select id="select02"
						data-toggle="select" data-minimum-results-for-search="-1"
						class="form-control">
						<option
							data-avatar-src="assets/images/256_rsz_1andy-lee-642320-unsplash.jpg">
							Adelle Sherley</option>
						<option data-avatar-src="assets/images/avatar/demi.png">
							Adrian Demian</option>
						<option data-avatar-src="assets/images/avatar/green.svg">
							Green Doe</option>
					</select>
				</div>
				<div class="form-group">
					<label for="select03">Multiple</label> <select id="select03"
						data-toggle="select" multiple class="form-control">
						<option selected="">CSS</option>
						<option selected="">HTML</option>
						<option>JavaScript</option>
						<option>Bootstrap</option>
					</select>
				</div>
				<div class="form-group">
					<label for="select04">Large</label> <select id="select04"
						data-toggle="select" multiple class="form-control form-control-lg">
						<option>CSS</option>
						<option>HTML</option>
						<option selected="">JavaScript</option>
						<option>Bootstrap</option>
					</select>
				</div>
				<label for="select05">Small</label> <select id="select05"
					data-toggle="select" class="form-control form-control-sm">
					<option>My first option</option>
					<option>Another option</option>
					<option>Third option is here</option>
				</select>
			</div>
		</div>
	</div> -->
</div>

</body>
</html>