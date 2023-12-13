package es.IS.CipherKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Generador {
    public static String generateVerifiedPassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars, String option, String text, boolean placeTextInFront) {
        String generatedPassword;
        Comprobador cadenaAComprobar;
        boolean esSegura;
        do {
            generatedPassword = generatePassword(length, useLowercase, useUppercase, useNumbers, useSpecialChars, option, text, placeTextInFront);
            cadenaAComprobar = new Comprobador(generatedPassword);
            if(option.equals("recomendada") || (length >= 8 && useLowercase && useUppercase && useNumbers && useSpecialChars)){ // Si es menor que 8 nunca será segura, por lo que devuelve la primera contraseña que devuelva
                esSegura = cadenaAComprobar.comprobadorContrasena();
            }else{
                return generatedPassword;
            }
        }while (!esSegura);

        return generatedPassword;
    }
    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars, String option, String text, boolean placeTextInFront) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()_+[]{}|;:,.<>?";

        StringBuilder charset = new StringBuilder();
        StringBuilder passwordCharset = new StringBuilder();
        int elements = 0;

        switch (option.toLowerCase()) {
            case "personalizado":
                if (useLowercase) {
                    charset.append(lowercaseChars);
                    passwordCharset.append(generateRandomChar(lowercaseChars));
                    elements ++;
                }
                if (useUppercase) {
                    charset.append(uppercaseChars);
                    passwordCharset.append(generateRandomChar(uppercaseChars));
                    elements ++;
                }
                if (useNumbers) {
                    charset.append(numberChars);
                    passwordCharset.append(generateRandomChar(numberChars));
                    elements ++;
                }
                if (useSpecialChars) {
                    charset.append(specialChars);
                    passwordCharset.append(generateRandomChar(specialChars));
                    elements ++;
                }
                break;
            case "recomendada":
                length = 14;
                charset.append(lowercaseChars).append(uppercaseChars).append(numberChars).append(specialChars);
                passwordCharset.append(generateRandomChar(lowercaseChars)).append(generateRandomChar(uppercaseChars)).append(generateRandomChar(numberChars)).append(generateRandomChar(specialChars));
                elements += 4;
                break;
            case "legible":
                length = 12;
                charset.append(lowercaseChars).append(uppercaseChars).append(numberChars);
                passwordCharset.append(generateRandomChar(lowercaseChars)).append(generateRandomChar(uppercaseChars)).append(generateRandomChar(numberChars));
                elements +=3;
                break;
            case "pin":
                length = 4;
                charset.append(numberChars);
                passwordCharset.append(generateRandomChar(numberChars));
                elements ++;
                break;
        }

        if(length < 1){
            length = 1;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(generateRandomChar(charset.toString()));
        }


        Set<Integer> usedIndexes = new HashSet<>(); // Almacena los índices ya utilizados
        Set<Integer> usedIndexesElem = new HashSet<>();
        int randomElementPass = 0;
        int randomElementElem = 0;
        SecureRandom random;
        for (int i = 0; i < Math.min(elements, length); i++) {
            random = new SecureRandom();
            do {
                randomElementPass = random.nextInt(length);
            } while (usedIndexes.contains(randomElementPass) );
            usedIndexes.add(randomElementPass);
            random = new SecureRandom();
            do {
                randomElementElem = random.nextInt(passwordCharset.length());
            } while (usedIndexesElem.contains(randomElementElem) );
            usedIndexesElem.add(randomElementElem);
            password.replace(randomElementPass, randomElementPass + 1, String.valueOf(passwordCharset.charAt(randomElementElem)));
        }


        StringBuilder result = new StringBuilder();
        if (placeTextInFront) {
            result.append(text).append(password);
        } else {
            result.append(password).append(text);
        }

        return result.toString();
    }

    private static char generateRandomChar(String charset) {
        SecureRandom random = new SecureRandom();
        int randomIndex = random.nextInt(charset.length());
        return charset.charAt(randomIndex);
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        String generatedPassword = generateVerifiedPassword(8, true, true, true, true, "recomendada", "", true);
        System.out.println("Generated Password: " + generatedPassword);
    }
}

