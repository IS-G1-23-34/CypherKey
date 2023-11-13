/*document.getElementById("generate").addEventListener("click", function() {
    const length = document.getElementById("passwordLength").value
    const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+[]{}|;:,.<>?";
    let password = "";

    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * charset.length);
        password += charset.charAt(randomIndex);
    }

    document.getElementById("password").textContent = password ;
});*/
let checkboxes = document.querySelectorAll('input[type="checkbox"]');
let miSelect = document.getElementById("selectNumero");

//Para marcar la opcion que llegue
function marcarOpcion(min, may, num, spe) {

    document.getElementById("checkmin").checked = min === "true";
    document.getElementById("checkmay").checked = may === "true";
    document.getElementById("checknum").checked = num === "true";
    document.getElementById("checkspe").checked = spe === "true";

}
function cargarOpcion(opcion){
    let opciones = document.getElementsByName("option");
    switch (opcion){
        case "personalizado":
            opciones[0].checked = true;
            break;
        case "recomendado":
            opciones[1].checked = true;
            break;
        case "legible":
            opciones[2].checked = true;
            break;
        case "pin":
            opciones[3].checked = true;
            break;
    }
}

function selectOption(option) {
    switch (option){
        case "personalizado":
            break;
        case "recomendado":
            miSelect.setAttribute("value", "14");
            document.getElementById('slider').value = 14;
            document.getElementById('selectNumero').value = 14;
            marcarOpcion("true", "true", "true", "true");
            break;
        case "legible":
            miSelect.setAttribute("value", "12");
            document.getElementById('slider').value = 12;
            document.getElementById('selectNumero').value = 12;
            marcarOpcion("true", "true", "true", "false");
            break;
        case "pin":
            miSelect.setAttribute("value", "4");
            document.getElementById('slider').value = 4;
            document.getElementById('selectNumero').value = 4;
            marcarOpcion("false", "false", "true", "false");
            break;
    }

}

function validarUltimaCheckbox() {
    let ultimaCheckbox = checkboxes[checkboxes.length - 1];
    let casillasActivadas = 0;
    document.getElementsByName("option")[0].checked = true;
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            casillasActivadas++;
        }
    });
    if(casillasActivadas <= 0){
        mostrarAlerta();
        return false;
    }
    return true;
}

function mostrarAlerta() {
    let alerta = document.getElementById('alertaNoCasillasActivas');
    alerta.style.display = 'block';
    setTimeout(function() {
        alerta.style.display = 'none';
    }, 3000); // Ocultar el toast después de 3 segundos
}



function updateNumber(value) {
    document.getElementsByName("option")[0].checked = true;
    document.getElementById('slider').value = value;
    alertaUnder8(value);
}

function updateSlider(value) {
    document.getElementsByName("option")[0].checked = true;
    document.getElementById('selectNumero').value = value;
    alertaUnder8(value);
}

function alertaUnder8(value){
    let alerta = document.getElementById('alertaUnder8');
    if (value < 8)
        alerta.style.display = 'block';
        setTimeout(function() {
            alerta.style.display = 'none';
        }, 3000); // Ocultar el toast después de 3 segundos

}
//Funcion para copiar portapapeles
document.getElementById("copyButton").addEventListener("click", function (){
    const password = document.getElementById("password");
    const passwordText= password.textContent;

    //Crear un elemento de entrada de texto temporal
    const tempInput = document.createElement("input");
    tempInput.setAttribute("value", passwordText);
    document.body.appendChild(tempInput);

    //Seleccionar y copiar el texto al portapapeles
    tempInput.select();
    document.execCommand("copy");

    //Eliminar temporal
    document.body.removeChild(tempInput);

    const copyMessage = document.getElementById("copyMessage");
    copyMessage.style.display = "block";

    // Ocultar el mensaje
    setTimeout(function() {
        copyMessage.style.display = "none";
    }, 500);


})