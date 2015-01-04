<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Webtester</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/student/tests">Tests</a></li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Profile
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