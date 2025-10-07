//Example: "madam" → palindrome
public class PalindromeCheck {

    public static boolean isPalindrome(String str, int start, int end) {
        // Base case
        if (start >= end)
            return true;

        // Check first and last character
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive case
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "madam";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println(str + " is palindrome? " + result);
    }
}
