<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Saini Cable - ${title}</title>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<!-- datatable Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- self coded css -->
<link href="${css}/myWeb.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
			 <a class="navbar-brand" href="${contextRoot}/home">
				<img alt="Brand" src="">
			</a>
		</div>
	</div>
	</nav>
	<div class="content">

		<div class="container">

			<div class="row">
				<div class="col-xs-12">
					<div class="jumbotron">
						<h1>${errorTitle}</h1>
						<hr>
						<blockquote style:"word-wrap:break-word">${errorDescription}</blockquote>
					</div>
				</div>
			</div>

		</div>
	</div>
	</div>

</body>
</html>
