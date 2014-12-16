<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="templates/header.jsp"/>

<link rel="stylesheet" href="<c:url value="/resources/css/signup.css" />"/>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <%--<div class="navbar-header">--%>
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
                    <%--aria-expanded="false" aria-controls="navbar">--%>
                <%--<span class="sr-only">Toggle navigation</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<a class="navbar-brand" href="#">Webtester</a>--%>
        <%--</div>--%>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h2>Create Account</h2>

        <form:form method="post" action="${context}/signup" commandName="signupForm" class="form-horizontal" role="form">
        <%--<form role="form" class="form-horizontal">--%>
            <div class="form-group required">
                <div class="alert alert-danger hidden" role="alert"><form:errors path="*" cssClass="registersErrors"/></div>
                <label class="col-sm-2 control-label" for="Login">Enter
                    Login<sup>*</sup>
                </label>

                <div class="col-sm-10">
                    <form:input path="login" class="form-control" id="login" placeholder="Login" required="true" autofocus="true" />
                    <%--<input class="form-control" id="login" placeholder="Login" type="text">--%>
                </div>
            </div>

            <div class="form-group required">
                <label for="inputEmail" class="col-sm-2 control-label">Email Address<sup>*</sup></label>

                <div class="col-sm-10">
                    <form:input type="email" path="email" class="form-control" id="inputEmail" placeholder="Email" required="true" autofocus="true" />
                    <%--<input type="email" class="form-control" id="inputEmail" placeholder="Email">--%>
                </div>
            </div>

            <div class="form-group required">
                <label for="password" class="col-sm-2 control-label">Password<sup>*</sup></label>

                <div class="col-sm-10">
                    <form:password path="password" class="form-control" id="password" placeholder="Password" required="true" />
                    <%--<input type="password" class="form-control" id="inputPassword1" placeholder="Password">--%>
                </div>
            </div>

            <div class="form-group required">
                <label for="password2" class="col-sm-2 control-label">Retype Password<sup>*</sup>
                </label>

                <div class="col-sm-10">
                    <form:password path="password2" class="form-control" id="password2" placeholder="Retype Password" required="true" />
                    <%--<input type="password" class="form-control" id="inputPassword2" placeholder="Retype Password">--%>
                </div>
            </div>

            <div class="form-group required">
                <label class="col-sm-2 control-label" for="name">Name<sup>*</sup></label>

                <div class="col-sm-10">
                    <form:input path="name" id="name" class="form-control" placeholder="Last Name, Middle Name, First Name" />
                    <%--<input class="form-control" id="inputName" placeholder="Last Name, Middle Name, First Name" type="text">--%>
                </div>
            </div>

            <!-- Same as above, but in error state and message -->
            <!-- <div class="form-group has-error">
                <label class="control-label" for="email">Email<sup>*</sup></label>
                <input class="form-control" id="email" placeholder="Email" type="text">
                <div class="alert alert-danger">Important message</div>
            </div> -->

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label> <input type="checkbox">I Agree with <a
                                href="/">policy</a>
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <!-- 				Example of disabled button -->
                <!-- 				<button type="submit" class="btn btn-primary disabled">Отправить данные</button> -->
                <button type="submit" class="btn btn-primary btn-block">Create
                    Account
                </button>
            </div>
        <%--</form>--%>
        </form:form>
    </div>
    <!-- /container -->
</div>
<!-- Custom javascript functions for validate form -->
<%--<script src="<c:url value="/WEB-INF/temp/js/validate.js" />"/>--%>
<div class="container">

<jsp:include page="templates/footer.jsp"/>