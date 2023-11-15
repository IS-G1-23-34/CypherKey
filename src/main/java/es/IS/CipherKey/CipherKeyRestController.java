package es.IS.CipherKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CipherKeyRestController {
    @PostMapping("/generacion")
    @ResponseBody
    public ResponseEntity<String> generacion(@RequestParam Integer length,
                                             @RequestParam boolean minusculas,
                                             @RequestParam boolean mayusculas,
                                             @RequestParam boolean numeros,
                                             @RequestParam boolean specialChars,
                                             @RequestParam String option) {
        if (minusculas || mayusculas || numeros || specialChars) {
            String password = Generador.generador(length,
                    minusculas,
                    mayusculas,
                    numeros,
                    specialChars,
                    option);
            return new ResponseEntity<>(password, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/comprobacion")
    @ResponseBody
    public ResponseEntity<Boolean> comprobacion(@RequestParam String cadena){
        Comprobador cadenaAComprobar = new Comprobador(cadena);
        return new ResponseEntity<>(cadenaAComprobar.comprobadorContrasena(), HttpStatus.OK);
    }

}
