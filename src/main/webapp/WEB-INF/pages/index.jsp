<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="templates/header.jsp" />

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
        <div id="navbar" class="navbar-collapse collapse">
            <form:form method="POST" action="${context}/signin" commandName="loginForm" class="navbar-form navbar-right" role="form">
            <%--<form class="navbar-form navbar-right" role="form">--%>
                <div class="form-group">
                    <form:input path="login" type="text" placeholder="Login" class="form-control" />
                    <%--<input type="text" placeholder="Login" class="form-control">--%>
                </div>
                <div class="form-group">
                    <form:password path="password" placeholder="Password" class="form-control"/>
                    <%--<input type="password" placeholder="Password" class="form-control">--%>
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            <%--</form>--%>
            </form:form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Welcome to Webtester</h1>

        <p>Online/Offline quiz system. Useful for online/offline quiz, tests, exams & certifications.</p>

        <p><a class="btn btn-primary btn-lg" href="/signup" role="button">Sign Up &raquo;</a></p>
    </div>
</div>

<div class="container">
    <h1>Features</h1>
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Feature 1</h2>

            <p>This is a description for first feature.</p>

            <p><a class="btn btn-default" href="#" role="button">More &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Feature 2</h2>

            <p>This is a description for second feature.</p>

            <p><a class="btn btn-default" href="#" role="button">More &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Feature 3</h2>

            <p>This is a description for third feature.</p>

            <p><a class="btn btn-default" href="#" role="button">More &raquo;</a></p>
        </div>
    </div>

    <jsp:include page="templates/footer.jsp" />
