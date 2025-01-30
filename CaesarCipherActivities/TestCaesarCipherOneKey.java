public class TestCaesarCipherOneKey {

    public static void main(String[] args) {
        // Test encryption and decryption
        CaesarCipherOneKey cipher = new CaesarCipherOneKey(3); // Example key is 3
        String originalText = "HELLO WORLD!";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        // Test decrypting with unknown key (brute force)
        String encryptedMessage = "KHOOR ZRUOG!"; // Encrypted "HELLO WORLD!" with key 3
        int key = findKey(encryptedMessage);
        CaesarCipherOneKey bruteForceCipher = new CaesarCipherOneKey(key);
        String bruteForcedDecryption = bruteForceCipher.decrypt(encryptedMessage);
        System.out.println("Brute-forced Decrypted Message: " + bruteForcedDecryption);
    }

    // Method to find the key (simple brute force approach)
    public static int findKey(String input) {
        for (int key = 0; key < 26; key++) {
            CaesarCipherOneKey testCipher = new CaesarCipherOneKey(key);
            String decryptedMessage = testCipher.decrypt(input);
            // Check if the decrypted message looks like valid English (or other criteria)
            if (decryptedMessage.contains("HELLO")) { // You can adjust this check
                return key;
            }
        }
        return -1; // Return -1 if no valid key is found
    }
}
