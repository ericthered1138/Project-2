//These are the unique ID names for the elments for our data to be grabbed from our database...
const debriefTable = document.getElementById("debriefTable");
const debriefTableBody = document.getElementById("debriefBody");
const employeeId = sessionStorage.getItem("employeeId");
const debriefLog = document.getElementById("debriefLogging");
const headerUsername = document.getElementById("headerUsername");


// To receive information from our Employee...
async function getAllEmployeeData(){
    let url = "http://localhost:8080/employee/" + employeeId;
    let response = await fetch(url);
    console.log(url);

    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateUsername(body);
    }
    else{
        alert("There was a problem trying to obtain the employe data: apologies!");
    }
}

// To grab the employee username to display into the employee page...
function populateUsername(employee){
    headerUsername.innerText = `${employee.username}`;
    console.log(headerUsername);
}

// Function to create an Debrief log for the Agent to give more inclusive information for the user...
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

// To get all the debrief information from the employees with their Id...
async function getAllDebriefData(){
    let url= "http://localhost:8080/employee/debriefs/" + employeeId;
    let response = await fetch(url);

    if(response.status === 200){
        let body = await response.json();
        // console.log(body);
        populateDebriefData(body);
    }
    else{
        alert("there was a problem trying to get the debrief data: apologies!");
    }
}


// To receive the information of the Debrief Data...
function populateDebriefData(responseBody){
    for(let debrief of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${debrief.debriefingId}</td>
                              <td>${debrief.employeeId}</td>
                              <td>${debrief.debriefingText}</td>
                              <td>${debrief.dateOfOccurence}</td>
                              <td>${debrief.locationOfOccurrence}</td>
                              <td>${debrief.dateTimeOfCreation}</td>`
        // console.log(tableRow);
        debriefTableBody.append(tableRow);
        // console.log(debriefTableBody);                      
    }
}

function toggleDebriefData(){
    if(debriefTable.style.display === "none"){
        debriefTable.style.display  = "block";
        getAllDebriefData();
    }
    else{
        debriefTable.style.display = "none";
    }
}


// Logout Function for the Agent to logout from their page to protect their information...
function logout(){
    sessionStorage.clear();
    window.location.href = "../index.html";
}
getAllEmployeeData();
getAllDebriefData();