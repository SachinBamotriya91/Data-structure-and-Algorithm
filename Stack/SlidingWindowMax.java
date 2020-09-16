import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int count = 1;
        while (k > count) {
            st.push(a.length - count);
            count++;
        }
        for (int i = a.length - k; i >= 0; i--) {
            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                result.add(a[i]);
                st.push(i);
            } else if (st.peek() - i < k) {
                result.add(a[st.peek()]);
            } else {
                st.pop();
                st.push(i);
                result.add(i);
            }
        }
        System.out.println(result);

    }
}