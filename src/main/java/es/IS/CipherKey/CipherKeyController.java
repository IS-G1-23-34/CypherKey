package es.IS.CipherKey;

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

    @GetMapping("/comprobacion")
    public String comprobacion(Model model) {
        model.addAttribute("esSeguro", "\"\"");

        return "comprobacion";
    }

    @GetMapping("/generacion")
    public String generacion(Model model) {
        model.addAttribute("cadenaSegura", Generador.generador());
        return "generacion";
    }

    @PostMapping("/comprobacion")
    public String comprobacionPost(Model model, @RequestParam String cadena){
        Comprobador cadenaAComprobar = new Comprobador(cadena);
        model.addAttribute("esSeguro", cadenaAComprobar.comprobadorContrasena());
        return "comprobacion";
    }







}
