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
 <header>
<div class="headerColorHome">
    <div align="left" style="width: 30%; float: left;"><label id="headlabel1">Ebus</label>
      <!-- <a href="/eBusPrototype/Home/Home"><img id="homeBusLogo" src="/eBusPrototype/Images/logo_comp1.png"  /></a> -->
    </div>
    <div align="left" style="float: left; width: 32%; height: 20px;">
       <label id="headlabel1">eBusSupplies Back Office</label>
    </div>
    <div align="right" style="float: left; width: 35%">
      <table align="right" cellpadding="0" cellspacing="0">
      <tr>
                        <td>
                            <label class="labelFontCard1">Username:</label>
                        </td>
                        <td>
                            <label class="labelFontCard1"><c:out value="${username}"></c:out></label>
                        </td>
                    </tr>
      
        <!-- <tr>
           <td>
               <label class="labelFontCard1">Search:</label>
            </td>
            <td>
                <input type="search" id="searchSite" style="height:20px;width:100px;"/>
            </td>
        </tr> -->
        <tr>
             <td>
                  <label class="labelFontCard1" style="visibility:hidden;">Logout:</label>
             </td>
             <td>
                  <span class="labelFontCard1" style="padding-left: 50px;"><a href="logout">Logout</a></span>
             </td>
         </tr>
      </table>
      </div>
  </div>
</header>
<div id="w">
<nav>
		<ul id="nav">
			<li><a href="Home">Home</a></li>
			<li><a href="reportParams">Reports</a>
				<ul>
					<li><a href="reportList">Daily Reports</a></li>
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
			<li><a href="#">Admin Tool</a>
				<ul>
					<li><a href="roleAccess">Role Management</a></li>
					<li><a href="userAccess">User Management</a></li>
				</ul></li>
			
			<li><a href="#">CONTACT US</a></li>
		</ul>
	</nav>
</div>

<%
     response.setHeader("Cache-Control","no-cache");
                   response.setHeader("Cache-Control","no-store");
                response.setHeader("Pragma","no-cache");
                 response.setDateHeader ("Expires", 0);
                  
                   %>

</body>
</html>
