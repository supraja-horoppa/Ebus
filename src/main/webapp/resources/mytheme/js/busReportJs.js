$(function() {
            $( "#accordion-1" ).accordion({
			heightStyle: "content",
            autoHeight: false,
			clearStyle: true,
			collapsible: true,
			active: false
			
			});
			
			$( document ).ready(function() {
				var selectedLocationVal = null;
				var selectedDepos = "";
				busLocationDepos = {"bus":[
					{"locationName":"HeadOffice", "depos":[""]}, 
					{"locationName":"Company", "depos":["Atamelang"]},
					{"locationName":"Depot", "depos":["A1","A2","A3"]}
						]}
								bs = JSON.parse(JSON.stringify(busLocationDepos));
								$.each(bs.bus, function( index, value ) {
									$('#locs').append(new Option(value.locationName, value.locationName));		
								});
								
								 $("#locs").change(function() {
								   var selectedLoc = $( "#locs option:selected" ).text();
								   console.log("selected loc"+$( "#locs option:selected" ).text());
									if(selectedLoc != null){									
									$('#list1').empty()
									$('#list2').empty()
									$('#selectedLocDis').empty()
									}
									$.each(bs.bus, function( index, value ) {
									     if( value.locationName == selectedLoc){
										 selectedLocationVal = selectedLoc;
										 $.each(value.depos, function( index, value ) {
													$("#list1").append(new Option(value, value));												
												});
										 }
												
									});
								});
								var list1Selecs = "";
								var list2Selecs = "";
							$( "#list1" ).change(function() {
								list1Selecs = "";
								$( "#list1 option:selected" ).each(function() {
								  list1Selecs += $( this ).text() + ",";
								});
								list1Selecs = list1Selecs.substring(0, list1Selecs.length - 1);
								console.log("list1Selecs"+list1Selecs);
							  });
							  $("#addBtnId").click(function(){

									if( list1Selecs !=null){
											var selectedList = list1Selecs.split(",");
												$.each(selectedList, function( index, value ) {
												$("#list1 option[value='"+value+"']").remove();
													$("#list2").append(new Option(value, value));												
												});
										 }
									var selectedDepos = "";
									$( "#list2 option" ).each(function() {
									  selectedDepos += $( this ).text() + ",";
									});
									selectedDepos = selectedDepos.substring(0, selectedDepos.length - 1);
									document.getElementById('location').value=selectedDepos;
									document.getElementById('date').value=selectedDate;
									
							});
							
							$( "#list2" ).change(function() {
								list2Selecs = "";
								$( "#list2 option:selected" ).each(function() {
								  list2Selecs += $( this ).text() + ",";
								});
								list2Selecs = list2Selecs.substring(0, list2Selecs.length - 1);
								console.log("list2Selecs"+list2Selecs);
							  });
							  
							  $("#removeBtnId").click(function(){

									if( list2Selecs !=null){
											var selectedList = list2Selecs.split(",");										
												$.each(selectedList, function( index, value ) {
												$("#list2 option[value='"+value+"']").remove();
													$("#list1").append(new Option(value, value));												
												});
										 }
									var selectedDepos = "";
									$( "#list2 option" ).each(function() {
									  selectedDepos += $( this ).text() + ",";
									});
									selectedDepos = selectedDepos.substring(0, selectedDepos.length - 1);
									document.getElementById('location').value=selectedDepos;
									document.getElementById('date').value=selectedDate;
																		 
							});
														  
							  $("#closeAllTabsBtn").click(function(){									
									window.location.reload(true);
									$("#accordion-1").accordion('option', 'active' , false);
							  });
							  
							  $( "#datepicker" ).datepicker();
								var selectedDate = ""
									$("#datepicker").on("change",function(){
										selectedDate = $(this).val();
										var selectedDepos = "";
										$( "#list2 option" ).each(function() {
										  selectedDepos += $( this ).text() + ",";
										});
										selectedDepos = selectedDepos.substring(0, selectedDepos.length - 1);
										document.getElementById('location').value=selectedDepos;
										document.getElementById('date').value=selectedDate;
									});
							  
							  $("#selectedLocDepoDateAddBtn").click(function(){	
							  var selectedLoc = selectedLocationVal;
									var selectedDepos = "";
										$( "#list2 option" ).each(function() {
										  selectedDepos += $( this ).text() + ",";
										});
										selectedDepos = selectedDepos.substring(0, selectedDepos.length - 1);
										
									if(selectedDate != null && selectedLoc!=null){
										console.log("selectedDepos"+selectedDepos);
										console.log("selectedLoc"+selectedLoc);
										console.log("selectedDate"+selectedDate);
										$.ajax({
											data: {"selectedDate":selectedDate,"selectedLoc":selectedLoc,"selectedDepos":selectedDepos}
											,
											success: function(response){
												console.log("device control succeeded"+response);
											},
											error: function(errMsg){
												console.log("Device control failed");
											},
											type: 'POST',
											url: "storeSelectedLocDeposAndDate"
										});
									}else{
									   alert("Sorry, You didn't selected Date or Location...");
									}
							  });
							});
			
         });