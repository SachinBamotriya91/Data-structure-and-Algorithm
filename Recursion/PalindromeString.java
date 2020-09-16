public class PalindromeString {
    public static void main(String[] args) {
        String s = "abcba";
        boolean result = isPalindrome(s, 0, s.length() - 1);
        System.out.println(result);

    }

    public static boolean isPalindrome(String s, int l, int r) {
        if (r < l)
            return true;
        else if (s.charAt(l) != s.charAt(r))
            return false;
        return isPalindrome(s, l + 1, r - 1);
    }

}
