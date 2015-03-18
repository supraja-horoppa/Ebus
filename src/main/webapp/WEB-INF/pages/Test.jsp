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
                 url: "usersList",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['User Name','Email','First Name', 'Last Name','Mobile Number','Role'],
                 colModel:[
                     {name:'username',index:'username', width:150,editable:true,sorttype:'text'}, 
                     {name:'email',index:'email', width:150,editable:true,sorttype:'text'},
                     {name:'firstName',index:'firstName', width:150,editable:true,sorttype:'text'},
                     {name:'lastName',index:'lastName', width:150,editable:true,sorttype:'text'},
                     {name:'phone',index:'phone',width:150,editable:true,sorttype:'integer'},
                     {name:'role',index:'role',width:150,editable:true,sorttype:'text'}
                    
                 ],
                 rowNum:10,
                 rowList:[20,60,100],
                 pager: "#pagingDiv",
                 viewrecords: true,
				 sortname: 'username',
				 sortorder: "asc",
				 editurl: "LoadJsonDataServlet?type=BS21 7RH", // this is dummy existing url
                 caption: "Users Management",
				 height:200,
                 editurl: 'clientArray',
                 ondblClickRow: function(id, ri, ci) {
                    // edit the row and save it on press "enter" key
                    grid.jqGrid('editRow',id,true,null,null, 'clientArray');
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
			
			grid.jqGrid('navGrid',"#pagingDiv",{edit:true,add:true,del:true,search:false, refresh:false});

	
			

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
								              <table id="roleMgmtTable"></table>
								              <div id="pagingDiv"></div>
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