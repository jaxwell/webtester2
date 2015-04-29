<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="true" %>

<jsp:include page="../templates/top_menu.jsp" />

<div class="container-fluid">
  <div class="row">

    <jsp:include page="../templates/left_menu.jsp" />

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <!-- Progress bar with label-->
      <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${sessionScope.get('percentStatus')}%" />%;">
          <c:out value="${sessionScope.get('percentStatus')}" />%
        </div>
      </div>

      <h2 class="page-header">Timer: <span  id="timer"><c:out value="${sessionScope.get('questionTime')}"/></span>  seconds</h2>


      <h3>Question #<c:out value="${sessionScope.get('currentQuestion')}" /> (of total <c:out value="${sessionScope.get('totalQuestions')}" />)</h3>

      <c:if test="${!isLastAnswer}">
      <form action="${context}/student/exam" method="post" id="questionForm"></c:if>
        <c:if test="${isLastAnswer}">
        <form action="${context}/student/final" method="post" id="questionForm"></c:if>

        <blockquote>
          <c:out value="${question.question}" />
        </blockquote>

        <hr/>
        <c:forEach var="row" items="${answers}">
          <div class="checkbox">
            <label>
              <input type="checkbox" id="${row.idAnswer}">${row.text}
            </label>
          </div>
        </c:forEach>
        <button type="submit" class="btn btn-primary">
          <c:if test="${!isLastAnswer}">
            Next
          </c:if>
          <c:if test="${isLastAnswer}">
            Finish
          </c:if>
        </button>
      </form>
    </div>
  </div>
</div>