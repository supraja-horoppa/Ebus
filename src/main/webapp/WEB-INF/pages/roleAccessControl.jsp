<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Role Management</title>
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
				gridavail=$("#AvailableOperations");
               
		grid.jqGrid({
                 url: "rolesList",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['Id','role Name','Description', 'Status','operations'],
                 colModel:[
                           {name:'roleId', index:'roleId',width:150,editable:true,sorttype:'text',hidden:true},
                     {name:'roleName',index:'roleName', width:150,editable:true,sorttype:'text',editrules:{text:true},},
                     {name:'description',index:'description', width:150,editable:true,sorttype:'text'},
                     {name:'status',index:'status', width:150,editable:true,editrules: {required: true}, edittype: 'select', 
    						formatter: 'text',
    						editoptions:{value:getAllSelectOptions()}},
                     {name:'operations', index:'operations', width:150,editable:true,sorttype:'text',hidden:true}
                 ],
                 rowList:[10, 20, 50, 100],
                 pager: "#pagingDiv",
                 viewrecords: true,
				 sortname: 'roleName',
				 sortorder: "asc",
				 editurl: "LoadJsonDataServlet?type=BS21 7RH", // this is dummy existing url
                 caption: "Role Management",
				height:200,
                editurl: 'rolesList',
                ondblClickRow: function(id, ri, ci) {
                    // edit the row and save it on press "enter" key
                    grid.jqGrid('editRow',id,true,null,null, 'rolesList');
                },
                
                onSelectRow: function (rowid) {
                        var operationIds = $(this).jqGrid("getCell", rowid, "operations").split(","),
                        i, n = operationIds.length;
                        gridavail.jqGrid("resetSelection");
                        for (i = 0; i < n; i++) {
                    	var rowIds = gridavail.jqGrid('getDataIDs');
                    	for (j = 1; j <= rowIds.length; j++) {
                    	var dataFromCellByColumnName = gridavail.jqGrid ('getCell', j, 'id');
                            if (dataFromCellByColumnName == operationIds[i] ) {
                            	gridavail.setSelection(j); 
                            }
                        }
                    }
                },
                
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
							 onclickSubmit: function (params) {	 
									var list = $("#roleMgmtTable");
									var selectedRow = list.getGridParam("selrow");
									rowData = list.getRowData(selectedRow);
									return rowData;
								}
		               }
		               );

	
			gridavail.jqGrid({
                 url: "optsList",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['Id','Name','Description'],
                 colModel:[
					 {name:'id',index:'id', width:150,editable:true,sorttype:'text',hidden:true},
                     {name:'name',index:'name', width:150,editable:true,sorttype:'text',editrules:{text:true},},
                     {name:'description',index:'description', width:300,editable:true,sorttype:'text'}
                     
                 ],
                 rowList:[10,20,60,100],
                 pager: "#pagingDiv1",
                 viewrecords: true,
				 sortname: 'name',
				 sortorder: "asc",
				 editurl: "LoadJsonDataServlet?type=BS21 7RH", // this is dummy existing url
                 caption: "Available Operations",
				height:200,
				multiselect: true,
				loadonce:true,
                editurl: 'clientArray',
                ondblClickRow: function(id, ri, ci) {
                    // edit the row and save it on press "enter" key
                    gridavail.jqGrid('editRow',id,true,null,null, 'clientArray');
                },
                onSelectRow: function(id) {
                    if (id && id !== lastSel1) {
                        if (typeof lastSel1 !== "undefined") {
                            gridavail.jqGrid('restoreRow',lastSel1);
                        }
                        lastSel1 = id;
                    }
                }

             });
		function getAllSelectOptions(){
				 var states = { 'Active': 'Active', 'InActive': 'InActive' };
     			  return states;
			}

$('#save_role_operation').click(function(){
   var myGrid = $("#roleMgmtTable");
    selRowId = myGrid.jqGrid ('getGridParam', 'selrow');
    roleIdValue = myGrid.jqGrid ('getCell', selRowId, 'roleId');
	var avaGrid = $("#AvailableOperations");
selopIds = avaGrid.jqGrid('getGridParam','selarrrow');
selOpArrVal=""
if(selopIds==""){
}else if(selopIds!=""){
selOpArr = selopIds.toString().split(",");
for(i=0;i<selOpArr.length;i++){
	if(i < selOpArr.length-1){
		selOpArrVal = selOpArrVal + avaGrid.jqGrid ('getCell', selOpArr[i], 'id') +",";
	}else if(i==selOpArr.length-1){
	selOpArrVal = selOpArrVal + avaGrid.jqGrid ('getCell', selOpArr[i], 'id');
	}
}
console.log("roleId value="+roleIdValue);
console.log("selOpArrVal value="+selOpArrVal);

$.ajax({
	data: {"roleId":roleIdValue,"avaOpList":selOpArrVal}
	,
    success: function(data){
        console.log("device control succeeded"+data);
    },
    error: function(errMsg){
        console.log("Device control failed");
    },
    type: 'POST',
    url: "roleOperationsList"
});

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
			<td style="border-left: 3px solid #cdd0d4;"/>		

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
													 <div style="float:left;">
											   		<div style="padding:10px 0px 0p 0px">
												   		<div style="float: left;background: #7da600;"><button class="save_role_operation" id="save_role_operation">Save Role Operation</button></div>
											   		</div>
											   </div>
									
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
	<div >
		<div style="display:inline-block;" ><a href="Home">Home</a></div>
	</div>
</div>
</form>


 
 </body>
</html>