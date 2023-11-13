package es.IS.CipherKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CipherKeyRestController {

    @GetMapping("/generacion")
    @ResponseBody
    public ResponseEntity<String> generacion(@RequestParam int length, @RequestParam boolean minusculas, @RequestParam boolean mayusculas, @RequestParam boolean numeros, @RequestParam boolean specialChars, @RequestParam String option) {
        if (minusculas || mayusculas || numeros || specialChars) {
            String password = Generador.generador(length, minusculas, mayusculas, numeros, specialChars, option); // en caso de pasar un String que no es valido, te devolverá la contraseña recomendada
            return new ResponseEntity<>(password, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @PostMapping("/comprobacion")
    @ResponseBody
    public ResponseEntity<Boolean> comprobacion(@RequestBody String cadena){
        Comprobador cadenaAComprobar = new Comprobador(cadena);
        return new ResponseEntity<>(cadenaAComprobar.comprobadorContrasena(), HttpStatus.OK);
    }

}
