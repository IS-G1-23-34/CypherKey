function comprobarPost() {
    let data = "cadena=" + document.getElementById("cadena").value
    fetch("/api/comprobacion", {
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: data,
    })
        .then((response) => response.json())
        .then((seguro) => {
            console.log(seguro);
            fetch("js/particles.json")
                .then((res) => res.json())
                .then((data) => {
                    var file;
                    if (seguro) {
                        file = "/js/success.json"
                        const toast = new bootstrap.Toast(document.getElementById("liveToastSeguro"));
                        toast.show()
                    } else {
                        file = "/js/fail.json"
                        data['particles']['color']['value'] = '#198754'
                        const toast = new bootstrap.Toast(document.getElementById("liveToastNoSeguro"));
                        toast.show()
                    }
                    particlesJS.load('particles-js', file, function() {
                        console.log('callback - particles.js config loaded');
                    });
                });
        });
}

document.getElementById("cadena")
    .addEventListener("keyup", function(event) {
        event.preventDefault();
        if (event.keyCode === 13) {
            document.getElementById("comprobacion-btn").click();
        }
        check()
    });


function check() {
    const cadena = document.getElementById("cadena").value
    if (cadena !== "") {
        const newDiv = document.createElement("div")
        let secure = true
        newDiv.classList.add('alert')
        newDiv.classList.add('alert-danger')
        newDiv.classList.add('mt-2')
        newDiv.role = 'alert'
        newDiv.id = 'alerta'
        if (cadena.length < 8) {
            newDiv.appendChild(document.createTextNode("La longitud es menor que 8"))
            newDiv.appendChild(document.createElement('br'))
            secure = false
        }
        if (!/[A-Z]+/.test(cadena)) {
            newDiv.appendChild(document.createTextNode("No contiene mayusculas"))
            newDiv.appendChild(document.createElement('br'))
            secure = false
        }
        if (!/[a-z]+/.test(cadena)) {
            newDiv.appendChild(document.createTextNode("No contiene minusculas"))
            newDiv.appendChild(document.createElement('br'))
            secure = false
        }
        if (!/[0-9]+/.test(cadena)) {
            newDiv.appendChild(document.createTextNode("No contiene numeros"))
            newDiv.appendChild(document.createElement('br'))
            secure = false
        }
        if (!/[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(cadena)) {
            newDiv.appendChild(document.createTextNode("No contiene caracteres especiales"))
            secure = false
        }
        if (document.getElementById("alerta") != null) {
            document.getElementById("alerta").remove()
        }
        if (!secure) {
            document.getElementById("submit-btn").appendChild(newDiv)
        }
    }
}
