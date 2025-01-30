public class CaesarCipherTwoKeys {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    
    // Constructor to initialize the alphabets and shifted alphabets using the keys
    public CaesarCipherTwoKeys (int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = shiftAlphabet(key1);
        shiftedAlphabet2 = shiftAlphabet(key2);
    }

    // Helper method to shift the alphabet based on a given key
    private String shiftAlphabet(int key) {
        StringBuilder shifted = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            int newIndex = (i + key) % alphabet.length();
            shifted.append(alphabet.charAt(newIndex));
        }
        return shifted.toString();
    }

    // Method to encrypt a string using two keys
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = encryptCharacter(currentChar, i);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(currentChar); // Non-letter characters remain the same
            }
        }
        return encrypted.toString();
    }

    // Helper method to encrypt a character based on its position in the string
    private char encryptCharacter(char ch, int index) {
        int alphabetIndex = alphabet.indexOf(Character.toUpperCase(ch));
        char encryptedChar = ' ';
        if (alphabetIndex != -1) {
            if (index % 2 == 0) { // Even index: Use key1
                encryptedChar = shiftedAlphabet1.charAt(alphabetIndex);
            } else { // Odd index: Use key2
                encryptedChar = shiftedAlphabet2.charAt(alphabetIndex);
            }
            // Preserve case (upper or lower)
            if (Character.isLowerCase(ch)) {
                return Character.toLowerCase(encryptedChar);
            }
        }
        return encryptedChar;
    }

    // Method to decrypt a string using the two keys
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char decryptedChar = decryptCharacter(currentChar, i);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(currentChar); // Non-letter characters remain the same
            }
        }
        return decrypted.toString();
    }

    // Helper method to decrypt a character based on its position in the string
    private char decryptCharacter(char ch, int index) {
        int alphabetIndex = alphabet.indexOf(Character.toUpperCase(ch));
        char decryptedChar = ' ';
        if (alphabetIndex != -1) {
            if (index % 2 == 0) { // Even index: Use key1
                decryptedChar = reverseShiftedAlphabet(shiftedAlphabet1, alphabetIndex);
            } else { // Odd index: Use key2
                decryptedChar = reverseShiftedAlphabet(shiftedAlphabet2, alphabetIndex);
            }
            // Preserve case (upper or lower)
            if (Character.isLowerCase(ch)) {
                return Character.toLowerCase(decryptedChar);
            }
        }
        return decryptedChar;
    }

    // Helper method to reverse the shift of a letter in a shifted alphabet
    private char reverseShiftedAlphabet(String shiftedAlphabet, int index) {
        int originalIndex = shiftedAlphabet.indexOf(alphabet.charAt(index));
        return alphabet.charAt(originalIndex);
    }
}
