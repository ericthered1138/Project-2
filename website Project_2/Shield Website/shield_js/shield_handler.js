const claimTableBody = document.getElementById("claimBody");
const claimTable = document.getElementById("claimTable");
const employeeId = sessionStorage.getItem("employeeId");

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