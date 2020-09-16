import java.util.*;

public class ReverseInGroup {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a size of Array");
		int size = scan.nextInt();
		System.out.println("Enter a value from which you want to formed Array in Reverse Order");
		int k = scan.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter Array Values");
		for (int i = 0; i < size; i++)
			arr[i] = scan.nextInt();

		scan.close();
		arr = ReverseInGroup.revereGroup(arr, k);

		System.out.println("Reverse Grouped Array is :");

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}

	}

	public static int[] revereGroup(int arr[], int k) {

		for (int i = 0; i < arr.length; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, arr.length - 1);
			int temp;
			while (left < right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left += 1;
				right -= 1;
			}
		}
		return arr;
	}
}