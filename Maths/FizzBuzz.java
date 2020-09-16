import java.util.*;

public class FizzBuzz {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.close();
		ArrayList<String> arr = new ArrayList<String>(n);
		for (int i = 1; i <= n; i++) {

			if (i % 15 == 0) {
				arr.add("Fizz Buzz ");
			} else if (i % 3 == 0) {
				arr.add("Fizz ");
			} else if (i % 5 == 0)
				arr.add("Buzz ");
			else
				arr.add(String.valueOf(i) + " ");
		}

		for (int i = 1; i < arr.size(); i++)
			System.out.print(arr.get(i));
	}
}