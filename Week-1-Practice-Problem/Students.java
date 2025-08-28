public class Students {
	public static void names(String[] students) {
		for (String student : students) {
			String[] nameParts = student.trim().split("\\s+");
			System.out.println("First name: " + nameParts[0]);
			System.out.println("Last name: " + nameParts[nameParts.length - 1]);
		}
	}

	public static void lname(String[] students) {
		String max = "";
		for (String student : students) {
			if (student.trim().length() > max.length()) {
				max = student;
			}
		}
		System.out.println(max + " has the longest name.");
	}

	public static void sname(String[] students) {
		int count = 0;
		for (String student : students) {
			char firstChar = student.trim().charAt(0);
			if (firstChar == 'S' || firstChar == 's') {
				System.out.println(student + " starts with 'S'.");
				count++;
			}
		}
		System.out.println("Total names starting with 'S': " + count);
	}

	public static void main(String[] args) {
		String[] students = {
			"Arpit Singh",
			"Yatindra Rai",
			"Shameek Panesar",
			"Shresth Vardhan"
		};
		lname(students);
		sname(students);
		names(students);
	}
}