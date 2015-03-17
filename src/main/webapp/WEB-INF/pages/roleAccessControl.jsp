<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    <title>Ebus Role</title>
    <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/base/jquery.ui.base.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/redmond/jquery-ui.css"/>
    <link href="<c:url value="/resources/css/ui.jqgrid.css" />" media="screen" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>

	<script src="js/lib/grid.locale-en.js"></script>
	<script src="js/lib/jquery.jqGrid.src.js"></script>
	<script src="js/index.js"></script>
	<script src="<c:url value="/resources/js/lib/grid.locale-en.js" />"></script>
	<script src="<c:url value="/resources/js/lib/jquery.jqGrid.src.js" />"></script>
	<script src="<c:url value="/resources/js/role.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>
<div id="w">
	<nav>
		<ul id="nav">
			<li><a href="Home">Home</a></li>
			<li><a href="#">Reports</a>
				<ul>
					<li><a href="#">Daily Reports</a></li>
					<li><a href="#">Digital Marketing</a></li>
					<li><a href="#">Illustrations</a></li>
					<li><a href="#">Infographics</a></li>
					<li><a href="#">Product Design</a></li>
				</ul></li>
			<li><a href="#">Special Hire</a>
				<ul>
					<li><a href="#">Cityscapes</a></li>
					<li><a href="#">Oceans</a></li>
				</ul></li>
			<li><a href="Home">Admin Tool</a>
				<ul>
					<li><a href="roleAccess">Add Role</a></li>
					<li><a href="userAccess">Add User</a></li>
				</ul></li>
			
			<li><a href="#">CONTACT US</a></li>
		</ul>
	</nav>

		<div id="content">
		<h1>Role</h1>
		<table id="grid"></table>
		<div id="pager"></div>
		</div>
		
	</div>
	
	
	



</body>
</html>
	