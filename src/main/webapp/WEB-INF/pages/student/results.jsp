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
        <li><a href="/student/statistics">Statistics</a></li>
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
        <li class="active"><a href="/student/statistics">Statistics</a></li>
        <li><a href="#">Profile</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="">Create Test</a></li>
        <li><a href="">Test Management</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="/admin/users">User Management</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Statistics</h1>

      <h3 class="sub-header">Statistics for User: {TODO Add name}</h3>

      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>ID</th>
            <th>Test</th>
            <th>Result</th>
            <th>Passed Date</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="row" items="${statistics}">
            <tr>
              <td>${row.id}</td>
              <td>${row.name}</td>
              <td>${row.description}</td>
              <td>${row.time}</td>
              <td>${row.userByIdTutor.name}</td>
              <td><button type="button" class="btn btn-success btn-xs">Start Test</button></td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../templates/footer.jsp"/>