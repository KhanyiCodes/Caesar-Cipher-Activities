public class TestCaesarCipherTwoKeys {

    // Helper method to extract half of a string
    public String halfOfString(String message, int start) {
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            half.append(message.charAt(i));
        }
        return half.toString();
    }

    // Helper method to count the occurrences of letters in a string
    public int[] countLetters(String message) {
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                counts[ch - 'a']++;
            }
        }
        return counts;
    }

    // Helper method to find the index of the maximum occurrence in the array
    public int maxIndex(int[] counts) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                index = i;
            }
        }
        return index;
    }

    // Simple test method to demonstrate encryption and decryption
    public void simpleTests() {
        String input = "First Legion";
        CaesarCipherTwoKeys cipher = new CaesarCipherTwoKeys(17, 3);
        String encrypted = cipher.encrypt(input);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

    // Method to break the Caesar cipher by determining the keys
    public String breakCaesarCipher(String input) {
        String half1 = halfOfString(input, 0);
        String half2 = halfOfString(input, 1);

        int[] counts1 = countLetters(half1);
        int[] counts2 = countLetters(half2);

        int key1 = (maxIndex(counts1) - 4 + 26) % 26; // 4 is the index for the letter 'e'
        int key2 = (maxIndex(counts2) - 4 + 26) % 26;

        CaesarCipherTwoKeys cipher = new CaesarCipherTwoKeys (key1, key2);
        return cipher.decrypt(input);
    }
}
