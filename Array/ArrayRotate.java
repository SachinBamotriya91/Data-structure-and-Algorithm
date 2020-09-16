import java.util.*;

public class ArrayRotate {

    public static Integer[] leftRotate(Integer arr[], int d, int n) {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = ArrayRotate.gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void printArray(Integer arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* Fuction to get gcd of a and b */
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String args[]) {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        Integer arr[];

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Integer r[] = new Integer[t];
        int size;
        for (int t1 = 0; t1 < t; t1++) {
            size = scan.nextInt();
            r[t1] = scan.nextInt();
            arr = new Integer[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }
            list.add(arr);
        }
        scan.close();

        for (int t1 = 0; t1 < t; t1++) {
            Integer arr1[] = ArrayRotate.leftRotate(list.get(t1), r[t1], list.get(t1).length);
            ArrayRotate.printArray(arr1, arr1.length);
        }
    }

}