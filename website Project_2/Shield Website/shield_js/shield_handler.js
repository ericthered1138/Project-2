const claimTableBody = document.getElementById("claimBody");
const claimTable = document.getElementById("claimTable");
const employeeId = sessionStorage.getItem("employeeId");
const currentClaimPending = document.getElementById("currentClaimPendingBody");
const claimId = 0
const claimTableBodyToPrevious = document.getElementById("claimBodyToPrevious");
const claimTableToPrevious = document.getElementById("claimTableToPrevious");
const debriefTable = document.getElementById("debriefTable");
const debriefTableBody = document.getElementById("debriefBody");
const claimEmployeeDropDown = document.getElementById("claimEmployeeArrow");
const headerUsername = document.getElementById("headerUsername");
const leaderTable = document.getElementById("leaderBoardTable");
const leaderTableBody = document.getElementById("leaderBoardBody");
//####################    GRABS CLAIM DATA     ###############################################################################################################


async function getAllClaimData(){
    let url= "http://localhost:8080/employee/claims/all/" + employeeId;//handlerId;
    let response = await fetch(url);

    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateClaimData(body);
    }
    else{
        alert("there was a problem trying to get the claims data.");
    }
}

function populateClaimData(responseBody){
    claimTableBody.innerHTML = '';
    for(let claim of responseBody){
        if (claim.approval == "pending")
        {
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td>
                            <td>${claim.employeeId}</td>
                            <td>${claim.amount.toFixed(2)}</td>
                            <td>${claim.description}</td>
                            <td>${claim.dateOfOccurrence}</td>
                            <td>${claim.locationOfOccurrence}</td>
                            <td>${claim.dateTimeOfCreation}</td>
                            <td>${claim.approval}</td>
                            <td>${claim.handlerComment}</td>`
        claimTableBody.append(tableRow);
        }
        else if (claim.approval != "pending")
        {
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td>
                            <td>${claim.employeeId}</td>
                            <td>${claim.amount.toFixed(2)}</td>
                            <td>${claim.description}</td>
                            <td>${claim.dateOfOccurrence}</td>
                            <td>${claim.locationOfOccurrence}</td>
                            <td>${claim.dateTimeOfCreation}</td>
                            <td>${claim.approval}</td>
                            <td>${claim.handlerComment}</td>`
        claimTableBodyToPrevious.append(tableRow);
}

    }
}


function toggleClaimData()
{
    if (claimTable.style.display === "none"){
        claimTable.style.display="block";
        getAllClaimData();
    }
    else{
        claimTable.style.display="none";
    }
}

function toggleClaimDataToPrevious()
{
    if (claimTableToPrevious.style.display === "none"){
        claimTableToPrevious.style.display="block";
        getAllClaimData();
    }
    else{
        claimTableToPrevious.style.display="none";
    }
}


//#################################################################################################

// async function getAllClaimDataToPrevious(){
//     let url= "http://localhost:8080/employee/claims/all/" + employeeId;//handlerId;
//     let response = await fetch(url);

//     if(response.status === 200){
//         let body = await response.json();
//         console.log(body);
//         populateClaimDataToPrevious(body);
//     }
//     else{
//         alert("there was a problem trying to get the claims data.");
//     }
// }

// function populateClaimDataToPrevious(responseBody){
//     claimTableBodyToPrevious.innerHTML = '';
//     for(let claim of responseBody){
//         if (claim.approval == "approved")
//         {
//         let tableRow = document.createElement("tr");
//         tableRow.innerHTML = `<td>${claim.claimId}</td>
//                             <td>${claim.employeeId}</td>
//                             <td>${claim.amount.toFixed(2)}</td>
//                             <td>${claim.description}</td>
//                             <td>${claim.dateOfOccurrence}</td>
//                             <td>${claim.locationOfOccurrence}</td>
//                             <td>${claim.dateTimeOfCreation}</td>
//                             <td>${claim.approval}</td>
//                             <td>${claim.handlerComment}</td>`
//         claimTableBodyToPrevious.append(tableRow);
//         }
// }


// }


// function toggleClaimData2()
// {
//     if (claimTableToPrevious.style.display === "none"){
//         claimTable.style.display="block";
//         getAllClaimData();
//     }
//     else{
//         claimTableToPrevious.style.display="none";
//     }
// }

