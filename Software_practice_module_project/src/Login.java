import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		Scanner scannerUsername = new Scanner(System.in);
		Scanner scannerPassword = new Scanner(System.in);
		String usernameInput;
		String passwordInput;
		System.out.println("Please type username");
		usernameInput = scannerUsername.nextLine();
		System.out.println("Please type password");
		passwordInput = scannerPassword.nextLine();
		logInCheck(usernameInput, passwordInput);
	}

	public static void logInCheck(String passwordInput, String usernameInput) {
		if (passwordInput.equals("1") && (usernameInput.equals("1"))) {
			System.out.println("NICE");
		} else {
			System.out.println("Fail");
		}
	}

}

