<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../templates/header.jsp"/>

<link href="<c:url value="/resources/css/webtester.css" />" rel="stylesheet">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Webtester</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/student/tests">Tests</a></li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Profile
          <span class="caret"></span>
        </a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Settings</a></li>
            <li class="divider"></li>
            <li><a href="#">Sign out</a></li>
          </ul>
        </li>

      </ul>

      <form class="navbar-form navbar-right">
        <input type="text" class="form-control"
               placeholder="Search... (inactive)">
      </form>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="/student/tests">Tests</a></li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#">Profile</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li class="active"><a href="/tutor/createTest">Create Test</a></li>
        <li><a href="">Test Management</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="/admin/users">User Management</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Create new Test</h1>

      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label for="inputName" class="col-sm-2 control-label">Test title<sup>*</sup></label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputName" placeholder="Test title">
          </div>
        </div>
        <div class="form-group">
          <label for="inputDesc" class="col-sm-2 control-label">Description<sup>*</sup></label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputDesc" placeholder="Enter Description">
          </div>
        </div>
        <div class="form-group">
          <label for="inputTime" class="col-sm-2 control-label">Question time</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputTime" placeholder="Enter Time per Question (sec). Default: 30 sec" maxlength="4">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Create Test</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<jsp:include page="../templates/footer.jsp"/>