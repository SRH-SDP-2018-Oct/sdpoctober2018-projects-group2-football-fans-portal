import java.util.Scanner;

public class HomePage {

	public static void main(String[] args) {
		method1();
	}

	public static void method1() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Football Fans Portal");
		System.out.println("Selection of the options");
		System.out.println("1\t Login");
		System.out.println("2\t Registration");
		System.out.println("3\t Tournament");
		System.out.println("4\t Calendar");
		System.out.println("5\t Teams ");
		System.out.println("Please enter your choice:");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			log_in.method1();
			break;
		case 2:
			Insertando.method1();
			break;
		case 3:
			System.out.println("Tournament");
			break;
		case 4:
			PrintCalendar.method1();
			break;
		case 5:
			team_page.method1();
			break;
		default:
			System.out.println("Invalid choice");

			scanner.close();
		}
	}
}