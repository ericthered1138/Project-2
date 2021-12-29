async function Login(){
    let url = "";
    const username = document.getElementById("username");
    const password = document.getElementById("password");


    sessionStorage.setItem("username", username.value);
    sessionStorage.setItem("password", password.value);
    console.log(username.value);
    console.log(password.value);
    userJSON = JSON.stringify({"username": username.value.toLowerCase(), "password": password.value});
    console.log(userJSON);

    let response = await fetch(url, {
        method: "POST",
        headers:{"Content-Type": 'application/json'},
        body:userJSON}).then(response => {return response.json()});

    if(response.username == username.value.toLowerCase() && response.password == password.value){
        window.location.href = "../html/user.html";
    }
    else{
        LoginShieldAgent()
    }

}

async function LoginShieldAgent(){
    let url = "";
    const username = document.getElementById("username");
    const password = document.getElementById("password");

    sessionStorage.setItem("username", username.value);
    sessionStorage.setItem("password", password.value);
    console.log(username.value);
    console.log(password.value);
    shieldAgentJSON = JSON.stringify({"username": username.value.toLowerCase(), "password": password.value});
    console.log(shieldAgentJSON);

    let response = await fetch(url, {
        method: "POST",
        headers:{"Content-Type": 'applicaton/json'},
        body:shieldAgentJSON}).then(response => {return response.json()});

    if(response.username == username.value.toLowerCase() && response.password == password.value){
        window.location.href = "../shield_agent.html";
    }
    else{
        LoginShieldHandler()
    }
}

async function LoginShieldHandler(){
    let url = "";
    const username = document.getElementById("username");
    const password = document.getElementById("password");

    sessionStorage.setItem("username", username.value);
    sessionStorage.setItem("password", password.value);
    console.log(username.value);
    console.log(password.value);
    shieldHandlerJSON = JSON.stringify({"username": username.value.toLowerCase(), "password": password.value});
    console.log(shieldHandlerJSON);

    let respose = await fetch(url, {
        method: "POST", 
        headers:{"Content-Type": 'application/json'},
        body: shieldHandlerJSON}).then(response => {return response.json()});

    if(response.username == username.value.toLowerCase() && response.password == password.value){
        window.location.href = "../shield_handler.html";
    }
    else{
        alert("Invalid username or password")
        console.log(response.username, response.password);
    }
}

