import java.util.Scanner;

public class ReArrange {
    public static void main(String[] args) {
        System.out.println("Enter a Size of Array");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int arr[] = new int[size];
        System.out.println("enter elements of Array");
        for (int i = 0; i < size; i++)
            arr[i] = scan.nextInt();
        scan.close();
        arr = reArrange(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] reArrange(int arr[], int size) {
        int arr1[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = arr[arr[i]];
        }
        return arr1;
    }

}