//#############################  APPROVE AND DENY  ######################################################################################################


async function updateApproveClaimInfo(){
    let claimId = document.getElementById("claimIdInput").value;
    console.log(claimId);
    // let employeeId = document.getElementById("employeeIdInput").value;
    // console.log(employeeId);
    // let amount = document.getElementById("amountInput").value;
    // console.log(amount);
    // let description = document.getElementById("descriptionInput").value;
    // console.log(description);
    // let date = document.getElementById("dateInput").value;
    // console.log(date);
    // let location = document.getElementById("locationInput").value;
    // console.log(location);
    // let dateCreated = document.getElementById("dateCreatedInput").value;
    // console.log(dateCreated);
    // let approval = document.getElementById("approvalInput").value;
    // console.log(approval);
    let handlerComment = document.getElementById("handlerCommentInput").value;
    console.log(handlerComment);


    let url = "http://localhost:8080/claim/approve/" + claimId;
    let response = await fetch(url, {
    method: "PATCH",
    headers:{"Content-Type": 'application/json'},
    body: JSON.stringify({"handlerComment":handlerComment})
    });


    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        //populateApproveReimbursementData(body);
    }
    else{
        alert("Error Attempting to update pending claim.");
    }
}


async function updateDenyClaimInfo(){
    let claimId = document.getElementById("claimIdInput").value;
    console.log(claimId);
    // let employeeId = document.getElementById("employeeIdInput").value;
    // console.log(employeeId);
    // let amount = document.getElementById("amountInput").value;
    // console.log(amount);
    // let description = document.getElementById("descriptionInput").value;
    // console.log(description);
    // let date = document.getElementById("dateInput").value;
    // console.log(date);
    // let location = document.getElementById("locationInput").value;
    // console.log(location);
    // let dateCreated = document.getElementById("dateCreatedInput").value;
    // console.log(dateCreated);
    // let approval = document.getElementById("approvalInput").value;
    // console.log(approval);
    let handlerComment = document.getElementById("handlerCommentInput").value;
    console.log(handlerComment);


    let url = "http://localhost:8080/claim/deny/" + claimId;
    let response = await fetch(url, {
    method: "PATCH",
    headers:{"Content-Type": 'application/json'},
    body: JSON.stringify({"handlerComment":handlerComment}) //"employeeId":employeeId, "amount":amount, "description":description, "date":date, "location":location, "dateCreated":dateCreated, "approval":approval, "handlerComment":handlerComment
    });


    if (response.status === 200){
        let body = await response.json();
        //populateDenyReimbursementdata(body)
    }
    else{
        alert("Error attempting to update pending claim.");
    }
}

//#############################  APPROVE AND DENY POPULATE  ######################################################################################################


function populateDenyClaimData(responseBody){
    for(let claim of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td><td>${claim.employeeId}</td><td>${claim.amount}</td><td>${claim.description}</td><td>${claim.date}</td><td>${claim.location}</td><td>${claim.dateCreated}</td><td>${claim.approval}</td><td>${claim.handlerComment}</td>`;
        console.log(tableRow);
        currentClaimPending.appendChild(tableRow);
        console.log(currentClaimPending);
    }
}


function populateApproveClaimData(responseBody){
    for (let claim of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td><td>${claim.employeeId}</td><td>${claim.amount}</td><td>${claim.description}</td><td>${claim.date}</td><td>${claim.location}</td><td>${claim.dateCreated}</td><td>${claim.approval}</td><td>${claim.handlerComment}</td>`;
        console.log(tableRow);
        currentClaimPending.appendChild(tableRow);
        console.log(currentClaimPending);
    }
}

//######################################   DEBRIEFS    #############################

async function getDebriefData(){
    let url= "http://localhost:8080/employee/debriefs/" + claimEmployeeDropDown.value;
    let response = await fetch(url);
    console.log(claimEmployeeDropDown.value);

    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateDebriefData(body);
    }
    else{
        alert("there was a problem trying to get the debrief data");
    }
}



function populateDebriefData(responseBody){
    // let DebriefemployeeId = 
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
        getDebriefData();
    }
    else{
        debriefTable.style.display = "none";
    }
}

