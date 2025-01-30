public class CaesarCipherOneKey {
    private final String alphabet;
    private final String shiftedAlphabet;
    private final int key;

    // Constructor
    public CaesarCipherOneKey(int key) {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key;
        this.shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    // Encrypt method
    public String encrypt(String input) {
        input = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int index = alphabet.indexOf(currentChar);
            if (index != -1) {
                encrypted.append(shiftedAlphabet.charAt(index));
            } else {
                encrypted.append(currentChar); // Non-alphabetic characters remain unchanged
            }
        }

        return encrypted.toString();
    }

    // Decrypt method
    public String decrypt(String input) {
        CaesarCipherOneKey cc = new CaesarCipherOneKey(26 - this.key);
        return cc.encrypt(input);
    }

    // Main method to test CaesarCipher
    public static void main(String[] args) {
        CaesarCipherOneKey cipher = new CaesarCipherOneKey(20); // Example key is 20
        String originalText = "Rebaone Khanyisile Cynthia Vilakazi";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
