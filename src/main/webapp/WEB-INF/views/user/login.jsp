<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "cybersoft.backend.java14.crm.util.UrlConst" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<body class="layout-login">
    <div class="layout-login__overlay"></div>
    <div class="layout-login__form bg-white" data-perfect-scrollbar>
        <div class="d-flex justify-content-center mt-2 mb-5 navbar-light">
            <a href="index.html" class="navbar-brand" style="min-width: 0">
                <img class="navbar-brand-icon" src="assets/images/logo.png" width="250" alt="Cybersoft">
            </a>
        </div>

        <h4 class="m-0">Log in!</h4>
        <p class="mb-5">You wanna get the job done? LOG IN NOW!</p>

        <form action="<%= request.getContextPath()+UrlConst.AUTH_LOGIN %>" method="post">
            
            <div class="form-group">
                <label class="text-label" for="email_2">Email Address:</label>
                <div class="input-group input-group-merge">
                    <input name="email" type="email" required="" class="form-control form-control-prepended" placeholder="john@doe.com">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-envelope"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="password_2">Password:</label>
                <div class="input-group input-group-merge">
                    <input name="password" type="password" required="" class="form-control form-control-prepended" placeholder="Enter your password">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-key"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group mb-5">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" checked="" class="custom-control-input" id="terms" />
                    <label class="custom-control-label" for="terms">I accept <a href="#">Terms and Conditions</a></label>
                </div>
            </div>
            <div class="form-group text-center">
                <button class="btn btn-primary mb-2" type="submit">Login</button><br>
                <a class="text-body text-underline" href="signup">Don't have an account? Sign up</a>
            </div>
        </form>
    </div>

</body>

</html>