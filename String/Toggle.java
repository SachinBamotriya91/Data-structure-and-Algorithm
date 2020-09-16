import java.util.Scanner;

public class Toggle {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        n = toggle(n);
        System.out.println(n);
        scan.close();
    }

    public static String toggle(String n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 'a' + 'A');
            } else {
                ch = (char) (ch - 'A' + 'a');
            }
            sb.setCharAt(i, ch);
        }
        return sb.toString();
    }
}