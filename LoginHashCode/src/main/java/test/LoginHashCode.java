package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class LoginHashCode {

	public static void main(String[] args) {
		Map<String, String> hm= new HashMap<String, String>();
		Map<String, String> um= new HashMap<String, String>();
		
		Scanner sc=new Scanner(System.in);
		int c=0;
		do {
			System.out.println("\n1. register\n2. Verify\n3. Display all users\n4. Display hashcode\n5. Exit");
			System.out.println("eneter choice: ");
			c=sc.nextInt();
			switch (c) {
			case 1:
				sc.nextLine();
				System.out.println("enter username:");
				String u=sc.nextLine();
				System.out.println("enter password:");
				String p=sc.nextLine();
				String hashedPass = hashPassword(p);
				hm.put(u, hashedPass);
				um.put(u, p);
				break;
			case 2:
				sc.nextLine();
				System.out.println("enter username:");
				u=sc.nextLine();
				System.out.println("enter password:");
				p=sc.nextLine();
				hashedPass = hashPassword(p);
				boolean isPasswordCorrect = verifyPassword(p,hashedPass);

		        if (isPasswordCorrect) {
		            System.out.println("Login successful!");
		        } else {
		            System.out.println("Login failed. Incorrect password.");
		        }

				break;
			case 3:
				System.out.println(um);
				break;
			case 4:
				System.out.println(hm);
				break;
			case 5:
				System.out.println("thanks.....");
				break;
			default:
				break;
			}
		} while (c!=5);
		
		
		
		
		
		
//		// Hardcoded values for demonstration purposes
//        String hardcodedUsername = "example_user";
//        String hardcodedPassword = "example_password";
//
//        // Hash the hardcoded password
//        String hashedPassword = hashPassword(hardcodedPassword);
//        hm.put(hardcodedUsername, hashedPassword);
//        System.out.println(hm);
//        System.out.println("Hardcoded Hashed Password: " + hashedPassword);
//
//        // Simulate a login attempt with the entered password
//        String enteredPassword = "example_password";
//        boolean isPasswordCorrect = verifyPassword(enteredPassword, hashedPassword);
//
//        if (isPasswordCorrect) {
//            System.out.println("Login successful!");
//        } else {
//            System.out.println("Login failed. Incorrect password.");
//        }
	}
	
	
	
	private static String hashPassword(String plainPassword) {
        // Generate a random salt
        String salt = BCrypt.gensalt();

        // Hash the password with the salt
        return BCrypt.hashpw(plainPassword, salt);
    }

    private static boolean verifyPassword(String enteredPassword, String storedHashedPassword) {
        // Use BCrypt.checkpw() to verify the password
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }

}
