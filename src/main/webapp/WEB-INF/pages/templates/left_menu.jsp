<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- ==================================== -->
<!-- Start Left Navigation Panel Template -->
<!-- ==================================== -->
<div class="col-sm-3 col-md-2 sidebar">
    <sec:authorize access="hasRole('STUDENT')">
        <ul class="nav nav-sidebar">
            <li><a href="${context}/student/tests">Tests</a></li>
            <li><a href="${context}/student/results">Statistics</a></li>
            <li><a href="${context}/profile">Profile</a></li>
        </ul>
    </sec:authorize>

    <sec:authorize access="hasRole('TUTOR')">
        <ul class="nav nav-sidebar">
            <li><a href="${context}/tutor/createTest">Create Test</a></li>
            <li><a href="${context}/tutor/tests">Test Management</a></li>
        </ul>
    </sec:authorize>

    <sec:authorize access="hasRole('ADVANCED_TUTOR')">
        <ul class="nav nav-sidebar">
            <li><a href="${context}/advanced_tutor/tests">Test Management (All)</a></li>
        </ul>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <ul class="nav nav-sidebar">
            <li class="active"><a href="${context}/admin/users">User Management</a></li>
        </ul>
    </sec:authorize>
</div>
<!-- ================================== -->
<!-- End Left Navigation Panel Template -->
<!-- ================================== -->