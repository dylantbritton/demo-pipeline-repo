window.onload = function() {
	loadNavbar();
	loadDashboardView();
}

function loadNavbar() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			document.getElementById('navbar').innerHTML = xhr.responseText;

			document.getElementById('home').addEventListener("click",
					loadDashboardView, false);
			// document.getElementById('myAccount').addEventListener("click",
			// loadReqView, false);
			document.getElementById('logout').addEventListener("click", logout,
					false);

			if (document.getElementById('employeeNav')) {

				document.getElementById('goReq').addEventListener("click",
						loadReqView, false);
				document.getElementById('myPending').addEventListener("click",
						loadMyPendingView, false);
				document.getElementById('myResolved').addEventListener("click",
						loadMyResolvedView, false);
			}

			else if (document.getElementById('managerNav')) {

				document.getElementById('viewAllEmp').addEventListener("click",
						loadEmpListView, false);
				document.getElementById('viewAllRes').addEventListener("click",
						loadAllResolvedView, false);
				document.getElementById('viewAllPend').addEventListener(
						"click", loadAllPendingView, false);
			} else {
			}
		}
	}
	xhr.open("GET", "navbar?r=" + new Date().getTime(), true);
	xhr.send();
}

// ----------------------------------Employee Views
function loadDashboardView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "dashboardServlet?r=" + new Date().getTime(), true);
	xhr.send();
}

function loadReqView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "submitRequest?=" + new Date().getTime(), true);
	xhr.send();
}

function loadMyPendingView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveMyPendingInfo();
		}
	}
	xhr.open("GET", "myPendingView?=" + new Date().getTime(), true);
	xhr.send();
}

function loadMyResolvedView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveMyResolvedInfo();
		}
	}
	xhr.open("GET", "myResolvedView?=" + new Date().getTime(), true);
	xhr.send();
}

// ---------------------------Employee Retrieve

function retrieveMyPendingInfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let myPending = JSON.parse(xhr.responseText);

			if (myPending.length > 0) {
				let table = document.getElementById("myPendTable");

				for (let i = 0; i < myPending.length; i++) {

					newDataItem1 = document.createElement("td");
					newDataItem1.appendChild(document.createTextNode("$"));
					newDataItem1.appendChild(document
							.createTextNode(myPending[i]["amount"].toFixed(2)));
					newDataItem2 = document.createElement("td");
					newDataItem2.appendChild(document
							.createTextNode(myPending[i]["type"]));
					newDataItem3 = document.createElement("td");
					newDataItem3.appendChild(document
							.createTextNode(myPending[i]["description"]));
					newDataItem4 = document.createElement("td");
					newDataItem4.appendChild(document
							.createTextNode(myPending[i]["dateSubmitted"]));

					newRow = document.createElement("tr");
					newRow.appendChild(newDataItem1);
					newRow.appendChild(newDataItem2);
					newRow.appendChild(newDataItem3);
					newRow.appendChild(newDataItem4);

					table.appendChild(newRow);
				}
			} else {

				// No pending requests!
			}

		}
	}
	xhr.open("GET", "getMyPending?=" + new Date().getTime(), true);
	xhr.send();
}

function retrieveMyResolvedInfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let myResolved = JSON.parse(xhr.responseText);

			if (myResolved.length > 0) {

				let table = document.getElementById("myResolvedTable");

				for (let i = 0; i < myResolved.length; i++) {

					newDataItem1 = document.createElement("td");
					newDataItem1.appendChild(document.createTextNode("$"));
					newDataItem1
							.appendChild(document
									.createTextNode(myResolved[i]["amount"]
											.toFixed(2)));
					newDataItem2 = document.createElement("td");
					newDataItem2.appendChild(document
							.createTextNode(myResolved[i]["type"]));
					newDataItem3 = document.createElement("td");
					newDataItem3.appendChild(document
							.createTextNode(myResolved[i]["description"]));
					newDataItem4 = document.createElement("td");
					newDataItem4.appendChild(document
							.createTextNode(myResolved[i]["dateSubmitted"]));
					newDataItem5 = document.createElement("td");
					newDataItem5.appendChild(document
							.createTextNode(myResolved[i]["status"]));

					newRow = document.createElement("tr");
					newRow.appendChild(newDataItem1);
					newRow.appendChild(newDataItem2);
					newRow.appendChild(newDataItem3);
					newRow.appendChild(newDataItem4);
					newRow.appendChild(newDataItem5);

					table.appendChild(newRow);
				}
			} else {

				// No pending requests!
			}

		}
	}
	xhr.open("GET", "getMyResolved?=" + new Date().getTime(), true);
	xhr.send();

}

