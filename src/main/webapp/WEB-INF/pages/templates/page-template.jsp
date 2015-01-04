<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="<c:url value="/resources/favicon.ico"/>" />

  <title>Webtester</title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="<c:url value="/resources/css/starter-template.css" />" rel="stylesheet" />
  <link href="<c:url value="/resources/css/webtester.css" />" rel="stylesheet">


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="<c:url value="/resources/js/html5shiv.min.js" />" />
  <script src="<c:url value="/resources/js/respond.min.js" />" />
  <![endif]-->
</head>

<body>

<decorator:body />


<hr>
<footer>
  <p>&copy; Ievgen Bykov 2014</p>
</footer>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>