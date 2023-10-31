package es.IS.CipherKey;

import java.util.Random;

public class Generador {

    static String generador(int length){
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+[]{}|;:,.<>?";
        StringBuilder password= new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = chooseRandomCharacter(charset);
            password.append(randomChar);
        }
        return String.valueOf(password);
    }

    private static char chooseRandomCharacter(String str) {
        Random random = new Random();
        int randomIndex = random.nextInt(str.length());
        return str.charAt(randomIndex);
    }

}
