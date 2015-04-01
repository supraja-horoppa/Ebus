<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Ebus Admin</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>

<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"></link>
	
</head>
<body>
<div id="w">
<nav>
		<ul id="nav">
			<li><a href="Home">Home</a></li>
			<li><a href="#">Reports</a>
				<ul>
					<li><a href="reports">Daily Reports</a></li>
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
					<li><a href="roleAccess">Role Management</a></li>
					<li><a href="userAccess">User Management</a></li>
				</ul></li>
			
			<li><a href="#">CONTACT US</a></li>
		</ul>
	</nav>
</div>
	<div id="content">
	<form method="post" action="dailyAuditReport">
 
    <table>
    <tr>
        <td>Location	</td>
        <td><input type="text" name="location"></input></td> 
    </tr>
    <tr>
        <td>Date	</td>
        <td><input type="date" data-icon="calender" name="date"></input></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Add">
        </td>
    </tr>
</table>    
     
</form>
</div>
</body>
</html>