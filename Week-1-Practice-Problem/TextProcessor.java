import java.util.*;

public class TextProcessor {
	public static String cleanInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			return "";
		}
		input = input.trim().replaceAll("\\s+", " ");
		String firstLetter = input.substring(0, 1).toUpperCase();
		return firstLetter + input.substring(1).toLowerCase();
	}

	public static void analyzeText(String text) {
		if (text.isEmpty()) {
			System.out.println("No text to analyze!");
			return;
		}
		int wordCount = text.split("\\s+").length;
		int sentenceCount = text.split("[.!?]").length;
		int charCount = text.replaceAll("\\s+", "").length();
		String[] words = text.split("\\W+");
		String longestWord = "";
		for (String word : words) {
			if (word.length() > longestWord.length()) {
				longestWord = word;
			}
		}
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : text.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				freq.put(c, freq.getOrDefault(c, 0) + 1);
			}
		}
		char mostCommonChar = ' ';
		int maxCount = 0;
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostCommonChar = entry.getKey();
			}
		}
		System.out.println("\n--- TEXT ANALYSIS ---");
		System.out.println("Word count: " + wordCount);
		System.out.println("Sentence count: " + sentenceCount);
		System.out.println("Character count (no spaces): " + charCount);
		System.out.println("Longest word: " + longestWord);
		System.out.println("Most common character: " + mostCommonChar + " (" + maxCount + " times)");
	}

	public static String[] getWordsSorted(String text) {
		String[] words = text.split("\\W+");
		Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
		return words;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== TEXT PROCESSOR ===");
		System.out.println("Enter a paragraph of text:");
		String input = scanner.nextLine();
		String cleanedText = cleanInput(input);
		if (cleanedText.isEmpty()) {
			System.out.println("Invalid input! Exiting.");
			scanner.close();
			return;
		}
		analyzeText(cleanedText);
		String[] sortedWords = getWordsSorted(cleanedText);
		System.out.println("\n--- SORTED WORDS ---");
		for (String word : sortedWords) {
			if (!word.isEmpty()) {
				System.out.print(word + " ");
			}
		}
		System.out.println();
		System.out.println("\nEnter a word to search:");
		String searchWord = scanner.nextLine().trim().toLowerCase();
		boolean found = false;
		for (String word : sortedWords) {
			if (word.equalsIgnoreCase(searchWord)) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Word '" + searchWord + "' found in text!");
		} else {
			System.out.println("Word '" + searchWord + "' not found.");
		}
		scanner.close();
	}
}