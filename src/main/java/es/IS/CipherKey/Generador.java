package es.IS.CipherKey;

import java.util.Random;

public class Generador {

    static String generador(int length, boolean minusculas, boolean mayusculas, boolean numeros, boolean specialChars){
        String nocaps = "abcdefghijklmnopqrstuvwxyz";
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nums = "0123456789";
        String special = "!@#$%^&*()_+[]{}|;:,.<>?";
        StringBuilder password= new StringBuilder();

        String charset = "";
        if (minusculas){
            charset += nocaps;
        }
        if (mayusculas){
            charset += caps;
        }
        if (numeros){
            charset += nums;
        }
        if (specialChars){
            charset += special;
        }

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
