$(function() {
            $( "#accordion-1" ).accordion({
			heightStyle: "content",
            autoHeight: false,
			clearStyle: true,
			collapsible: true,
			active: false
			});
            
            $( "#contractsDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            $( "#dutiesDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            $( "#busesDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            $( "#routesDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            $( "#staffDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            $( "#locationDiv" ).accordion({
    			heightStyle: "content",
                autoHeight: false,
    			clearStyle: true,
    			collapsible: true,
    			active: false
    			});
            
            var selectedDeposGlobal = "";
            var selectedDateGlobal = "";
            var selectedContractsGlobal = "";
            var selectedDutiesGlobal = "";
            var selectedRoutesGlobal = "";
            var selectedBusesGlobal = "";
            var selectedStaffGlobal = "";
            var locationGlobal = "";
            var dateGlobal = "";
            var contractsGlobal = "";
            var dutiesGlobal = "";
            var routesGlobal = "";
            var busesGlobal = "";
            var staffGlobal = "";
			$( document ).ready(function() {
				$('#summary').fadeIn('slow');
				var selectedLocationVal = null;
				
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
									selectedDeposGlobal = selectedDepos;
									document.getElementById('location').value=selectedDepos;
									document.getElementById('date').value=selectedDate;
									document.getElementById('contracts').value = selectedContractsGlobal;
									if(selectedDepos!= ""){
										locationGlobal= "Location parameter is "+selectedDepos+".";
									} else {
										locationGlobal = "Location parameter is not provided.";
									}
									if(selectedContractsGlobal != "") {
										contractsGlobal = "Contracts parameter is "+selectedContractsGlobal;
									} else {
										contractsGlobal = "Contracts parameter is not provided";
									}
									if(selectedDutiesGlobal != "") {
										dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
									} else {
										dutiesGlobal = "Duties parameter is not provided";
									}
									if(selectedRoutesGlobal != "") {
										routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
									} else {
										routesGlobal = "Routes parameter is not provided";
									}
									if(selectedBusesGlobal != "") {
										busesGlobal = "Buses parameter is "+selectedBusesGlobal;
									} else {
										busesGlobal = "Buses parameter is not provided";
									}
									if(selectedStaffGlobal != ""){
										staffGlobal = "Staff parameter is "+selectedStaffGlobal;
									} else {
										staffGlobal = "Staff parameter is not provided";
									}
									document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
												+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
									
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
									selectedDeposGlobal = selectedDepos;
									document.getElementById('location').value=selectedDepos;
									document.getElementById('date').value=selectedDate;
									document.getElementById('contracts').value = selectedContractsGlobal;
									if(selectedDepos!= ""){
										locationGlobal= "Location parameter is "+selectedDepos+".";
									} else {
										locationGlobal = "Location parameter is not provided.";
									}
									if(selectedContractsGlobal != "") {
										contractsGlobal = "Contracts parameter is "+selectedContractsGlobal;
									} else {
										contractsGlobal = "Contracts parameter is not provided";
									}
									
									if(selectedDutiesGlobal != "") {
										dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
									} else {
										dutiesGlobal = "Duties parameter is not provided";
									}
									if(selectedRoutesGlobal != "") {
										routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
									} else {
										routesGlobal = "Routes parameter is not provided";
									}
									if(selectedBusesGlobal != "") {
										busesGlobal = "Buses parameter is "+selectedBusesGlobal;
									} else {
										busesGlobal = "Buses parameter is not provided";
									}
									if(selectedStaffGlobal != ""){
										staffGlobal = "Staff parameter is "+selectedStaffGlobal;
									} else {
										staffGlobal = "Staff parameter is not provided";
									}
									document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
												+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
																		 
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
										selectedDeposGlobal = selectedDepos;
										selectedDateGlobal = selectedDate;
										document.getElementById('location').value=selectedDepos;
										document.getElementById('date').value=selectedDate;
										document.getElementById('contracts').value = selectedContractsGlobal;
										if(selectedDepos!= ""){
											locationGlobal= "Location parameter is "+selectedDepos+".";
										} else {
											locationGlobal = "Location parameter is not provided.";
										}
										if(selectedContractsGlobal != "") {
											contractsGlobal = "Contracts parameter is "+selectedContractsGlobal;
										} else {
											contractsGlobal = "Contracts parameter is not provided";
										}
										if(selectedDutiesGlobal != "") {
											dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
										} else {
											dutiesGlobal = "Duties parameter is not provided.";
										}
										if(selectedRoutesGlobal != "") {
											routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
										} else {
											routesGlobal = "Routes parameter is not provided";
										}
										if(selectedBusesGlobal != "") {
											busesGlobal = "Buses parameter is "+selectedBusesGlobal;
										} else {
											busesGlobal = "Buses parameter is not provided";
										}
										if(selectedStaffGlobal != ""){
											staffGlobal = "Staff parameter is "+selectedStaffGlobal;
										} else {
											staffGlobal = "Staff parameter is not provided";
										}
										document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
													+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
									});
								
								var selectedDuties = "";
								var $checkes = $('input:checkbox[name="duties"]').change(function () {
									var checkboxes = document.querySelectorAll('input[name="duties"]:checked'), values = [];
								    Array.prototype.forEach.call(checkboxes, function(el) {
								        values.push(el.value);
								    });
								  selectedDuties= values; 
								selectedDutiesGlobal = selectedDuties;
								document.getElementById('duties').value = selectedDutiesGlobal;
								if(selectedDeposGlobal!= ""){
									locationGlobal= "Location parameter is "+selectedDeposGlobal+".";
								} else {
									locationGlobal = "Location parameter is not provided.";
								}
								if(selectedContractsGlobal != ""){
									contractsGlobal = "Contract parameter is "+selectedContracts;
								} else {
									contractsGlobal = "Contract parameter is not provided.";
								}
								if(selectedDutiesGlobal != "") {
									dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
								} else {
									dutiesGlobal = "Duties parameter is not provided";
								}
								if(selectedRoutesGlobal != "") {
									routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
								} else {
									routesGlobal = "Routes parameter is not provided";
								}
								if(selectedBusesGlobal != "") {
									busesGlobal = "Buses parameter is "+selectedBusesGlobal;
								} else {
									busesGlobal = "Buses parameter is not provided";
								}
								if(selectedStaffGlobal != ""){
									staffGlobal = "Staff parameter is "+selectedStaffGlobal;
								} else {
									staffGlobal = "Staff parameter is not provided";
								}
								document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
											+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
							     });
								
								var selectedRoutes = "";
								var $checkes = $('input:checkbox[name="routes"]').change(function () {
									var checkboxes = document.querySelectorAll('input[name="routes"]:checked'), values = [];
								    Array.prototype.forEach.call(checkboxes, function(el) {
								        values.push(el.value);
								    });
								  selectedRoutes= values; 
								selectedRoutesGlobal = selectedRoutes;
								document.getElementById('routes').value = selectedRoutesGlobal;
								if(selectedDeposGlobal!= ""){
									locationGlobal= "Location parameter is "+selectedDeposGlobal+".";
								} else {
									locationGlobal = "Location parameter is not provided.";
								}
								if(selectedContractsGlobal != ""){
									contractsGlobal = "Contract parameter is "+selectedContracts;
								} else {
									contractsGlobal = "Contract parameter is not provided.";
								}
								if(selectedDutiesGlobal != "") {
									dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
								} else {
									dutiesGlobal = "Duties parameter is not provided";
								}
								if(selectedRoutesGlobal != "") {
									routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
								} else {
									routesGlobal = "Routes parameter is not provided";
								}
								if(selectedBusesGlobal != "") {
									busesGlobal = "Buses parameter is "+selectedBusesGlobal;
								} else {
									busesGlobal = "Buses parameter is not provided";
								}
								if(selectedStaffGlobal != ""){
									staffGlobal = "Staff parameter is "+selectedStaffGlobal;
								} else {
									staffGlobal = "Staff parameter is not provided";
								}
								document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
											+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
							     });
								
								var selectedBuses = "";
								var $checkes = $('input:checkbox[name="buses"]').change(function () {
									var checkboxes = document.querySelectorAll('input[name="buses"]:checked'), values = [];
								    Array.prototype.forEach.call(checkboxes, function(el) {
								        values.push(el.value);
								    });
								  selectedBuses= values; 
								selectedBusesGlobal = selectedBuses;
								document.getElementById('buses').value = selectedBusesGlobal;
								if(selectedDeposGlobal!= ""){
									locationGlobal= "Location parameter is "+selectedDeposGlobal+".";
								} else {
									locationGlobal = "Location parameter is not provided.";
								}
								if(selectedContractsGlobal != ""){
									contractsGlobal = "Contract parameter is "+selectedContracts;
								} else {
									contractsGlobal = "Contract parameter is not provided.";
								}
								if(selectedDutiesGlobal != "") {
									dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
								} else {
									dutiesGlobal = "Duties parameter is not provided";
								}
								if(selectedRoutesGlobal != "") {
									routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
								} else {
									routesGlobal = "Routes parameter is not provided";
								}
								if(selectedBusesGlobal != "") {
									busesGlobal = "Buses parameter is "+selectedBusesGlobal;
								} else {
									busesGlobal = "Buses parameter is not provided";
								}
								if(selectedStaffGlobal != ""){
									staffGlobal = "Staff parameter is "+selectedStaffGlobal;
								} else {
									staffGlobal = "Staff parameter is not provided";
								}
								document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
											+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
							     });
								
								var selectedStaff = "";
								var $checkes = $('input:checkbox[name="staff"]').change(function () {
									var checkboxes = document.querySelectorAll('input[name="staff"]:checked'), values = [];
								    Array.prototype.forEach.call(checkboxes, function(el) {
								        values.push(el.value);
								    });
								  selectedStaff= values; 
								selectedStaffGlobal = selectedStaff;
								document.getElementById('staff').value = selectedStaffGlobal;
								if(selectedDeposGlobal!= ""){
									locationGlobal= "Location parameter is "+selectedDeposGlobal+".";
								} else {
									locationGlobal = "Location parameter is not provided.";
								}
								if(selectedContractsGlobal != ""){
									contractsGlobal = "Contract parameter is "+selectedContracts;
								} else {
									contractsGlobal = "Contract parameter is not provided.";
								}
								if(selectedDutiesGlobal != "") {
									dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
								} else {
									dutiesGlobal = "Duties parameter is not provided";
								}
								if(selectedRoutesGlobal != "") {
									routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
								} else {
									routesGlobal = "Routes parameter is not provided";
								}
								if(selectedBusesGlobal != "") {
									busesGlobal = "Buses parameter is "+selectedBusesGlobal;
								} else {
									busesGlobal = "Buses parameter is not provided";
								}
								if(selectedStaffGlobal != ""){
									staffGlobal = "Staff parameter is "+selectedStaffGlobal;
								} else {
									staffGlobal = "Staff parameter is not provided";
								}
								document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
											+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
							     });
								
								var selectedContracts = "";
								var $checkes = $('input:checkbox[name="contracts"]').change(function () {
									selectedContracts = $checkes.filter(':checked').map(function () {
								     return this.value;
								  }).get();
									selectedContractsGlobal = selectedContracts;
								document.getElementById('contracts').value = selectedContractsGlobal;
								if(selectedDeposGlobal!= ""){
									locationGlobal= "Location parameter is "+selectedDeposGlobal+".";
								} else {
									locationGlobal = "Location parameter is not provided.";
								}
								if(selectedContractsGlobal != ""){
									contractsGlobal = "Contract parameter is "+selectedContracts;
								} else {
									contractsGlobal = "Contract parameter is not provided.";
								}
								if(selectedDutiesGlobal != "") {
									dutiesGlobal = "Duties parameter is "+selectedDutiesGlobal;
								} else {
									dutiesGlobal = "Duties parameter is not provided";
								}
								if(selectedRoutesGlobal != "") {
									routesGlobal = "Routes parameter is "+selectedRoutesGlobal;
								} else {
									routesGlobal = "Routes parameter is not provided";
								}
								if(selectedBusesGlobal != "") {
									busesGlobal = "Buses parameter is "+selectedBusesGlobal;
								} else {
									busesGlobal = "Buses parameter is not provided";
								}
								if(selectedStaffGlobal != ""){
									staffGlobal = "Staff parameter is "+selectedStaffGlobal;
								} else {
									staffGlobal = "Staff parameter is not provided";
								}
								document.getElementById('params').value = locationGlobal+"\n"+contractsGlobal
											+"\n"+dutiesGlobal+"\n"+routesGlobal+"\n"+busesGlobal+"\n"+staffGlobal;
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