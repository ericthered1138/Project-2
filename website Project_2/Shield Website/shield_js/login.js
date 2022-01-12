async function Login(){
    let url = "http://localhost:8080/login";
    const username = document.getElementById("username");
    const password = document.getElementById("password");

    userJSON = JSON.stringify({"username": username.value.toLowerCase(), "passcode": password.value});
    console.log(userJSON);

    let response = await fetch(url, {
        method: "POST",
        cache: "no-cache",
        headers:{"Content-Type": 'application/json'},
        body:userJSON});
    
        
    if (response.status == 200){
        let body = await response.json();
        window.sessionStorage.setItem("userId", body["userId"]);
        window.location.href = "shield_html/user.html";
    }
    else{
        LoginShieldAgent()
    }

}

async function LoginShieldAgent(){
    let url = "http://localhost:8080/employee/login";
    const username = document.getElementById("username");
    const password = document.getElementById("password");

    shieldAgentJSON = JSON.stringify({"username": username.value.toLowerCase(), "passcode": password.value});
    console.log(shieldAgentJSON);

    let response = await fetch(url, {
        cache: "no-cache",
        method: "POST",
        headers:{"Content-Type": 'applicaton/json'},
        body:shieldAgentJSON})
    
    console.log(response);

    if (response.status == 201){
        let body = await response.json();
        if (body["handler"]){
            window.sessionStorage.setItem("employeeId", body["employeeId"]);
            window.location.href = "shield_html/shield_handler.html";
        }
        else{
            window.sessionStorage.setItem("employeeId", body["employeeId"]);
            window.location.href = "shield_html/shield_agent.html";
        }
    }
    else{
        alert("Invalid username or password")
        console.log(response.username, response.password);
    }
}

async function CreateUserAccount(){
    let url ="http://localhost:8080/newUser";
    const newUserFirstName = document.getElementById("signUpFirstName");
    const newUserLastName = document.getElementById("signUpLastName");
    const newUserUsername = document.getElementById("signUpUsername");
    const newUserPassword = document.getElementById("signUpPassword");
    const confirmNewUserPassword = document.getElementById("confirmSignUpPassword");
    console.log(newUserPassword.value);
    console.log(confirmNewUserPassword.value);

    if(newUserPassword.value == confirmNewUserPassword.value){
        newUserJSON = JSON.stringify({"userid": 0, "username": newUserUsername.value, "passcode": newUserPassword.value, "firstName": newUserFirstName.value, "lastName": newUserLastName.value});

        let response = await fetch(url, {
            cache: "no-cache",
            method: "POST",
            headers:{"Content-Type": 'application/json'},
            body: newUserJSON})

            if(response.status === 201){
                console.log(response.json());
                alert("Successfully created account")
            }
            else if(response.status === 404){
                alert("Username is taken.");
            }
            else{
                alert("There was an issue");
            }
    }
    else{
        alert("Password does not match")
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("#loginForm");
    const createAccountForm = document.querySelector("#createAccountForm");

    document.querySelector("#linkCreateAccount").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.add("form--hidden");
        createAccountForm.classList.remove("form--hidden");
    });

    document.querySelector("#linkLogin").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.remove("form--hidden");
        createAccountForm.classList.add("form--hidden");
    });
});

function clearCreateAccountData(){
    document.getElementById("createAccountForm").reset();
}

function clearLoginFormData(){
    document.getElementById("loginForm").reset();
}