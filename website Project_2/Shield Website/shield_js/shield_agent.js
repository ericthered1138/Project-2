const debriefTableBody = document.getElementById("debriefBody");
const employeeId = sessionStorage.getItem("employeeId");
const debriefLog = document.getElementById("debriefLogging");
const employee = sessionStorage.getItem("username");


function logout(){
    sessionStorage.clear();
    window.location.href = "../index.html";
}
function populateUsername(employee){
    headerUsername.innerText = `${employee.username}`;
}

async function employeeCreateDebriefsLogData(){
    let debriefingText = document.getElementById("debriefingText");
    let dateOfOccurrence = document.getElementById("dateOfOccurrence");
    let locationOfOccurrence = document.getElementById("locationOfOccurrence");

    let response = await fetch(
        "http://localhost:8080/debrief", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({"employeeId":employeeId,
                                  "debriefingText":debriefingText.value,
                                  "dateOfOccurrence":dateOfOccurrence.value,
                                  "locationOfOccurrence":locationOfOccurrence.value})
        }
    )
    if(response.status === 201){
        let body = await response.json();
        // console.log(response);
    }
    else{
        alert("There was a problem trying to request a debrief form: apologies!");
    }
}

async function getAllDebriefData(){
    let url= "http://localhost:8080/employee/debriefs/" + employeeId;
    let response = await fetch(url);

    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateDebriefData(body);
    }
    else{
        alert("there was a problem trying to get the debrief data: apologies!");
    }
}

function populateDebriefData(responseBody){
    for(let debrief of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${debrief.debriefingId}</td>
                              <td>${debrief.employeeId}</td>
                              <td>${debrief.debriefingText}</td>
                              <td>${debrief.dateOfOccurence}</td>
                              <td>${debrief.locationOfOccurrence}</td>
                              <td>${debrief.dateTimeOfCreation}</td>`
        console.log(tableRow);
        debriefTableBody.append(tableRow);
        console.log(debriefTableBody);                      
    }
}
getAllDebriefData();