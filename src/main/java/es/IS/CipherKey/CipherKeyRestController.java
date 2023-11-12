package es.IS.CipherKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CipherKeyRestController {

    @GetMapping("/generacion")
    @ResponseBody
    public String generacion(@RequestParam int length) {
        String password = Generador.generador(length);
        return password;
    }

    @PostMapping("/comprobacion")
    @ResponseBody
    public boolean comprobacion(@RequestBody String cadena){
        Comprobador cadenaAComprobar = new Comprobador(cadena);
        return cadenaAComprobar.comprobadorContrasena();
    }

}
