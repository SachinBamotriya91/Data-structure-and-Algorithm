import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotate(int[] arr, int k) {

        k = k % arr.length;
        if (k < 0)
            k = k + arr.length;
        // part 1
        reverse(arr, 0, arr.length - k - 1);
        // part 2
        reverse(arr, arr.length - k, arr.length - 1);

        // part 3
        reverse(arr, 0, arr.length - 1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}