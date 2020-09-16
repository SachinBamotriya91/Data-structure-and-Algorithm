import java.util.Scanner;
import java.util.Stack;

// from end we will be solving the expression 
public class PrefixEvaluation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();

        scan.close();
        Stack<Integer> values = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = values.pop();
                int v2 = values.pop();
                int v = operation(v1, v2, ch);
                values.push(v);

                String inv1 = infix.pop();
                String inv2 = infix.pop();

                String inv = "(" + inv1 + ch + inv2 + ")";
                infix.push(inv);

                String post1 = postfix.pop();
                String post2 = postfix.pop();
                String post = post1 + post2 + ch;
                postfix.push(post);

            } else {
                values.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");

            }
        }
        System.out.println(values.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
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
