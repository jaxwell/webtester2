<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<jsp:include page="../templates/header.jsp" />--%>

<%--<link href="${context}/resources/css/webtester.css" rel="stylesheet">--%>

<jsp:include page="../templates/top_menu.jsp"/>


<div class="container-fluid">
    <div class="row">

        <jsp:include page="../templates/left_menu.jsp"/>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Edit User Details</h1>

            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="inputLogin" class="col-sm-2 control-label">Login</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputLogin" placeholder="Login" value="${user.login}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDesc" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputDesc" placeholder="Email" value="${user.email}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputName" placeholder="Name" value="${user.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="student" class="col-sm-2 control-label">Student</label>
                    <input id="student" type="checkbox" value="roleStudent" />
                </div>
                <div class="form-group">
                    <label for="tutor" class="col-sm-2 control-label">Tutor</label>
                    <input id="tutor" type="checkbox" value="roleTutor">
                </div>
                <div class="form-group">
                    <label for="advanced" class="col-sm-2 control-label">Advanced</label>
                    <input id="advanced" type="checkbox" value="roleAdvanced">
                </div>
                <div class="form-group">
                    <label for="admin" class="col-sm-2 control-label">Admin</label>
                    <input id="admin" type="checkbox" value="roleAdmin">
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="submit" class="btn btn-primary">Cancel</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
