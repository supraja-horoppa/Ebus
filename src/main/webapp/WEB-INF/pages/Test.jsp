<!DOCTYPE html>
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
..ui-pg-table {background:green}
.ui-jqgrid .ui-widget-header {
    border: 1px solid #0b3e6f;
    background: #7da600;
    color: #40453a;
}

.ui-jqgrid .ui-jqgrid-bdiv { overflow-y: scroll }

  </style>
     
  <script type='text/javascript'>
   jQuery(document).ready(function () {
				
			var lastSel,lastSel1,
                grid=$("#roleMgmtTable"),
				gridavail=$("#AvailableOperations"),
                myDelOptions = {
                    // because I use "local" data I don't want to send the changes to the server
                    // so I use "processing:true" setting and delete the row manually in onclickSubmit
                    onclickSubmit: function(rp_ge, rowid) {
                        // we can use onclickSubmit function as "onclick" on "Delete" button
                        alert("The row with rowid="+rowid+" will be deleted");

                        // delete row
                        grid.delRowData(rowid);
                        $("#delmod"+grid[0].id).hide();

                        if (grid[0].p.lastpage > 1) {
                            // reload grid to make the row from the next page visable.
                            // TODO: deleting the last row from the last page which number is higher as 1
                            grid.trigger("reloadGrid", [{page:grid[0].p.page}]);
                        }

                        return true;
                    },
                    processing:true
                };  			 


             grid.jqGrid({
                 url: "rolesList",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['Id','role Name','Description', 'Status'],
                 colModel:[
                           {name:'roleId', index:'roleId',width:150,editable:true,sorttype:'text',hidden:true},
                     {name:'roleName',index:'roleName', width:150,editable:true,sorttype:'text',editrules:{text:true},},
                     {name:'description',index:'description', width:150,editable:true,sorttype:'text'},
                     {name:'status',index:'status', width:150,editable:true,sorttype:'text'}
                 ],
                 rowNum:10,
                 rowList:[20,60,100],
                 pager: "#pagingDiv",
                 viewrecords: true,
				 sortname: 'firstName',
				 sortorder: "desc",
				 editurl: "LoadJsonDataServlet?type=BS21 7RH", // this is dummy existing url
                 caption: "Role Management",
				height:200,
                editurl: 'rolesList',
                ondblClickRow: function(id, ri, ci) {
                    // edit the row and save it on press "enter" key
                    grid.jqGrid('editRow',id,true,null,null, 'rolesList');
                },
                onSelectRow: function(id) {
                    if (id && id !== lastSel) {
                        // cancel editing of the previous selected row if it was in editing state.
                        // jqGrid hold intern savedRow array inside of jqGrid object,
                        // so it is safe to call restoreRow method with any id parameter
                        // if jqGrid not in editing state
                        if (typeof lastSel !== "undefined") {
                            grid.jqGrid('restoreRow',lastSel);
                        }
                        lastSel = id;
                    }
                }

             });
			
			grid.jqGrid('navGrid',"#pagingDiv",{edit:true,add:true,del:true,search:false, refresh:false},
			        // Edit options
		            {
		            savekey: [true, 13],
		            reloadAfterSubmit: true,
		            //jqModal: true,
		            closeOnEscape: true,
		            closeAfterEdit: true,
					height:300,
					width:500,
					bSubmit: "Update",
					bCancel: "Close",
					bClose: "Close",
					editCaption: "Edit Record"
					
		        },
		        // Add options
		             {
						 savekey: [true, 13],
						 reloadAfterSubmit: true,
						 //jqModal: true,
						 height:300,
						 width:500,
						 bSubmit: "Save",
						 bCancel: "Close",
						 bClose: "Close",
						 addCaption: "Add Record",
						 closeOnEscape: true,
						 closeAfterAdd: true, 
						 closeOnEscape: true
					},
		        // Delete options
		               { 
							closeOnEscape: true, 
							multipleSearch: false,
							reloadAfterSubmit:true,
		                    closeAfterSearch: false,
		                    bSubmit: "Delete",
							 bCancel: "Close",
							 bClose: "Close",
		               }
		               );

	
			gridavail.jqGrid({
                 url: "optsList",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['Name','Description'],
                 colModel:[
                     {name:'name',index:'name', width:150,editable:true,sorttype:'text',editrules:{text:true},},
                     {name:'description',index:'description', width:300,editable:true,sorttype:'text'}
                     
                 ],
                 rowNum:20,
                 rowList:[20,60,100],
                 pager: "#pagingDiv1",
                 viewrecords: true,
				 sortname: 'firstName',
				 sortorder: "desc",
				 editurl: "LoadJsonDataServlet?type=BS21 7RH", // this is dummy existing url
                 caption: "Available Operations",
				height:200,
				multiselect: true,
                editurl: 'clientArray',
                ondblClickRow: function(id, ri, ci) {
                    // edit the row and save it on press "enter" key
                    gridavail.jqGrid('editRow',id,true,null,null, 'clientArray');
                },
                onSelectRow: function(id) {
                    if (id && id !== lastSel1) {
                        // cancel editing of the previous selected row if it was in editing state.
                        // jqGrid hold intern savedRow array inside of jqGrid object,
                        // so it is safe to call restoreRow method with any id parameter
                        // if jqGrid not in editing state
                        if (typeof lastSel1 !== "undefined") {
                            gridavail.jqGrid('restoreRow',lastSel1);
                        }
                        lastSel1 = id;
                    }
                }

             });



         });
  </script>
 </head>
 <body>
<form id='myForm'>
<div style="float:left;width:1155px;height:100%">

	<table border=0>
		<tr>
			<td style="border-left: 1px solid #cdd0d4;"/>		

			<td>
					<table style="width:100%;">
						<tr><td bgcolor="#666666" style="color:white">Application Roles</td></tr>
						<tr>						
							<td>
								 <div>
							         <div style="width:100%;border:1px;">
								          <div style="float: left;border:1px;">
								              <table id="roleMgmtTable"></table>
								              <div id="pagingDiv"></div>
								          </div>
								
										 <div style="float: left;padding:0px 0px 0px 20px">
								              <table id="AvailableOperations"></table>
								              <div id="pagingDiv1"></div>
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
</form>


 
 </body>
</html>