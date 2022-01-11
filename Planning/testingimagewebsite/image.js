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


function previewFile() {
    var preview = document.querySelector('img');
    var file    = document.querySelector('input[type=file]').files[0];
    var reader  = new FileReader();
  
    reader.addEventListener("load", function () {
      var base64gif = reader.result; // your gif in base64 here
      preview.src = base64gif;
      document.getElementById('base64').innerHTML = base64gif;
    }, false);
  
    if (file) {
      reader.readAsDataURL(file);
    }
  }