// ---------------------------------Employee Send

// function processReq() {
//
// console.log("I got pressed");
// // loadNavbar();
// // loadDashboardView();
// }

// -------------------------------Manager View

function loadEmpListView() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveAllEmployees();
		}
	}
	xhr.open("GET", "employeeListView?=" + new Date().getTime(), true);
	xhr.send();
}

function loadAllResolvedView() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveAllResolved();
		}
	}
	xhr.open("GET", "resolvedReimburseView?=" + new Date().getTime(), true);
	xhr.send();
}

function loadAllPendingView() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveAllPending();
		}
	}
	xhr.open("GET", "viewAllPending?=" + new Date().getTime(), true);
	xhr.send();
}

// --------------------------------Manager Retrieve

function retrieveAllEmployees() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let employeeList = JSON.parse(xhr.responseText);

			if (employeeList.length > 0) {

				let table = document.getElementById("employeeTable");

				for (let i = 0; i < employeeList.length; i++) {
					console.log(employeeList[i]["role"]);
					newDataItem1 = document.createElement("td");
					newDataItem1.appendChild(document
							.createTextNode(employeeList[i]["role"]));
					newDataItem2 = document.createElement("td");
					newDataItem2.appendChild(document
							.createTextNode(employeeList[i]["firstname"] + " "
									+ employeeList[i]["lastname"]));
					newDataItem3 = document.createElement("td");
					newDataItem3.appendChild(document
							.createTextNode(employeeList[i]["username"]));
					newDataItem4 = document.createElement("td");
					newDataItem4.appendChild(document
							.createTextNode(employeeList[i]["email"]));

					let viewEmpBtn = document.createElement('input');
					viewEmpBtn.type = "button";
					viewEmpBtn.value = "View Requests";
					viewEmpBtn.id = employeeList[i];
					viewBtn.addEventListener("click", loadEmpReqView, false);
					
					newRow = document.createElement("tr");
					newRow.appendChild(newDataItem1);
					newRow.appendChild(newDataItem2);
					newRow.appendChild(newDataItem3);
					newRow.appendChild(newDataItem4);

					table.appendChild(newRow);
				}
			} else {

			}

		}
	}
	xhr.open("GET", "retrieveEmployees?=" + new Date().getTime(), true);
	xhr.send();
}

function retrieveAllResolved() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let resolvedList = JSON.parse(xhr.responseText);

			if (resolvedList.length > 0) {

				let table = document.getElementById("resolvedTable");

				for (let i = 0; i < resolvedList.length; i++) {

					newDataItem1 = document.createElement("td");
					newDataItem1.appendChild(document.createTextNode("$"));
					newDataItem1.appendChild(document
							.createTextNode(resolvedList[i]["amount"]
									.toFixed(2)));
					newDataItem2 = document.createElement("td");
					newDataItem2.appendChild(document
							.createTextNode(resolvedList[i]["type"]));
					newDataItem3 = document.createElement("td");
					newDataItem3.appendChild(document
							.createTextNode(resolvedList[i]["description"]));
					newDataItem4 = document.createElement("td");
					newDataItem4.appendChild(document
							.createTextNode(resolvedList[i]["dateSubmitted"]));
					newDataItem5 = document.createElement("td");
					newDataItem5.appendChild(document
							.createTextNode(resolvedList[i]["dateResolved"]));
					newDataItem6 = document.createElement("td");
					newDataItem6.appendChild(document
							.createTextNode(resolvedList[i]["status"]));
					newDataItem7 = document.createElement("td");
					newDataItem7.appendChild(document
							.createTextNode(resolvedList[i]["username"]));
					newDataItem8 = document.createElement("td");
					newDataItem8.appendChild(document
							.createTextNode(resolvedList[i]["name"]));

					newRow = document.createElement("tr");
					newRow.appendChild(newDataItem1);
					newRow.appendChild(newDataItem2);
					newRow.appendChild(newDataItem3);
					newRow.appendChild(newDataItem4);
					newRow.appendChild(newDataItem5);
					newRow.appendChild(newDataItem6);
					newRow.appendChild(newDataItem7);
					newRow.appendChild(newDataItem8);

					table.appendChild(newRow);
				}
			} else {

			}

		}
	}
	xhr.open("GET", "retrieveAllResolved?=" + new Date().getTime(), true);
	xhr.send();
}

