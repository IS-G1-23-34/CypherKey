package es.IS.CipherKey;

import java.util.Random;

public class Generador {

    static String generador(int length, boolean minusculas, boolean mayusculas, boolean numeros, boolean specialChars, String opcion){
        String nocaps = "abcdefghijklmnopqrstuvwxyz";
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nums = "0123456789";
        String special = "!@#$%^&*()_+[]{}|;:,.<>?";
        StringBuilder password= new StringBuilder();
        String charset = "";
        switch (opcion){
            case "personalizado":
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
                break;
            default:
            case "recomendado":
                length = 14;
                charset += nocaps;
                charset += caps;
                charset += nums;
                charset += special;
                break;
            case "legible":
                length = 12;
                charset += nocaps;
                charset += caps;
                charset += nums;
                break;
            case "pin":
                length = 4;
                charset += nums;
                break;

        }
        if (length > 30)
            length = 30;
        if (length < 1)
            length = 1;

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
