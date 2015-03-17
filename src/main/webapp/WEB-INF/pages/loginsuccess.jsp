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
 <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
 <script src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>
<div id="header">
<table width="2000">
	<tr>
		<td width="1000"><h2>Ebus</h2></td>
		<td width="1000"><h3><input type="text" name="search"/></h3><br/>
		
		</td>
	</tr>
</table>

</div>
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
</div>



</body>
</html>