function retrieveAllPending() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let pendingList = JSON.parse(xhr.responseText);
			let table = document.getElementById("pendingTable");
			let form = document.getElementById("resForm");

			if (pendingList.length > 0) {

				for (let i = 0; i < pendingList.length; i++) {

					newDataItem1 = document.createElement("td");
					newDataItem1.appendChild(document.createTextNode("$"));
					newDataItem1
							.appendChild(document
									.createTextNode(pendingList[i]["amount"]
											.toFixed(2)));
					newDataItem2 = document.createElement("td");
					newDataItem2.appendChild(document
							.createTextNode(pendingList[i]["type"]));
					newDataItem3 = document.createElement("td");
					newDataItem3.appendChild(document
							.createTextNode(pendingList[i]["description"]));
					newDataItem4 = document.createElement("td");
					newDataItem4.appendChild(document
							.createTextNode(pendingList[i]["dateSubmitted"]));
					newDataItem5 = document.createElement("td");
					newDataItem5.appendChild(document
							.createTextNode(pendingList[i]["username"]));
					newDataItem6 = document.createElement("td");
					newDataItem6.appendChild(document
							.createTextNode(pendingList[i]["name"]));
					newDataItem7 = document.createElement("td");
					newDataItem7.appendChild(document
							.createTextNode(pendingList[i]["email"]));

					// create resolve radio button
					let resolveBtn = document.createElement('input');
					resolveBtn.type = "radio";
					resolveBtn.id = pendingList[i]["reqid"];
					resolveBtn.value = pendingList[i]["reqid"];
					resolveBtn.name = "selectedResolve";
					resolveBtn.required = true;
					resolveBtn
							.addEventListener("click", showApproveDeny, false);

					// create button columns for approve and reject
					let label1 = document.createTextNode("Approve ");
					label1.className = "setResolve";
					label1.id = pendingList[i]["reqid"];


					let label2 = document.createTextNode("Reject ");
					label2.className = "setResolve";
					label2.id = pendingList[i]["reqid"];


					// create approve radio button
					let approveBtn = document.createElement('input');
					approveBtn.type = "radio";
					approveBtn.value = "approve";
					approveBtn.name = "setResolve";
					approveBtn.className = "setResolve";
					approveBtn.id = pendingList[i]["reqid"];
					approveBtn.required = true;

					// create approve radio button
					let rejectBtn = document.createElement('input');
					rejectBtn.type = "radio";
					rejectBtn.value = "reject";
					rejectBtn.name = "setResolve";
					rejectBtn.className = "setResolve";
					rejectBtn.id = pendingList[i]["reqid"];
					rejectBtn.required = true;

					form.appendChild(resolveBtn);
					form.appendChild(approveBtn);
					form.appendChild(rejectBtn);

					newRow = document.createElement("tr");
					newRow.appendChild(newDataItem1);
					newRow.appendChild(newDataItem2);
					newRow.appendChild(newDataItem3);
					newRow.appendChild(newDataItem4);
					newRow.appendChild(newDataItem5);
					newRow.appendChild(newDataItem6);
					newRow.appendChild(newDataItem7);

					// append resolve buttons
					newRow.appendChild(resolveBtn);
					newRow.appendChild(label1);
					newRow.appendChild(approveBtn);
					newRow.appendChild(label2);
					newRow.appendChild(rejectBtn);

					table.appendChild(newRow);
				}
			} else {

			}
			
			let els = document.getElementsByClassName("setResolve");

			Array.prototype.forEach.call(els, function(el) {
			    	el.style.visibility = 'hidden';
			});
			
		}
	}
	xhr.open("GET", "retrieveAllPending?=" + new Date().getTime(), true);
	xhr.send();
}

function showApproveDeny() {
	
	//x.style.visibility = 'visible';
	let els = document.getElementsByClassName("setResolve");

			Array.prototype.forEach.call(els, function(el) {
			    if(el.id == event.target.id){
				
			    	el.style.visibility = 'visible';
				
			    } else{
					
			    	el.style.visibility = 'hidden';

			    }
			});
}


function prepareResolveView() {
	reqid = event.target.id

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveSelectedResolve();
		}
	}

	xhr.open("GET", "prepareResolveView?=" + new Date().getTime(), true);
	xhr.send();
}

function retrieveSelectedResolve() {

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let selectedResolve = JSON.parse(xhr.responseText);
			console.log(selectedResolved);
		}
	}

	xhr.open("GET", "processResolve?=" + new Date().getTime(), true);
	xhr.send();
}

// --------------------logout

function logout() {
	let xhr = new XMLHttpRequest;

	xhr.onreadystatechange = function() {
		if (xhr.onreadystatechange == 4 && status == 20) {

		}
	}

	xhr.open("POST", "logout", true);
	xhr.send();
}