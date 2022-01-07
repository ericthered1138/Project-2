//These are the unique ID names for the elements for our information to be grabbed from our database...
const userTable = document.getElementById("userTable");
const userTableBody = document.getElementById("userBody");
const claimTable = document.getElementById("claimTable");
const claimTableBody = document.getElementById("claimBody");
const headerUsername = document.getElementById("headerUsername");
const userId = sessionStorage.getItem("userId");
const claimModal = document.getElementById("myModal");
const claimEmployeeDropDown = document.getElementById("claimEmployee");


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
        populateUsername(body);
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

//function to grab the username data...
function populateUsername(user){
    headerUsername.innerText = `${user.username}`;
}

//function to grab the claim information for the user...
function populateClaimData(responseBody){
        claimTableBody.innerHTML = '';
        for(let claim of responseBody){
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
    

}

function toggleClaimData()
{
    if (claimTable.style.display === "none"){
        claimTable.style.display="block";
        getAllClaimInfo();
    }
    else{
        claimTable.style.display="none";
    }
}


async function createNewClaim(){
    let url = "http://localhost:8080/claim"
    let employeeId = document.getElementById("claimEmployee").value;
    let amount = document.getElementById("claimAmount");
    let description = document.getElementById("claimDescription");
    let date = document.getElementById("claimDate");
    let location = document.getElementById("claimLocation");
    let approval = "pending";
    let handlerComment = "";
    console.log(employeeId);

    let createClaimJSON = JSON.stringify({"claimId": 0, "userId": parseInt(userId), "employeeId": parseInt(employeeId), "amount": parseInt(amount.value), "description": description.value, "dateOfOccurrence": date.value, "locationOfOccurrence": location.value, "approval": approval, "handlerComment": handlerComment});
    console.log(createClaimJSON);
    document.getElementById("newClaimForm").reset()

    let response = await fetch(url, {
        method: "POST",
        headers:{"Content-Type": 'application/json'},
        body:createClaimJSON})
        
        if (response.status === 201){
            let body = await response.json();
            console.log(body);
        }
        else{
            alert("There was an issue");

    }
}

async function GrabAllEmployeeInfo(){
    let url = "http://localhost:8080/employee/list"

    let response = await fetch(url)
    if(response.status === 200){
        let body = await response.json();
        console.log(body);
        populateEmployeeDropDown(body);
    }
    else{
        alert("There was a problem trying to receive the employee information for the new claims");
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


getAllUserData();
GrabAllEmployeeInfo();