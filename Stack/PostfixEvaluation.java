
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();

        scan.close();
        Stack<Integer> values = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                values.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = values.pop();
                int v1 = values.pop();
                int v = operation(v1, v2, ch);
                values.push(v);

                String inv2 = infix.pop();
                String inv1 = infix.pop();

                String inv = "(" + inv1 + ch + inv2 + ")";
                infix.push(inv);

                String pre2 = prefix.pop();
                String pre1 = prefix.pop();
                String pre = ch + pre1 + pre2;
                prefix.push(pre);

            }

        }
        System.out.println(values.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static int operation(int v1, int v2, char ch) {
        if (ch == '+')
            return v1 + v2;
        else if (ch == '-')
            return v1 - v2;
        else if (ch == '*')
            return v1 * v2;
        else if (ch == '/')
            return v1 / v2;
        else
            return 0;
    }

}
