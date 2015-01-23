<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../templates/top_menu.jsp" />

<div class="container-fluid">
  <div class="row">

    <jsp:include page="../templates/left_menu.jsp" />

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">User Statistics</h1>

      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>ID</th>
            <th>TestName</th>
            <th>Result</th>
            <th>Passed</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="row" items="${result}">
            <tr>
              <td>${row.id}</td>
              <td>
                  ${row.testByIdTest.name}
                <c:if test="${row.testByIdTest.name} == null">
                  ${row.comment}
                </c:if>
              </td>
              <td>${row.result}</td>
              <td><small>${row.created}</small></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>