//These are the unique ID names for the elements for our information to be grabbed from our database...
const userTable = document.getElementById("userTable");
const userTableBody = document.getElementById("userBody");
const claimTable = document.getElementById("claimTable");
const claimTableBody = document.getElementById("claimBody");
const userId = sessionStorage.getItem("userId");


function logout(){
    sessionStorage.clear();
    window.location.href = "../index.html"
}
//Give each a unique id name for E2E testing, just for consideration... 


//function to grab the user information...
async function getAllUserData(){
    let url = "http://localhost:8080/user/" + userId;
    let response = await fetch(url);

    if (response.status === 200){
        let body = await response.json();
        console.log(body);
        populateUserData(body);
        getAllClaimInfo();
    }
}

//function to grab all the claim information from the specific user by their user_Id
async function getAllClaimInfo(){
    let url = "http://localhost:8080/user/claims/" + userId;
    let response = await fetch(url);
    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateClaimData(body);
    }
    else{
        alert("There was a problem trying to receive the claim information: apologies!");
    }
}

//function to grab the user information data...
function populateUserData(user){
    let tableRow = document.createElement("tr");
    tableRow.innerHTML = `<td>${user.userId}</td><td>${user.username}</td><td>${user.firstName}</td><td>${user.lastName}</td>`;
    userTableBody.append(tableRow);
}

//function to grab the claim information for the user...
function populateClaimData(responseBody){
    for(let claim of responseBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${claim.claimId}</td>
                               <td>${claim.employeeId}</td>
                               <td>${claim.amount}</td>
                               <td>${claim.description}</td>
                               <td>${claim.dateOfOccurrence}</td>
                               <td>${claim.locationOfOccurrence}</td>
                               <td>${claim.dateTimeOfCreation}</td>
                               <td>${claim.approval}</td>
                               <td>${claim.handlerComment}</td>`
        claimTableBody.append(tableRow);
    }
}
getAllUserData();