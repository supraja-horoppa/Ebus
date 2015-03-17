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
				width: 100,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'firstName',
				label: 'FirstName',
				index: 'firstName',
				width: 100,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'lastName',
				label: 'LasttName',
				index: 'lastName',
				width: 100,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'email',
				label: 'Email',
				index: 'email',
				width: 100,
				editable: true,
				editrules: {required: true}
			},
			{
				name:'phone',
				label: 'Phone',
				index: 'phone',
				width: 100,
				editable: true,
				editrules: {required: true}
			},
			
		],
		caption: "Users",
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
