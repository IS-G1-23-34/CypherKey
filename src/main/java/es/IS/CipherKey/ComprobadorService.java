package es.IS.CipherKey;

import org.springframework.stereotype.Service;

@Service
public class ComprobadorService {
    public ComprobadorService(){

    }

    public boolean comprobarContrasena(String contrasena){
        Comprobador comprobador = new Comprobador(contrasena);

        return comprobador.comprobadorContrasena();
    }
}
