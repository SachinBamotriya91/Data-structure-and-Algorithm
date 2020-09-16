import java.util.*;

public class DifferenceArray {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int arr1[] = new int[n1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scan.nextInt();
        }
        int n2 = scan.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scan.nextInt();
        }
        scan.close();
        int diff[] = new int[n1 > n2 ? n1 : n2];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;
        int carry = 0;
        int d = 0;
        while (k >= 0) {
            int a = i >= 0 ? arr1[i] : 0;
            int d1 = a;
            int d2 = arr2[j] + carry;
            if (d2 >= d1) {
                carry = 0;
                d = d2 - d1;
                diff[k] = d;
            } else {
                carry = -1;

                d = d2 + 10 - d1;
                diff[k] = d;
            }
            i--;
            j--;
            k--;

        }
        int index = 0;
        while (index < diff.length) {
            if (diff[index] == 0)
                index++;
            else
                break;
        }
        for (int s = index; s < diff.length; s++) {
            System.out.println(diff[s]);
        }

    }
}