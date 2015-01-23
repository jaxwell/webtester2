<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../templates/top_menu.jsp"/>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="../templates/left_menu.jsp"/>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Tests Management</h1>

            <h2 class="sub-header"><sec:authentication property="principal.username"/> Tests</h2>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Time</th>
                        <th>Edit</th>
                        <th>Activate</th>
                        <th>Delete</th>
                        <th>Questions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>1</td>
                        <td>Test Name</td>
                        <td>120</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">Edit</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-success btn-xs">Activate</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger btn-xs">Delete</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">Manage</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary btn-block">Add new Test</button>
            </div>
        </div>
    </div>
</div>