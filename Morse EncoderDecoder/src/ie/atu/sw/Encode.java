package ie.atu.sw;

import java.util.HashMap;

public class Encode {
	
	public static StringBuilder Encoding(String input) {
		
		// ENCODING MAP
		HashMap<Character, String> encodeMap = new HashMap<>();
		
		// Characters and values
		encodeMap.put('a', ".-");
		encodeMap.put('b', "-...");
		encodeMap.put('c', "-.-.");
		encodeMap.put('d', "-..");
		encodeMap.put('e', ".");
		encodeMap.put('f', "..-.");
		encodeMap.put('g', "--.");
		encodeMap.put('h', "....");
		encodeMap.put('i', "..");
		encodeMap.put('j', ".---");
		encodeMap.put('k', "-.-");
		encodeMap.put('l', ".-..");
		encodeMap.put('m', "--");
		encodeMap.put('n', "-.");
		encodeMap.put('o', "---");
		encodeMap.put('p', ".--.");
		encodeMap.put('q', "--.-");
		encodeMap.put('r', ".-.");
		encodeMap.put('s', "...");
		encodeMap.put('t', "-");
		encodeMap.put('u', "..-");
		encodeMap.put('v', "...-");
		encodeMap.put('w', ".--");
		encodeMap.put('x', "-..-");
		encodeMap.put('y', "-.--");
		encodeMap.put('z', "--..");
		encodeMap.put('1', ".----");
		encodeMap.put('2', "..---");
		encodeMap.put('3', "...--");
		encodeMap.put('4', "....-");
		encodeMap.put('5', ".....");
		encodeMap.put('6', "-....");
		encodeMap.put('7', "--...");
		encodeMap.put('8', "---..");
		encodeMap.put('9', "----.");
		// Encoding space as "/"
		encodeMap.put(' ', "/");

		StringBuilder output = new StringBuilder();
		// Append the characters
		// Time complexity of for loop O(x)
		// x - length of line
		for (char letter : input.toCharArray()) {
			// If map contains the character
			if (encodeMap.containsKey(Character.toLowerCase(letter))) {
				// Encode the character
				output.append(encodeMap.get(Character.toLowerCase(letter))).append(" ");
			}
		}
		return output;
	}

}
