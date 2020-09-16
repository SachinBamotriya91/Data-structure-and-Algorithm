import java.util.*;

public class Anagrams {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a First String ");
        String f1 = scan.next();
        System.out.println("Enter a Second String");
        String f2 = scan.next();
        scan.close();
        boolean result = Anagrams.isAnagrams(f1, f2);
        if (result)
            System.out.println("Strings Are Anagram");
        else
            System.out.println("Strings Are Not Anagram");

    }

    public static boolean isAnagrams(String s1, String s2) {
        {
            int n1 = s1.length();
            int n2 = s2.length();
            if (n1 != n2)
                return false;

            char s11[] = s1.toCharArray();
            char s22[] = s2.toCharArray();
            Arrays.sort(s11);
            Arrays.sort(s22);

            for (int i = 0; i < n1; i++) {
                if (s11[i] != s22[i])
                    return false;
            }
            return true;

        }
    }

}