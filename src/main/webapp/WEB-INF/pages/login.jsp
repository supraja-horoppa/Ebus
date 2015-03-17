<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>Login Page</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</head>

<body>

	<form:form action="create" method="post" commandName="loginForm" cssClass="form-horizontal" autocomplete="off">
		<fieldset>
		
			<legend>Log in</legend>
			
			<label for="organization">Organization</label>
			<div class="controls">
					<form:select id="login" path="organization" items="${organizationList}"/>
				</div>
			<div class="clear"></div>
			
			<label for="login">UserName</label>			
			<form:input path="username" type="text" id="login" name="login" />
			<div class="clear"></div>
			
			<label for="password">Password</label>
			<form:input path="password" type="password" id="password" name="password"/>
			<div class="clear"></div>
			
			<br />
			
			<input type="submit" style="margin: -20px 0 0 287px;" class="button" name="commit" value="Log in"/>	
		</fieldset>
	</form:form>
	
</body>

</html>