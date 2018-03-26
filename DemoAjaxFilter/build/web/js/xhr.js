/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

console.log("In Console");

var btn = document.getElementById('btn-poem');
var content = document.getElementById('div-poem');

btn.addEventListener('click', function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8084/DemoAjaxFilter/getPoem");
    xhr.onload = function () {

        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var poem = JSON.parse(xhr.responseText);
                console.log(poem);
                poem.forEach((sentence) => {
                    content.innerHTML += sentence + '<br/>';
                });
            } else {
                console.log("ERROR");
            }
        }
    }
    xhr.send();
});
