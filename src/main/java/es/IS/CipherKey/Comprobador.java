package es.IS.CipherKey;

public class Comprobador {
    private String entrada;

    public Comprobador(String entrada) {
        this.entrada = entrada;
    }

    public boolean comprobadorContrasena(){
        boolean esSeguro = false;

        if (this.entrada.length() >= 8
                && this.entrada.matches(".*[A-Z].*")
                && this.entrada.matches(".*[0-9].*")
                && this.entrada.matches(".*[\\!@\\#\\$%\\^&\\*\\(\\)\\-_\\=\\+\\[\\{\\]\\}\\\\\\|;\\:'\",\\<\\.\\>\\/\\?`~].*")) {
            esSeguro = true;
        }

        return esSeguro;
    }
}
