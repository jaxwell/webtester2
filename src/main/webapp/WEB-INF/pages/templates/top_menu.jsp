<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- ============================= -->
<!-- Start Top Navigation Template -->
<!-- ============================= -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Webtester</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <sec:authorize access="hasRole('STUDENT')">
                    <li><a href="${context}/student/tests">Tests</a></li>
                    <li><a href="${context}/student/results">Statistics</a></li>
                </sec:authorize>

                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><sec:authentication property="principal.username" />
                    <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${context}/profile">Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="${context}/logout">Sign out</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>
<!-- =========================== -->
<!-- End Top Navigation Template -->
<!-- =========================== -->