<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>jqGrid Example</title>
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.6.2.js'></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
  <style type='text/css'>

.ui-jqgrid-btable .ui-state-highlight { background: yellow; }
.ui-jqgrid-htable .ui-jqgrid-labels {background-color:green}

.ui-jqgrid .ui-widget-header {
    border: 1px solid #0b3e6f;
    background: #7da600;
    color: #40453a;
}

.ui-jqgrid .ui-jqgrid-bdiv { overflow-y: scroll }

  </style>
     
  <script type='text/javascript'>
$(function() {

	$.extend($.jgrid.defaults, {
				datatype: 'json',
				jsonReader : {
			        root: "rows",
			        page: "page",
			        total: "total",
			        records: "records",
			        repeatitems: false,
			        cell: "cell",
			        id: "id"
			    },
				
				sortname: 'username',
				sortorder: 'asc',
				height: 'auto',
				viewrecords: true,
				rowList: [10, 20, 50, 100],
				altRows: true,
				loadError: function(xhr, status, error) {
					alert(error);
				}
			});

	$.extend($.jgrid.edit, {
				closeAfterEdit: true,
				closeAfterAdd: true,
				ajaxEditOptions: { contentType: "application/json" },
				mtype: 'PUT',
				serializeEditData: function(data) {
					delete data.oper;
					return JSON.stringify(data);
				}
			});
	$.extend($.jgrid.del, {
				mtype: 'DELETE',
				serializeDelData: function() {
					return "";
				}
			});

	var editOptions = {
		onclickSubmit: function(params, postdata) {
			params.url = URL + '/' + postdata.id;
		}
	};
	var addOptions = {mtype: "POST"};
	var delOptions = {
		onclickSubmit: function(params, postdata) {
			params.url = URL + '/' + postdata;
		}
	};

	var URL = 'usersList';
	var options = {
		url: URL,
		editurl: URL,
		colModel:[
			{
				name:'username',
				label: 'Ussername',
				index: 'username',
				width: 150,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'firstName',
				label: 'FirstName',
				index: 'firstName',
				width: 150,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'lastName',
				label: 'LasttName',
				index: 'lastName',
				width: 150,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'email',
				label: 'Email',
				index: 'email',
				width: 150,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'phone',
				label: 'Phone',
				index: 'phone',
				width: 150,
				editable: true,
				editrules: {required: true}
			},
			
		],
		caption: "User Management",
		pager : '#pager',
		height: 'auto',
		ondblClickRow: function(id) {
			jQuery(this).jqGrid('editGridRow', id, editOptions);
		}
	};

	$("#grid")
			.jqGrid(options)
			.navGrid('#pager',
			{}, //options
			editOptions,
			addOptions,
			delOptions,
			{} // search options
	);
	
	

});
  </script>
 </head>
 <body>

<div style="float:left;width:1155px;height:100%">

	<table border=0>
		<tr>
			<td style="border-left: 3px solid #cdd0d4;"/>		

			<td>
					<table style="width:100%;">
						<tr><td bgcolor="#666666" style="color:white">Application Users</td></tr>
						<tr>						
							<td>
								 <div>
							         <div style="width:100%;border:1px;">
								          <div style="float: left;border:1px;">
								              <table id="grid"></table>
								              <div id="pager"></div>
								          </div>
								
										 
							         </div>
							  </div>
							
							</td>
						</tr>
					</table>
	
			</td>
			<td style="border-left: 3px solid #cdd0d4;"/>
	   </tr>
	</table>

</div>



 
 </body>
</html>