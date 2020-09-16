import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        result[n - 1] = -1;
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (arr[i] > st.peek()) {
                st.pop();
                if (st.size() == 0) {
                    result[i] = -1;
                    break;
                }
            }
            if (st.size() != 0) {
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for (Integer i : result) {
            System.out.print(i + " ");

        }
    }
}
