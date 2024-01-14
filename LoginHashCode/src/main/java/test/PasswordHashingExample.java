package test;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingExample {

    public static String hashPassword(String plainPassword) {
        // Generate a random salt
        String salt = BCrypt.gensalt();

        // Hash the password with the salt
        return BCrypt.hashpw(plainPassword, salt);
    }

    public static boolean verifyPassword(String enteredPassword, String storedHashedPassword) {
        // Use BCrypt.checkpw() to verify the password
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }

    public static void main(String[] args) {
        // Example usage
        String passwordToHash = "Pranav";
        
        // Hash the password
        String hashedPassword = hashPassword(passwordToHash);
        System.out.println("Hashed Password: " + hashedPassword);

        // Verify the password
        String enteredPassword = "Pranav";
        boolean isPasswordCorrect = verifyPassword(enteredPassword, hashedPassword);

        if (isPasswordCorrect) {
            System.out.println("Password is correct!");
        } else {
            System.out.println("Incorrect password.");
        }
    }
}