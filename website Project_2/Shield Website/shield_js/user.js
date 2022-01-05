//These are the unique ID names for the elements for our information to be grabbed from our database...
const userTable = document.getElementById("userTable");
const userTableBody = document.getElementById("userTableBody");
const claimTable = document.getElementById("claimTable");
const claimTableBody = document.getElementById("claimTableBody");
const username = sessionStorage.getItem("username");


function logout(){
    sessionStorage.clear();
    window.location.href = "shield_js/user.js"
}
//Give each a unique id name for E2E testing, just for consideration... 


//function to grab the user information...
async function getAllUserData(){
    let url = "";
    let response = await fetch(url);

    if (response.status === 200){
        let body = await response.json();
        console.log(body);
        //populateUserData(body);
        //getAllClaimInfo();
    }
}

//function to grab all the claim information from the specific user by their user_Id
async function getAllClaimInfo(){
    let userId = sessionStorage.getItem("userId");
    let url = "" + userId;
    let response = await fetch(url);

    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        //populateClaimData(body);
    }
    else{
        alert("There was a problem trying to receive the claim information: apologies!");
    }
}

//function to grab the user information data...
function populateUserData(user){
    let tableRow = document.createElement("tr");
    tableRow.innerHTML = ''
    tableRow.innerHTML = `<td>${user.userId}</td><td>${user.username}</td><td>${user.passcode}</td><td>${user.firstName}</td><td>${user.lastName}</td>`;
    userTableBody.append(tableRow);
    sessionStorage.setItem("userId", user.userId);
}

//function to grab the claim information for the user...
function populateClaimData(responseBody){
    for(let claim of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td>
                               <td>${claim.userId}</td>
                               <td>${claim.employeeId}</td>
                               <td>${claim.amount}</td>
                               <td>${claim.description}</td>
                               <td>${claim.dateOfOccurrence}</td>
                               <td>${claim.locationOfOccurrence}</td>
                               <td>${claim.dateTimeOfCreation}</td>
                               <td>${claim.approval}</td>
                               <td>${claim.handlerComment}</td>`
        console.log(tableRow);
        claimTableBody.append(tableRow);
        console.log(claimTableBody);
    }
}
getAllUserData();