//#############################################    ######################################
async function GrabAllEmployeeInfo(){
    let url = "http://localhost:8080/employee/list"

    let response = await fetch(url)
    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateEmployeeDropDown(body);
    }
    else{
        alert("problem trying to receive the employee information for claim");
    }
}

function populateEmployeeDropDown(employeeList){
    claimEmployeeDropDown.innerHTML = '';
    for (let employee of employeeList){
        if (employee.handler == false){
            let dropdownOptions = document.createElement("option");
            dropdownOptions.innerText = `${employee.firstName} ${employee.lastName}`;
            dropdownOptions.value = `${employee.employeeId}`;
            claimEmployeeDropDown.append(dropdownOptions);
        }
    }


}
GrabAllEmployeeInfo();


//####################################################     ###########################
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
        alert("problem trying to obtain the employe data");
    }
}

function populateUsername(employee){
    headerUsername.innerText = `${employee.username}`;
    console.log(headerUsername);
}

getAllEmployeeData();


//##############################  ################################################
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

function toggleLeaderBoardData(){
    if(leaderTable.style.display === "none"){
        leaderTable.style.display = "block";
        getAllLeaderBoardInfo();
    }
    else{
        leaderTable.style.display = "none";
    }
}



























































// async function  createUserPendingClaimForm(){
//     //clear the table
//     let pendingTable = document.getElementById(""); //Add unique id name to be used in html...
//     pendingTable.innerHTML = '';

//     let url = "" + claimId;
//     const the_claim = await fetch(url).then(response => {return response.json()});
//     for(aClaimId in the_claim){
//         let aClaimObject = the_claim[aClaimId]
//         let claimStatus = aClaimId.if_approved;
//         if(reimbursementStatus == "pending"){
//             let claimId = aClaimObject.claimId;
//             let userId = aClaimObject.userId;
//             let employeeId = aClaimObject.employeeId;
//             let amount = aClaimObject.amount;
//             let description = aClaimObject.description;
//             let dateOfOccurrence = aClaimObject.description;
//             let locationOfOccurrence = aClaimObject.locationOfOccurrence;
//             let dateTimeOfCreation = aClaimObject.dateTimeOfCreation;
//             let approval = aClaimObject.approval;
//             let handlerComment = aClaimObject.handlerComment;


//             let row = pendingTable.insertRow();
//             let first = row.insertCell(0);
//             let second = row.insertCell(1);
//             let third = row.insertCell(2);
//             let fourth = row.insertCell(3);
//             let fifth = row.insertCell(4);
//             let sixth = row.insertCell(5);
//             let seventh = row.insertCell(6);
//             let eigth = row.insertCell(7);
//             let ninth = row.insertCell(8);
//             let tenth = row.insertCell(9);
//             let eleventh = row.insertCell(10); //the cell for the radio buttons.
            


//             first.innerHTML = claimId;
//             second.innerHTML = userId;
//             third.innerHTML = employeeId;
//             fourth.innerHTML = amount;
//             fifth.innerHTML = description;
//             sixth.innerHTML = dateOfOccurrence;
//             seventh.innerHTML = locationOfOccurrence;
//             eigth.innerHTML = dateTimeOfCreation;
//             ninth.innerHTML = approval;
//             tenth.innerHTML = handlerComment;

//             eleventh.setAttribute("id", claimId);
//             eleventh.innerHTML = 
//             `<div class="form-check form-check-inline">
//                 <input class="form-check-input" type="radio" name="` + claimId + `" id="` + claimId + `pending" checked = true value="option1">
//                 <label class="form-check-label" for="inlineRadio1">Pending</label>
//             </div>
//             <div class="form-check form-check-inline">
//                 <input class="form-check-input" type="raido" name="` + claimId + `" id="` + claimId + `approval" value="option2">
//                 <label class="form-check-label" for="inlineRadio2">Approve</label>
//             </div>
//             <div class="form-check form-check-inline">
//                 <input class="form-check-input" type="radio" name="` + claimId + ` id=" ` + claimId + `disapproval" value="option3">
//                 <label class="form-check-label" for="inlineRadio2">Disapprove</label>
//             </div>
//             `

//             //To add a comment section on the table for the shield handler
//             tenth.innerHTML = `<div><input type="text" id=" ` + claimId + `comment"></div>`
//         };
//     }
// }
// createUserPendingClaimForm()
