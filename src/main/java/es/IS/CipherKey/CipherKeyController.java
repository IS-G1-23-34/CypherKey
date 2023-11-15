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
        return "generacion";
    }
}
