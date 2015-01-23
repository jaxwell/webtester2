<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="./templates/header.jsp" />

<%--<link href="${context}/resources/css/webtester.css" rel="stylesheet">--%>

<jsp:include page="./templates/top_menu.jsp" />

<div class="container-fluid">
  <div class="row">

    <jsp:include page="./templates/left_menu.jsp" />

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">404 Resource Not Found</h1>

      <img src="${context}/resources/images/notfound.jpg" />

    </div>
  </div>
</div>

<jsp:include page="templates/footer.jsp" />