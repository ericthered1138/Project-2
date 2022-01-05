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
        body:userJSON}).then(response => {return response.json()});
    
    console.log(response);

    if(Object.keys(response).length === 5){
        window.sessionStorage.setItem("userID", response["userID"]);
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
        body:shieldAgentJSON}).then(response => {return response.json()});
    
    console.log(response);

    if(Object.keys(response).length === 7 && response["handler"] == true){
        window.sessionStorage.setItem("employeeID", response["employeeID"]);
        window.location.href = "shield_html/shield_handler.html";

    }else if(Object.keys(response).length === 7){
        window.sessionStorage.setItem("employeeID", response["employeeID"]);
        window.location.href = "shield_html/shield_agent.html";
    }
    else{
        alert("Invalid username or password")
        console.log(response.username, response.password);
    }
}

// async function LoginShieldHandler(){
//     let url = "";
//     const username = document.getElementById("username");
//     const password = document.getElementById("password");

//     sessionStorage.setItem("username", username.value);
//     sessionStorage.setItem("password", password.value);
//     console.log(username.value);
//     console.log(password.value);
//     shieldHandlerJSON = JSON.stringify({"username": username.value.toLowerCase(), "password": password.value});
//     console.log(shieldHandlerJSON);

//     let respose = await fetch(url, {
//         method: "POST", 
//         headers:{"Content-Type": 'application/json'},
//         body: shieldHandlerJSON}).then(response => {return response.json()});

//     if(response.username == username.value.toLowerCase() && response.passcode == password.value && response.handler == true){
//         window.location.href = "/shield_handler.html";
//     }
//     else{
//         alert("Invalid username or password")
//         console.log(response.username, response.password);
//     }
// }


// // Testing for Create Account window in Login Screen
// function setFormMessage(formElement, type, message) {
//     const messageElement = formElement.querySelector(".form__message");

//     messageElement.textContent = message;
//     messageElement.classList.remove("form__message--success", "form__message--error");
//     messageElement.classList.add(`form__message--${type}`);
// }

// function setInputError(inputElement, message) {
//     inputElement.classList.add("form__input--error");
//     inputElement.parentElement.querySelector(".form__input-error-message").textContent = message;
// }

// function clearInputError(inputElement) {
//     inputElement.classList.remove("form__input--error");
//     inputElement.parentElement.querySelector(".form__input-error-message").textContent = "";
// }

// document.addEventListener("DOMContentLoaded", () => {
//     const loginForm = document.querySelector("#login");
//     const createAccountForm = document.querySelector("#createAccount");

//     document.querySelector("#linkCreateAccount").addEventListener("click", e => {
//         e.preventDefault();
//         loginForm.classList.add("form--hidden");
//         createAccountForm.classList.remove("form--hidden");
//     });

//     document.querySelector("#linkLogin").addEventListener("click", e => {
//         e.preventDefault();
//         loginForm.classList.remove("form--hidden");
//         createAccountForm.classList.add("form--hidden");
//     });

//     loginForm.addEventListener("submit", e => {
//         e.preventDefault();

//         // Perform your AJAX/Fetch login

//         setFormMessage(loginForm, "error", "Invalid username/password combination");
//     });

//     document.querySelectorAll(".form__input").forEach(inputElement => {
//         inputElement.addEventListener("blur", e => {
//             if (e.target.id === "signupUsername" && e.target.value.length > 0 && e.target.value.length < 10) {
//                 setInputError(inputElement, "Username must be at least 10 characters in length");
//             }
//         });

//         inputElement.addEventListener("input", e => {
//             clearInputError(inputElement);
//         });
//     });
// });