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
    });