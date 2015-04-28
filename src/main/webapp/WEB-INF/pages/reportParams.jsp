<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet"/>
 <link href="<c:url value="/resources/css/busReportCss.css" />" rel="stylesheet"/>
 <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
 <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
 <script src="<c:url value="/resources/js/busReportJs.js" />"></script>  
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
			<li><a href="#">Reports</a>
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
<div id="content" >
<div style="margin: 40px 0 0 0; font-size: 15px;">
<div id="accordion-1" style="width:900px;">
<h2>Select Location</h2>
   <div style="height:300px; ">
		<div class="selectLocCls">Select:
		</div>
		<select id="locs" >
		   <option value="None">-- Select --</option>
		   </select>
      
		   <div style="text-align:center;">
			   <div id="leftListId">
				   <div class="listHeadingCls">List of Locations:</div>
				   <select id="list1" multiple >
					</select>
			   </div>
			   <div id="addRemoveBtns">
					<div id="addBtnId" class="myButton" style="display:block;">Add</div>
					<div id="removeBtnId" class="myButton" style="display:block;">Remove</div>
			   </div>
			   <div id="rightListId">
					<div class="listHeadingCls">Selected Locations:</div>
			        <select id="list2" multiple >	
					</select>
			   </div>
			</div>
   </div>
   <h2>Select Contracts</h2>
   <div>
  <table>
     <tr><td>Contract1</td><td><input type="checkbox" name="contracts" value="Contract1" /> </td></tr>
     <tr><td>Contract2 </td><td><input type="checkbox" name="contracts" value="Contract2"/></td></tr>
     <tr><td>Contract3</td><td><input type="checkbox" name="contracts" value="Contract3"/></td></tr>
     <tr><td>Contract4</td><td><input type="checkbox" name="contracts" value="Contract4"/></td></tr>
   </table>   
   </div>
   <h2>Select Duties</h2>
   <div>
   <table>
      <tr><td>Duty1</td><td><input type="checkbox" name="duties" value="Duty1" /> </td></tr>
      <tr><td>Duty2 </td><td><input type="checkbox" name="duties" value="Duty2"/></td></tr>
      <tr><td>Duty3</td><td><input type="checkbox" name="duties" value="Duty3"/></td></tr>
      <tr><td>Duty4</td><td><input type="checkbox" name="duties" value="Duty4"/></td></tr>
   </table>  </div>
   <h2>Select Routes</h2>
   <div>
   <table>
     <tr><td>Route1</td><td><input type="checkbox" name="routes" value="Route1" /> </td></tr>
     <tr><td>Route2 </td><td><input type="checkbox" name="routes" value="Route2"/></td></tr>
     <tr><td>Route3</td><td><input type="checkbox" name="routes" value="Route3"/></td></tr>
     <tr><td>Route4</td><td><input type="checkbox" name="routes" value="Route4"/></td></tr>
   </table>  </div>
   <h2>Select Buses</h2>
   <div>
   <table>
     <tr><td>Bus1</td><td><input type="checkbox" name="buses" value="Bus1" /> </td></tr>
     <tr><td>Bus2 </td><td><input type="checkbox" name="buses" value="Bus2"/></td></tr>
     <tr><td>Bus3</td><td><input type="checkbox" name="buses" value="Bus3"/></td></tr>
     <tr><td>Bus4</td><td><input type="checkbox" name="buses" value="Bus4"/></td></tr>
   </table>  </div>
   <h2>Select Staff</h2>
   <div>
   <table>
     <tr><td>staff1</td><td><input type="checkbox" name="staff" value="staff1" /> </td></tr>
     <tr><td>staff2 </td><td><input type="checkbox" name="staff" value="staff2"/></td></tr>
     <tr><td>staff3</td><td><input type="checkbox" name="staff" value="staff3"/></td></tr>
     <tr><td>staff4</td><td><input type="checkbox" name="staff" value="staff4"/></td></tr>
   </table>  </div></div>
   <div>
   <label>Saved Parameters Details:</label>
   <br></br>
   
   <c:if test="${not empty objects}">
    	<ul>
			<c:forEach var="listValue" items="${objects}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
   </c:if>
    <c:if test="${empty objects}">
        No parameters provided.
    </c:if>
    
   </div>
   <div id="selectedLocDisId" style="margin: 50px 0 0 100px; width:900px;">
   <form  method="post" action="saveReportParams"  >
		
			<div class="clear"></div>
			<table><tr>
			<td><input type="hidden" id="location" name="location" /></td>
			<td><input type="hidden" id="date" name="date"/></td>
			<td><input type="hidden" id="contracts" name = "contracts" /></td></tr>
			<tr><td><input type="hidden" id="duties" name="duties" /></td>
			<td><input type="hidden" id="routes" name="routes" /></td>
			<td><input type="hidden" id="buses" name="buses" /></td></tr>
			<td><input type="hidden" id="staff" name="staff" /></td>
			</table>
			<div id ="closeAllTabsBtn" >
			<table width =50% >
			<tr><td><input type="submit"  class="button"  value="Save Params"/></td>
			<td><input type="reset"	 class="button" value="Reset"/></td></tr>
			</table></div>
        
    
</form>
</div>
</div>
</div>
</body>
</html>