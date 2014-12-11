<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../templates/header.jsp" />

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
					</ul></li>

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
				<li><a href="">Create Test</a></li>
				<li><a href="">Test Management</a></li>
			</ul>
			<ul class="nav nav-sidebar">
				<li class="active"><a href="/admin/users">User Management</a></li>
			</ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">User Management</h1>

			<h2 class="sub-header">Registered Users</h2>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
					<tr>
						<th>ID</th>
						<th>Role</th>
						<th>Login</th>
						<th>Email</th>
						<th>Name</th>
						<th>Created</th>
						<th>Edit</th>
						<th>Activate</th>
						<th>Delete</th>
						<th>Updated</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${users}">
							<tr>
								<td>${row.id}</td>
								<td>
									<c:forEach var="rowRole" items="${row.userRolesByIdUser}">
									${rowRole.roleByIdRole.name}<br/>
									</c:forEach>
								</td>
								<td>${row.login}</td>
								<td>${row.email}</td>
								<td>${row.name}</td>
								<td><small>${row.created}</small></td>
								<td><button type="button" class="btn btn-primary btn-xs">Edit</button></td>
								<td>${row.active ? "<button type=\"button\" class=\"btn btn-warning btn-xs\">Deactivate</button>" : "<button type=\"button\" class=\"btn btn-success btn-xs\">Activate</button>"}
								<td><button type="button" class="btn btn-danger btn-xs">Delete</button></td>
								<td><small>${row.updated}</small></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />