//These are the unique ID names for the elments for our data to be grabbed from our database...
const debriefTable = document.getElementById("debriefTable");
const debriefTableBody = document.getElementById("debriefBody");
const leaderTable = document.getElementById("leaderBoardTable");
const leaderTableBody = document.getElementById("leaderBoardBody");
const employeeId = sessionStorage.getItem("employeeId");
const debriefLog = document.getElementById("debriefLogging");
const headerUsername = document.getElementById("headerUsername");
const thumbnail = document.getElementById("thumbNail");


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
    let debriefingText = document.getElementById("debriefText");
    let dateOfOccurrence = document.getElementById("dateOfOccurrence");
    let locationOfOccurrence = document.getElementById("locationText");

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
        alert("Your Debrief has been submitted");
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

//function to grab all the claim information from the specific employee by their information in Leaderboard
async function getAllLeaderBoardInfo(){
    let url = "http://localhost:8080/leaderboard"
    let response = await fetch(url);
    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateLeaderBoardData(body);
    }
    else{
        alert("There was a problem trying to receive the claim information: apologies!");
    }
}

function populateLeaderBoardData(responseBody){
    leaderTableBody.innerHTML = '';
    for(let i = 0; i < responseBody.length; i += 2){
        console.log(i);
        let leader = responseBody[i];
        console.log(leader);
        let total = responseBody[i + 1];
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${leader}</td>
                              <td>${total}</td>`;
        console.log(tableRow);
        leaderTableBody.append(tableRow);
        
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
function toggleLeaderBoardData(){
    if(leaderTable.style.display === "none"){
        leaderTable.style.display = "block";
        getAllLeaderBoardInfo();
    }
    else{
        leaderTable.style.display = "none";
    }
}


async function getEmployeeImage(){
    let url = "http://localhost:8080/employee/image/" + employeeId;
    console.log(url);
    let response = await fetch(url);
    console.log(response);
    thumbnail.innerHTML = '';

    if(response.status === 200){
        const image_blob = await response.blob();
        const image_text = await image_blob.text();
        const image_Element = document.createElement('img');
        image_Element.src = "data:image/gif;base64,"+ image_text;
        image_Element.style.width = "auto";
        image_Element.style.height = "93px";
        thumbnail.appendChild(image_Element);
    }
    else{
        alert("There was a problem trying to obtain the employe data: apologies!");
    }
}

function delay(time) {
    return new Promise(resolve => setTimeout(resolve, time));
  }
  
async function previewFile() {
  var file    = document.getElementById('portrait_input').files[0];
  var reader  = new FileReader();
  let format = "data:image/gif;base64,";
  let length = format.length

  reader.addEventListener("load", function () {
    var base64gif = reader.result; // your gif in base64 here
    console.log(base64gif.slice(11, 14));

    if (base64gif.length < 1_000_000 && base64gif.slice(11, 14) === "gif"){
      fetch("http://localhost:8080/employee/image/" + employeeId, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: String(base64gif).slice(length)
        })
    
    }
    else{
      alert("File too large")
    }
  }, false);

  if (file) {
    reader.readAsDataURL(file);
    await delay(1000);
    getEmployeeImage();
  }
}


// Logout Function for the Agent to logout from their page to protect their information...
function logout(){
    sessionStorage.clear();
    window.location.href = "../index.html";
}
getAllEmployeeData();
getAllDebriefData();
getEmployeeImage();