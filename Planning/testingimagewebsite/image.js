async function getEmployeeImage(){
    let url = "http://localhost:8080/employee/image/1";
    console.log(url);
    let response = await fetch(url);
    console.log(response);

    if(response.status === 200){
        const image_blob = await response.blob();
        const image_text = await image_blob.text();
        const image_Element = document.createElement('img');
        image_Element.src = "data:image/gif;base64,"+ image_text;
        document.body.appendChild(image_Element);
    }
    else{
        alert("There was a problem trying to obtain the employe data: apologies!");
    }
}

getEmployeeImage()


async function previewFile() {
  var file    = document.getElementById('portrait_input').files[0];
  var reader  = new FileReader();
  let format = "data:image/gif;base64,";
  let length = format.length

  reader.addEventListener("load", function () {
    var base64gif = reader.result; // your gif in base64 here
    console.log(String(base64gif).slice(length))
    document.getElementById('base64').innerHTML = base64gif;

    fetch(
      "http://localhost:8080/employee/image/1", {
          method: "POST",
          headers: {"Content-Type": "application/json"},
          body: String(base64gif).slice(length)
      })
  }, false);

  if (file) {
    reader.readAsDataURL(file);
  }
}