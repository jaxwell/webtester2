<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%--<jsp:include page="templates/header.jsp" />--%>
<link href="${context}/resources/css/signin.css" rel="stylesheet" />

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
                    <%--aria-expanded="false" aria-controls="navbar">--%>
                <%--<span class="sr-only">Toggle navigation</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <a class="navbar-brand" href="#">Webtester</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <%-- Old Form (Without Spring Security) --%>
        <%--<form:form method="post" action="${context}/signin" commandName="loginForm" class="form-signin" role="form">--%>
        <%--&lt;%&ndash;<form class="form-signin" role="form">&ndash;%&gt;--%>
            <%--<h2 class="form-signin-heading">Please sign in</h2>--%>
            <%--<div class="alert alert-danger" role="alert"><form:errors path="*"/></div>--%>
            <%--&lt;%&ndash;<input type="text" class="form-control" placeholder="Login" required autofocus>&ndash;%&gt;--%>
            <%--<form:input path="login" class="form-control" placeholder="Login" required="true" autofocus="true" />--%>
            <%--&lt;%&ndash;<input type="password" class="form-control" placeholder="Password" required>&ndash;%&gt;--%>
            <%--<form:password path="password" class="form-control" placeholder="Password" required="true" />--%>

            <%--<div class="checkbox">--%>
                <%--<label>--%>
                    <%--<input type="checkbox" value="remember-me"> Remember me (temp. inactive)--%>
                <%--</label>--%>
            <%--</div>--%>
            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
            <%--<a class="btn btn-xs btn-link nav-justified">Restore password</a>--%>
            <%--<a class="btn btn-xs btn-link nav-justified" href="/signup">Not Account Yet? Sign Up today.</a>--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
        <%--</form:form>--%>

        <%-- Login form (Spring Security) --%>
        <form method="post" action="${context}/loginHandler" class="form-signin" role="form">

            <h2 class="form-signin-heading">Please sign in</h2>

            <c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION != null }">
                <div class="alert alert-danger" role="alert">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</div>
            </c:if>

            <input type="text" class="form-control" placeholder="Login" name="j_username" required autofocus />

            <input type="password" class="form-control" placeholder="Password" name="j_password" required>

            <%--<div class="checkbox">--%>
                <%--<label>--%>
                    <%--<input type="checkbox" value="true" name="_spring_security_remember_me"> Remember me--%>
                <%--</label>--%>
            <%--</div>--%>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <a class="btn btn-xs btn-link nav-justified">Restore password</a>
            <a class="btn btn-xs btn-link nav-justified" href="/signup">Not Account Yet? Sign Up today.</a>

        </form>
    </div>
    <!-- /container -->
</div>

<div class="container">
<%--<jsp:include page="templates/footer.jsp" />--%>