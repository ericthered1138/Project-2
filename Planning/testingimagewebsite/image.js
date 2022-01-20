async function getEmployeeImage(){
    let url = "http://localhost:8080/employee/image/1";
    console.log(url);
    let response = await fetch(url);
    console.log(response);

    if(response.status === 200){
        // const image_blob = await response.blob();
        // const image_text = await image_blob.text();
        const image_text = await response.text();
        const image_Element = document.createElement('img');
        image_Element.src = "data:image/gif;base64,"+ image_text;
        document.body.appendChild(image_Element);
    }
    else{
        alert("There was a problem trying to obtain the employe data: apologies!");
    }
}

getEmployeeImage()


// function delay(time) {
//     return new Promise(resolve => setTimeout(resolve, time));
//   }
  
async function previewFile() {
  let file    = document.getElementById('portrait_input').files[0];
  let reader  = new FileReader();
  let format = "data:image/gif;base64,";
  let length = format.length
  let base64gif;

  reader.addEventListener("load", async function () {
    base64gif = reader.result;
    console.log(base64gif.slice(11, 14));

    if (base64gif.length < 1_000_000 && base64gif.slice(11, 14) === "gif"){
      await fetch(
        "http://localhost:8080/employee/image/" + "1", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: String(base64gif).slice(length)
        })

        getEmployeeImage();
    
    }
    else{
      alert("File too large")
    }
  }, false);

  if (file) {
    reader.readAsDataURL(file);
  }
}
