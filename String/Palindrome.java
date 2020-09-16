import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String Please");
        String s = scan.nextLine();

        scan.close();
        printPalindromeSS(s);

    }

    public static void printPalindromeSS(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String temp = s.substring(i, j);
                boolean result = isPalindrome(temp);
                if (result)
                    System.out.println(temp);
            }
        }
    }

    public static boolean isPalindrome(String A) {
        String temp = new String(A.replaceAll("[^A-Za-z0-9]", "").toLowerCase());

        char arr[] = temp.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}