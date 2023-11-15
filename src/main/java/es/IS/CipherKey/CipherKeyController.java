package es.IS.CipherKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CipherKeyController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/documentacion")
    public String documentacion() {
        return "documentacion";
    }

    @GetMapping("/comprobacion")
    public String comprobacion(Model model) {
        model.addAttribute("esSeguro", "\"\"");

        return "comprobacion";
    }

    @GetMapping("/generacion")
    public String generacion(Model model) {
        model.addAttribute("cadenaSegura", "Haga clic en el botón para generar una contraseña.");
        model.addAttribute("defLength", 14);
        model.addAttribute("defmin", true);
        model.addAttribute("defmay", true);
        model.addAttribute("defnum", true);
        model.addAttribute("defspe", true);
        model.addAttribute("opcion", "recomendada");
        return "generacion";
    }

    @GetMapping("/generar")
    public String generar(Model model, @RequestParam int length, @RequestParam(defaultValue = "false") boolean minusculas, @RequestParam(defaultValue = "false") boolean mayusculas, @RequestParam(defaultValue = "false") boolean numeros, @RequestParam(defaultValue = "false") boolean specialChars, @RequestParam String option) {
        if (!(minusculas || mayusculas || numeros || specialChars)) { // en caso de quitar t0do, se pone t0do a true, comprobar en html
            minusculas = true;
            mayusculas = true;
            numeros = true;
            specialChars = true;
        }
        model.addAttribute("cadenaSegura", Generador.generador(length, minusculas, mayusculas, numeros, specialChars, option)); // en caso de pasar un String que no es valido, te devolverá la contraseña recomendada

        model.addAttribute("defLength", length);
        model.addAttribute("defmin", minusculas);
        model.addAttribute("defmay", mayusculas);
        model.addAttribute("defnum", numeros);
        model.addAttribute("defspe", specialChars);
        model.addAttribute("opcion", option);
        return "generacion";
    }

    @PostMapping("/comprobacion")
    public String comprobacionPost(Model model, @RequestParam String cadena){
        Comprobador cadenaAComprobar = new Comprobador(cadena);
        model.addAttribute("esSeguro", cadenaAComprobar.comprobadorContrasena());
        return "comprobacion";
    }
}
