<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   <head>
      <meta charset="utf-8">
      <title>Daily Audit Report </title>
      <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
	  <link href="<c:url value="/resources/css/busReportCss.css" />" rel="stylesheet"/>
	  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	  <script src="<c:url value="/resources/js/busReportJs.js" />"></script>  
	     
   </head>
<body>
   <div id="accordion-1" style="margin: 50px 0 0 100px; width:900px;">
      <h3>Select Location</h3>
   <div style="height:300px;">
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
   <h3>Select Date</h3>
   <div>
     
	  <p>Calendar: <input type="text" id="datepicker" /></p>
	 
   </div>
   </div>
   
   <div id="selectedLocDisId" style="margin: 50px 0 0 100px; width:900px;">
   <form  method="post" action="dailyAuditReport"  >
		
			<div class="clear"></div>
			
			<label for="location">Selected Location:</label>			
			<input type="text" id="location" name="location" />
			<label for="date">Selected Date:</label>
			<input type="text" id="date" name="date"/>
			<div class="clear"></div>
			
			<div id ="closeAllTabsBtn" >
			<input type="submit" style="margin: 20px 0 0 187px;" class="button"  value="Get Report"/>
			<input type="reset"	class="button" value="close"/></div>
        
    
</form>
<div style="display:inline-block;" ><a href="Home">Home</a></div>
</div>
</body>
</html>