package es.IS.CipherKey;

import org.springframework.stereotype.Service;

@Service
public class GeneradorService {
    public GeneradorService(){

    }

    public String generarContrasena(int length){
        return Generador.generador(length);
    }
}
