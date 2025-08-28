import java.util.Scanner;

public class StringInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your full name: ");
		String inputString = sc.nextLine();

		System.out.print("Which programming language do you like the most?: ");
		String language = sc.nextLine();

		System.out.print("How is your programming experience?: ");
		String experience = sc.nextLine();

		System.out.println("You entered: " + inputString);
		System.out.println("Your favorite programming language is: " + language);
		System.out.println("Your programming experience is: " + experience);

		String[] nameParts = inputString.trim().split("\\s+");
		String firstName = nameParts[0];
		String lastName = nameParts[nameParts.length - 1];
		int charCount = experience.replace(" ", "").length();
		String languageUpper = language.toUpperCase();

		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Programming Language (Uppercase): " + languageUpper);
		System.out.println("Total characters in experience (excluding spaces): " + charCount);

		sc.close();
	}
}
