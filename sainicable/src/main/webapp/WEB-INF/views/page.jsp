<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js " />
<spring:url var="images" value="/resources/images" />
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Saini Cable - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page content -->


	<c:if test="${userClickHome==true }">
		<%@include file="home.jsp"%>
	</c:if>

	<!--When user click only about  -->


	<c:if test="${userClickAbout==true }">
		<%@include file="about.jsp"%>
	</c:if>


	<!--When user click only services-->


	<c:if test="${userClickServices==true }">
		<%@include file="services.jsp"%>
	</c:if>


	<!--When user click only contact-->


	<c:if test="${userClickContact==true }">
		<%@include file="contact.jsp"%>
	</c:if>



	<!-- Footer -->

	<%@include file="./shared/footer.jsp"%>

</body>

</html>
