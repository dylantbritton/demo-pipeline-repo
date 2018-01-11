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



function retrieveLastResolve() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let pendingList = JSON.parse(xhr.responseText);

			console.log(pendingList);
					resolutionMessage = document.getElementById("resolutionMessage");
					resolutionMessage.appendChild(document.createTextNode(pendingList.status));
					newDataItem1 = document.getElementById("amount");
					newDataItem1.appendChild(document.createTextNode("$"));
					newDataItem1
							.appendChild(document
									.createTextNode(pendingList["amount"]
											.toFixed(2)));
					
					newDataItem2 = document.getElementById("type");
					newDataItem2.appendChild(document.createTextNode(pendingList[i]["type"]));
					
					newDataItem3 = document.getElementById("description");
					newDataItem3.appendChild(document.createTextNode(pendingList[i]["description"]));
					
					newDataItem4 = document.getElementById("dateSubmitted");
					newDataItem4.appendChild(document
							.createTextNode(pendingList[i]["dateSubmitted"]));
					
					newDataItem5 = document.getElementById("username");
					newDataItem5.appendChild(document
							.createTextNode(pendingList[i]["username"]));
					
					newDataItem6 = document.getElementById("name");
					newDataItem6.appendChild(document
							.createTextNode(pendingList[i]["name"]));
					
					newDataItem7 = document.getElementById("email");
					newDataItem7.appendChild(document
							.createTextNode(pendingList[i]["email"]));

			
		}
	}
	xhr.open("GET", "retrieveLastResolve?=" + new Date().getTime(), true);
	xhr.send();
}