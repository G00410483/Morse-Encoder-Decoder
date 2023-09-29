package ie.atu.sw;

import java.util.HashMap;

public class Decode {
	
	public static StringBuilder Decoding (String input) {
		
		// DECODING MAP
		HashMap<String, Character> decodeMap = new HashMap<>();
		
		// Characters and values
		decodeMap.put(".-", 'a');
		decodeMap.put("-...", 'b');
		decodeMap.put("-.-.", 'c');
		decodeMap.put("-..", 'd');
		decodeMap.put(".", 'e');
		decodeMap.put("..-.", 'f');
		decodeMap.put("--.", 'g');
		decodeMap.put("....", 'h');
		decodeMap.put("..", 'i');
		decodeMap.put(".---", 'j');
		decodeMap.put("-.-", 'k');
		decodeMap.put(".-..", 'l');
		decodeMap.put("--", 'm');
		decodeMap.put("-.", 'n');
		decodeMap.put("---", 'o');
		decodeMap.put(".--.", 'p');
		decodeMap.put("--.-", 'q');
		decodeMap.put(".-.", 'r');
		decodeMap.put("...", 's');
		decodeMap.put("-", 't');
		decodeMap.put("..-", 'u');
		decodeMap.put("...-", 'v');
		decodeMap.put(".--", 'w');
		decodeMap.put("-..-", 'x');
		decodeMap.put("-.--", 'y');
		decodeMap.put("--..", 'z');
		decodeMap.put(".----", '1');
		decodeMap.put("..---", '2');
		decodeMap.put("...--", '3');
		decodeMap.put("....-", '4');
		decodeMap.put(".....", '5');
		decodeMap.put("-....", '6');
		decodeMap.put("--...", '7');
		decodeMap.put("---..", '8');
		decodeMap.put("----.", '9');
		// Decoding "/" as space
		decodeMap.put("/", ' ');
		
		StringBuilder output = new StringBuilder();
		String[] words = input.split("  ");
		// Nested for loop
		// Time complexity O(x^2)
		// x - number of characters
		for (String word : words) {
			// Split the word into letters
			// Time complexity O(x)
			// x - number of characters
			String[] letters = word.split(" ");
			// For loop
			// Time complexity O(x)
			// x - number of characters
			for (String letter : letters) {
				// Decode the character	
				output.append(decodeMap.get(letter));
				//}
			}
			// Spacing between words
			output.append(" ");
		}
		return output;
	}
}
