//package SirMossen;
public class HashFunctions {
    // First function
    public static int simpleHash(String s) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 31 + s.charAt(i);
        }
        hash = hash & 0x7FFFFFFF;  // ensure positive
        return hash;
    }

    // Second function
    public static int expHash(String st) {
        int hash = 0;
        int prime = 31;
        int multiplier = 1;

        for (char c : st.toCharArray()) {
            hash += multiplier * c;
            multiplier *= prime;
        }
        hash = hash & 0x7FFFFFFF;  // ensure positive
        return hash;
    }

    // Reverse function without predefined methods
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] reversed = new char[n];

        for (int i = 0; i < n; i++) {
            reversed[i] = chars[n - 1 - i];
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        String input = "Sayeel";

        // Use reverse function
        String reverse = reverseString(input);

        // Simple Hash
        int simpleHashOriginal = simpleHash(input);
        int simpleHashReverse = simpleHash(reverse);

        // Exponential Hash
        int expHashOriginal = expHash(input);
        int expHashReverse = expHash(reverse);

        // Merge into array
        int[] hashes = {
                simpleHashOriginal,
                simpleHashReverse,
                expHashOriginal,
                expHashReverse
        };

        // Print results
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reverse);

        System.out.println("\n--- Hash Codes ---");
        System.out.println("Simple Hash (Original): " + simpleHashOriginal);
        System.out.println("Simple Hash (Reverse): " + simpleHashReverse);
        System.out.println("Exp Hash (Original): " + expHashOriginal);
        System.out.println("Exp Hash (Reverse): " + expHashReverse);

        System.out.println("\n--- Stored in Array ---");
        for (int h : hashes) {
            System.out.println(h);
        }
    }
}
