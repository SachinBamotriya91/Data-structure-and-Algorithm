import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostPre {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == ')') {

                while (ops.peek() != '(') {

                    /*
                     * char op = ops.pop(); String postv2 = postfix.pop(); String postv1 =
                     * postfix.pop(); String post = postv1 + postv2 + op; postfix.push(post);
                     * 
                     * String prev2 = prefix.pop(); String prev1 = prefix.pop(); String pre = op +
                     * prev1 + prev2; prefix.push(pre);
                     */
                    processing(ops, postfix, prefix);

                }
                ops.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {

                    /*
                     * char op = ops.pop(); String postv2 = postfix.pop(); String postv1 =
                     * postfix.pop(); String post = postv1 + postv2 + op; postfix.push(post);
                     * 
                     * String prev2 = prefix.pop(); String prev1 = prefix.pop(); String pre = op +
                     * prev1 + prev2; prefix.push(pre);
                     */
                    processing(ops, postfix, prefix);

                }
                ops.push(ch);
            }

        }
        while (ops.size() > 0) {

            /*
             * char op = ops.pop(); String postv2 = postfix.pop(); String postv1 =
             * postfix.pop(); String post = postv1 + postv2 + op; postfix.push(post);
             * 
             * String prev2 = prefix.pop(); String prev1 = prefix.pop(); String pre = op +
             * prev1 + prev2; prefix.push(pre);
             */
            processing(ops, postfix, prefix);

        }

        System.out.println(postfix.pop());
        System.out.println(prefix.pop());

    }

    public static void processing(Stack<Character> ops, Stack<String> postfix, Stack<String> prefix) {

        char op = ops.pop();
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        String post = postv1 + postv2 + op;
        postfix.push(post);

        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String pre = op + prev1 + prev2;
        prefix.push(pre);

    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else
            return 0;
    }
}
