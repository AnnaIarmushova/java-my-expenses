package Utils;

import java.util.Random;

public class Utils {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String str) {
        this.email = generateRandomString() + str;
    }

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
