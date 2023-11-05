package driver;

import java.security.SecureRandom;
import java.util.Random;

public class DriverPassaANDEmail {
    private static String randomName;
    
    //============================
    //Random Email Domain Generation
    //============================
    public static String generateRandomEmail() {
        Random random = new SecureRandom();
        String[] domains = {"gmail", "yahoo", "outlook", "example", "sample", "test"};
        String randomDomain = domains[random.nextInt(domains.length)]; //randomly select one of the domains
        return randomDomain.toString();
    }
    
    //============================
    //Random Your Email Generation
    //============================
    public static String generateRandomName() {
        String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NUMERALS = "0123456789";
        String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder();
        Random random = new SecureRandom();

        String characters = CAPITAL_LETTERS + NUMERALS + LOWERCASE_LETTERS;
        int nameLength = random.nextInt(6) + 3; // Random name length between 5 and 10 characters

        for (int i = 0; i < nameLength; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }

        randomName = name.toString(); // Store the generated name
        return randomName;
    }
    
    //============================
    //Random Password Generation
    //============================
    public static String generateRandomPassword() {
        if (randomName == null) {
            randomName = generateRandomName(); //call it if the name is not generated
        }

        String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NUMERALS = "0123456789";
        String CYRILLIC_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();

        //1 Capital letter.
        password.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));

        //1 Numeral.
        password.append(NUMERALS.charAt(random.nextInt(NUMERALS.length())));

        //1 letter of your email (use the stored randomName).
        password.append(randomName.charAt(random.nextInt(randomName.length())));

        //1 cyrillic character.
        password.append(CYRILLIC_CHARACTERS.charAt(random.nextInt(CYRILLIC_CHARACTERS.length())));

        //remaining characters (length at least 10)
        while (password.length() < 10) {
            String characters = CAPITAL_LETTERS + NUMERALS + LOWERCASE_LETTERS + CYRILLIC_CHARACTERS;
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
    
    public static String getRandomName() {
        if (randomName == null) {
            randomName = generateRandomName();
        }
        return randomName;
    }
}


   

